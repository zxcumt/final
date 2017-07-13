<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<%@include file="/public/bootstraphead.jsp"%>
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/user.js"></script>
<!-- cart -->
</head>
<body>
	<!--header-->
	<%@include file="/public/head.jsp"%>
	<%@include file="/public/findpasswordmodal.jsp"%>
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
				<form>
					<div class="register-top-grid">
						<h3>注册</h3>
						<div class="input">
							<span>邮箱地址<label>*</label></span> <input id="newemail"
								type="text">
							<div class="alert alert-warning" id="newemailwarnings"
								style="display: none" role="alert">
								<a href="#" id="emailcontent" class="alert-link"></a>
							</div>
						</div>
						<div class="input">
							<span>密码<label>*</label></span> <input id="newpassword"
								type="password">
						</div>
						<div class="input">
							<span>验证密码<label>*</label></span> <input id="newpassword1"
								type="password">
						</div>
						<div class="alert alert-warning" id="newpasswordwarning"
							style="display: none" role="alert">
							<a href="#" class="alert-link">密码为空或两次密码不相等</a>
						</div>
						<a class="news-letter" href="#"> <label class="checkbox"><input
								type="checkbox" name="checkbox" checked=""><i> </i>Sign
								Up for Newsletter</label>
						</a>
						<div class="clearfix"></div>
					</div>
				</form>
				<div class="clearfix"></div>
				<div class="register-but">

					<input id="register" type="submit" value="submit">
					<div class="clearfix"></div>

				</div>
			</div>
		</div>
	</div>
	<!--//account-->
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

	<!--footer-->

</body>
</html>