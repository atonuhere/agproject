<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <footer class="footer">
        <div class="container">
            <div class="widget col-lg-3 col-md-3 col-sm-12">
            <h4 class="title">About us</h4>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since the 1500s..</p>
                <a class="button small" href="#">read more</a>
            </div><!-- end widget -->
            <div class="widget col-lg-3 col-md-3 col-sm-12">
            <h4 class="title">Recent Posts</h4>
				<ul class="recent_posts">
					<li>
                    	<a href="#">
						<img src="${rootpath}images/demos/01_recent_post.png" alt="" />Mockup Design PSD Template
                        </a>
						<a class="readmore" href="#">read more</a>
					</li>
					<li>
                    	<a href="#">
						<img src="${rootpath}images/demos/02_recent_post.png" alt="" />App Screen Mockup Template
                        </a>
						<a class="readmore" href="#">read more</a>
					</li>
				</ul><!-- recent posts -->
            </div><!-- end widget -->  
            <div class="widget col-lg-3 col-md-3 col-sm-12">
            <h4 class="title">Get In Touch</h4>
                <ul class="contact_details">
                	<li><i class="fa fa-envelope-o"></i> support@gfsindia.com</li>
                	<li><i class="fa fa-envelope-o"></i> info@gfsindia.com</li>
                	<li><i class="fa fa-phone-square"></i> +90 04 333 02 22</li>
                	<li><i class="fa fa-home"></i> Istanbul Universitesi Iletisim Fakultesi, Istanbul, TURKEY</li>
                	<li><a href="#"><i class="fa fa-map-marker"></i> View large map</a></li>
                </ul><!-- contact_details -->
            </div><!-- end widget -->  
            <div class="widget col-lg-3 col-md-3 col-sm-12">
            <h4 class="title">Flickr Stream</h4>
				<ul class="flickr">
					<li><a href="#"><img alt="" src="${rootpath}images/demos/01_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/02_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/03_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/04_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/05_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/06_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/07_flickr.jpg"></a></li>
					<li><a href="#"><img alt="" src="${rootpath}images/demos/08_flickr.jpg"></a></li>
				</ul>
            </div><!-- end widget -->  
        </div><!-- end container -->
        
        <div class="copyrights">
            <div class="container">
                <div class="col-lg-6 col-md-6 col-sm-12 columns">
                    <p>Copyright © 2014 - All right reserved. Designed by <a title="Enterprise HTML Themes" href="http://gfsinida.com/">Greenfield Solutions</a></p>
                </div><!-- end widget -->
                <div class="col-lg-6 col-md-6 col-sm-12 columns text-right">
                    <div class="footer-menu right">
                        <ul class="menu">
                            <li><a href="#">Home</a></li>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Sitemap</a></li>
                            <li><a href="#">Site Terms</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </div>
                </div><!-- end large-6 -->   
            </div><!-- end container -->
        </div><!-- end copyrights -->
    </footer><!-- end footer -->
    <div class="dmtop">Scroll to Top</div>

      <!-- Main Scripts-->
	<script src="${rootpath}js/jquery.js"></script>
	<script src="${rootpath}js/bootstrap.min.js"></script>
    <script src="${rootpath}js/jquery.unveilEffects.js"></script>	
	<script src="${rootpath}js/retina-1.1.0.js"></script>
	<script src="${rootpath}js/jquery.hoverdir.js"></script>
    <script src="${rootpath}js/owl.carousel.js"></script>	
    <script src="${rootpath}js/jetmenu.js"></script>	
	<script src="${rootpath}js/jquery.hoverex.min.js"></script>
	<script src="${rootpath}js/jquery.prettyPhoto.js"></script>
	<script src="${rootpath}js/custom.js"></script>
	<!-- LayerSlider script files -->
	<script src="${rootpath}js/layerslider/js/greensock.js" type="text/javascript"></script>
	<script src="${rootpath}js/layerslider/js/layerslider.transitions.js" type="text/javascript"></script>
	<script src="${rootpath}js/layerslider/js/layerslider.kreaturamedia.jquery.js" type="text/javascript"></script>
	<!-- Initializing the slider -->
	<script>
		jQuery("#layerslider").layerSlider({
			pauseOnHover: false,
			autoPlayVideos: false,
			responsive: false,
			responsiveUnder: 1280,
			layersContainer: 1280,
			skin: 'v5',
			skinsPath: 'js/layerslider/skins/'
		});
	</script>
