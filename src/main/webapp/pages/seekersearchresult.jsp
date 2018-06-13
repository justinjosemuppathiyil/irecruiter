<%@page import="main.java.com.techies.irecruiter.vo.RequirmentResultVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Job Search</title>
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
<script type="text/javascript">
function showDiv(id){
	document.getElementById('viewdetails'+id).style.display="block";
}
function hideDiv(id){
	document.getElementById('viewdetails'+id).style.display="none";
}

function confirmOnlinetest(providerId){
	var url = '/irecruiter/conductTest?id='+providerId;
	alert("url:"+url);
	window.open(url,"win","menubar=no,status=no,titlebar=no,toolbar=no,location=no,scrollbars=yes,resizable=yes");
}
</script>
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
					<%List searchRequirmentList = (ArrayList)session.getAttribute("searchRequirmentList");%>
					<!-- Content -->
					<div id="content" class="8u skel-cell-important">
						<section>
							<header>
								<h2>Search Job(<%=searchRequirmentList.size()%>)</h2>
							</header>
							<div id="content-area">
			
								<%	if(searchRequirmentList==null)
									{
										searchRequirmentList = new ArrayList();
										
									}
									for(int i=0;i<searchRequirmentList.size();i++)
									{
										RequirmentResultVO requirmentResultVO = (RequirmentResultVO)searchRequirmentList.get(i);
									
								%>
								<div id="content-area-searchresult">
									<p><b style="color:#008B8B;"><%=requirmentResultVO.getJobTitle() %></b></p>
									<table>
										<tr style="height:40px;">
											<td><b>Desired Skill&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=requirmentResultVO.getSkillstr() %></td>
										</tr>
										<tr style="height:40px;">
											<td><b>Qualification&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=requirmentResultVO.getQualification()%></td>
										</tr>
										<tr style="height:40px;">
											<td><b>Place&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=requirmentResultVO.getJobPlace() %></td>
										</tr>
									</table>
									<p><a href="#c" onclick="showDiv(<%=requirmentResultVO.getRequirmentID()%>)" style="float:right;">&laquo;&laquo;View&raquo;&raquo;</a></p>
									<br>
									
									<div id="viewdetails<%=requirmentResultVO.getRequirmentID()%>" style="display:none" >
										<table>
											<tr style="height:40px;">
												<td><b>JobTitle&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=requirmentResultVO.getJobTitle() %></td>
											</tr>
											<tr style="height:40px;">
												<td><b>JobCategory&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=requirmentResultVO.getJobCategory() %></td>
											</tr>
											<tr style="height:40px;">
												<td><b>Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=requirmentResultVO.getJobDescription() %></td>
											</tr>
											<tr style="height:40px;">
												<td><b>Experience&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=requirmentResultVO.getMinExperience()%>-<%=requirmentResultVO.getMaxExperience()%></td>
											</tr>
										</table>
										<p style="color:#B22222;float:center;">If you want to apply for the job,then you must attend the aptitude test</p>
										<p><a href="#c" onclick="hideDiv(<%=requirmentResultVO.getRequirmentID()%>)">Close</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="#c" onclick="confirmOnlinetest(<%=requirmentResultVO.getProviderID()%>)" class="button button-style1">Apply Job</a></p>
									</div>
								</div>
								<%} %>
								</div>
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