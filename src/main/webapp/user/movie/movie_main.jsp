<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['영화명', '예매율'],
          <c:forEach var="vo" items="${list}">
          ['<c:out value="${vo.title}"/>', <c:out value="${vo.reserve}"/>],
          </c:forEach>
          
        ]);

        var options = {
          title: '영화예매현황',
          width:450,
          height:450
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
        
        var chart1 = new google.visualization.ColumnChart(document.getElementById("columnchart"));
        chart1.draw(data, options);

      }
    </script>

</head>
<body>
  <center>
    <table id="table_content">
     <tr>
      <c:forEach var="vo" items="${list }">
       <td class="tdcenter">
       <a href="movie_detail.do?no=${vo.no }">
        <img src="${vo.image }" width=120 height=150></a>
       </td>
      </c:forEach>
     </tr>
     <tr>
      <c:forEach var="vo" items="${list }">
       <td class="tdcenter">
        <b>${vo.title }</b>
       </td>
      </c:forEach>
     </tr>
     <tr>
      <c:forEach var="vo" items="${list }">
       <td class="tdcenter">
        ${vo.regdate }
       </td>
      </c:forEach>
     </tr>
     <tr>
      <c:forEach var="vo" items="${list }">
       <td class="tdcenter">
                   찜:${ vo.like}
       </td>
      </c:forEach>
     </tr>
    </table>
    <table id="table_content">
     <tr>
       <td><div id="piechart" style="width: 450px; height: 450px;"></div></td>
       <td><div id="columnchart" style="width: 450px; height: 450px;"></div></td>
     </tr>
    </table> 
  </center>
</body>
</html>



