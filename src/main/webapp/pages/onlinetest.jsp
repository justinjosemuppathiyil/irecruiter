<%@page import="main.java.com.techies.irecruiter.dataobject.OnlineTestStatusDO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Online Test</title>
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
					<div id="content" class="8u skel-cell-important">
						<section>
							<div id="content-area-onlinetest">
								<form:form action="/irecruiter/submitOnlineTest" name="conductOnlineTestForm" commandName="conductOnlineTestForm">
									<p><span style="color:red;font-size:25px;">${skipStatus}</span></p>
									<% OnlineTestStatusDO onlineTestStatusDO = (OnlineTestStatusDO)session.getAttribute("testStatus"); %>
									<%if(onlineTestStatusDO.isSkip()==true){ %>
									<div class="test_question_nmbr">
										<p><span id="question_no">Question  <%=onlineTestStatusDO.getSkipQuesNo() %></span>&nbsp;&nbsp;&nbsp;<span id="time_left" style="float:right;">Time Left ${onlineTestForm.timeLeft }</span>
									</div>
									<%}else{ %>
									<div class="test_question_nmbr">
										<p><span id="question_no">Question ${onlineTestForm.questionNo}</span>&nbsp;&nbsp;&nbsp;<span id="time_left" style="float:right;">Time Left ${onlineTestForm.timeLeft }</span>
									</div>
									<%} %>
									<div class="test_question">
										<p id="question"><form:label path="queLabel">${onlineTestForm.question}</form:label></p>
										<p><form:hidden path="question" value="${onlineTestForm.question}"/>	
											<ul><form:radiobutton path="result" value="${onlineTestForm.option1}"/>${onlineTestForm.option1}</ul>
											<ul><form:radiobutton path="result" value="${onlineTestForm.option2}"/>${onlineTestForm.option2}</ul>
											<ul><form:radiobutton path="result" value="${onlineTestForm.option3}"/>${onlineTestForm.option3}</ul>
											<ul><form:radiobutton path="result" value="${onlineTestForm.option4}"/>${onlineTestForm.option4}</ul>
											<form:hidden path="questionNo" value="${onlineTestForm.questionNo}"/>
										</p>
									</div>
									<p>
										<input type="submit" value="Next" style="width:50px;height:30px;float:right;"/>
									</p>		
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