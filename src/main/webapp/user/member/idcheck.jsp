<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){ // window.onload , $(document).ready(function(){})
	$('#checkBtn').click(function(){
		var id=$('#id').val();
		/*
		     val() ==> input,select,textarea getter
		     val("value") setter
		     attr("�Ӽ���") ==> getter
		     attr("�Ӽ���",��) ==> setter
		     text("")
		     html("") ==> �±׸� �����ϴ� ���α׷� (DOM)
		*/
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		var param="id="+id;
		sendMessage("POST", "../../idcheck_ok.do", param, idcheck);
		alert("1");
	});
});
function idcheck()
{
	
	if(httpRequest.readyState==4)
	{
		if(httpRequest.status==200)
		{
			var res=httpRequest.responseText;
			alert(res);
			if(res.trim()=="0")
			{
				$('#result').text("");
				var r=$('#id').val()+"��(��) ��� ������ ID�Դϴ�<br>"
				     +"<center>"
			         +"<input type=button onclick=ok('"+$('#id').val()+"') value=Ȯ��>"
			         +"</center>";
				$('#result').append(r);
			}
			else
			{
				$('#result').text("");
				var r=$('#id').val()+"��(��) �̹� ������� ID�Դϴ�<br> �ٸ� ID�� �Է��ϼ���";
				$('#result').append(r);
			}
			
		}
	}
}
function ok(id)
{
	parent.frm.id.value=id;
	parent.Shadowbox.close();
}
</script>
</head>
<body>
   <center>
     <table id="table_content" style="margin-top: 20px">
       <tr>
        <td>
          ID:<input type=text name=id size=12 id="id">
          <input type=button value="���̵�üũ" id="checkBtn">
        </td>
       </tr>
       <tr>
         <td id="result"></td>
       </tr>
     </table>
   </center>
 </body>
</html>







