<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form:form action="/admin/thing" method="DELETE" modelAttribute="thing">
  <div>
    <label for="base">Thing:</label>
    <input type="text" style="width:250px" value="${thing.name}" size="45" readonly="readonly" />
  </div>
  <div>
    <label for="building">Local:</label>
    <input type="text" style="width:250px" value="${thing.local.room}" size="45" readonly="readonly" />
  </div>
  <div class="submit">
    <a href="<c:url value="/admin/thing/form/list" />" id="back" class="btn btn-default">Back</a>
	<input id="Delete" type="submit" value="Delete" class="btn btn-primary" />
  </div>
  <form:hidden path="id"/>
</form:form>