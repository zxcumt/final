<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="orders-items">
	<div class="container">

		<c:if test="${orders=='[]'}">还没有任何订单</c:if>
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<c:forEach varStatus="idx" items="${orders}" var="order">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading${idx.index}">
						<h5 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion"
								href="#collapse${idx.index}"
								aria-expanded="${ide.index==0?true:false}"
								aria-controls="collapseOne"> 订单号：${order.ordernumber} &nbsp
								&nbsp 订单时间：<fmt:formatDate value="${order.starttime}"
									pattern="yyyy-MM-dd HH:mm:ss" /> &nbsp &nbsp
								订单状态：${order.state}&nbsp
								<br>
								收货地址：${order.address} &nbsp &nbsp收货人:${order.personname}
							</a>
						</h5>
					</div>
					<div id="collapse${idx.index}" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="heading${idx.index}">
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered">

									<thead>
										<tr>
											<th>#</th>
											<th>商品图片</th>
											<th>商品名称</th>
											<th>商品信息</th>
											<th>商品总价</th>
										</tr>
									</thead>
									<c:forEach items="${order.queryCarksAllDto.cakes}" var="cake"
										varStatus="cakeidx">
										<tr>
											<td>${cakeidx.index+1}</td>
											<td>
												<div class="cart-item cyc">
													<img class="img-responsive" src="${cake.image}" alt="">
												</div>
											</td>
											<td><h5>${cake.name}</h5></td>
											<td>
												单价:${cake.price} $<br> 数量:x${cake.number}
											</td>
											<td>${cake.price*cake.number}</td>

										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</div>