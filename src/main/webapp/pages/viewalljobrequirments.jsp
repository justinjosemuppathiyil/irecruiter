<%@page import="java.util.List"%>
<%@page import="main.java.com.techies.irecruiter.vo.RequirmentVO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-All Requirments</title>
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
<%
	List requirmentList = (ArrayList)session.getAttribute("requirmentList");
	if(requirmentList == null){
		requirmentList = new ArrayList();
	}
%>
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
							<!--<form:form action="/irecruiter/viewRequirmentsDetails" method="get" name="RequirmentsDetailsForm" commandName="RequirmentsDetailsForm">-->
								<table class="gridtable">
									<thead>
										<tr>
											<th colspan="2" style="font-size:25px;">Requirment Details</th>
										</tr>
										<tr>
											<th style="text-align:left;">Job Title</th>
											<th style="text-align:left;">Action</th>
										</tr>
									</thead>
									 <% for(int i=0;i<requirmentList.size();i++){
									 RequirmentVO requirmentVO = (RequirmentVO)requirmentList.get(i);%>
									<tbody>
										<tr class="dark">
											<td><%=requirmentVO.getJobTitle()%></td>
											<td><a href="/irecruiter/viewRequirmentsDetails?id=<%=requirmentVO.getRequirmentID()%>">View&nbsp;&nbsp;&nbsp</a>I
												<a href="/irecruiter/editRequirmentDetails?id=<%=requirmentVO.getRequirmentID()%>">Edit&nbsp;&nbsp;&nbsp</a>I
												<a href="/irecruiter/deleteRequirmentDetails?id=<%=requirmentVO.getRequirmentID()%>">Delete&nbsp;&nbsp;&nbsp</a></td>
										</tr>
									</tbody>
									<%} %>
								</table>
								<!--</form:form>-->
							</div>
						</section>
					</div>
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
	<!-- /Footer -->

	<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Developed: <a href="#">Divya Mathew</a> Design: <a href="http://templated.co">Templated</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
			</div>
		</div>


	</body>
</html>