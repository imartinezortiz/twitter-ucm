<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<spring:url var="homeUrl" value="/" />
		<p>The user <c:out value="${username}" /> has successfully registered. Go to the <a href="${homeUrl}">welcome page</a></p>
		<footer><p>© FDI 2015</p></footer>
	</div>
	<!-- JS -->
	<script src="<spring:url value="/webjars/jquery/2.1.1/jquery.min.js" />"></script>
	<script src="<spring:url value="/webjars/bootstrap/3.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>