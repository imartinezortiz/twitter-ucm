<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- CSS -->
	<link rel="stylesheet" href="<spring:url value="/webjars/bootstrap/3.0.0/css/bootstrap.min.css"/>">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
	<title>Twitter UCM</title>	
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
	          <ul class="nav nav-pills pull-right">
<sec:authorize access="isAnonymous()">
	            <li role="presentation" class="active"><a href="<spring:url value="/login" />">Sign in</a></li>
	            <li role="presentation"><a href="<spring:url value="/users/registration" />">Register</a></li>
</sec:authorize>
<sec:authorize access="isAuthenticated()">

<c:url var="logoutUrl" value="/doLogout"/>
<form action="${logoutUrl}" method="POST">
<button type="submit" class="btn btn-primary">Logout</button>
<input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form>
</sec:authorize>
	          </ul>
	        </nav>
			<h3 class="text-muted">Welcome to Twitter UCM</h3>
		</div>
<sec:authorize access="isAuthenticated()">
		<fieldset>
  			<legend>Write something:</legend>
			<form:form commandName="newTweet">
				<form:textarea path="message"></form:textarea>
				<form:errors path="message" />
				<form:button type="submit" class="btn btn-lg btn-primary">Tweet</form:button>
			</form:form>
		</fieldset>
</sec:authorize>
		<h1>List of recent posts</h1>
		<ul>
<c:forEach items="${tweets}" var="tweet">
			<li><div><p><c:out value="${tweet.message}" /></p><p><em>Publicado por <c:out value="${tweet.username}" /> el <tags:localDate date="${tweet.date}"/></em></p></div></li>
</c:forEach>
		</ul>
		<footer><p>© FDI 2015</p></footer>
	</div>
	<!-- JS -->
	<script src="<spring:url value="/webjars/jquery/2.1.1/jquery.min.js" />"></script>
	<script src="<spring:url value="/webjars/bootstrap/3.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>