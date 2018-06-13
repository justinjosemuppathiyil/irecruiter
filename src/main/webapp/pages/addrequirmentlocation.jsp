<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Requirment Locations</title>
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

					<!-- Sidebar -->
					<div id="sidebar" class="4u">
						
						<section>
							<header>
								<h2>Comments</h2>
							</header>
							<ul class="style">
								<li>
									<p class="posted">Sep 30, 2015</p>
									<p><a href="#">"iRecruiter gives an excellent platform to freshers as it provides so many opportunities."</a></p>
								</li>
								<li>
									<p class="posted">Sep 30, 2015</p>
									<p><a href="#"> "iRecruiter is a silver lining in the dark sky"</a></p>
								</li>
							</ul>
						</section>
					</div>
					
					<!-- Content -->
					<div id="content" class="8u skel-cell-important">
						<section>
							<header>
								<h2>Job Requirments Details</h2>
								<span class="byline">Add Job Locations Details</span>
							</header>
							<div id="content-area">
								<form:form action="/irecruiter/submitRequirmentsLocation" method="get" name="RequirmentsLocationForm" commandName="RequirmentsLocationForm">
								<%String actionType=(String)session.getAttribute("actionType"); %>
									<table>
										<tr>
											<td><label for="jobPlace">Job Place&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="jobPlace" placeholder="jobPlace"/></td>
											<%}else{%>
											<td><form:input path="jobPlace" value="${locationVO.jobPlace}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="jobDistrict">Job District&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="jobDistrict" placeholder="jobDistrict"/></td>
											<%}else{%>
											<td><form:input path="jobDistrict" value="${locationVO.jobDistrict}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="jobState">Job State&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="jobState" placeholder="jobState" /></td>
											<%}else{%>
											<td><form:input path="jobState" value="${locationVO.jobState}" /></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="jobCountry">Job Country&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="jobCountry" placeholder="jobCountry"/></td>
											<%}else{%>
											<td><form:input path="jobCountry" value="${locationVO.jobCountry}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="PIN">Pin&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="PIN" placeholder="PIN code" /></td>
											<%}else{%>
											<td><form:input path="PIN" value="${locationVO.PIN}" /></td>
											<form:hidden path="requirmentID" value="${locationVO.requirmentID}"/>
											<form:hidden path="providerID" value="${locationVO.providerID}"/>
											<form:hidden path="locationID" value="${locationVO.locationID}"/>
											<%}%>
										</tr>
										<tr>
											<td></td>
											<td>
												<br>
												<input type="submit" style="float:left; margin-left:285px;" value="ADD">
												<a style="float:left;margin-left:15px;" href="/irecruiter/addRequirmentsLocation?id=${requirmentID}">NEXT</a>	
											</td>
									</table>
									<%if("VIEW".equalsIgnoreCase(actionType))
										{
									%>
									<table class="gridtable">
										<thead>
										<tr>
											<th colspan="6" style="font-size:25px;">Locations Details</th>
										</tr>
										<tr>
											<th style="text-align:left;">Job Place</th>
											<th style="text-align:left;">Job District</th>       
											<th style="text-align:left;">Job State</th>
											<th style="text-align:left;">Job Country</th>
											<th style="text-align:left;">Pin</th>
											<th style="text-align:left;">Action</th>
										</tr>
										</thead>
										<tbody>
										<c:forEach items="${locationList}"var="locationList">
											<tr class="dark">
												<td><c:out value="${locationList.jobPlace}"></c:out></td>
												<td><c:out value="${locationList.jobDistrict}"></c:out></td>
												<td><c:out value="${locationList.jobState}"></c:out></td>
												<td><c:out value="${locationList.jobCountry}"></c:out></td>
												<td><c:out value="${locationList.PIN}"></c:out></td>
												<td><a href="/irecruiter/editRequirmentsLocation?id=${locationList.locationID}">Edit</a></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
									<%}%>
									<form:hidden path="providerID" value="${providerID}"/>
									<form:hidden path="requirmentID" value="${requirmentID}"/>
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