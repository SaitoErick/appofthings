<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form:form action="/admin/local" method="DELETE" modelAttribute="local">
  <div>
    <label for="base">Base:</label>
    <input type="text" style="width:250px" value="${local.base}" size="45" readonly="readonly" />
  </div>
  <div>
    <label for="building">Building:</label>
    <input type="text" style="width:250px" value="${local.building}" size="45" readonly="readonly" />
  </div>
  <div>
    <label for="floor">Floor:</label>
    <input type="text" style="width:250px" value="${local.floor}" size="45" readonly="readonly" />
  </div>
  <div>
    <label for="room">Room:</label>
    <input type="text" style="width:250px" value="${local.room}" size="45" readonly="readonly" />
  </div>
  <div class="submit">
    <a href="<c:url value="/admin/local/form/list" />" id="back" class="btn btn-default">Back</a>
	<input id="Delete" type="submit" value="Delete" class="btn btn-primary" />
  </div>
  <form:hidden path="id"/>
</form:form>