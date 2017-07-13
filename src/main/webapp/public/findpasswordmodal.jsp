<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- bootstrap的模态窗口-->
<!--modal-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改密码</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="recipient-name" class="control-label" id="lableemail">邮箱</label>
					<input id="emailconsure" type="text" class="form-control">
					<button class="btn btn-primary" id="consure" type="button">发送验证码</button>
				</div>
				<div class="alert alert-danger" id="findpasswordwarning"
					role="alert" style="display: none">
					<a href="#" id="findpasswprdwrong" class="alert-link"></a>
				</div>
				<div class="form-group">
					<label for="message-text" class="control-label" id="lableidentify">验证码</label>
					<input class="form-control" id="message-identify"></input>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button id="findPasswordNext" type="button" class="btn btn-primary">下一步</button>
			</div>
		</div>
	</div>
</div>