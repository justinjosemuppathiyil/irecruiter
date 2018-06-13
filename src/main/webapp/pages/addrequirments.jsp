<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Job Requrments</title>
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
	<%String actionType=(String)session.getAttribute("actionType"); %>
	<!-- Header -->
		<div id="header" style="height:220px;">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<%if("CREATE".equalsIgnoreCase(actionType)){%>
						<li class="active"><a href="index.html">Homepage</a></li>
						<%}else{%>
						<li><a href="/irecruiter/providerHome">Homepage</a></li>
						<li><a href="/irecruiter/viewProviderProfile?id=${providerId}">View Profile</a></li>
						<li><a href="/irecruiter/getProviderProfile?id=${providerId}">Edit Profile</a></li>
						<li><a href="/irecruiter/viewSearchSeeker">Search Seeker</a></li>
						<li><a href="/irecruiter/providerLogout">Logout</a></li>
						<%}%>
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
								<h2>Job Requirment Details</h2>
								<span class="byline">Complete with Requirment details</span>
							</header>
							<div id="content-area">
								<form:form action="/irecruiter/submitRequirments" method="get" name="AddRequirmentsForm" commandName="AddRequirmentsForm">
									<table>
										<tr>
											<td><label for="jobTitle">Job Title&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="jobTitle" placeholder="Job Title"/></td>
											<%}else{%>
											<td><form:input path="jobTitle" value="${requirmentVO.jobTitle}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="jobCategory">Job Category&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="jobCategory" placeholder="Job Category"/></td>
											<%}else{%>
											<td><form:input path="jobCategory" value="${requirmentVO.jobCategory}"/></td>
											<%}%>
										</tr>
										<tr>
											<td style="vertical-align:top;"><label for="jobDescription">Job Description&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:textarea path="jobDescription" placeholder="Job Description"/></td>
											<%}else{%>
											<td><textarea name="jobDescription" >${requirmentVO.jobDescription}</textarea></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="minExperience">Minimum Experience&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="minExperience" placeholder="Minimam Experience"/></td>
											<%}else{%>
											<td><form:input path="minExperience" value="${requirmentVO.minExperience}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="maxExperience">Maximum Experience&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="maxExperience" placeholder="Maximam Experience"/></td>
											<%}else{%>
											<td><form:input path="maxExperience" value="${requirmentVO.maxExperience}"/></td>
											<%}%>
										</tr>
										<tr>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><label for="skillList">Skill Details&nbsp;&nbsp;&nbsp;</label></td>
											<td><form:select path="skillList" multiple="multiple" style="height:auto;">
												<form:option value="JAVA">JAVA</form:option>
												<form:option value="J2EE">J2EE</form:option>
												<form:option value="PHP">PHP</form:option>
												<form:option value="C++">C++</form:option>
												<form:option value="C">C</form:option>
												<form:option value=".NET">.NET</form:option>
												<form:option value="ANDROID">ANDROID</form:option>
												</form:select>
											</td>
										</tr>
											<%}else{%>
											<% List skillList = (ArrayList)session.getAttribute("skillList");%>
										<tr>
											<td><label for="skillList">Skill Details&nbsp;&nbsp;&nbsp;</label></td>
											<td>
											<%for(int i=0;i<skillList.size();i++){%>	
											<%=skillList.get(i)%>,
											<%}%>
											</td>
										</tr>
										<tr>
											<td></td>
											<td>
												<form:select path="skillList" multiple="multiple" style="height:auto;">
												<form:option value="JAVA">JAVA</form:option>
												<form:option value="J2EE">J2EE</form:option>
												<form:option value="PHP">PHP</form:option>
												<form:option value="C++">C++</form:option>
												<form:option value="C">C</form:option>
												<form:option value=".NET">.NET</form:option>
												<form:option value="ANDROID">ANDROID</form:option>
												</form:select>
											</td>
												<form:hidden path="requirmentID" value="${requirmentVO.requirmentID}"/>
												<%}%>
										</tr>
										<tr>
											<td></td>
											<td>
												<br>
												<input type="submit" style="float:right;" value="Next">
												<input type="reset" style="float:right;" value="Reset">	
											</td>
									</table>
								<form:hidden path="actionType" value='<%=(String)session.getAttribute("actionType")%>'/>
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