<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/doLogin" var="loginUrl" />
<form action="${loginUrl}" method="POST" class="form-signin">
	<h2 class="form-signin-heading">Please sign in</h2>
	<label for="inputUsername" class="sr-only">Username</label>
	<input
		type="text" id="inputUsername" name="username" class="form-control"
		placeholder="Username, email" required="required"
		autofocus="autofocus"> <label for="inputPassword"
		class="sr-only">Password</label> <input type="password"
		id="inputPassword" name="password" class="form-control"
		placeholder="Password" required="required">
	<div class="checkbox">
		<label> <input type="checkbox"
			name="remember-me" value="true">
			Remember me
		</label>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>