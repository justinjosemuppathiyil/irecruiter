<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Online Test</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/skel-panels.min.js"></script>
		<script src="resources/js/init.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.slidepanel.setup.js"></script>
		<link rel="stylesheet" href="resources/css/skel-noscript.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" href="resources/css/style-desktop.css" />
		<link rel="stylesheet" href="resources/css/form-style.css" />
		<script>
			function closeWindow(){
				window.close();
			}
		</script>
	</head>
	<body class="homepage">
	<!-- Header -->
		<div id="header" style="height:220px;">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
					</ul>
				</nav>
			</div>
			<div class="container"> 
				
				<!-- Logo -->
				<div id="logo">
					<h1 style="font-size:10px;"><a href="index.html">iRecruiter</a></h1>
				</div>
			</div>
		</div>
	<!-- Header --> 

	<!-- Main -->
		<div id="main">
			<div id="content" class="container">
				<header>
					<h2>Online test Result</h2>
				</header>
					<!-- Content -->
					<div id="content" style="margin-left:350px;" class="8u skel-cell-important">
						<div class="row">
							<section class="6u">
								<a href="#" class="image full"><img src="resources/images/adm.png" alt=""></a>
								<p><marquee>Congratulations.....</marquee></p>
								<p style="color:#191970">${status }</p>
							</section>								
						</div>
						<section>
							<div id="content-area">
								<table>
									<tr>
										<td><b>Total Score&nbsp;&nbsp;&nbsp;</b></td>
										<td>${onlineTestStatusDO.score }</td>
									</tr>
									<tr>
										<td><b>No.Of Fail&nbsp;&nbsp;&nbsp;</b></td>
										<td>${onlineTestStatusDO.noOfFail }</td>
									</tr>
									<tr>
										<td><b>No.Of Success&nbsp;&nbsp;&nbsp;</b></td>
										<td>${onlineTestStatusDO.noOfPass }</td>
									</tr>
									<tr>
										<td><b>No.Of Skip&nbsp;&nbsp;&nbsp;</b></td>
										<td>${onlineTestStatusDO.noOfSkip }</td>
									</tr>
									<tr>
											<td colspan="2">
												<br>
												<a href="#"onclick="closeWindow()" class="button button-style1" style="float:left; margin-left:100px;">Close Window</a>
											</td>
										</tr>
								</table>
									
						</div>
					</section>
				</div>
			</div>
		</div>
	<!-- /Main -->
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