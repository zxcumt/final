<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="cart-items">
	<c:forEach var="good" items="${goods}">
		<div class="col-md-3 col-sm-3 col-xs-6">
			<a href="single?id=${good.id}">
			<div class="onecollect" style="border: 2px solid;">
				<div class="product-img b-link-stripe b-animate-go  thickbox">
					<img alt="" src="${good.image}">
				</div>
				<div>${good.name}</div>
				<div>${good.presentprice}</div>
			</div>
			</a>
		</div> 
	</c:forEach>
</div>
