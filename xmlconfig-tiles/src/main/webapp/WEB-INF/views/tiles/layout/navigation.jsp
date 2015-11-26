<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="header clearfix">
	<nav>
		<ul class="nav nav-pills pull-right">
			<sec:authorize access="isAnonymous()">
				<li role="presentation" class="active"><a
					href="<spring:url value="/login" />">Sign in</a></li>
				<li role="presentation"><a
					href="<spring:url value="/users/registration" />">Register</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<spring:url var="logoutUrl" value="/doLogout" />
				<form action="${logoutUrl}" method="POST">
					<button type="submit" class="btn btn-primary">Logout</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</sec:authorize>
		</ul>
		<h3 class="text-muted">Welcome to Twitter UCM</h3>
	</nav>
</div>