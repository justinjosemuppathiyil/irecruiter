<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="main.java.com.techies.irecruiter.vo.SeekerAllDetailsVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Seeker Search Result</title>
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
</script>
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
					<%List searchSeekerDetailsList = (ArrayList)session.getAttribute("searchSeekerDetailsList");%>
					<!-- Content -->
					<div id="content" class="8u skel-cell-important">
						<section>
							<header>
								<h2>Search Seeker(<%=searchSeekerDetailsList.size()%>)</h2>
							</header>
							<div id="content-area">
			
							<%if(searchSeekerDetailsList==null){
									searchSeekerDetailsList = new ArrayList();}
									for(int i=0;i<searchSeekerDetailsList.size();i++){
										SeekerAllDetailsVO seekerAllDetailsVO = (SeekerAllDetailsVO)searchSeekerDetailsList.get(i);
							%>
								<div id="content-area-searchresult">
									<p><b style="color:#008B8B;"><%=seekerAllDetailsVO.getSeekerName() %></b></p>
									<table>
										<tr style="height:40px;">
											<td><b>Course Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=seekerAllDetailsVO.getCourseName() %></td>
										</tr>
										<tr style="height:40px;">
											<td><b>Skill&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=seekerAllDetailsVO.getSkill() %></td>
										</tr>
										<tr style="height:40px;">
											<td><b>Experience&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=seekerAllDetailsVO.getExperience() %></td>
										</tr>
										<tr style="height:40px;">
											<td><b>Place&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
											<td><%=seekerAllDetailsVO.getSeekerStreet() %>-<%=seekerAllDetailsVO.getSeekerDistrict() %></td>
										</tr>
									</table>
									<p><a href="#c" onclick="showDiv(<%=seekerAllDetailsVO.getSeekerID()%>)" style="float:right;">&laquo;&laquo;View&raquo;&raquo;</a></p>
									<br>
									
									<div id="viewdetails<%=seekerAllDetailsVO.getSeekerID()%>" style="display:none" >
										<table>
											<tr style="height:40px;">
												<td><b>Institute&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=seekerAllDetailsVO.getInstitute() %></td>
											</tr>
											<tr style="height:40px;">
												<td><b>PassOutYear&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=seekerAllDetailsVO.getPassYear() %></td>
											</tr>
											<tr style="height:40px;">
												<td><b>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=seekerAllDetailsVO.getSeekerEmail1() %>,<%=seekerAllDetailsVO.getSeekerEmail2() %></td>
											</tr>
											<tr style="height:40px;">
												<td><b>Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td> 
												<td><%=seekerAllDetailsVO.getSeekerPhone1() %>,<%=seekerAllDetailsVO.getSeekerPhone2() %></td>
											</tr>
										</table>
										<p><a href="#c" onclick="hideDiv(<%=seekerAllDetailsVO.getSeekerID()%>)">close</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="/irecruiter/sendMail?id=<%=seekerAllDetailsVO.getSeekerEmail1()%>)" class="button button-style1">Send Mail</a></p>
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