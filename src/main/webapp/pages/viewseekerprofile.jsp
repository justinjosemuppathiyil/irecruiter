<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Sign UP</title>
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
						<li><a href="irecruiter/seekerHome">Homepage</a></li>
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
	<!-- Header --> 

	<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row">

					
					<!-- Content -->
					<div id="content" style="margin-left:215px;" class="8u skel-cell-important">
						<section>
							<div id="content-area">
								<%String actionType = (String)session.getAttribute("actionType"); 
								 List seekerSkillset = (ArrayList)session.getAttribute("seekerSkillset");%>
								<form:form action="/irecruiter/showSeekerDetails" name="SeekerForm" commandName="SeekerForm">
									<table class="gridtable">
										<thead>
											<tr>
												<th colspan="2" style="font-size:25px;">Seeker Profile</th>
											</tr>
											<tr>
												<th colspan="2" style="text-align:left;">Seeker Details</th>
											</tr>
										</thead>
										<tbody>
											<tr class="light">
												<td>Name</td>
												<td>${seekerVO.seekerName }</td>
											</tr>
											<tr class="dark">
												<td>Address</td>
												<td>${seekerVO.seekerAddress }</td>
											</tr>
											<tr class="light">
												<td>Gender</td>
												<td>${seekerVO.seekerGender }</td>
											</tr>
											<tr class="dark">
												<td>DOB</td>
												<td>${seekerVO.seekerDOB }</td>
											</tr>
											<tr class="light">
												<td>Country</td>
												<td>${seekerVO.seekerCountry }</td>
											</tr>
											<tr class="dark">
												<td>State</td>
												<td>${seekerVO.seekerState }</td>
											</tr>
											<tr class="light">
												<td>District</td>
												<td>${seekerVO.seekerDistrict }</td>
											</tr>
											<tr class="dark">			
												<td>Street</td> 
												<td>${seekerVO.seekerStreet }</td>
											</tr>
											<tr class="light">					
												<td>Pin</td>
												 <td>${seekerVO.seekerPIN }</td>
											</tr>
											<tr class="dark">					
												<td>Email1</td>
												 <td>${seekerVO.seekerEmail1 }</td>
											</tr>
											<tr class="light">					
												<td>Email2</td>
												 <td>${seekerVO.seekerEmail2 }</td>
											</tr>
											<tr class="dark">					
												<td>Phone1</td>
												 <td>${seekerVO.seekerPhone1 }</td>
											</tr>
											<tr class="light">					
												<td>Phone2</td>
												 <td>${seekerVO.seekerPhone2 }</td>
											</tr>
										</tbody>
										<thead>
											<tr>
												<th colspan="2" style="text-align:left;">Course details</th>
											</tr>
										</thead>
										<tbody>
											<tr class="dark">
												<td>CourseName</td>
												<td>${seekerQualificationVO.courseName }</td>
											</tr>
											<tr class="light">
												<td>Specilization</td>
												<td>${seekerQualificationVO.specilization }</td>
											</tr>
											<tr class="dark">
												<td>Institute/University/Board</td>
												<td>${seekerQualificationVO.institute }</td>
											</tr>
											<tr class="light">
												<td>Year of passing</td>
												<td>${seekerQualificationVO.passYear }</td>
											</tr>
											<tr class="dark">
												<td>%/GPA</td>
												<td>${seekerQualificationVO.gpa }</td>
											</tr>
										</tbody>
										<thead>
											<tr>
												<th colspan="2" style="text-align:left;">Skills and Experience</th>
											</tr>
										</thead>
										<tbody>
											<tr class="light">
												<td>Skills</td>
												<td>
													<% for(int i=0;i<seekerSkillset.size();i++){%>
													<%=seekerSkillset.get(i)%>,
													<%}%>
												</td>	
											</tr>
											<tr class="dark">
												<td>Experience</td>
												<td>${seekerExperienceVO.experience}</td>
											</tr>
										</tbody>
									</table> 
									<%if("CREATE".equalsIgnoreCase(actionType)||"UPDATE".equalsIgnoreCase(actionType)){%>
									<table style="text-align:left;">
										<tr>
											<td></td>
											<td>
												<br>
												<input type="submit" value="Finish">
											</td>
										</tr>
									</table>
									<form:hidden path="seekerID" value="${seekerID}"/>
									<%} %>
									<input type="hidden" name="seekerSkillset" value="<%=session.getAttribute("seekerSkillset")%>" />
									<input type="hidden" name="actionType" value="<%=session.getAttribute("actionType")%>" />
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