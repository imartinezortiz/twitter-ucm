<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="homeUrl" value="/" />
<p>The user	<c:out value="${username}" /> has successfully registered. Go to the <a href="${homeUrl}">welcome page</a></p>