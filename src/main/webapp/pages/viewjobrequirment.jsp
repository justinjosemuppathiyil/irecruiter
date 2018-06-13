<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Requirment Details</title>
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
							<%String actionType = (String)session.getAttribute("actionType");
							List skillList = (ArrayList)session.getAttribute("skillList");
							List locationList = (ArrayList)session.getAttribute("locationList");%>
							<form:form action="/irecruiter/showRequirmentDetails" name="RequirmentForm" commandName="RequirmentForm">
								<table class="gridtable">
									<thead>
										<tr>
											<th colspan="6" style="font-size:25px;">Requirment Details</th>
										</tr>
										<tr>
											<th style="text-align:left;">Job Title</th>
											<th style="text-align:left;">Job Category</th>
											<th style="text-align:left;">Job Description</th>
											<th style="text-align:left;">MinExperience</th>
											<th style="text-align:left;">MaxExperience</th>
											<th style="text-align:left;">Skills</th> 
										</tr>
									</thead>
									<tbody>
										<tr class="dark">
											<td>${requirmentVO.jobTitle }</td>
											<td>${requirmentVO.jobCategory }</td>
											<td>${requirmentVO.jobDescription }</td>
											<td>${requirmentVO.minExperience }</td>
											<td>${requirmentVO.maxExperience }</td>
											<td><% for(int i=0;i<skillList.size();i++){%>
											<%=skillList.get(i)%>,
											<%}%>
											</td>
										</tr>
									</tbody>
									<thead>
										<tr>
											<th colspan="6" style="font-size:25px;">Locations Details</th>
										</tr>
										<tr>
											<th style="text-align:left;">Job Place</th>
											<th style="text-align:left;">Job District</th>
											<th style="text-align:left;">Job State</th>
											<th style="text-align:left;">Job Country</th>
											<th style="text-align:left;" colspan="2">Pin</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${locationList}"var="locationList">
										<tr class="light">
											<td><c:out value="${locationList.jobPlace}"></c:out></td>
											<td><c:out value="${locationList.jobDistrict}"></c:out></td>
											<td><c:out value="${locationList.jobState}"></c:out></td>
											<td><c:out value="${locationList.jobCountry}"></c:out></td>
											<td colspan="2"><c:out value="${locationList.PIN}"></c:out></td>
										</tr>
										</c:forEach>
									</tbody>
									<thead>
										<tr>
											<th colspan="6" style="font-size:25px;">Qualification Details</th>
										</tr>
										<tr>
											<th style="text-align:left;" colspan="2">Qualification</th>
											<th style="text-align:left;" colspan="4">Specialization</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${qualificationList}"var="qualificationList">
										<tr class="dark">
										    <td colspan="2"><c:out value="${qualificationList.qualification}"></c:out></td>
										    <td colspan="4"><c:out value="${qualificationList.qualificationSpecilization}"></c:out></td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
								<table style="text-align:left;">
								<%if("VIEW".equalsIgnoreCase(actionType)){%>
									<tr>
										<td></td>
										<td>
											<br>
											<input type="submit" style="float:right;" value="Finish">	
										</td>
     
								<%}else{ %>
									<tr>
										<td></td>
										<td>
											<br>
											<input type="submit" style="float:right;" value="Finish">	
										</td>
								<%} %>
								</table>
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