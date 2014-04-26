<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- block -->
<div class="block">
  <div class="block-content collapse in">
	<form:form action="/admin/thing" method="POST" modelAttribute="thingForm">
		<div>
		  <label for="thing">Name:</label>
		  <form:input cssStyle="width:250px" path="name" size="45" />
		  <label for="sensorName">Sensor name:</label>
		  <form:input cssStyle="width:250px" path="sensorName" size="45" />
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
    <table class="table table-striped">
      <thead>
        <tr>
          <th>Name</th>
          <th>Sensor name</th>
          <th>Local</th>
          <th>Active?</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${things}" var="thing">
          <tr>
	        <td>${thing.name}</td>
	        <td>${thing.sensorName}</td>
	        <td>${thing.local}</td>
	        <td>${thing.isActive}</td>
            <td>
              <div class="btn-group">
                <!--a class="btn" href="/admin/thing/form/view/${thing.id}"><i class="icon-eye-open"></i></a>
                <a class="btn" href="/admin/thing/form/update/${thing.id}"><i class="icon-pencil"></i></a-->
                <a class="btn" href="/admin/thing/form/delete/${thing.id}"><i class="icon-remove"></i></a>
              </div>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<!-- /block -->