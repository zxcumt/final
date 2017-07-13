//商品管理
$(function() {
	$("#add").click(function(){
	    $('#win').window({
			title:"规格信息",
			width:600,
			height:400,
			content:'<iframe src="backgoods_add" frameborder="0" width="100%" height="100%" />'
	   });		
   });	
	
	
  $("#remove").click(function(){
        var rows=$("#back-good").datagrid("getSelections");
        if(rows.length>0){
        $.messager.confirm('确定操作',"您确定要下架此商品嘛？",function(flag){
                 
		             if(flag){
		                 var  ids=[];
		                 for(var i=0 ;i<rows.length;i++){
		                    ids.push(rows[i].id);
		                 }
		                 $.ajax({
		                   type:"POST",
		                   url:'Goods_downGoods',
		                   data:{
		                     ids:ids.join(','),
		                   },
		                   beforeSend:function(){
		                   
		                   },
		                   success:function(data){
		                   
		                   if(data){
		                        $('#back-good').datagrid('loaded');
								$('#back-good').datagrid('load');
								$('#back-good').datagrid('unselectAll');
								$.messager.show({
		                              title:'提示',
		                              msg:'已下架!',
									});
		                    }
		                   
		                   },
		                 });
		               }
        });
          
        }else{
          $.messager.alert('提示','请选择一个或多个商品'); 
        }
     });
  
var editorRow=undefined;
  
$("#redo").click(function() {
	$("#submit,#redo").hide();
	editorRow=undefined;
    $("#back-good").datagrid("rejectChanges");
});

$("#submit").click(function(){
  	$("#submit,#redo").hide();
  
  	$('#back-good').datagrid('endEdit',editorRow);
});


$('#back-good').datagrid({    
	    with:600,
	    title:'成品商品管理',
	    treeField:'name',
	    fit: true,
	    idField:'id',
	    pageSize:10,
	    pageList:[10,15,20],
	    columns:[[    
	              {field:'id',title:'序号',width:200,checkbox:true,},
	              {field:'img',title:'商品展示图',sortable:true,width:200,formatter: function(value,row,index){
	    			if (row.image){
	    				return "<image style='width:100px; margin:0 auto' src='"+row.image+"'></image>";
	    			} else {
	    				return value;
	    			}
	    		   }},
	               {field:'name',title:'商品名称',width:200,editor:{type:'text',options:{required:true,},},} , 	
	               {field:'number',title:'商品库存',width:200,editor:{type:'text',options:{required:true,},},styler: function(value,row,index){
	   				if (row.number < 20){
						return 'background-color:#ffee00;color:red;';
					  }
				    }
                   } , 
	               {field:'presentprice',title:'商品单价',width:200,editor:{type:'text',options:{required:true,},},} , 
	               {field:'content',title:'商品详情',width:200,editor:{type:'text',options:{required:true,},},}		             	        
	               ]],   
		fitColumns:true,
		pagination:true,
		remoteSort:false,
		multiSort:true,
		nowrap:false,
		rownumbers:true,
		toolbar:'#tb',
	    striped:true,
	    url:'Goods_queryGoodsForBack', 	    
		onDblClickRow: function (rowIndex,rowData){
		 $('#submit,#redo').show();

		 if(editorRow!=undefined){
		 		 console.log(editorRow)
		 $('#back-good').datagrid('endEdit',editorRow);
		 editorRow=undefined;
		 }
		  if(editorRow==undefined){
		  		 console.log(editorRow)
		  $('#back-good').datagrid('beginEdit',rowIndex);
		  editorRow=rowIndex;
		  }
		 },	  
		 
		   onAfterEdit:function(index, row, changes){
			     
			     
			     var updated=$('#back-good').datagrid('getChanges','updated');// 将更新的数据赋值给updated
			    // 新增用户
			  			    
			    if(updated.length>0){
			    var updategood=updated[0];
							    $.ajax({
									type:'POST',
									url:'Goods_changeGood',
									data:{
										// 以这种形式传id
								    id:updategood.id,
							        content:updategood.content,
							        presentprice:updategood.presentprice,
							        number:updategood.number,
							        name:updategood.name,
							        // 把更新的数据传到后台
								    },
								   
								beforeSend:function(){
									$('#back-good').datagrid('loading');
								},
								success:function(data){
									if(data){
										$('#back-good').datagrid('loaded');
										$('#back-good').datagrid('load');
										$('#back-good').datagrid('unselectAll');
										$.messager.show({
				                              title:'提示',
				                              msg:'已被修改!',
											});
									}
								},
							});
			       }			    
						    $('#submi,#redo').hide();
						    editorRow=undefined;
			    },	
	  });
})

function search() {
	if($('input[name="name"]').val()!=''){
		$('#back-good').datagrid('load', {
			name : $.trim($('input[name="name"]').val()), //过滤空格并且传递name=goodname的input的参数值
		});
	}
}
