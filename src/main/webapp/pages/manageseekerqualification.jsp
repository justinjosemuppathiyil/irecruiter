<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Seeker Qualification</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/skel-panels.min.js"></script>
		<script src="resources/js/init.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.slidepanel.setup.js"></script>
		<script type="text/javascript" src="resources/js/validatequali.js"></script>
		<link rel="stylesheet" href="resources/css/skel-noscript.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" href="resources/css/style-desktop.css" />
		<link rel="stylesheet" href="resources/css/form-style.css" />
	</head>
	<body>
	<%String actionType = (String)session.getAttribute("actionType"); %>
	<!-- Header -->
		<div id="header" style="height:220px;">
			<div id="nav-wrapper"> 
				<!-- Nav -->
				<nav id="nav">
					<ul>
						<%if("CREATE".equalsIgnoreCase(actionType)){%>
						<li class="active"><a href="index.html">Homepage</a></li>
						<%}else{%>
						<li><a href="irecruiter/seekerHome">Homepage</a></li>
						<li><a href="/irecruiter/getSeekerProfile?id=${seekerID}"> Edit Profile</a></li>
						<li><a href="/irecruiter/viewSeekerProfile?id=${seekerID}">View Profile</a></li>
						<li><a href="/irecruiter/seekerLogout">Logout</a></li>
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
								<h2>Qualification Details</h2>
								<span class="byline">Complete with your qualification details</span>
							</header>
							<div id="content-area">
								<form:form action="/irecruiter/manageSeekerQualification" name="SeekerQualificationForm" commandName="SeekerQualificationForm" onsubmit= "return validateQualification(this);">		
									<table>
										<tr>
											<td><label for="courseName">Course name&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
											{
											%>
											<td><form:input path="courseName" placeholder="CourseName eg:mca" onblur="checkcourse()"/></td>
											<%}else{%>
											<td><form:input path="courseName" value="${seekerQualificationVO.courseName }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="specilization">Specialization&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
													{
											%>
											<td><form:input path="specilization" placeholder="Specialization eg:computerApplication,physics" onblur="checkspecial()"/></td>
											<%}else{%>
											<td><form:input path="specilization" value="${seekerQualificationVO.specilization }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="passYear">Year of passing&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
													{
												%>
											<td><form:input path="passYear" placeholder="Year" onblur="checkpass()"/></td>
											<%}else{%>
											<td><form:input path="passYear" value="${seekerQualificationVO.passYear }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="institute">Name of institution&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
													{
												%>
											<td><form:input path="institute" placeholder="institution/University/Board" onblur="checksintitute()"/></td>
											<%}else{%>
											<td><form:input path="institute" value="${seekerQualificationVO.institute }"/></td>
											<%}%>
									</tr>
									<tr>
										<td><label for="gpa">%/GPA&nbsp;&nbsp;&nbsp;</label></td>
										<%if("CREATE".equalsIgnoreCase(actionType))
												{
										%>
										<td><form:input path="gpa" placeholder="%/GPA" onblur="checkgpa()"/></td>
										<%}else{%>
										<td><form:input path="gpa" value="${seekerQualificationVO.gpa }"/></td>
										<form:hidden path="seekerID" value="${seekerID}"/>
										<form:hidden path="sqID" value="${seekerQualificationVO.sqID}"/>
										<form:hidden path="experienceID" value="${seekerExperienceVO.experienceID}"/>
										<form:hidden path="skillID" value="${seekerSkillVO.skillID}"/>
										<%}%>
									</tr>
									<tr>
										<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
										<td><label for="skill">Skill&nbsp;&nbsp;&nbsp;</label></td>
										<td>
											<select name="skill" multiple size="2" style="height:auto;">
												<option value="java">JAVA</option>
												<option value="c">C</option>
												<option value="J2EE">J2EE</option>
												<option value="PHP">PHP</option>
												<option value="C++">C++</option>
												<option value=".NET">.NET</option>
												<option value="ANDROID">ANDROID</option>
											</select>
										</td>
									</tr>
										<%}else{%>
										<% List seekerSkillset = (ArrayList)session.getAttribute("seekerSkillset");	%>
									<tr>
										<td><label for="skill">Skill&nbsp;&nbsp;&nbsp;</label></td>
										<td>
											<%for(int i=0;i<seekerSkillset.size();i++){%>
												<%=seekerSkillset.get(i)%>,
											<%}%>
										</td>
									</tr>
									<tr>
										<td></td>
										<td>
											<form:select path="skill" multipe="multiple" style="height:auto;">
											<form:option value="java">JAVA</form:option>
											<form:option value="c">C</form:option>
											<form:option value="linux">LINUX</form:option>
											</form:select>
										</td>
										<%}%>
									</tr>
									<tr>
										<td><label for="experience">Experience&nbsp;&nbsp;&nbsp;</label></td>
										<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
										<td><form:select path="experience" >
											<form:option value="fresher">Fresher</form:option>
											<form:option value="0-1">0-1</form:option>
											<form:option value="1-2">1-2</form:option>
											<form:option value="2-3">2-3</form:option>
											<form:option value="3-4">3-4</form:option>
											<form:option value="4-5">4-5</form:option>
											<form:option value="more">More</form:option>
											</form:select></td>
										<%}else{%>
										<td><form:input path="experience" value="${seekerExperienceVO.experience }"/></td>
										<%}%>
									</tr>
									<tr>
											<td></td>
											<td>
												<br>
												<input type="submit" style="float:right;" value="Next">	
											</td>
										<form:hidden path="actionType" value='<%=(String)session.getAttribute("actionType")%>'/>	
								</table>
								<form:hidden path="seekerID" value="${seekerID}"/>			
							</form:form>
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