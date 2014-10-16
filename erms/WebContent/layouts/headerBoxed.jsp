<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
                    <p><span><i class="fa fa-envelope-o"></i>info@gfsindia.com</span> <span><i class="fa fa-phone"></i> +91 33 2462 4153</span></p>
                </div>
                
			</div>
    	</div><!-- end container -->
    </div><!-- end topbar -->

    <header class="header">
    	<div class="container">
        	<div class="site-header clearfix">
                <div class="col-lg-3 col-md-3 col-sm-12 title-area pull-left">
                    <div class="site-title" id="title">
                        <a href="index-2.html" title="">
                            <img src="images/gfs_logo.png" alt="">	
                        </a>
                    </div>
                </div><!-- title area -->
                <div class="col-lg-9 col-md-12 col-sm-12">
                   <div id="nav">
                        <div class="container clearfix">
                        <ul id="jetmenu" class="jetmenu blue">
                            
                            <li class="right"><a href="#"><i class="icon-user"></i> Client Login</a>
                                <div class="megamenu half-width">
                                    <div class="col-lg-8 col-md-8 col-sm-12">
                                        <h5 class="title">Login</h5>
                                        <form id="loginform" method="post" name="loginform" action="doLogin.html">
											<div class="form-group">
												<div class="input-group">
						                               <span class="input-group-addon"><i class="fa fa-user"></i></span>
						                               <input type="search" class="form-control" placeholder="Username" name="username">
												</div>
											</div>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"><i class="fa fa-lock"></i></span>
													<input type="password" class="form-control" placeholder="Password" name="password">
												</div>
											</div>
											<div class="form-group">
												<div class="checkbox">
													<label> 
														<input type="checkbox" name="rememberMe"> Remember me
													</label>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="button">Sign in</button>
											</div>
										</form>
                                     </div>
                                    
                                </div>
                            </li>
                        </ul>
                        </div>
                    </div><!-- nav -->   
                </div><!-- title area -->
            </div><!-- site header -->
    	</div><!-- end container -->
    </header><!-- end header -->