<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>single</title>
<!-- Custom Theme files -->
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
<!-- //js -->
<!-- FlexSlider -->
<script defer
    src="<%=request.getContextPath()%>/js/jquery.flexslider.js"></script>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/flexslider.css" type="text/css"
    media="screen" />
<script>
    // Can also be used with $(document).ready()
    $(window).load(function() {
        $('.flexslider').flexslider({
            animation : "slide",
            controlNav : "thumbnails"
        });
    });
</script>
<!--//FlexSlider -->
</head>
<body>
    <!--header-->
    <%@include file="/public/head.jsp"%>
    <%@include file="/public/findpasswordmodal.jsp"%>
    <%@include file="/public/publicmodal.jsp"%>
    <!--//header-->
    <!--//single-page-->
    <div class="single">
        <div class="container">
            <div class="single-grids">
                <div class="col-md-4 single-grid">
                    <div class="flexslider">
                        <ul class="slides">
                            <c:forEach var="image" items="${cake.image}" varStatus="idx">
                                <li data-thumb="${image}">
                                    <div class="thumb-image">
                                        <img src="${image}" data-imagezoom="true"
                                            class="img-responsive">
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4 single-grid simpleCart_shelfItem">
                    <h3>${cake.name}</h3>
                    <p>${cake.content}</p>
                    <ul class="size size1">
                        <h3></h3>
                        <li><a class="checked" href="#" title="1"></a></li>
                        
                    </ul>
                    <ul class="size size2">
                        <h3></h3>
                        <li><a class="checked" href="#" title="1"></a></li>
                        
                    </ul>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price" name="${cake.price}">$${cake.price}</h5>
                        </div>
                        <div class="rating">
                            <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
                            <span>☆</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <p class="qty">数量 :</p>
                    <input min="1" type="number" id="quantity" name="quantity"
                        value="1" class="form-control input-small">
                    <div class="btn_form">
                        <a href="#"
                            onclick="addToCart('${cake.id}','${sessionScope.username}')"
                            class="add-cart item_add">加入购物车</a>
                    </div>
                   
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- collapse -->
    <div class="collpse tabs">
        <div class="container">
            <div class="panel-group collpse" id="accordion" role="tablist"
                aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion"
                                href="#collapseOne" aria-expanded="true"
                                aria-controls="collapseOne"> Description </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in"
                        role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">Anim pariatur cliche reprehenderit,
                            enim eiusmod high life accusamus terry richardson ad squid. 3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch.
                            Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
                            tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
                            craft beer labore wes anderson cred nesciunt sapiente ea
                            proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
                            craft beer farm-to-table, raw denim aesthetic synth nesciunt you
                            probably haven't heard of them accusamus labore sustainable VHS.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse"
                                data-parent="#accordion" href="#collapseTwo"
                                aria-expanded="false" aria-controls="collapseTwo">
                                additional information </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse"
                        role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">Anim pariatur cliche reprehenderit,
                            enim eiusmod high life accusamus terry richardson ad squid. 3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch.
                            Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
                            tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
                            craft beer labore wes anderson cred nesciunt sapiente ea
                            proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
                            craft beer farm-to-table, raw denim aesthetic synth nesciunt you
                            probably haven't heard of them accusamus labore sustainable VHS.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse"
                                data-parent="#accordion" href="#collapseThree"
                                aria-expanded="false" aria-controls="collapseThree"> reviews
                                (5) </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse"
                        role="tabpanel" aria-labelledby="headingThree">
                        <div class="panel-body">Anim pariatur cliche reprehenderit,
                            enim eiusmod high life accusamus terry richardson ad squid. 3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch.
                            Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
                            tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
                            craft beer labore wes anderson cred nesciunt sapiente ea
                            proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
                            craft beer farm-to-table, raw denim aesthetic synth nesciunt you
                            probably haven't heard of them accusamus labore sustainable VHS.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFour">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse"
                                data-parent="#accordion" href="#collapseFour"
                                aria-expanded="false" aria-controls="collapseFour"> help </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse"
                        role="tabpanel" aria-labelledby="headingFour">
                        <div class="panel-body">Anim pariatur cliche reprehenderit,
                            enim eiusmod high life accusamus terry richardson ad squid. 3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch.
                            Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
                            tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
                            craft beer labore wes anderson cred nesciunt sapiente ea
                            proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
                            craft beer farm-to-table, raw denim aesthetic synth nesciunt you
                            probably haven't heard of them accusamus labore sustainable VHS.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--//collapse -->
 </body>
 </html>  
   