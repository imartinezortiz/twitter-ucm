<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<div>
			<form:button type="submit" class="btn btn-primary">Register</form:button>
		</div>
	</form:form>
</fieldset>