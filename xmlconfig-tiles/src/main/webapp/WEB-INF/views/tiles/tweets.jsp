<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<form:form commandName="createTweet">
	<spring:bind path="message">
		<div class="form-group">
		<form:label path="message">Write something:</form:label>
		<form:textarea path="message" class="form-control" placeholder="message"></form:textarea>
		<form:errors path="message" />
		</div>
	</spring:bind>
		<form:button type="submit" class="btn btn-primary">Tweet</form:button>
	</form:form>
</sec:authorize>
<h1>List of recent posts</h1>
<ul class="list-unstyled">
	<c:forEach items="${tweets}" var="tweet">
		<li><div>
				<p>
					<c:out value="${tweet.message}" />
				</p>
				<p>
					<em>Published by <c:out value="${tweet.username}" /> at <tags:localDate
							date="${tweet.date}" /></em>
				</p>
			</div></li>
	</c:forEach>
</ul>