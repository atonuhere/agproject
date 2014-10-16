<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="pages"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   	<title><decorator:title default="Enterprise Risk Management system"/></title>
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="${rootpath}images/favicon.ico">
    
	<!-- Google Fonts -->
    <link rel="stylesheet" type="text/css" href="${rootpath}css/OpenSans.css" >
    <link rel="stylesheet" type="text/css" href="${rootpath}css/Raleway.css" >
	<!-- Awesome Fonts -->
	<link rel="stylesheet" type="text/css" href="${rootpath}css/font-awesome.css">
	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="${rootpath}css/bootstrap.css" >
	<!-- Template Styles -->
	<link rel="stylesheet" type="text/css" href="${rootpath}css/style.css">
	<link rel="stylesheet" type="text/css" href="${rootpath}css/colors.css">    
	<!-- Layer Slider -->
	<link rel="stylesheet" type="text/css" href="${rootpath}js/layerslider/css/layerslider.css">
	<!-- http://www.456bereastreet.com/archive/201209/tell_css_that_javascript_is_available_asap/ -->
	<script>
		document.documentElement.className = document.documentElement.className.replace(/(\s|^)no-js(\s|$)/, '$1js$2');
	</script>
  
	<!-- Support for HTML5 -->
	<!--[if lt IE 9]>
		<script src="${rootpath}js/html5.js"></script>
	<![endif]-->

	<!-- Enable media queries on older browsers -->
	<!--[if lt IE 9]>
		<script src="${rootpath}js/respond.min.js"></script>
	<![endif]-->
  
	<script src="${rootpath}js/modernizr.js"></script>
  
  </head>
<body class="boxed">
<!-- BOXED WRAPPER -->
    <div id="wrapper" class="container">
    
	    <!--------Header start----------->
	    <%@ include file="headerBoxed.jsp" %>
	    <!--------Header End----------->
		
		<!--------Content start----------->
	    <decorator:body/>       
	    <!--------Content end----------->
	    
	    <!--------Footer start-----------> 
	    <%@ include file="footerBoxed.jsp" %>
	    <!--------Footer end----------->
     
   </div><!-- end boxed -->
    
</body>
</html>