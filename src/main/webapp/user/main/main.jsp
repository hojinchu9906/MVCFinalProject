<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="EUC-KR" />
        <title>��ȭ��� ����Ʈ�Դϴ�.</title>
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
						<li><a href="join.do">ȸ������</a></li>
						<li><a href="movie_main.do">��ȭ����</a></li>
						<li><a href="news_main.do">Ŀ�´�Ƽ</a></li>
						<c:if test="${sessionScope.id !=null and sessionScope.admin==0 }">
							<li><a href="mypage.do">MyPage</a></li>
						</c:if>
						<c:if test="${sessionScope.id !=null and sessionScope.admin==1 }">
							<li><a href="reserve.do">������Ȳ</a></li>
						</c:if>
					</ul>
				</div>
				
				<c:if test="${sessionScope.id==null }">
					<div style="margin-left: 700px">
					 <input type=text name=id size=12 placeholder="���̵�" id="id">&nbsp;
					 <input type=password name=pwd size=12 placeholder="��й�ȣ" id="pwd">
					 <input type=button value="�α���" id="logBtn">
					</div>					
				</c:if>
				
				<c:if test="${sessionScope.id !=null }">
					<div style="margin-left: 700px">
						<form action="logout.do">
						${sessionScope.name }(${sessionScope.admin==1?"������":"�Ϲ�" })�� �α��� �Ǿ����ϴ�!
						<input type="submit" value="�α׾ƿ�" id="logoutBtn">
						</form>
					</div>
				</c:if>
				
				<div id="status" style="margin-left: 700px"></div>	
				<div id="top_padding"></div>
						
				
				<jsp:include page="${jsp }"/>
              
		</div>
    </body>
</html>






















