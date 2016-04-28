package com.sist.controller;
import java.util.*;
import java.io.*;
// Class.forName("com.sist.movie.BoardController")   
public class PackageScan {
   public static List<String> packageClassCreate(String pack)
   {
	   List<String> list=new ArrayList<String>();
	   try
	   {
		  // String path="C:\\springDev\\springStudy\\MVCFinalProject\\src\\main\\java\\";
		   String path="C:\\Users\\sist\\Documents\\GitStudyDownload\\spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32-x86_64_\\workspace\\MVCFinalProject\\src\\main\\java\\";
		   String real_path=path+pack.replace(".", "\\");
		   // java//com//sist//movie
		   // com.sist.movie.BoardController
		   File dir=new File(real_path);
		   File[] files=dir.listFiles();
		   for(File f:files)
		   {
			   String name=f.getName();
			   String ext=name.substring(name.lastIndexOf('.')+1);
			   if(ext.equals("java"))
			   {
				   String save=pack+"."+name;
				   list.add(save.substring(0,save.lastIndexOf('.')));
				   
			   }
		   }
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return list;
   }
}
