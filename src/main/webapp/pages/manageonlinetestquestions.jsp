<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>iRecruiter-Create Questions</title>
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
								<h2>Add Questions and Answer</h2>
							</header>
							<div id="content-area">
							<%String actionType = (String)session.getAttribute("actionType"); %>
								<form:form action="/irecruiter/submitQuestion" method="get" name="manageOnlineTestForm" commandName="manageOnlineTestForm">
									<table>
										<tr>
											<td style="vertical-align:top;"><label for="question">Questions&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType)){ %>
											<td><form:textarea path="question"/></td>
											<%}else{ %>
											<td><textarea name="question">${onlineTestVO.question}</textarea></td>
											<%}%>
										</tr>
										<tr>
											<td><label for="option1">Option1&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType)){ %>
											<td><form:input path="option1"/></td>
											<%}else{ %>
											<td><form:input path="option1" value="${onlineTestVO.option1 }"/></td>
											<%} %>
										</tr>
										<tr>
											<td><label for="option2">Option2&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType)){ %>
											<td><form:input path="option2"/></td>
											<%}else{ %>
											<td><form:input path="option2" value="${onlineTestVO.option2 }"/></td>
											<%} %>
										</tr>
										<tr>
											<td><label for="option3">Option3&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType)){ %>
											<td><form:input path="option3"/></td>
											<%}else{ %>
											<td><form:input path="option3" value="${onlineTestVO.option3 }"/></td>
											<%} %>
										</tr>
										<tr>
											<td><label for="option4">Option4&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType)){ %>
											<td><form:input path="option4"/></td>
											<%}else{ %>
											<td><form:input path="option4" value="${onlineTestVO.option4 }"/></td>
											<%} %>
										</tr>
										<tr>
											<td><label for="answer">Answer&nbsp;&nbsp;&nbsp;</label></td>
											<%if("CREATE".equalsIgnoreCase(actionType)){ %>
											<td><form:input path="answer"/></td>
											<%}else{ %>
											<td><form:input path="answer" value="${onlineTestVO.answer }"/></td>
											<form:hidden path="questionID" value="${onlineTestVO.questionID }"/>
											<%} %>
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
									<form:hidden path="providerID" value="${providerID}"/>
									<form:hidden path="actionType" value='<%=(String)session.getAttribute("actionType")%>'/>
								</form:form>
								<span style="color:red;">View question and answer&nbsp;&nbsp;&nbsp;<a href="/irecruiter/listAllQuestions">Click here</a></span>
							<table class="gridtable">
									<thead>
										<tr>
											<th style="text-align:left;">Question/Options</th>
											<th style="text-align:left;">Answer</th>
											<th style="text-align:left;">Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${questionList}"var="questionList">
										<tr class="light">
									    	<td><c:out value="${questionList.question}"></c:out><br>
											(a).<span style="color:blue"><c:out value="${questionList.option1}"></c:out></span>&nbsp;
											(b).<span style="color:blue"><c:out value="${questionList.option2}"></c:out></span><br>
											(c).<span style="color:blue"><c:out value="${questionList.option3}"></c:out></span>&nbsp;
											(d).<span style="color:blue"><c:out value="${questionList.option4}"></c:out></span>
											</td>
											<td><c:out value="${questionList.answer}"></c:out></td>
											<td><a href="/irecruiter/editQuestion?id=${questionList.questionID}">Edit&nbsp;&nbsp;&nbsp;</a>I
											    <a href="/irecruiter/deleteQuestion?id=${questionList.questionID}">Delete</a></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
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