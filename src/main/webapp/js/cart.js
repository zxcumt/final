//购物车js
$(function() {
	$("#quantity").change(function() {
		cart.sinplePrice()
	})
	$(".size2 li a").click(function() {
		$(".size2 li .checked").removeClass("checked")
		$(this).addClass("checked")
	})
	$('.close').on('click',function(c) {		
		var cartid=$(this).attr("title")
		cart.deleteCakeFromCart(cartid)		
	}); 
})

function addToCart(id,username){
	var number=$("#quantity").val()
	var size=$(".size1 li .checked").attr("title")
	var tier=$(".size2 li .checked").attr("title")
	
	if(cart.iflogin(username)){
		cart.addToCart({username:username,id:id,number:number,size:size,tier:tier})
	}	
}

function forwardCart(username){
	if(cart.iflogin(username)){
		cart.forwardCart(username)
	}
}

function emptyCart(username){
	if(cart.iflogin(username)){
	 cart.emptyCart(username);
	}
}



var goods="/final/goods/"

var cart = {
	URL : {
       addtoCart:function(){
	     return goods+"addCart";
       } ,

	   deleteCakeFromCart:function(){
		   return goods+"deleteOneFromCart";
	   },
	   emptyCart:function(){
		   return  goods+"emptyCart";
	   },
	   collection:function(){
		   return goods+"addCollection"
	   }
	},
	sinplePrice : function() {	
		var a=$("#quantity").val()
		var b= $(".item_price").attr("name")
		var size=$(".size1 li .checked").attr("title")
		var sinplePrice = a * b*size
		$(".item_price").html("$" + sinplePrice)
	},
	addToCart(param){
			$.post(cart.URL.addtoCart(), {
				good_id : param['id'],
				username:param['username'],
			    number:param['number'],
			    tier:param['tier'],
			    price: $(".item_price").attr("name")
			}, function(result) {
				if(result){
					cart.totalprice(param['size'],param['number'],$(".item_price").attr("name"),"+")
				}
				result?cart.publicModalShow("结果","添加成功"):cart.publicModalShow("结果","添加失败,请重试")						
			})	
	},
	iflogin(username){
		if(username!=''){
			return true
		}else{
			cart.publicModalShow("登陆状态","尚未登录,请先登陆！")
			return false
		}	
	},
	forwardCart(username){
		window.location.href = 'checkout?username='+username;
	},
	deleteCakeFromCart:function(id){
		var cartprice=$("#sinplecartprice").attr("title")
				console.log(cartprice)
		$.post(cart.URL.deleteCakeFromCart(), {
			cartId:id,
			cartprice:cartprice
		}, function(result) {		
			if(result){
				//页面动画删除效果				
				var theclass='.cart-header'+id
				$(theclass).fadeOut('slow',function(c) {
					$(theclass).remove();
				});
				cart.totalprice(1,1,cartprice,"-")
			}else{
				cart.publicModalShow("删除结果提醒","删除此商品失败")
			}
		})	
	},
	publicModalShow:function(title,content){
		$("#publicModalLabel").text(title)&&$(".public-model-body").html(content)&&$('#publicModal').modal('show');
	},
	emptyCart:function(username){
		$.post(cart.URL.emptyCart(), {
			username:username
		}, function(result) {		
			cart.publicModalShow("清空购物车结果","购物车已清空")
			$(".simpleCart_total").text(0.0);
		})	
	},
	totalprice:function(number,price,how){
		console.log(number,price,how)
		switch (how){
		case '+':
			console.log("+",parseFloat($(".simpleCart_total").html()))
		    var totaoprice=parseFloat($(".simpleCart_total").html())+number*price+0.0;
		    $(".simpleCart_total").text(totaoprice);
		    break;
		case '-':
			console.log("-",parseFloat($(".simpleCart_total").html()))
		    var totaoprice=parseFloat($(".simpleCart_total").html())-number*price+0.0;
		    $(".simpleCart_total").text(totaoprice);
		    break;
		} 
	}
}