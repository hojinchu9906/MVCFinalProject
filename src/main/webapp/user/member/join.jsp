<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
td{
     font-family: ���� ���;
     font-size: 9pt;
}
</style>
<link rel="stylesheet" type="text/css" href="shadow/css/shadowbox.css"/>
<script type="text/javascript" src="shadow/js/shadowbox.js"></script>
<script type="text/javascript">
Shadowbox.init({
	players:["iframe"]
});
function idcheck()
{
	Shadowbox.open({
		content:"user/member/idcheck.jsp",
		player:"iframe",
		title:"���̵� �ߺ�üũ",
		width:250,
		height:200
	});
}
function postfind()
{
	
}
</script>
</head>
<body>
   <center>
     <h3>ȸ������</h3>
     <form name=frm action="../member/join_ok.jsp">
     <table border=1 bordercolor=black width=500 cellspacing=0 cellpadding=0>
      <tr>
       <td>
         <table border=0 width=500 cellspacing=0 cellpadding=0>
           <tr height=27>
            <td width=15% align=right>ID</td>
            <td width=85% align=left>
             <input type="text" size=12 name=id required readonly>
             <input type=button value="ID�ߺ�üũ" onclick="idcheck()">
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>Password</td>
            <td width=85% align=left>
             <input type="password" size=10 name=pwd>
             &nbsp;&nbsp;���Է� &nbsp;
             <input type="password" size=10 name=pwd1>
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>�̸�</td>
            <td width=85% align=left>
             <input type="text" size=12 name=name>
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>����</td>
            <td width=85% align=left>
             <input type="radio" name=sex checked value=����>����
             <input type="radio" name=sex value=����>����
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>�������</td>
            <td width=85% align=left>
             <input type="date" size=12 name=birth>
            </td>
           </tr>
           
           <tr height=27>
            <td width=15% align=right>�̸���</td>
            <td width=85% align=left>
             <input type="email" size=45 name=email>
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>��ȭ��ȣ</td>
            <td width=85% align=left>
             <select name=tel1>
              <option>010</option>
              <option>011</option>
              <option>017</option>
             </select>
             <input type="text" size=5 name=tel2>-<input type="text" size=5 name=tel3>
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>�����ȣ</td>
            <td width=85% align=left>
             <input type="text" size=5 name=post1 readonly>-<input type="text" size=5 name=post2 readonly>
             <input type=button value=�����ȣ�˻� onclick="postfind()">
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>�ּ�</td>
            <td width=85% align=left>
             <input type="text" size=45 name=addr1 readonly>
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>���ּ�</td>
            <td width=85% align=left>
             <input type="text" size=45 name=addr2>
            </td>
           </tr>
           <tr height=27>
            <td width=15% align=right>���ּ�</td>
            <td width=85% align=left>
             <textarea rows="8" cols="50" name=content></textarea>
            </td>
           </tr>
           <tr height=27>
            <td colspan="2" align=center>
             <input type="submit" value=����>
             <input type="button" value=���>
            </td>
           </tr>
         </table>
       </td>
      </tr>
     </table>
     </form>
   </center>
</body>
</html>






