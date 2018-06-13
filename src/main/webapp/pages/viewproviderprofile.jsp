<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Provider Profile</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/skel-panels.min.js"></script>
		<script src="resources/js/init.js"></script>
		<link rel="stylesheet" href="resources/css/skel-noscript.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" href="resources/css/style-desktop.css" />
		<link rel="stylesheet" href="resources/css/form-style.css" />
	</head>
	<body>
	<!-- Header -->
		<div id="header" style="height:220px;">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="/irecruiter/providerHome">Homepage</a></li>
						<li><a href="/irecruiter/viewProviderProfile?id=${providerId}">View Profile</a></li>
						<li><a href="/irecruiter/getProviderProfile?id=${providerId}">Edit Profile</a></li>
						<li><a href="/irecruiter/viewSearchSeeker">Search Seeker</a></li>
						<li><a href="/irecruiter/providerLogout">Logout</a></li>
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
			<div class="container">
				<div class="row">

					
					<!-- Content -->
					<div id="content" style="margin-left:215px;" class="8u skel-cell-important">
						<section>
							<div id="content-area">
								<table class="gridtable">
									<thead>
										<tr>
											<th colspan="2" style="font-size:25px;">Provider Profile</th>
										</tr>
										<tr>
											<th colspan="2" style="text-align:left;">Provider Details</th>
										</tr>
										</thead>
										<tbody>
											<tr class="light">
												<td>Company Name</td>
												<td>${providerVO.name }</td>
											</tr>
											<tr class="dark">
												<td>Website</td>
												<td>${providerVO.websiteaddr}</td>
											</tr>
											<tr class="light">
												<td>Address</td>
												<td>${providerVO.address}</td>
											</tr>
											<tr class="dark">
												<td>Street</td>
												<td>${providerVO.street }</td>
											</tr>
											<tr class="light">
												<td>District</td>
												<td>${providerVO.district}</td>
											</tr>
											<tr class="dark">
												<td>State</td>
												<td>${providerVO.state}</td>
											</tr>
											<tr class="light">
												<td>Country</td>
												<td>${providerVO.country}</td>
											</tr>
											<tr class="dark">
												<td>Pin</td>
												<td>${providerVO.pin}</td>
											</tr>
											<tr class="light">					
												<td>Email1</td>
												 <td>${providerVO.email1}</td>
											</tr>
											<tr class="dark">					
												<td>Email2</td>
												 <td>${providerVO.email2}</td>
											</tr>
											<tr class="light">					
												<td>Phone1</td>
												 <td>${providerVO.phone1}</td>
											</tr>
											<tr class="dark">					
												<td>Phone2</td>
												 <td>${providerVO.phone2}</td>
											</tr>
										</tbody>
										
									</table>
								</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	<!-- /Main -->

	

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
	<!-- /Footer -->

	<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Developed: <a href="#">Divya Mathew</a> Design: <a href="http://templated.co">Templated</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
			</div>
		</div>


	</body>
</html>