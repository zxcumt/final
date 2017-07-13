//js
$(function() {
	// 地区联动选择
	$(".area").change(function() {
		order.queryChildArea($(this).attr("name"), $(this).val())
	})
	$("#paynow").click(function(){
	  $(this).attr("disabled", true); 
      var addressId= $(".addressdefault").attr("title")     
      order.payToOrder(order.goodchecked(), addressId)
	})
	$("#addressrow .addressnotdefault").click(function(){
		$("#addressrow .addressdefault").removeClass("addressdefault")
		$(this).addClass("addressdefault")
	})
})

function creatOrder(username) {
	if (cart.iflogin(username)) {
		/**
		 * 获取name=cake的购物车商品的cakeid
		 */
		var obj = $("[name='cake']")
		var check_val = order.goodchecked();
		console.log(check_val)
		if (check_val.length == 0) {
			cart.publicModalShow("生成订单提醒", "选择您需要购买的商品后重试！")
		} else {
			order.useaddress(username)
		}
	}
}
function addAddress(username) {
	console.log(username)
	var province = $("#province").find("option:selected").text()
	var city = $("#city").find("option:selected").text()
	var county = $("#county").find("option:selected").text()
	var addressdetail = $("#detail").val()
	var personname = $("#personname").val()
	var phone = $("#phone").val()
	$("#addresswarning").hide()
	if (cart.iflogin(username)==true&&order.isNull("详细地址", addressdetail) == order
			.isNull("收件人姓名", personname) == order.notPhone(phone) == false) {
		order.addAddress({
			username : username,
			province : province,
			city : city,
			county : county,
			addressdetail : addressdetail,
			personname : personname,
			phone : phone,
			isdefault : $("#defaultaddress").is(":checked")
		})
	}

}



var orderurl = "/final/order/"
var addressurl = "/final/address/"
var order = {
	URL : {
		queryUserAddress : function() {
			return addressurl + "queryUserAddress";
		},
		queryArea : function() {
			return addressurl + "queryArea";
		},
		addAddress : function() {
			return addressurl + "addAddress";
		},
		consureCart : function() {
			return orderurl + "consureCart";
		},
		payToOrder:function(){
			return orderurl + "addOrder";
		}
	},
	useaddress : function(username) {
		$.post(order.URL.queryUserAddress(), {
			username : username
		}, function(result) {
			// 该用户没有使用过的地址
			if (result.length == 0) {
				order.queryArea("province", '')
				$("#addressModal").modal("show")
			} else {
				window.location.href = 'pay?cartIds='+order.goodchecked()+"&&username="+username;
			}
		})
	},
	// 获得地址选择器
	queryArea : function(area, code) {
		var address = []
		$.post(order.URL.queryArea(), {
			area : area,
			code : code
		}, function(result) {
			var optionString = "";
			var len = result.length
			for (i = 0; i < len; i++) {
				optionString += "<option value=\'" + result[i].code + "\'>"
						+ result[i].name + "</option>";
			}
			$("#" + area).html(optionString);
			$("#" + area).selectpicker('refresh');
			order.queryChildArea(area, result[0].code)
		})
	},
	queryChildArea : function(area, code) {
		switch (area) {
		case 'province':
			order.queryArea("city", code)
			break
		case 'city':
			order.queryArea("county", code)
			break
		default:
			break
		}
	},
	isNull : function(key, value) {
		if (value == '') {
			$("#addresswrong").html(key + "不能为空，请填写完整")
			$("#addresswarning").show()
			return true
		} else {
			return false
		}
	},
	notPhone : function(phone) {
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (!myreg.test(phone)) {
			$("#addresswrong").html("请输正确的手机号")
			$("#addresswarning").show()
			return true
		} else {
			return false
		}
	},
	addAddress : function(param) {
		$.post(order.URL.addAddress(), param, function(result) {
			if (result) {	
				if(order.goodchecked()==''){
					index.addAddressSuccess(param["username"]);
				}else{
					window.location.href = 'pay?cartIds='+order.goodchecked()+"&&username="+param["username"];
				}
				
			}
		})
	},
	goodchecked : function() {
		var obj = $("[name='cake']")
		var check_val = [];
		for (k in obj) {
			if (obj[k].checked)
				check_val.push(obj[k].value);
		}
		return check_val
	},
	payToOrder:function(cartIds,addressId){
		$.post(order.URL.payToOrder(),{cartIds:cartIds,addressId:addressId},function(result){
			if(result){
				console.log("支付成功")
				window.location.href="ordersuccess?orderId="+result;		
			}else{
				cart.publicModalShow("支付提醒","支付失败，订单未生成");
			    console.log("支付失败")
			}	
		})
	}
//	consureShoppingcart : function(cartIds) {
//		$.post(order.URL.consureCart(), {
//			cartIds : cartIds
//		}, function(result) {
//			console.log(result)
//		})
//	}

}