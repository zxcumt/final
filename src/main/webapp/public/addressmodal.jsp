<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- bootstrap的模态窗口-->
<!--modal-->
<div class="modal fade" id="addressModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新增地址</h4>
			</div>
			<div class="modal-body">
				<table style="">
					<thead>
						<tr>
							<td>省</td>
							<td>城</td>
							<td>县</td>
						</tr>
					</thead>

					<tr>
						<td><select name="province" id="province"
							class="selectpicker area">
						</select></td>
						<td><select name="city" id="city" class="selectpicker area">
						</select></td>
						<td><select name="county" id="county"
							class="selectpicker area">
						</select></td>
					</tr>
				</table>
				<table style="border-spacing: 10px 5px; border-collapse: separate;">
					<tr>
						<td><label for="recipient-name" class="control-label">详细地址</label></td>
						<td><input id="detail" type="text" class="form-control"></td>
					</tr>

					<tr>
						<td><label for="message-text" class="control-label">收件人姓名</label></td>
						<td><input class="form-control" type="text" id="personname"></input></td>
					</tr>

					<tr>
						<td><label for="message-text" class="control-label">联系电话</label></td>
						<td><input class="form-control" type="text" id="phone"></input></td>
					</tr>
				</table>
				<label for="checkbox"><input id="defaultaddress"
					type="checkbox"> <i>设置为默认地址</i></label>
				<div class="alert alert-danger" id="addresswarning" role="alert"
					style="display: none">
					<a href="#" id="addresswrong" class="alert-link"></a>
				</div>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button id="addAddress"
					onclick="addAddress('${sessionScope.username}')" type="button"
					class="btn btn-primary">保存</button>
			</div>
		</div>
	</div>
</div>