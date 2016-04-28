package com.news.dao;
import java.io.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;
public class NewsManager {
   public static List<Item> news_data(String find)
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   URL url=new URL("http://newssearch.naver.com/search.naver?where=rss&query="
				   +URLEncoder.encode(find, "UTF-8"));
		   JAXBContext jc=JAXBContext.newInstance(Rss.class);
		   Unmarshaller um=jc.createUnmarshaller();
		   Rss rss=(Rss)um.unmarshal(url);
		   list=rss.getChannel().getItem();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return list;
   }
}
