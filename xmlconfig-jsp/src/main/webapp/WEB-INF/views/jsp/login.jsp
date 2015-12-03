<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
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
    
	<title>Twitter UCM</title>	
</head>
<body>
	<div class="container">
	<spring:url value="/doLogin" var="loginUrl" />

	<form action="${loginUrl}" method="POST" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username, email" required="required" autofocus="autofocus">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="_spring_security_remember_me" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
      </form>

		<footer><p>© FDI 2015</p></footer>
	</div>
	<!-- JS -->
	<script src="<spring:url value="/webjars/jquery/2.1.1/jquery.min.js" />"></script>
	<script src="<spring:url value="/webjars/bootstrap/3.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>