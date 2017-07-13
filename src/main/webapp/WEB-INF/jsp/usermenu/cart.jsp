<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="cart-items">
	<div class="container">
		<h2>My Shopping Cart</h2>

		<c:if test="${cakes=='[]'}">购物车是空的哦,快去买点东西吧</c:if>
		<c:forEach varStatus="idx" items="${cakes}" var="cake">

			<div class=" cart-header  cart-header${cake.id}">
				<div class="close" title="${cake.id}"></div>

				<div class="cart-sec simpleCart_shelfItem">

					<div class="cart-item cyc">
						<input type="checkbox" name="cake" value="${cake.id}" /> <img
							src="${cake.image}" class="img-responsive" alt="">
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
							
							<span id="sinplecartprice"
								title="${cake.number*cake.price}">最终价:${cake.number*cake.price}</span>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</c:forEach>
		
		<c:if test="${cakes!='[]'}">
			<a href="#" onclick="creatOrder('${sessionScope.username}')"><img
				alt="" style="width: 15%; display: inline; float: right;"
				src="images/shopping.png"></a>
		</c:if>
	</div>
</div>