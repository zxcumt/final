<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
    
    
    
     addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //Custom Theme files -->
<%@include file="/public/bootstraphead.jsp"%>
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
    rel="stylesheet" media="all">
<script src="<%=request.getContextPath()%>/js/imagezoom.js"></script>
 
<title>订单评价</title>
</head>
<body>
<!--header-->
    <%@include file="/public/head.jsp"%>
    <%@include file="/public/findpasswordmodal.jsp"%>
    <%@include file="/public/publicmodal.jsp"%>
    <!--//header-->
	<div style="margin-top:82px;font-size:20px;text-align: center;">
	商品打分<div id="quality" class="star-s"></div><br/>
    </div>
    
<center> 
<table border=-1> 
<tr> 
<td style="text-align: center;">用户名:</td> 
<td><textarea style="text-align: center;" name="memo" rows=2 cols=60></textarea></td> 
</tr> 
<tr> 
<td style="text-align: center;">评:</td> 
<td><textarea style="text-align: center;" name="memo" rows=4 cols=60></textarea></td> 
</tr>
</table> 
</center> 
<div class="register-but" style="text-align: center;">

		<input id="register" type="submit" value="submit">
		<div class="clearfix"></div>

</div>    
    
	<script type="text/javascript">
	 function StarComment(eleID) {
                  var starValue = 1;
                  var tar = $("#" + eleID)[0];
                  var dealMousemove=function(e) {
                     var that = e;
                      console.log(e.offsetX);
                      starValue = parseInt(e.offsetX / 15) + 1;
                      tar.className = "star-s s" + starValue.toString();
                     console.log(tar.className);
                 }
                 $(tar).bind("mousemove", function (e) {
                     dealMousemove(e);
                 });
                 $(tar).bind("click", function () {
                     $(tar).unbind("mousemove")
                 });
                 
                 /*开放接口函数：返回div的星级分数*/
                 this.getStarValue=function(){
                     return starValue;
                 }
             }
 
             /*根据需要初始化指定的div，给其赋予星级得分功能*/
             var starQuality = new StarComment("quality");
            
             </script>
	 <!--collapse --> 
	<div class="collpse tabs">
        <div class="container">
            <div class="panel-group collpse" id="accordion" role="tablist"
                aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion"
                                href="#collapseOne" aria-expanded="true"
                                aria-controls="collapseOne"> 谢谢惠顾，期待下次的相遇。</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in"
                        role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">希望您喜欢我们的商品！
                        </div>
                    </div>
                </div>
                
        </div>
    </div>
    <!--//collapse --> 
	 
</body>
</html>