<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%  String path = request.getContextPath(); String basePath  =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
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
 
<title>订单评价</title>
</head>
<body>
<!--header-->
    <%@include file="/public/head.jsp"%>
    <%@include file="/public/findpasswordmodal.jsp"%>
    <%@include file="/public/publicmodal.jsp"%>
<!--//header-->
	<div style="margin-top:82px;font-size:20px;text-align: center;">
	商品打分<div id="quality" class="star-s"></div><br/>
    </div>
<base href="<%=basePath%>">
<h2>学生信息输入</h2><hr>   
<form action="commentsuccess" method="post" id="form" onSubmit="return validate()">
姓名：<input type="text" name="username"></input><br> 
评价：<input type="text" name="comment"></input><br>
<input type="submit" value="提交"/>  </form>

</body> 
</html> 