<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<s:actionerror/>
<s:actionmessage/>


<section class="section1">
    	<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-4 col-md-4 col-sm-12">
                	<h4 class="title">
                    	<span>Login Form</span>
                    </h4>
                	<s:form method="post" name="loginform" action="doLogin" namespace="/">
						<div class="form-group">
							<div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" class="form-control" placeholder="Username" name="username">
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
					</s:form>
                </div><!-- end login -->
				             
  			</div><!-- end content -->
        </div><!-- end container -->
</section><!-- end section -->
