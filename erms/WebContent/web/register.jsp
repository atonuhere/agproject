<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

 <section class="section1">
    	<div class="container clearfix">
			<div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
				<div class="col-lg-4 col-md-4 col-sm-12">
                	<h4 class="title">
                    	<span>Register Form</span>
                    </h4>
                	<form id="registerform" method="post" name="register" action="saveUser">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="First name" name="user.fname">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Last name" name="user.lname">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Email" name="user.email">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password" name="user.password">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Re-enter password" name="user.confirmPassword">
						</div>
						<div class="form-group">
							<input type="submit" class="button" value="Register an account">
						</div>
					</form>
				</div><!-- end register -->             
  			</div><!-- end content -->
       </div><!-- end container -->
</section><!-- end section -->


