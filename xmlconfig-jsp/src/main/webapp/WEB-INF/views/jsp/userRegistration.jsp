<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
      <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
	<title>Twitter UCM</title>	
</head>
<body>
	<div class="container">
		<fieldset>
  			<legend>New User:</legend>
  			<spring:url var="createUserUrl" value="/users" />
			<form:form commandName="createUser" action="${createUserUrl}">
				<spring:bind path="username">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="username">Username: </form:label>
						<form:input type="text" path="username" class="form-control" placeholder="Username"/>
						<form:errors path="username" />
					</div>
				</spring:bind>
				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="email">Email: </form:label>
						<form:input type="email" path="email" class="form-control" placeholder="Email"/>
						<form:errors path="email" />
					</div>
				</spring:bind>
				<spring:bind path="password">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="password">Password: </form:label>
						<form:input type="password" path="password" class="form-control" placeholder="Password"/>
						<form:errors path="password" />
					</div>
				</spring:bind>

				<div><form:button type="submit" class="btn btn-primary">Register</form:button></div>
			</form:form>
		</fieldset>
		<footer><p>© FDI 2015</p></footer>
	</div>
	<!-- JS -->
	<script src="<spring:url value="/webjars/jquery/2.1.1/jquery.min.js" />"></script>
	<script src="<spring:url value="/webjars/bootstrap/3.0.0/js/bootstrap.min.js" />"></script>
</body>
</html>
