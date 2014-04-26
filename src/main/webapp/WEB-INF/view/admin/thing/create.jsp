<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form:form action="/admin/thing" method="POST" modelAttribute="thingForm">
  <div>
    <label for="thing">Name:</label>
    <form:input cssStyle="width:250px" path="name" size="45" />
  </div>
  <div>
    <label for="sensorName">Sensor name:</label>
    <form:input cssStyle="width:250px" path="sensorName" size="45" />
  </div>
  <div>
    <label for="localId">Local:</label>
    <form:select path="localId" items="${locals}" />
  </div>
  <br/>
  <br/>
  <div class="submit">
    <a href="<c:url value="/admin/thing/form/list" />" id="cancel" class="btn btn-default">Cancel</a>
    <input id="Create" type="submit" value="Create" class="btn btn-primary" />
  </div>
</form:form>