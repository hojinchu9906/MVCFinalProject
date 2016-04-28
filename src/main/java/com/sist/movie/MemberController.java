package com.sist.movie;

import javax.servlet.http.HttpServletRequest;

import com.member.dao.MemberDAO;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller("memberController")
public class MemberController {
   @RequestMapping("join.do")
   public String memberJoin(HttpServletRequest req)
   {
	   req.setAttribute("jsp", "../member/join.jsp");
	   return "main/main";
   }
   @RequestMapping("idcheck_ok.do")
   public String memberIdCheck(HttpServletRequest req)
   {
	   String id=req.getParameter("id");
	   int count=MemberDAO.memberIdCheck(id);
	   System.out.println(id+"|"+count);
	   req.setAttribute("count", count);
	   //req.setAttribute("jsp", "../member/idcheck_ok.jsp");
	   //return "main/main";
	   return "member/idcheck_ok";
   }
}





