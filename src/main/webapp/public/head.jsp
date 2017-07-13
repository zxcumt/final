<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script src="<%=request.getContextPath()%>/js/user.js">
	
</script>
<script src="<%=request.getContextPath()%>/js/cart.js">
	
</script>
<!--header-->
<div class="header">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h1 class="navbar-brand">
					<a href="index.html">Cloud</a>
				</h1>
			</div>
			<!--navbar-header-->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.html" class="active">Home</a></li>
				</ul>
			</div>
			<!--//navbar-header-->
		</nav>
		<div class="header-info">
			
			<div class="header-right login">
				<a onclick="usermessage('${sessionScope.username}')"><span
					class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
				<div id="loginBox">
					<div id="loginForm">
						<c:choose>
							<c:when test="${!empty sessionScope.username}">
								<div id="islogin">
									<div class="alert alert-success" role="alert">
										<a href="#" class="alert-link" id="isLogin"
											title="${sessionScope.username}">欢迎您：${sessionScope.username}</a>
									</div>
									<script>
										$(
												function() {
													$("#exit")
															.click(
																	function() {
																		index
																				.logincancel("${sessionScope.username}")
																	})
												})
									</script>
									<p>
										<span><a id="exit">注销</a></span>
									</p>
								</div>
							</c:when>
							<c:otherwise>
								<form id="nologin">
									<fieldset id="body">
										<fieldset>
											<label for="email">邮箱</label> <input type="text"
												name="username" id="email">
											<div class="alert alert-warning" id="emailwarning"
												style="display: none" role="alert">
												<a href="#" class="alert-link">请输入正确的邮箱地址</a>
											</div>
										</fieldset>
										<fieldset>
											<label for="password">密码</label> <input type="password"
												name="password" id="password">
										</fieldset>
										<input id="login" value="登录">
										<div class="alert alert-danger" id="loginwarning" role="alert"
											style="display: none">
											<a href="#" class="alert-link">登陆失败，邮箱或密码错误</a>
										</div>
										<label for="checkbox"><input type="checkbox"
											id="checkbox" checked="checked"> <i>记住我</i></label>
									</fieldset>
									<p>
										New User ? <a class="sign" href="register">注册</a> <span><a
											href="javascript:$('#myModal').modal('show')">Forgot your
												password?</a></span>
									</p>


								</form>
							</c:otherwise>
						</c:choose>


					</div>
				</div>
			</div>
			<div class="header-right cart">
				<a onclick="forwardCart('${sessionScope.username}')"><span
					class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
				<div class="cart-box">
					
					<p>
						<a href="javascript:emptyCart('${username}')"
							class="simpleCart_empty">清空购物车</a>
					</p>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
