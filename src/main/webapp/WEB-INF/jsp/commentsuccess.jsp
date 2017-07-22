<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%> <%  String path = request.getContextPath(); String basePath  =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
    
    
    
     addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //Custom Theme files -->
<%@include file="/public/bootstraphead.jsp"%>
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
    rel="stylesheet" media="all">
<script src="<%=request.getContextPath()%>/js/imagezoom.js"></script>
 <title>评价成功！</title> 
 </head>
 <base href="<%=basePath%>">
 <body bgcolor="#FFFFCC"> 
<%@include file="/public/head.jsp"%>
<%@include file="/public/findpasswordmodal.jsp"%>
<%@include file="/public/publicmodal.jsp"%>
<%       
request.setCharacterEncoding("UTF-8");           
String username=request.getParameter("username");        
String comment=request.getParameter("comment"); 
out.print("用户名:"+username);
out.print("&nbsp;"); 
out.print("评价:"+comment);
Connection conn=null;      
Statement stat=null;      
ResultSet rs=null;      
Class.forName("com.mysql.jdbc.Driver");      
String url="jdbc:mysql://localhost:3306/miaosha?useSSL=true";
String root="root";       
String password="123456";       
conn=DriverManager.getConnection(url,root,password);      
stat=conn.createStatement();      
String sql="INSERT into comment values('"+username+"','"+comment+"')";
stat.executeUpdate(sql);  
%>
</body>
</html>




