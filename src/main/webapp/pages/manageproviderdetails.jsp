<%@page import="main.java.com.techies.irecruiter.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Create Provider</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="resources/js/skel.min.js"></script>
		<script src="resources/js/skel-panels.min.js"></script>
		<script src="resources/js/init.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.slidepanel.setup.js"></script>
		<script type="text/javascript" src="resources/js/validateproviderprofile.js"></script>
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
						<li class="active"><a href="index.html">Homepage</a></li>
						<li><a href="/irecruiter/viewProviderProfile?id=${providerId}">View Profile</a></li>
						<li><a href="/irecruiter/getProviderProfile?id=${providerId}">Edit Profile</a></li>
						<li><a href="/irecruiter/viewSearchSeeker">Search Seeker</a></li>
						<li><a href="right-sidebar.html">Logout</a></li>
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
								<h2>Provider Details</h2>
								<span class="byline">Complete with your company details</span>
							</header>
							<div id="content-area">
								<form:form action="/irecruiter/manageProviderDetails" name="manageProviderDetailsForm" commandName="manageProviderDetailsForm" onsubmit= "return validateProviderProfile(this);">
									<table>
										<tr>
											<td><label for="name">Name&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="name" placeholder="Name" onblur="checkname()"/></td>
											<%}else{%>
											<td><form:input path="name" value="${providerVO.name }"/></td>
											<%}%>
										</tr>
										<tr>
											<td style="vertical-align:top;"><label for="address">Address&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:textarea path="address" onblur="checkaddress()"/></td>
											<%}else{%>
											<td><textarea name="address">${providerVO.address }</textarea></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="street">Street&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="street" placeholder="Street" onblur="checkstreet()"/></td>
											<%}else{%>
											<td><form:input path="street" value="${providerVO.street }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="country">Country&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><select name="country" onblur="checkcountry()">
												<option>--select--</option>
												<option>India</option>
												<option>Germany</option></select></td>
											<%}else{%>
											<td><select name="country">
												<option>${providerVO.country }</option>
												<option>India</option>
												<option>Germany</option></select></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="state">State&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="state" placeholder="State" onblur="checkstate()"/></td>
											<%}else{%>
											<td><form:input path="state" value="${providerVO.state }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="district">District&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="district" placeholder="District" onblur="checkdistrict()"/></td>
											<%}else{%>
											<td><form:input path="district" value="${providerVO.district }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="pin">PIN&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="pin" placeholder="PIN" onblur="checkpin()"/></td>
											<%}else{%>
											<td><form:input path="pin" value="${providerVO.pin }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="websiteaddr">Website&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="websiteaddr" placeholder="Website" onblur="checkwebsiteaddr()"/></td>
											<%}else{%>
											<td><form:input path="websiteaddr" value="${providerVO.websiteaddr }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="email">Email&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="email1" placeholder="Email 1" onblur="checkemail1()"/>
											<form:input path="email2" placeholder="Email 2" onblur="checkemail2()"/>
											</td>
											<%}else{%>
											<td><form:input path="email1" value="${providerVO.email1 }"/>
											<form:input path="email2" value="${providerVO.email2 }"/></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="phone">Phone&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType))
												{
											%>
											<td><form:input path="phone1" placeholder="Phone 1" onblur="checkphone1()"/>
												<form:input path="phone2" placeholder="Phone 2" onblur="checkphone2()"/>
											</td>
											<%}else{%>
											<td><form:input path="phone1" value="${providerVO.phone1 }"/>
											<form:input path="phone2" value="${providerVO.phone2 }"/>
											</td>
											<form:hidden path="providerID" value="${providerVO.providerID}"/>
											<form:hidden path="contactID" value="${providerVO.contactID}"/>
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
								<h2>${status }</h2>
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