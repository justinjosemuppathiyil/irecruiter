<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>iRecruiter</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/skel-panels.min.js"></script>
		<script src="resources/js/init.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.slidepanel.setup.js"></script>
		<script type="text/javascript" src="resources/js/loginvalidate.js"></script>
		<link rel="stylesheet" href="resources/css/skel-noscript.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" href="resources/css/style-desktop.css" />
		<link rel="stylesheet" href="resources/css/loginslider.css" />
	</head>
	<body class="homepage">
		<div id="topbar">
		<div id="slidepanel">
			<div class="topbox">
				<h2>Login Here</h2>
				<form:form action="/irecruiter/submitLogin" name="loginForm" commandName="loginForm" onsubmit="return validateLogin(this);">
						<label for="Username">Username:
							<form:input type="text" name="username" path="username" value="" />
						</label>
						&nbsp;
						<label for="Password">Password:
							<form:input type="password" path="password" name="password" value="" />
						</label>
						&nbsp;
						<label for="teacherremember">
							<input class="checkbox" type="checkbox" checked="checked" />
						Remember me</label>
						&nbsp;
						<input type="submit" value="Login" />
						&nbsp;
						<input type="reset" value="Reset" />
					
				</form:form>
				<a id="closeit" style="display: block;float:right;" href="#slidepanel">Close Panel</a>
			</div>
			<div class="topbox last"></div>
			<br class="clear" />
		</div>
		</div>
	<!-- Header -->
		<div id="header">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li class="active"><a href="index.html">Home</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Contact Us</a></li>
						<li><a href="/irecruiter/userRegistration">Sign Up</a></li>
						<li><a id="slideit" href="#slidepanel">Login</a></li>
					</ul>
				</nav>
			</div>
			<div class="container"> 
				<!-- Logo -->
				<div id="logo">
					<h1><a href="#">iRecruiter</a></h1>
				</div>
			</div>
		</div>

	<!-- Featured -->
		<div id="featured">
			<div class="container">
				<header>
					<h2>Welcome to iRecruiter</h2>
					<p style="color:red;">${status}</p>
				</header>
				<p>A <strong>seamless</strong>, interface between users, companies and institutions. <a href="#">Success doesn't come to you, you go to it.</a></p> 
				<div class="row">
					<section class="4u">
						<span class="pennant"><span class="fa fa-briefcase"></span></span>
						<h3>Companies</h3>
						<a href="#" class="button button-style1">Read More</a>
					</section>
					<section class="4u">
						<span class="pennant"><span class="fa fa-lock"></span></span>
						<h3>Secure</h3>
						<a href="#" class="button button-style1">Read More</a>
					</section>
					<section class="4u">
						<span class="pennant"><span class="fa fa-globe"></span></span>
						<h3>Globaly</h3>
						<a href="#" class="button button-style1">Read More</a>
					</section>

				</div>
			</div>
		</div>

	<!-- Main -->
		<div id="main">
			<div id="content" class="container">
				<div class="row">
					<section class="6u">
						<a href="#" class="image full"><img src="resources/images/pic33.jpg" alt=""></a>
						<p style="color:#191970">&ldquo;One important key to success is self-confidence. An important key to self-confidence is preparation&ldquo;</p>
					</section>				
					<section class="6u">
						<a href="#" class="image full"><img src="resources/images/admin2.jpg" alt=""></a>
						<p style="color:#191970">&ldquo;Believe in yourself! Have faith in your abilities! Without a humble but reasonable confidence in your own powers you cannot be successful or happy.&rdquo;</p>
					</section>				
					
				</div>
			
			</div>
		</div>

	<!-- Tweet -->
		<div id="tweet">
			<div class="container">
				<section>
					<blockquote>&ldquo;Opportunities don't often come along. So, when they do, you have to grab them.&rdquo;</blockquote>
				</section>
			</div>
		</div>

	<!-- Footer -->
		<div id="footer">
			<div class="container">
				<section>
					<header>
						<h2>Get in touch</h2>
					</header>
					<ul class="contact">
						<li><a href="#" class="fa fa-twitter"><span>Twitter</span></a></li>
						<li class="active"><a href="#" class="fa fa-facebook"><span>Facebook</span></a></li>
						<li><a href="#" class="fa fa-dribbble"><span>Pinterest</span></a></li>
						<li><a href="#" class="fa fa-tumblr"><span>Google+</span></a></li>
					</ul>
				</section>
			</div>
		</div>

	<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Developed: <a href="#">Divya Mathew</a> Design: <a href="http://templated.co">Templated</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
			</div>
		</div>

	</body>
</html>