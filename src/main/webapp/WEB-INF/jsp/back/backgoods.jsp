<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/public/backpublic.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/back/goods.js"></script>
<title>后台模版管理</title>
<script>
/*
$(function(){
	$("#detail").click(function(){
	 var rows=$("#back-good").datagrid("getSelections");
        if(rows.length==1){
		    $('#win').window({
				title:"规格信息",
				width:600,
				height:400,
				content:'<iframe src="backgoods_detail?id='+rows[0].id+'" frameborder="0" width="100%" height="100%" />'
		   });		
       }else{
          $.messager.alert('提示','请选择一个商品，不能多选或不选'); 
       }
    });
$("#detail2").click(function(){
	 var rows=$("#back-good").datagrid("getSelections");
        if(rows.length==1){
		    $('#win').window({
				title:"规格信息",
				width:600,
				height:400,
				content:'<iframe src="backgoods_detail2?id='+rows[0].id+'" frameborder="0" width="100%" height="100%" />'
		   });		
       }else{
          $.messager.alert('提示','请选择一个商品，不能多选或不选'); 
       }
    });
	$("#redo").click(function() {
			$("#submit,#redo").hide();
			editorRow=undefined;
            $("#back-good").datagrid("rejectChanges");
		});
		  
	$("#submit").click(function(){
		  	$("#submit,#redo").hide();
		  
		  	$('#back-good').datagrid('endEdit',editorRow);
	});



    $('#name').combobox({    
		    url:'ComProduct_getAllName?type=0&state=0',    
		    valueField:'name',    
		    textField:'name'
		  });
	


 	var editorRow=undefined;
 	
	
});*/
</script>
</head>
<body>
	<table id="back-good"></table>
	<div id="tb">
		<div style="padding: 5px;">
			根据商品名称来查询： <select class="easyui-textbox" id="name" name="name"
				data-options="iconCls:'icon-search'" style="width: 180px"
				prompt="请输入你要查询的商品名"></select>
			<button id="btn" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onClick="search()">查询</button>

			<a id="remove" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove'">下架</a> <a id="add"
				class="easyui-linkbutton" data-options="iconCls:'icon-add'">新品上架</a>
			<a id="redo" class="easyui-linkbutton"
				data-options="iconCls:'icon-redo'" style="display: none">取消编辑</a> <a
				id="submit" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'" style="display: none">保存</a>
(可进行双击修改)
		</div>

	</div>
	<div id="back-modelCategory"></div>

	<div id="win"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>


</body>
</html>