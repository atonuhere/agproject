<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://bibeault.org/tld/ccc" prefix="ccc" %>
<ccc:constantsMap className="com.gfs.erm.web.common.WebConstants" var="Constants"/>
<c:set var="loguser" value="${sessionScope[Constants.CURRENT_USER_SESSION]}"/>


    <header class="header">
    	<div class="container">
        	<div class="site-header clearfix">
                <div class="col-lg-3 col-md-3 col-sm-12 title-area pull-left">
                    <div class="site-title" id="title">
                        <a href="home.html" title="">
                            <img src="${rootpath}images/gfs_logo.png" alt="">	
                        </a>
                    </div>
                </div><!-- title area -->
                <div class="col-lg-9 col-md-12 col-sm-12">
                   <div id="nav">
                        <div class="container clearfix">
                        <ul id="jetmenu" class="jetmenu blue">
                            <li class="<c:if test="${menu eq 'home'}" >active</c:if>">
                            	<a href="${rootpath}home.html">Home</a>
                                
                            </li>
                            <li class="<c:if test="${menu eq 'incident'}" >active</c:if>">
                            	<a href="${rootpath}incident/index.html">Incident</a>
                                <ul class="dropdown">
                                    <li><a href="${rootpath}incident.html">Incident</a>
                                </ul>
                            </li>
                            <c:if test="${loguser ne null}" >
                            <li class="right"><a href="#"><i class="icon-user"></i> Logged in</a>
                                <div class="megamenu half-width">
                                    <div class="row">
                                        <div class="col2">
                                        <h5 class="title"> ${loguser.userName}</h5>
                                            <ul class="contact_details">
                                                <li><i class="fa fa-envelope-o"></i> Edit Profile</li>
                                                <li><i class="fa fa-envelope-o"></i> Change Password</li>
                                            </ul><!-- contact_details -->
                                        </div>
                                    </div>
                                    
                                </div>
                            </li>
                            </c:if>
                        </ul>
                        </div>
                    </div><!-- nav -->   
                </div><!-- title area -->
            </div><!-- site header -->
    	</div><!-- end container -->
    </header><!-- end header -->