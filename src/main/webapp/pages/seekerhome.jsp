<%@page import="main.java.com.techies.irecruiter.vo.JobVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Seekerhome</title>
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
		<%List allJobList = (ArrayList)session.getAttribute("allJobList");
							if(allJobList==null){
								allJobList = new ArrayList();
							}%>
		<%List recentJobList = (ArrayList)session.getAttribute("recentJobList");
							if(recentJobList==null){
								recentJobList = new ArrayList();
							}%>
	<!-- Header -->
		<div id="header" style="height:220px;">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="/irecruiter/seekerHome">Homepage</a></li>
						<li><a href="/irecruiter/getSeekerProfile?id=${seekerID}"> Edit Profile</a></li>
						<li><a href="/irecruiter/viewSeekerProfile?id=${seekerID}">View Profile</a></li>
						<li><a href="/irecruiter/seekerLogout">Logout</a></li>
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
		<font style="color:white;padding-left:70px;">Welcome&nbsp;&nbsp;&nbsp;${seekerVO.seekerName}</font>
	<!-- Header --> 

	<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row">
				<form:form action="/irecruiter/searchRequirment" method="get" name="SearchRequirmentForm" commandName="SearchRequirmentForm">
					<form:input path="jobCategory" style="width:700px;height:50px;" placeholder="Job Category"/>
					<form:input path="city" style="width:495px;height:50px;" placeholder="City"/>
					<form:input path="skill" style="width:400px;height:50px;" placeholder="Skill"/>
					<form:input path="qualification" style="width:310px;height:50px;" placeholder="Qualification"/>
					<form:input path="qualificationSpecilization" style="width:310px;height:50px;" placeholder="Specilization (eg:cs,it)"/>
					<input type="submit" value="Search Jobs" style="height:50px;width:165px;">
				</form:form>
				<!-- Content -->
					<div id="content" class="8u skel-cell-important">
						<section>
							<br><br>
							<table class="gridtable" style="width:150px;">
								<thead >
										<th >All Jobs</th>
								</thead>
							</table>
							<table class="gridtable">
								<tbody>
								<%for(int i=0;i<allJobList.size();i++){
										JobVO jobVO = (JobVO)allJobList.get(i);%>
									<tr class="dark" >
										<td><%=jobVO.getName() %>,<%=jobVO.getJobTitle()%></td>
									</tr>
								</tbody>
								<%}%>
							</table>							
						</section>
					</div>
					
					<!-- Sidebar -->
					<div id="sidebar" class="4u">
						<section>
							<br><br>
							<header>
								<h2>Top Recruiters</h2>
							</header>
							<div class="row">
								<section class="6u">
									<ul class="default">
										<li><a href="#">Wipro</a></li>
										<li><a href="#">IBS</a></li>
										<li><a href="#">TCS</a></li>
										<li><a href="#">Infosys</a></li>
										<li><a href="#">Cognizent</a></li>
									</ul>
								</section>
								<section class="6u">
									<ul class="default">
										<li><a href="#">Google</a></li>
										<li><a href="#">Flipcart</a></li>
										<li><a href="#">VISA</a></li>
										<li><a href="#">Accentre</a></li>
										<li><a href="#">IBM</a></li>
									</ul>
								</section>
							</div>
						</section>
						<section>
							<header>
								<h2>Recent Jobs</h2>
							</header>
							<ul class="style">
							<marquee direction="up" onMouseOver="this.stop()" onMouseOut="this.start()" loop="-1" truespeed="truespeed">
								<%for(int i=0;i<recentJobList.size();i++){
										JobVO jobVO = (JobVO)recentJobList.get(i);%>
								<li>
									<p><a href="#"><%=jobVO.getName() %>,<%=jobVO.getJobTitle()%></a></p>
								</li>
								<%}%>
								</marquee>
							</ul>
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
	<!-- /Tweet -->
	
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