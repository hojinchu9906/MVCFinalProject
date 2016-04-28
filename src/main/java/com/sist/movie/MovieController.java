package com.sist.movie;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.io.File;
import java.util.*;
import com.movie.dao.*;
@Controller("movieController")
// POJO 
public class MovieController {
   @RequestMapping("movie_main.do")
   public String movie_main(HttpServletRequest req)
   {
	   MovieDataManager m=new MovieDataManager();
	   List<MovieDTO> list=m.movieAllData();
	   req.setAttribute("list", list);
	   req.setAttribute("jsp", "../movie/movie_main.jsp");
	   return "main/main";
   }
   @RequestMapping("movie_detail.do")
   public String movie_detail(HttpServletRequest req)
   {
	   String no=req.getParameter("no");
	   MovieDataManager m=new MovieDataManager();
	   MovieDTO d=m.movieDetail(Integer.parseInt(no));
	    File file=new File("C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MVCFinalProject\\user\\movie\\desc.txt");
		if(file.exists())
			file.delete();
		
		for(int i=1;i<=3;i++)
		{
		  String json=m.movie_review(d.getTitle(), i);
		  m.json_parse(json);
		}
		m.wordcloud();
	   List<String> list=m.read_review();
	   req.setAttribute("list", list);
	   req.setAttribute("vo", d);
	   req.setAttribute("jsp", "../movie/movie_detail.jsp");
	   return "main/main";
   }
}






