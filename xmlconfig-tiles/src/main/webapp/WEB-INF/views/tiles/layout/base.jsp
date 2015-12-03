<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
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
      <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

	<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="navigation" />
		<tiles:insertAttribute name="content" />
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<!-- JS -->
	<script src="<spring:url value="/webjars/jquery/2.1.1/jquery.min.js" />"></script>
	<script	src="<spring:url value="/webjars/bootstrap/3.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>