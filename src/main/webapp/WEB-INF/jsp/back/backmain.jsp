<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/public/backpublic.jsp"%>
<title>后台主页</title>
<script type="text/javascript">
	$(function() {
		var treeData = [ {
			text : "商品管理",
			children : [ {
				text : "商品以及库存查询",
				attributes : {
					url : "backgoods"
				}
			}, {
				text : "已下架商品管理",
				attributes : {
					url : "backdowngoods"
				}
			} ]
		}, {
			text : "订单管理",
			children : [ {
				text : "订单处理",
				attributes : {
					url : "backorder"
				}
			}]
		} ];
		var treeData2 = [ {
			text : "库存管理",
			children : [ {
				text : "总部库存查询",
				attributes : {
					url : "backZongBu"
				}
			}, {
				text : "门店库存查询",
				attributes : {
					url : "backZongBu_MenDian"
				}
			}, {
				text : "门店库存申请操作",
				attributes : {
					url : "backApply"
				}
			} ]
		}, {
			text : "销售管理",
			children : [ {
				text : "门店销售明细查询",
				attributes : {
					url : "backZongBuMingXi"
				}
			} ]
		} ];
		// 实例化树菜单
		$("#tree").tree({
			data : treeData,
			lines : true,
			onClick : function(node) {
				if (node.attributes) {
					openTab(node.text, node.attributes.url);
				}
			}
		});
		$("#tree2").tree({
			data : treeData2,
			lines : true,
			onClick : function(node) {
				if (node.attributes) {
					openTab(node.text, node.attributes.url);
				}
			}
		});
		// 新增Tab
		function openTab(text, url) {
			if ($("#tt").tabs('exists', text)) {
				$("#tt").tabs('select', text);
			} else {
				var content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="
						+ url + "></iframe>";
				$("#tt").tabs('add', {
					title : text,
					closable : true,
					content : content
				});
			}
		}

	});
</script>
</head>
<body class="easyui-layout">

	<!--后台操作系统左边的选项框  -->
	<div data-options="region:'west',title:'系统操作',split:true"
		style="width: 250px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true">

<!-- 			<div title="商品管理" data-options="iconCls:'icon-save'"
				style="overflow: auto; padding: 10px;">
				<ul class="easyui-tree">
					<div>
						<ul id="tree2"></ul>

					</div>

				</ul>
			</div> -->

			<!-- 第二个管理 -->
			
				<ul id="aa" class="easyui-tree">

					<div>
						<ul id="tree"></ul>

					</div>

				</ul>


		

		</div>
	</div>
	<!--后台操作系统的具体操作页面  -->
	<div data-options="region:'center',title:'操作内容'"
		style="padding: 1px; background: #eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省页面" style="padding: 20px; display: none;">
				后台操作内容主页</div>
		</div>
	</div>
</body>
</html>