<%@page import="main.java.com.techies.irecruiter.vo.ProviderVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Admin Home</title>
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
	</head>
	<body>
	<!-- Header -->
		<div id="header" style="height:220px;">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="index.html">Homepage</a></li>
						<li class="active"><a href="left-sidebar.html">Services</a></li>
						<li><a href="right-sidebar.html">Logout</a></li>
						<li><a href="no-sidebar.html">No Sidebar</a></li>
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
					<!-- Sidebar -->
					<div id="sidebar" class="4u">
						<section>
							<header>
								<h2>Companies</h2>
							</header>
							<div class="row">
								<section class="6u">
									<ul class="default">
									<marquee direction="down" onMouseOver="this.stop()" onMouseOut="this.start()" loop="-1" truespeed="truespeed">
										<li><a href="#">WIPRO</a></li>
										<li><a href="#">UST-GOBAL</a></li>
										<li><a href="#">TCS</a></li>
										<li><a href="#">GOOGLE</a></li></marquee>
									</ul>
								</section>
								<section class="6u">
									<ul class="default">
									<marquee direction="up" onMouseOver="this.stop()" onMouseOut="this.start()" loop="-1" truespeed="truespeed">
										<li><a href="#">WIPRO</a></li>
										<li><a href="#">UST-GOBAL</a></li>
										<li><a href="#">TCS</a></li>
										<li><a href="#">GOOGLE</a></li></marquee>
									</ul>
								</section>
							</div>
						</section>
						<section>
							<header>
								<h2>Mauris vulputate</h2>
							</header>
							<ul class="style">
								<li>
									<p class="posted">Sep 21, 2015  |  (10 )  Comments</p>
									<p><a href="#">"iRecruiter gives an excellent platform to freshers as it provides so many opportunities."</a></p>
								</li>
								<li>
									<p class="posted">Sep 18, 2015  |  (10 )  Comments</p>
									<p><a href="#"> "iRecruiter is a silver lining in the dark sky"</a></p>
								</li>
							</ul>
						</section>
					</div>
					
					<!-- Content -->
					<div id="content" class="8u skel-cell-important">
						<section>
							<header>
								<h2>Welcome Admin</h2>
							</header>
							<div id="content-area">
							<%List allProviderList = (ArrayList)session.getAttribute("allProviderList");
							if(allProviderList==null){
								allProviderList = new ArrayList();
							}%>
								<form:form action="/irecruiter/manageAllProviderDetails" method="get" name="adminForm" commandName="adminForm">
								<table class="gridtable">
									<thead>
										<tr>
											<th colspan="2" style="font-size:25px;">Company Details</th>
										</tr>
										<tr>
											<th style="text-align:left;">Company Name</th>
											<th style="text-align:left;">Action</th>
										</tr>
									</thead>
									<% for(int i=0;i<allProviderList.size();i++){
										ProviderVO providerVO = (ProviderVO)allProviderList.get(i);%>
									<tbody>
										<tr class="dark">
											<td><%=providerVO.getName() %>,<%=providerVO.getStreet() %></td>
											<td><a href="/irecruiter/viewAllProviderProfile?id=<%=providerVO.getProviderID()%>">VIEW ALL</a>I
												<a href="/irecruiter/deleteProviderProfile?id=<%=providerVO.getProviderID()%>">BLOCK</a></td>
										</tr>
									</tbody>
									<%} %>
								</table>
							    </form:form>	
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