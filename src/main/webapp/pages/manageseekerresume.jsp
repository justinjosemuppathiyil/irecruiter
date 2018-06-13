<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Resume</title>
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
							<div id="content-area">
								<form:form action="/irecruiter/manageSeekerResume" name="SeekerResumeForm" commandName="SeekerResumeForm" enctype="multipart/form-data" method="post">
									<table class="gridtable">
										<thead>
											<tr>
												<th colspan="2" style="font-size:25px;">Upload Resume</th>
											</tr>
										</thead>
										<tbody>
											<tr class="dark">
												<%if("CREATE".equalsIgnoreCase(actionType))
												{
												%>
												<td>Choose a File&nbsp;&nbsp;&nbsp;<input type="file" name="file" requied="requied"/></input></td>
												<td><input type="submit" value="Upload"></td>
												<%}else{%>
												<td>File Name&nbsp;&nbsp;&nbsp;${jobSeekerResumeVO.filename}<input type="file" name="file" requied="requied"/></input></td>
												<td><input type="submit" value="Finish"></td>
												<form:hidden path="seekerID" value="${seekerID}"/>
												<form:hidden path="resumeID" value="${jobSeekerResumeVO.resumeID}"/>
												<%}%>
											</tr>
											</tbody>
												<form:hidden path="seekerID" value="${seekerID}"/>
												<form:hidden path="actionType" value='<%=(String)session.getAttribute("actionType")%>'/>
									</table>
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