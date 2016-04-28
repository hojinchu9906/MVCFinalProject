<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="EUC-KR" />
        <title>영화통계 사이트입니다.</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="user/styles.css" rel="stylesheet" type="text/css" media="screen" />
        
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
        <script type="text/javascript" src="user/js/ajax.js"></script>
        <script>
        $(function(){
        	
        });
        </script>
        
    </head>
    <body>
    	<div id="wrap">
				<div id="menu">
					<ul>
						<li><a href="main.do" class="active">Home</a></li>
						<li><a href="join.do">회원가입</a></li>
						<li><a href="movie_main.do">영화센터</a></li>
						<li><a href="news_main.do">커뮤니티</a></li>
						<c:if test="${sessionScope.id !=null and sessionScope.admin==0 }">
							<li><a href="mypage.do">MyPage</a></li>
						</c:if>
						<c:if test="${sessionScope.id !=null and sessionScope.admin==1 }">
							<li><a href="reserve.do">예매현황</a></li>
						</c:if>
					</ul>
				</div>
				
				<c:if test="${sessionScope.id==null }">
					<div style="margin-left: 700px">
					 <input type=text name=id size=12 placeholder="아이디" id="id">&nbsp;
					 <input type=password name=pwd size=12 placeholder="비밀번호" id="pwd">
					 <input type=button value="로그인" id="logBtn">
					</div>					
				</c:if>
				
				<c:if test="${sessionScope.id !=null }">
					<div style="margin-left: 700px">
						<form action="logout.do">
						${sessionScope.name }(${sessionScope.admin==1?"관리자":"일반" })님 로그인 되었습니다!
						<input type="submit" value="로그아웃" id="logoutBtn">
						</form>
					</div>
				</c:if>
				
				<div id="status" style="margin-left: 700px"></div>	
				<div id="top_padding"></div>
						
				
				<jsp:include page="${jsp }"/>
              
		</div>
    </body>
</html>






















