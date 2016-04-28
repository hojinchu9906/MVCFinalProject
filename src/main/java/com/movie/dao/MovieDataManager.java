package com.movie.dao;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

import java.io.*;
import java.net.*;
import java.util.*;
public class MovieDataManager {
	public static void main(String[] args)
	{
		MovieDataManager m=new MovieDataManager();
		File file=new File("C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MVCFinalProject\\user\\movie\\desc.txt");
		if(file.exists())
			file.delete();
		
		for(int i=1;i<=3;i++)
		{
		  String json=m.movie_review("�ؾ�ȭ", i);
		  m.json_parse(json);
		}
	}
    public static List<MovieDTO> movieAllData()
    {
    	List<MovieDTO> list=
    			new ArrayList<MovieDTO>();
    	try
    	{
    		Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/").get();
    		//System.out.println(doc);
    		Elements titleElem=doc.select("div.box-contents strong.title");
    		Elements percentElem=doc.select("div.box-contents strong.percent");
    		Elements imgElem=doc.select("div.box-image span.thumb-image img");
    		/*
    		 *  <span class="like"> 
                            <button class="btn-like" value="78746">��ȭ ���ϱ�</button>
                            <span class="count"> 
                                <strong><i>12,196</i><span>���� ����</span></strong> 
                                <i class="corner-RT"></i><i class="corner-LT"></i><i class="corner-LB"></i><i class="corner-RB"></i><i class="corner-arrow"></i>
                            </span>
                            <a class="link-reservation" href="/ticket/?MOVIE_CD=20009280&MOVIE_CD_GROUP=20009280">����</a>
                        </span>
                        
                        
                         <div class="egg-gage small">
                                <span class="egg great"></span>
								<span class="percent">96%</span>
							</div>


    		 */
    		Elements likeElem=doc.select("div.box-contents span.like span.count strong i");
    		Elements rElem=doc.select("div.box-contents span.txt-info strong");
    		Elements sElem=doc.select("div.box-contents span.percent");
    		for(int i=0;i<titleElem.size();i++)
    		{
    			Element telem=titleElem.get(i);
    			Element pelem=percentElem.get(i);
    			Element ielem=imgElem.get(i);
    			Element lelem=likeElem.get(i);
    			String img=ielem.attr("src");
    			Element relem=rElem.get(i);
    			Element selem=sElem.get(i);
    			MovieDTO d=new MovieDTO();
    			d.setNo(i+1);
    			d.setTitle(telem.text());
    			d.setImage(img);
    			int like=Integer.parseInt(lelem.text().replace(",",""));
    			d.setLike(like);
    			d.setRegdate(relem.text().substring(0, relem.text().indexOf("����")).trim());
    			//System.out.println(telem.text()+" "+pelem.text()+" "+img+" "+lelem.text()+" "+relem.text()+" "+selem.text());
    		    String percent=pelem.text();
    		    if(percent.equals("?"))
    		    	percent="0%";
    			d.setPercent(percent.substring(3, percent.indexOf('%')));
    		    d.setReserve(Double.parseDouble(selem.text().substring(0, selem.text().indexOf('%'))));
    		    list.add(d);
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	return list;
    }
    public MovieDTO movieDetail(int no)
    {
    	List<MovieDTO> list=movieAllData();
    	MovieDTO d=list.get(no-1);
    	return d;
    }
	public List<MovieDTO> movieHot()
	{
		List<MovieDTO> list=new ArrayList<MovieDTO>();
		List<MovieDTO> temp=movieAllData();
		int[] rand=new int[2];
		for(int i=0;i<2;i++)
		{
			rand[i]=(int)(Math.random()*(temp.size()));
			MovieDTO d=temp.get(rand[i]);
			list.add(d);
		}
		
		return list;
	}
	public List<String> movie_rank()
	{
		List<String> list=new ArrayList<String>();
		try
		{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
			Elements elems=doc.select("td.title div.tit3");
			for(int i=0;i<elems.size();i++)
			{
				if(i>9) break;
				Element td=elems.get(i);
				list.add(td.text());
			}
		}catch(Exception ex){}
		return list;
	}
	public List<String> movie_reserve()
	{
		List<String> list=new ArrayList<String>();
		try
		{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rreserve.nhn").get();
			Elements elems=doc.select("td.title div.tit4");
			for(int i=0;i<elems.size();i++)
			{
				Element td=elems.get(i);
				list.add(td.text());
			}
		}catch(Exception ex){}
		return list;
	}
	public List<String> movie_boxoffice()
	{
		List<String> list=new ArrayList<String>();
		try
		{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rboxoffice.nhn").get();
			Elements elems=doc.select("td.title div.tit1");
			for(int i=0;i<elems.size();i++)
			{
				Element td=elems.get(i);
				list.add(td.text());
			}
		}catch(Exception ex){}
		return list;
	}
	// 7b429affa32c43e1adf62ad1eebb6928
	/*
	 *    ������ ���� 
	 *    =======
	 *       SNS : Twitter,Daum,Naver,����Ʈ(HTML=> JSoup)
	 *             ======= ==== =====
	 *                    ������ ���
	 *       �������������� : ������ ��� (data.go.kr,seoul.go.kr)
	 *       google , �Ƹ��� 
	 *    ������ �м� 
	 *    =======
	 *       txt , json , xml(�Ľ�)
	 *       
	 *    ������ ���  : MapReduce , Hive , Pig (������)
	 *             R
	 *    =======
	 *    ������ ����  : MongoDB
	 *    =======
	 *    �ϵ�(�л�ó��)
	 *    =======================> ���� 
	 */
	public String movie_review(String title,int page)
	{
		StringBuffer sb=new StringBuffer();
		try
		{
			String key="7b429affa32c43e1adf62ad1eebb6928";
			String query="https://apis.daum.net/search/blog?"
				   +"apikey="+key
				   +"&result=20&output=json&pageno="+page
				   +"&q="+URLEncoder.encode(title, "UTF-8");
			URL url=new URL(query);
			// ���� ���� 
			HttpURLConnection conn=
				(HttpURLConnection)url.openConnection();
			conn.connect();
			if(conn!=null)
			{
				BufferedReader in=
					new BufferedReader(
							new InputStreamReader(
									conn.getInputStream(), "UTF-8"));
				String data="";
				while(true)
				{
					data=in.readLine();
					if(data==null) break;
					sb.append(data+"\n");
				}
			}
			conn.disconnect();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return sb.toString();
	}
	//   JSON �Ľ� 
	/*   {"channel":{"result":"20","pageCount":"800",
	 *   === "item":[{},{},{}..]}
	 *   
	 *   {} => object : JSONObject
	 *   [] => array  : JSONArray
	 *   
	 */
	public void json_parse(String json)
	{
		try
		{
			JSONParser jc=new JSONParser();
			JSONObject jo=(JSONObject)jc.parse(json);
			JSONObject channel=(JSONObject)jo.get("channel");
			JSONArray item=(JSONArray)channel.get("item");
			String desc="";
			for(int i=0;i<item.size();i++)
			{
				JSONObject obj=(JSONObject)item.get(i);
				String review=(String)obj.get("description");
				//System.out.println(review);
				desc+=review+"\n";
			}
			desc=desc.replaceAll("[A-Za-z0-9]", "");
			desc=desc.replace("&", "");
			desc=desc.replace(".", "");
			desc=desc.replace("#", "");
			desc=desc.replace("?", "");
			desc=desc.replace("/", "");
			desc=desc.replace(";", "");
			desc=desc.replace("(", "");
			desc=desc.replace(")", "");
			desc=desc.replace("[", "");
			desc=desc.replace("]", "");
			desc=desc.replace("+", "");
			desc=desc.replace(",", "");
			desc=desc.replace("'", "");
			desc=desc.replace("~", "");
			//desc=desc.replace("+", "");
			//System.out.println(desc);
			
			FileWriter fw=new FileWriter("C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MVCFinalProject\\user\\movie\\desc.txt",true);
			fw.write(desc);
			fw.close();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void wordcloud()
	{
		try
		{
			RConnection rc=new RConnection();
			rc.voidEval("library(KoNLP)");
			rc.voidEval("library(wordcloud)");
			rc.voidEval("review<-readLines(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MVCFinalProject/user/movie/desc.txt\")");
		    rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MVCFinalProject/user/movie/review.png\",width=450,height=450)");
		    rc.voidEval("nouns<-sapply(review,extractNoun,USE.NAMES = F)");
		    rc.voidEval("word<-table(unlist(nouns))");
		    rc.voidEval("wordcloud(names(word),freq=word,scale=c(8,1),rot.per = 0.25,random.order = F,min.freq = 1,color=rainbow(15))");
		    rc.voidEval("dev.off()");
		    rc.close();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public List<String> read_review()
	{
		List<String> list=new ArrayList<String>();
		try
		{
			RConnection rc=new RConnection();
			rc.setStringEncoding("utf8");
			rc.voidEval("review<-readLines(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MVCFinalProject/user/movie/desc.txt\")");
			REXP p=rc.eval("review");
			String[] data=p.asStrings();
			for(String s:data)
			{
				list.add(s);
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}

}





