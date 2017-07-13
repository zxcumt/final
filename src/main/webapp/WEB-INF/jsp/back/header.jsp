<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<title></title>
</head>
<body>
    <div class="header1">
        <div class="header2">
            <div class="logo">
                <strong>被涂鸦后台管理系统</strong>
            </div>
            <div class="contact">
                <div class="prompt">
                    <span id="today"></span>
                </div>
                <div id="headerMenu" class="headerMenu">
                    <ul>
                        <li><a href="#" class="easyui-linkbutton" data-options="plain:true" onclick="exit()">安全退出</a></li>
                        <li><a class="easyui-linkbutton" data-options="plain:true" >您好，<s:property value="#session.userName"/></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
  <script type="text/javascript">
		function exit(){
			$.messager.confirm('确认','您确认想要安全退出吗？',function(r){    
			    if (r){
					var url ='back_exit.action';
					  $('<form method="post" action="' + url + '"></form>').appendTo('body').submit().remove();
			    }    
			});
		};
	</script> 
</body>
</html>