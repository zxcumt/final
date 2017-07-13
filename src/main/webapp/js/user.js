//存放主要交互逻辑的js代码
// javascript 模块化(package.类.方法)

$(function() {
	/*
	 * 隐藏验证提醒
	 */
	$("#email").focus(function() {
		$("#emailwarning").hide()
		$("#loginwarning").hide()
	})
	/*
	 * 登陆
	 */
	$("#login").click(function() {
		index.login({
			email : $("#email").val(),
			password : $("#password").val()
		})
	})
	/*
	 * 记住名称
	 */
	if ($.cookie("user") == "true") {
		$("#email").val($.cookie("username"));
		$("#password").val($.cookie("password"));
	}
	/*
	 * 判断邮箱是否已经被注册过
	 */
	$("#newemail").focusout(function() {
		index.emailcanuse($("#newemail").val());
	})
	/*
	 * 注册
	 */
	$("#register").click(function() {
		index.register({
			username : $("#newemail").val(),
			password : $("#newpassword").val(),
			password2 : $("#newpassword1").val()
		})
	})
	/*
	 * 找回密码的发送邮箱验证码
	 */
	$("#consure").click(function() {
		console.log("执行了")
		index.findEmail($("#emailconsure").val())
	})
	$("#findPasswordNext").click(function() {
		console.log($("#findPasswordNext").html())
		if ($("#findPasswordNext").html() == "完成") {// 找回密码第二部
			index.findPasswordThree({
				password : $("#emailconsure").val(),
				password2 : $("#message-identify").val()
			})

		} else {
			index.findPasswordNext({// 找回密码第一步
				email : $("#emailconsure").val(),
				identify : $("#message-identify").val()
			})
		}
	})
	$(".usermenuleft a").click(function() {		
		var menu = $(this).text()
		$(".usermenuleft .active").removeClass("active")
		$(this).addClass("active")
		$(".panel-title").text(menu)
		var username=$("#isLogin").attr("title")
		if (username!=undefined) {
			
			index.switchMenu(menu,username)	
		}else{
			cart.publicModalShow("登陆状态","尚未登录,请先登陆！")
		}
	})

  
})

function usermessage(username) {
	if (cart.iflogin(username)) {
		window.location.href = "userdetail?username=" + username
	}
}

function setDeaultAddresss(addressId,username){
	index.changeDefaultAddress({
		id:addressId,
		username:username
	})
}

function addNewAddress(username){
	if (cart.iflogin(username)) {
		order.queryArea("province", '')
		$("#addressModal").modal("show")
	}
}
function deleteAddress(id,username){
	if (cart.iflogin(username)) {
		index.deleteAddress(id)
	}
}

function collect(id){
	index.collect(id)
}

var user = "/final/user/"
var newemail = false
var index = {
	// 封装秒杀相关ajax的url
	URL : {

		login : function() {
			return user + 'login';
		},
		logincancel : function() {
			return user + 'logincancel';
		},
		register : function() {
			return user + 'register';
		},
		emailcanuse : function() {
			return user + 'isused';
		},
		findpassword : function() {
			return user + "findpassword";
		},
		findpasswordnext : function() {
			return user + "findpasswordnext";
		},
		findPasswordThree : function() {
			return user + "findpasswordthree";
		},
		usermenu:function(){
			return user+"usermenu";
		},
		changeDefaultAddress:function(){
			return "/MiaoSha/address/changeAddress";
		},
		deleteAddress:function(){
			return "/MiaoSha/address/deleteAddress"
		},

	},
	isEmail : function(email) {
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		return reg.test(email);
	},
	login : function(param) {
		index.isEmail(param['email']) ? $.get(index.URL.login(), {
			username : param['email'],
			password : param['password']
		}, function(result) {

			result ? location.reload() : $("#loginwarning").show();
			$("#checkbox").is(":checked") ? $.cookie('username',
					param['email'], {
						expires : 7
					})
					&& $.cookie('password', param['password'], {
						expires : 7
					}) && $.cookie('user', true, {
						expires : 7
					}) : $.cookie('username', {
				expires : -1
			}) && $.cookie('password', {
				expires : -1
			} && $.cookie('user', false, {
				expires : -1
			}))
		}) : $("#emailwarning").show()
	},
	logincancel : function(username) {
		$.get(index.URL.logincancel(), {
			username : username
		}, function(result) {
			result ? location.reload() : console.log("注销失败");
		});
	},
	emailcanuse : function(email) {
		newemail = false;
		index.isEmail(email) ? $.post(index.URL.emailcanuse(), {
			username : email,
		}, function(result) {
			result ? ($("#emailcontent").html('该邮箱已经被注册') && $(
					"#newemailwarnings").show()) : $("#newemailwarnings")
					.hide();
			result ? newemail = false : newemail = true;
		}) : $("#emailcontent").html('请输入正确的邮箱')
				&& $("#newemailwarnings").show()
	},
	register : function(param) {
		console.log(newemail)
		newemail ? (param['password'] != ''
				&& param['password'] == param['password2'] ? ($(
				"#newpasswordwarning").hide() &&
		/*
		 * 密码不为空且两个相等
		 */
		$.post(index.URL.register(), {
			username : param['username'],
			password : param['password'],
		}, function(result) {
			result ? $(location).attr('href', 'index') : alert("注册失败");
		})) : $("#newpasswordwarning").show()) : console.log("青")
	},
	findEmail : function(email) {
		$("#findpasswordwarning").hide()
		index.isEmail(email) ? $.post(index.URL.findpassword(), {
			username : email,
		}, function(result) {
			result ? $("#consure").attr("disabled", true)
					&& $("#consure").html("已发送")
					&& $("#emailconsure").attr("disabled", "disabled") : $(
					"#findpasswprdwrong").html("邮箱未被注册")
					&& $("#findpasswordwarning").show();
		}) : $("#findpasswprdwrong").html("请输入正确的邮箱")
				&& $("#findpasswordwarning").show()
	},
	findPasswordNext : function(param) {
		$("#findpasswordwarning").hide()
		$.post(index.URL.findpasswordnext(), {
			identify : param['identify'],
			username : param['email']
		}, function(result) {
			if (result) {
				$("#lableidentify").html("确认密码");
				$("#lableemail").html("新密码");
				$("#findPasswordNext").html("完成")
				$("#consure").hide();
				$("#emailconsure,#message-identify").val("");
				$("#emailconsure").removeAttr("disabled")
			} else {
				$("#findpasswprdwrong").html("验证码错误");
				$("#findpasswordwarning").show()
			}

		})
	},
	findPasswordThree : function(param) {
		console.log(param)
		$("#findpasswordwarning").hide()
		param['password'] != '' && param['password'] == param['password2'] ? $
				.post(index.URL.findPasswordThree(), {
					password : param['password'],
					username : $.cookie("username")
				}, function(result) {
					result ? location.reload() : $("#findpasswprdwrong").html(
							"修改密码失败，未知原因")
							&& $("#findpasswordwarning").show()
				}) : $("#findpasswprdwrong").html("密码为空或两次密码不相等")
				&& $("#findpasswordwarning").show()
	},
	switchMenu:function(menu,username){		
		$(".panel-body").load(index.URL.usermenu(), {menu:menu,username:username}, function(result) {
			console.log(menu)
		});
	},
	changeDefaultAddress(param){
		$.post(index.URL.changeDefaultAddress(),param,function(result){
			result?index.switchMenu("我的地址",param["username"]):cart.publicModalShow("提醒","更改默认地址失败")
		})
	},
	addAddressSuccess(username){
		$("#addressModal").modal("hide")
		index.switchMenu("我的地址",username)
	},
	deleteAddress:function(id){
		$.post(index.URL.deleteAddress(),{id:id},function(result){
			cart.publicModalShow("提醒","地址已删除")
            index.switchMenu("我的地址",$("#isLogin").attr("title"))
		})
	},
	collect:function(id){
	var username=index.iflogin()
			if (username!='') {					
		              $.post(cart.URL.collection(),{id:id,username:username},function(result){	
		            	  console.log(result)
		    })
		}
	},
	iflogin(){
		var username=$("#isLogin").attr("title")
		if (username!=undefined) {
				return username
		}else{
			  cart.publicModalShow("登录提醒","请先登录")
			  return  '';
		}
	}

// now: function () {
// return '/seckill/time/now';
// },
// exposer: function (seckillId) {
// return '/seckill/' + seckillId + '/exposer';
// },
// execution: function (seckillId, md5) {
// return '/seckill/' + seckillId + '/' + md5 + '/execution';
// }
// },
/*
 * //验证手机号 validatePhone: function (phone) { if (phone && phone.length == 11 &&
 * !isNaN(phone)) { return true;//直接判断对象会看对象是否为空,空就是undefine就是false; isNaN
 * 非数字返回true } else { return false; } },
 * 
 * //详情页秒杀逻辑 detail: { //详情页初始化 init: function (params) { //手机验证和登录,计时交互
 * //规划我们的交互流程 //在cookie中查找手机号 var userPhone = $.cookie('userPhone'); //验证手机号 if
 * (!seckill.validatePhone(userPhone)) { //绑定手机 控制输出 var killPhoneModal =
 * $('#killPhoneModal'); killPhoneModal.modal({ show: true,//显示弹出层 backdrop:
 * 'static',//禁止位置关闭 keyboard: false//关闭键盘事件 });
 * 
 * $('#killPhoneBtn').click(function () { var inputPhone =
 * $('#killPhoneKey').val(); console.log("inputPhone: " + inputPhone); if
 * (seckill.validatePhone(inputPhone)) { //电话写入cookie(7天过期)
 * $.cookie('userPhone', inputPhone, {expires: 7, path: '/seckill'}); //验证通过
 * 刷新页面 window.location.reload(); } else { //todo 错误文案信息抽取到前端字典里
 * $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300); }
 * }); }
 * 
 * //已经登录 //计时交互 var startTime = params['startTime']; var endTime =
 * params['endTime']; var seckillId = params['seckillId'];
 * $.get(seckill.URL.now(), {}, function (result) { if (result &&
 * result['success']) { var nowTime = result['data']; //时间判断 计时交互
 * seckill.countDown(seckillId, nowTime, startTime, endTime); } else {
 * console.log('result: ' + result); alert('result: ' + result); } }); } },
 * 
 * handlerSeckill: function (seckillId, node) { //获取秒杀地址,控制显示器,执行秒杀
 * node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
 * 
 * $.get(seckill.URL.exposer(seckillId), {}, function (result) { //在回调函数种执行交互流程
 * if (result && result['success']) { var exposer = result['data']; if
 * (exposer['exposed']) { //开启秒杀 //获取秒杀地址 var md5 = exposer['md5']; var killUrl =
 * seckill.URL.execution(seckillId, md5); console.log("killUrl: " + killUrl);
 * //绑定一次点击事件 $('#killBtn').one('click', function () { //执行秒杀请求 //1.先禁用按钮
 * $(this).addClass('disabled');//,<-$(this)===('#killBtn')-> //2.发送秒杀请求执行秒杀
 * $.post(killUrl, {}, function (result) { if (result && result['success']) {
 * var killResult = result['data']; var state = killResult['state']; var
 * stateInfo = killResult['stateInfo']; //显示秒杀结果 node.html('<span class="label
 * label-success">' + stateInfo + '</span>'); } }); }); node.show(); } else {
 * //未开启秒杀(浏览器计时偏差) var now = exposer['now']; var start = exposer['start']; var
 * end = exposer['end']; seckill.countDown(seckillId, now, start, end); } } else {
 * console.log('result: ' + result); } }); },
 * 
 * countDown: function (seckillId, nowTime, startTime, endTime) {
 * console.log(seckillId + '_' + nowTime + '_' + startTime + '_' + endTime); var
 * seckillBox = $('#seckill-box'); if (nowTime > endTime) { //秒杀结束
 * seckillBox.html('秒杀结束!'); } else if (nowTime < startTime) { //秒杀未开始,计时事件绑定
 * var killTime = new Date(startTime + 1000);//todo 防止时间偏移
 * seckillBox.countdown(killTime, function (event) { //时间格式 var format =
 * event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒 '); seckillBox.html(format);
 * }).on('finish.countdown', function () { //时间完成后回调事件 //获取秒杀地址,控制现实逻辑,执行秒杀
 * console.log('______fininsh.countdown'); seckill.handlerSeckill(seckillId,
 * seckillBox); }); } else { //秒杀开始 seckill.handlerSeckill(seckillId,
 * seckillBox); } }
 */
}