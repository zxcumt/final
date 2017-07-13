<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/public/backpublic.jsp"%>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<script	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/theme.css" media="all" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/sortable.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/fileinput.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/zh.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/theme.js" type="text/javascript"></script>

<title>后台商品添加</title>
<script type="text/javascript">
	$(function() {

		//注册botton的事件
		$("#btn2").click(
				function() {
					//开启验证
					var textbox = document.getElementsByName('format');

					var v = $('#file-1').val();
					var v1 = $('#file-2').val();
					$("#ff").form("enableValidation");
					if (v == '') {
						$.messager.alert('我的消息', "请选择首页展示图片", 'info');
					} else {
						if (v1 == '') {
							$.messager.alert('我的消息', "请选择详情页展示图片", 'info');
						} else {
							//如果验证成功，则提交数据
							$('#ff').form('submit', {
								url : 'Goods_addGood',
								success : function(result) {

									//表单重置
									$("#ff").form("reset");
									//关闭当前页面
									parent.$('#win').window("close");
									parent.$.messager.show({
										title : '提示',
										msg : '添加信息成功！',
										timeout : 2000,
										showType : 'slide',
									});

									//刷新dg
									parent.$("#back-good").datagrid("reload");
								}
							});
						}

					}

				});
		
	
	});
</script>
<style>
tr {
	margin: 10px 0; /*设置tr间距为2px*/
}
</style>
</head>
<body style="height: 100%; width: 100%">
	<div id="dd-add"
		style="width: 100%; display: flex; justify-content: center;">
		<form id="ff" method="post" enctype="multipart/form-data">
			<table
				style="margin-top: 30px; float: left; border-collapse: collapse;cellpadding="5">
				<tr>
					<td>蛋糕名称：</td>
					<td><input id="name" type="text" name="name"
						class="easyui-textbox"
						data-options="panelWidth:100,panelHeight:'auto',required:true"
						style="width: 160px" /></td>
				</tr>
				<tr>
					<td>详细介绍：</td>
					<td><input id="content" type="text" name="content"
						class="easyui-textbox"
						data-options="panelWidth:100,panelHeight:'auto',required:true"
						style="width: 160px" /></td>
				</tr>

				<tr>
					<td>单价：</td>
					<td><input id="price" type="text" name="presentprice"
						class="easyui-numberbox"
						data-options="panelWidth:100,panelHeight:'auto',min:0,precision:2,required:true"
						style="width: 160px" /></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input id="stock" type="text" name="number"
						class="easyui-numberbox"
						data-options="panelWidth:100,panelHeight:'auto',min:0,required:true"
						style="width: 160px" /></td>
				</tr>
		
				<tr>
					<td>首页图片：</td>
					<td>
						<div class="form-group">
							<input name="indeximage" id="file-1" type="file" multiple
								class="file" data-max-file-count="1" required>
						</div>
					</td>

				</tr>
				<tr>
					<td>详情页图片：</td>
					<td>
						<div class="form-group">
							(选择照片可以按Ctrl+鼠标点击多选) <input name="detailimage" id="file-2" type="file"
								multiple class="file" data-max-file-count="1" required>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<div style="margin-top: 10px;">
							<a id="btn2" class="easyui-linkbutton"
								data-options="iconCls:'icon-add'">添加</a>
						</div>
					</td>
				</tr>
			</table>

		</form>


	</div>

</body>
<script>


	$(".file").fileinput({
		language : 'zh', //设置语言 
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
		overwriteInitial : false,
		initialPreviewAsData : true,
		showUpload : false,
		maxFileSize: 10000,

	});
</script>
</html>