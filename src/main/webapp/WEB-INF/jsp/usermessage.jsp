<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">			
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<!-- //Custom Theme files -->
<%@include file="/public/bootstraphead.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>

<script src="<%=request.getContextPath()%>/js/order.js">
	
</script>
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- //js -->
</head>
<body>
	<!--header-->
	<%@include file="/public/head.jsp"%>
	<%@include file="/public/findpasswordmodal.jsp"%>
	<%@include file="/public/publicmodal.jsp"%>
	<%@include file="/public/addressmodal.jsp"%>
	<!--//header-->
	<div class="row">


		<div class="list-group col-sm-2 col-md-2 usermenuleft">
			<a href="#" class="list-group-item active">我的信息</a> <a href="#"
				class="list-group-item">我的购物车</a> <a href="#"
				class="list-group-item">我的订单</a> <a href="#" class="list-group-item">我的收藏</a>
			<a href="#" class="list-group-item">我的地址</a>
		</div>



		<div class="col-sm-10 col-md-10">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">我的账户</h3>
				</div>
				<div class="panel-body">
				
				</div>
			</div>
		</div>
	</div>




	<!--footer-->

	<%@include file="/public/footer.jsp"%>


</body>
</html>