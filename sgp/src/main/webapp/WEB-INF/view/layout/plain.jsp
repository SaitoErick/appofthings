<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><tiles:insertAttribute name="title" defaultValue="" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Pagina de login">
    <meta name="author" content="Marcos Vidolin">

    <!-- styles -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet">

	<% /* STYLES - dynamic content */ %>
	<tilesx:useAttribute id="styles" name="styles" classname="java.util.List" ignore="true" />
	<c:forEach var="cssName" items="${styles}">
		<link type="text/css" href="<c:url value="/resources/css/${cssName}"/>"
			rel="stylesheet" media="screen" />
	</c:forEach>


    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

    <% /* SCRIPTS - dynamic content */ %>
	<tilesx:useAttribute id="scripts" name="scripts" classname="java.util.List" ignore="true" />
	<c:forEach var="jsName" items="${scripts}">
		<script src="<c:url value="/resources/js/${jsName}" />"></script>
	</c:forEach>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

	<!-- Page content -->
	<div class="container">

		<% /* BODY - dynamic content */ %>
		<tiles:insertAttribute name="body" defaultValue="" />

	</div>
	<!-- End of page content -->

	<% /* FOOTER - dynamic content */ %>
	<tiles:insertAttribute name="footer" defaultValue="" />




</body>
</html>