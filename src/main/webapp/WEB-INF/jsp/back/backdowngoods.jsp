<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/public/backpublic.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/easyui/datagrid-detailview.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/back/downgoods.js"></script>
<title>后台模版管理</title>
<script>

</script>
</head>
<body>
	<table id="back-downgood"></table>
	<div id="tb">
		<div style="padding: 5px;">
			根据商品名称来查询： <select class="easyui-textbox" id="name" name="name"
				data-options="iconCls:'icon-search'" style="width: 180px"
				prompt="请输入你要查询的商品名"></select>
			<button id="btn" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onClick="search()">查询</button>
			<a id="add" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">重新上架</a>


		</div>

	</div>
	<div id="back-modelCategory"></div>

	<div id="win"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>


</body>
</html>