<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="pages"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   	<title><decorator:title default="Enterprise Risk Management system"/></title>
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="${rootpath}assets/images/favicon.ico">
    
	<!-- Google Fonts -->
    <link rel="stylesheet" type="text/css" href="${rootpath}assets/css/OpenSans.css" >
    <link rel="stylesheet" type="text/css" href="${rootpath}assets/css/Raleway.css" >
	<!-- Awesome Fonts -->
	<link rel="stylesheet" type="text/css" href="${rootpath}assets/css/font-awesome.css">
	
	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="${rootpath}assets/css/bootstrap.css" >
	<link rel="stylesheet" type="text/css" href="${rootpath}assets/css/bootstrap-datetimepicker.min.css" >
	<!-- Template Styles -->
	<link rel="stylesheet" type="text/css" href="${rootpath}assets/css/style.css">
	<link rel="stylesheet" type="text/css" href="${rootpath}assets/css/colors.css"> 
	
	   
	<!-- Layer Slider -->
	
	<!-- http://www.456bereastreet.com/archive/201209/tell_css_that_javascript_is_available_asap/ -->
	<script>
		document.documentElement.className = document.documentElement.className.replace(/(\s|^)no-js(\s|$)/, '$1js$2');
	</script>
  
  	<script src="${rootpath}assets/js/jquery.js"></script>
   	<s:head />
  	
	<!-- Support for HTML5 -->
	<!--[if lt IE 9]>
		<script src="${rootpath}assets/js/html5.js"></script>
	<![endif]-->

	<!-- Enable media queries on older browsers -->
	<!--[if lt IE 9]>
		<script src="${rootpath}assets/js/respond.min.js"></script>
	<![endif]-->
  
	<script src="${rootpath}assets/js/modernizr.js"></script>
	
	
  	
  	
  	
  </head>
<body class="boxed">
<!-- BOXED WRAPPER -->
    <div id="wrapper" class="container">
    	
    	 <!--------Topbar start----------->
    	<div class="topbar clearfix">
		 	<div class="container">
				<div class="col-lg-6 col-md-6 col-sm-12 text-left">
				             <div class="social_buttons">
				                 <a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a>
				                 <a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a>
				                 <a href="#" data-toggle="tooltip" data-placement="bottom" title="Google+"><i class="fa fa-google-plus"></i></a>
				                 <a href="#" data-toggle="tooltip" data-placement="bottom" title="Github"><i class="fa fa-github"></i></a>
				                 <a href="#" data-toggle="tooltip" data-placement="bottom" title="Dribbble"><i class="fa fa-dribbble"></i></a>
				                 <a href="#" data-toggle="tooltip" data-placement="bottom" title="RSS"><i class="fa fa-rss"></i></a>
				             </div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 text-right">
				         	<div class="callus">
				                 <p><span><i class="fa fa-envelope-o"></i>support@gfsindia.com</span> <span><i class="fa fa-phone"></i> +91 33 2462 4153</span></p>
				             </div>
				</div>
		 	</div><!-- end container -->
		</div>
		<!-- end topbar -->
	    <!--------Header start----------->
	    <%@ include file="header.jsp" %>
	    <!--------Header End----------->
	    
	    <!--------Post wrapper End----------->
		<section class="post-wrapper-top">
	    	<div class="container">
	            <div class="post-wrapper-top-shadow">
	                <span class="s1"></span>
	            </div>
	            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	                <ul class="breadcrumb">
	                    <li><a href="home.html">Home</a></li>
	                    <li>${menu}</li>
	                </ul>
	                <h2 style="text-transform: uppercase;">${menu}</h2>
	            </div>
	            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<!-- search -->
						<div class="search-bar">
							<form action="#" method="get">
								<fieldset>
									<input type="image" src="${rootpath}assets/images/pixel.gif" class="searchsubmit" alt="" />
									<input type="text" class="search_text showtextback" name="s" id="s" value="Search on this site..." />							
								</fieldset>
							</form>
						</div>
						<!-- / end div .search-bar -->
	            </div>
	        </div>
		</section>
		<!-- end post-wrapper-top -->
		
		<!--------Content start----------->
	    <section class="section1">
	    	<div class="container clearfix">
	        	<div class="content clearfix">
	        		  	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
		        			<s:actionerror/>
		        			<s:actionmessage/>
		        			<div class="alert alert-danger hide" id="messageErrorContent">
		        				${sessionScope.errorAction.errorMessage}
		        			</div>
		        			<div class="alert alert-success hide" id="messageSuccessContent">
		        				${sessionScope.successAction.successMessage}
		        			</div>
		        		</div>
		        		<div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12 clearfix">
		        		  	<div id="sidebar" class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
		        		  	 <%@ include file="menu.jsp" %>
		        		  	</div><!-- end sidebar -->
		        		  
		        		  	<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
			    				<decorator:body/>
			    			</div>
			    		</div>		
		    	</div><!-- end content -->
		    </div><!-- end container -->
	    </section><!-- end section -->		       
	    <!--------Content end----------->
	    
	    <!--------Footer start-----------> 
	    <%@ include file="footer.jsp" %>
	    <!--------Footer end----------->
     	<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		</div>
		<!-- Modal End-->
     	<div class="dmtop">Scroll to Top</div>
	    
	    <!-- Main Scripts-->
		
		<script src="${rootpath}assets/js/bootstrap.min.js"></script>
		<script src="${rootpath}assets/js/jquery.unveilEffects.js"></script>	
		<script src="${rootpath}assets/js/retina-1.1.0.js"></script>
		<script src="${rootpath}assets/js/jquery.hoverdir.js"></script>
	    <script src="${rootpath}assets/js/owl.carousel.js"></script>	
	    <script src="${rootpath}assets/js/jetmenu.js"></script>	
		<script src="${rootpath}assets/js/jquery.hoverex.min.js"></script>
		<script src="${rootpath}assets/js/jquery.prettyPhoto.js"></script>
		<script src="${rootpath}assets/js/custom.js"></script>
		<script src="${rootpath}assets/js/bootstrap-datetimepicker.min.js"></script>
		<script src="${rootpath}assets/js/main.js"></script>
		
   </div><!-- end boxed -->
   <c:if test="${sessionScope.errorAction.errorMessage ne null }">
	<script>
		$('#messageErrorContent').show();
	</script>
	</c:if>
	<c:if test="${sessionScope.successAction.successMessage ne null }">
	<script>
		$('#messageSuccessContent').show();
	</script>
	</c:if>  
</body>
</html>
