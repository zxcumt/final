//订单管理

function search() {
	$('#back-order').datagrid('load', {
		username : $.trim($('input[name="name"]').val()), //过滤空格并且传递name=goodname的input的参数值
	});
}

function seek(oid,state){
    $.messager.confirm('确定操作',"确认执行此操作吗？",function(flag){
    if(flag){   
    	$.ajax({
			url : "Order_orderState",
			data : {
              orderid:oid,
              state:state
			},
			dataType:"json",
			success : function(res) {
			   $("#back-order").datagrid("reload");
			}
		});
		}

   });
	   
}
$(function(){
 	var editorRow=undefined;
 	
 	var conf = {
 			options:{
 				fitColumns:true,
 				url:'Order_queryAllOrderByBack', 	
 			    columns:[[      
 			 	        {field:'ordernumber',title:'订单编号',sortable:true,width:200,},
 			 	        {field:'personname',title:'收货人',sortable:true,width:200,},
 			 	        {field:'phone',title:'收货人电话',width:200,} , 	  
 			 	        {field:'address',title:'收货地址',sortable:true,width:200,},	
 			 	        {field:'totalprice',title:'订单总价',width:200,},    
 			 	        {field:'starttime',title:'订单时间',sortable:true,width:200,formatter: function(value,row,index){
 			 				if (row.starttime){
 			 					var dt = new Date(row.starttime);
 			 				    return dt.toLocaleString()
 			 				}
 			 			},},
 			 			{field:'state',title:'订单处理',width:200,formatter: function(value,row,index){
 			 				if (row.state=="已支付"){
 			 				return '<button    class="easyui-linkbutton button"   onClick="javascript:seek('+row.id+',1)">订单确认</button>';		
 			 				}else if(row.state=="待发货"){
 			 				return '<button    class="easyui-linkbutton button"   onClick="javascript:seek('+row.id+',2)">已发货</button>';		
 			 				}else if(row.state=="已发货"){
 			 				return '<button    class="easyui-linkbutton button"   onClick="javascript:seek('+row.id+',3)">订单完成</button>';
 			 				}else{
 			 				return row.state;
 			 				}
 			 			}},    
 			 	    ]],   
 			},
 			subgrid:{
				options:{
					fitColumns:true,
					foreignField:'id',
					singleSelect:true,
					url:'Order_queryOrderDetailByBack', 	    	
					columns:[[
                        {field:'name',title:'商品名称',width:200},
                        {field:'image',title:'商品展示图',sortable:true,width:200,formatter: function(value,row,index){
            				if (row.image){
            					return "<image style='width:100px; margin:0 auto' src='"+row.image+"'></image>";
            				} else {
            					return value;
            				}
            			}},            
						{field:'price',title:'单价',width:200},
						{field:'number',title:'数量',width:200},
						{field:'size',title:'重量',width:200},						
						{field:'totalprice',title:'销售额',width:200,formatter: function(value,row,index){
            				if (row){
            					return row.price*row.number*row.size;          			
            				}
            			}}
					]],

				}
			}
 		};
 	
	$('#back-order').datagrid({    
	    with:600,
	    title:'订单管理',
	    fit: true,
	    idField:'id',
	    pageSize:10,
	    pageList:[10,15,20],
		fitColumns:true,
		pagination:true,
		remoteSort:false,
		multiSort:true,
		nowrap:false,
		rownumbers:true,
		toolbar:'#tb',
	    striped:true,
	    view: detailview, 	
	     						    	
	  }).datagrid('subgrid', conf);
});