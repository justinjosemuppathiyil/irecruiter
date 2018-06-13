<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Create Seeker</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/skel-panels.min.js"></script>
		<script src="resources/js/init.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.slidepanel.setup.js"></script>
		<script type="text/javascript" src="resources/js/validateseekerprofile.js"></script>
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
								<h2>Job seeker Details</h2>
								<span class="byline">Complete with your details</span>
							</header>
							<div id="content-area">
								<form:form action="/irecruiter/manageSeekerDetails"  name="manageSeekerForm" commandName="manageSeekerForm" onsubmit= "return validateseekerprofile(this);">
									<table>
										<tr>
											<td><label for="seekerName">Name&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerName" placeholder="Name" onblur="checkname()"/></td>
											<%}else{%>
											<td><form:input path="seekerName" value="${seekerVO.seekerName}"/></td>
											<%}%>
										</tr>
										<tr>
											<td style="vertical-align:top;"><label for="seekerAddress">Address&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:textarea path="seekerAddress" onblur="checkaddress()"/></td>
											<%}else{%>
											<td><textarea name="seekerAddress">${seekerVO.seekerAddress }</textarea></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="seekerStreet">Street&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerStreet" placeholder="Street" onblur="checkstreet()"/></td>
											<%}else{%>
											<td><form:input path="seekerStreet" value="${seekerVO.seekerStreet }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="seekerCountry">Country&nbsp;&nbsp;&nbsp;</label></td>
												<%if("CREATE".equalsIgnoreCase(actionType))
													{
												%>
											<td><form:select path="seekerCountry" onblur="checkcountry()">
												<form:option value="null">--select--</form:option>
												<form:option value="India">India</form:option>
												<form:option value="Germany">Germany</form:option></form:select></td>
												<%}else{%>
												<td><form:select path="seekerCountry">
												<form:option value="${seekerVO.seekerCountry }">${seekerVO.seekerCountry }</form:option>
												<form:option value="India">India</form:option>
												<form:option value="Germany">Germany</form:option></form:select></td>
												<%}%>
										</tr>
										<tr>
											<td><label for="seekerState">State&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerState" placeholder="State" onblur="checkstate()"/></td>
											<%}else{%>
											<td><form:input path="seekerState" value="${seekerVO.seekerState}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="seekerDistrict">District&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerDistrict" placeholder="District" onblur="checkdistrict()"/></td>
											<%}else{%>
											<td><form:input path="seekerDistrict" value="${seekerVO.seekerDistrict }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="seekerPIN">Pin&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerPIN" placeholder="PIN" onblur="checkpin()"/></td>
											<%}else{%>
											<td><form:input path="seekerPIN" value="${seekerVO.seekerPIN}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="seekerDOB">DOB&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerDOB" placeholder="Date of birth"/></td>
											<%}else{%>
											<td><form:input path="seekerDOB" value="${seekerVO.seekerDOB}"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="seekerGender">Gender&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:select path="seekerGender">
																					<form:option value="MALE">MALE</form:option>
																					<form:option value="FEMALE">FEMALE</form:option>
																					</form:select></td>
											<%}else{%>
											<td><form:select path="seekerGender">	
																					<form:option value="${seekerVO.seekerGender }">${seekerVO.seekerGender }</form:option>
																					<form:option value="MALE">MALE</form:option>
																					<form:option value="FEMALE">FEMALE</form:option>
																					</form:select></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="email">Email&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerEmail1" placeholder="Email 1*" onblur="checkemail1()"/>
												<form:input path="seekerEmail2" placeholder="Email 2" onblur="checkemail2()"/></td>
											<%}else{%>
											<td><form:input path="seekerEmail1" value="${seekerVO.seekerEmail1 }"/>
												<form:input path="seekerEmail2" value="${seekerVO.seekerEmail2 }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="phone">Phone&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="seekerPhone1" maxlength="10" placeholder="Phone 1*" onblur="checkphone1()"/>
												<form:input path="seekerPhone2" maxlength="10" placeholder="Phone 2" onblur="checkphone2()"/></td>
											<%}else{%>
											<td><form:input path="seekerPhone1" value="${seekerVO.seekerPhone1 }"/>
												<form:input path="seekerPhone2" value="${seekerVO.seekerPhone2 }"/></td>
												<form:hidden path="seekerID" value="${seekerVO.seekerID}"/>
												<form:hidden path="contactID" value="${seekerVO.contactID}"/>
												<%}%>
										</tr>
										<tr>
											<td></td>
											<td>
												<br>
												<input type="reset" style="float:left; margin-left:285px;" value="Reset">
												<input type="submit" style="float:left;margin-left:15px;" value="Submit">
												
											</td>
										</tr>
									</table>
									<form:hidden path="username" value="${username}"/>
									<form:hidden path="actionType" value='<%=(String)session.getAttribute("actionType") %>'/>	
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