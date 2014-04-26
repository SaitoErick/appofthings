<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	Usuario logado: <security:authentication property="principal.username" />
	
	<security:authorize ifAnyGranted="ROLE_USER">
		<br />
		Somente usuario podem ver
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN">
		<br />
		Somanete administradores podem ver
	</security:authorize>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">
		<br />
		Administradores ou usuario porem ver
	</security:authorize>
	
	<br />
	<a href="<c:url value="j_spring_security_logout" />"> Logout</a>
