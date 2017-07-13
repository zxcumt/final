<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="cart-items">
	<div class="container">
		<c:if test="${addresses=='[]'}">您还没有添加任何地址</c:if>
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<c:forEach varStatus="idx" items="${addresses}" var="address">

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading${idx.index+1}">
						<h5 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion"
								href="#collapse${idx.index+1}" aria-expanded="false"
								aria-controls="collapseOne">地址：${address.province}${address.city}${address.county}${address.addressdetail}
								收件人：${address.personname}
								<p class="text-right">
									<strong>${address.isdefault==0?'默认地址':''}</strong>
								</p>
							</a>
						</h5>
					</div>
					<div id="collapse${idx.index+1}" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="heading${idx.index+1}">
						<div class="panel-body">
							收件人手机号：${address.phone} &nbsp &nbsp&nbsp&nbsp&nbsp
							<button type="button" class="btn btn-info">修改地址</button>
							<c:if test="${address.isdefault!=0}">
								<button class="btn btn-primary  setDefaultAddress" title=""
									onclick="setDeaultAddresss(${address.id},'${sessionScope.username}')">
									设置为默认地址</button>
							</c:if>
							<button class="btn btn-warning"
								onclick="deleteAddress(${address.id},'${sessionScope.username}')">删除地址</button>
						</div>
					</div>
				</div>
			</c:forEach>
			<button class="btn btn-success" id="addNewAddress"
				onclick="addNewAddress('${sessionScope.username}')">添加地址</button>
		</div>
	</div>
</div>