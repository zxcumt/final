<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>支付确认</title>
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
	<!--cart-items-->

	<div class="cart-items" style="margin-top: 20px;">
		<div class="container">
			<h2>支付确认</h2>
			<c:if test="${cakes=='[]'}">购物车空空是空的</c:if>
			<c:forEach varStatus="idx" items="${cakes}" var="cake">
				<div class=" cart-header  cart-header${cake.id}">
					<div class="close" title="${cake.id}"></div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<input type="checkbox" name="cake" checked="checked"
								hidden="true" value="${cake.id}" /> <img src="${cake.image}"
								class="img-responsive" alt="">
						</div>
						<div class="cart-item-info">
							<h3>
								<a href="#"> ${cake.name} </a><span>${cake.status}</span>
							</h3>
							<ul class="qty">
								<li><p>单价:${cake.price}</p></li>
								<li><p>数量:X${cake.number}</p></li>
								<li><p>包邮</p></li>
							</ul>
							<div class="delivery">
								<p>折扣 : 无</p>
								<span id="sinplecartprice"
									title="${cake.number*cake.price}">最终价:${cake.number*cake.price}</span>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</c:forEach>
			
			<button style="float: right;" id="paynow" type="button"
				class="btn btn-info">立即支付</button>

		</div>

	</div>

	<!--//address-->
	<div class="row" id="addressrow">
		<c:forEach items="${addresss}" varStatus="idx" var="address">
			<div title="${address.id}"
				class="col-xs-6 col-md-3 addressnotdefault <c:if test="${address.isdefault==0}">addressdefault</c:if>">
				<address>
					<strong>${address.province}${address.city}${address.county}</strong><br>${address.addressdetail}<br>
					<abbr title="Phone">P:${address.phone}</abbr><br> <strong>${address.personname}</strong>
				</address>

			</div>
		</c:forEach>
	</div>



	<div class="clearfix"></div>
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