<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   	<title><tiles:insertAttribute name="title" defaultValue="" /></title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/client/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
	<link href="<c:url value="/resources/client/css/font-awesome.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/client/css/style.css"/>" rel="stylesheet">
</head>
<body>

  <tiles:insertAttribute name="body" defaultValue="" />

  <script src="<c:url value="/resources/client/js/jquery-2.1.0.min.js" />"></script>
  <script src="<c:url value="/resources/client/js/bootstrap.min.js" />"></script>
  <script src="<c:url value="/resources/client/js/scripts.js" />"></script>
  
</body>
</html>