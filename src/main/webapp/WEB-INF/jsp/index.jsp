<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<!-- Custom Theme files -->
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


</head>
<body>
	<!--header-->
	<%@include file="/public/head.jsp"%>
		<%@include file="/public/publicmodal.jsp"%>
	<%@include file="/public/findpasswordmodal.jsp"%>
	<!--banner-->
	<div class="banner">
		<div class="container">
			<h2 class="hdng">
				云端有限公司  <span> 欢迎您！ </span>
				
			</h2>
			<p>Our best goods make your day special</p>
			<p>现在与您同时在线共有${onlineCount>0?onlineCount:0}人！</p>
			<a href="#">SHOP NOW</a>
			<div class="banner-text">
				
			</div>
		</div>
	</div>
	<div class="gallery">
		<div class="container">
			<div class="gallery-grids">
				<c:forEach var="cake" begin="0" end="9" items="${cakes}"
					varStatus="idx">
					<div
						class=" <c:choose>
			        	<c:when test="${idx.index==0}">col-md-8 glry-two</c:when>
			        	<c:when test="${idx.index==1}">glry-two col-md-4</c:when>
			        	<c:otherwise>col-md-3</c:otherwise>
					</c:choose> gallery-grid ">
						<a href="single?id=${cake.id}"><img src="${cake.image}"
							class="img-responsive" alt="" />
							<div class="gallery-info">
								<p>
									<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
									view
								</p>
								<a class="shop  collect" onclick="collect(${cake.id})" href="#">收藏</a>
								<a class="shop" href="single?id=${cake.id}">立即购买</a>
								<div class="clearfix"></div>
							</div> </a>
						<div class="galy-info">
							<p>${cake.name}</p>
							<div class="galry">
								<div class="prices">
									<h5 class="item_price">$${cake.presentprice}</h5>
								</div>
								<div class="rating">
									<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<!--//gallery-->
	<!--subscribe-->
	<div class="subscribe">
		<div class="container">
			<h3>Newsletter</h3>
			<form>
				<input type="text" class="text" value="Email"
					onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Email';}"> <input
					type="submit" value="Subscribe">
			</form>
		</div>
	</div>
	<!--//subscribe-->
	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-2 footer-grid">
					<h4>company</h4>
					<ul>
						<li><a href="products.html">products</a></li>
						<li><a href="#">Work Here</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Happenings</a></li>
						<li><a href="#">Dealer Locator</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>service</h4>
					<ul>
						<li><a href="#">Support</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Warranty</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h4>order & returns</h4>
					<ul>
						<li><a href="#">Order Status</a></li>
						<li><a href="#">Shipping Policy</a></li>
						<li><a href="#">Return Policy</a></li>
						<li><a href="#">Digital Gift Card</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>legal</h4>
					<ul>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Terms and Conditions</a></li>
						<li><a href="#">Social Responsibility</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid icons">
					<h4>Connect with Us</h4>
					<ul>
						<li><a href="#"><img src="images/i1.png" alt="" />Follow
								us on Facebook</a></li>
						<li><a href="#"><img src="images/i2.png" alt="" />Follow
								us on Twitter</a></li>
						<li><a href="#"><img src="images/i3.png" alt="" />Follow
								us on Google-plus</a></li>
						<li><a href="#"><img src="images/i4.png" alt="" />Follow
								us on Pinterest</a></li>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</body>
</html>