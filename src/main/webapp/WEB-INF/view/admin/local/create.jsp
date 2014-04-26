<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form:form action="/admin/local" method="POST" modelAttribute="local">
  <div>
    <label for="base">Base:</label>
    <form:input cssStyle="width:250px" path="base" size="45" />
  </div>
  <div>
    <label for="building">Building:</label>
    <form:input cssStyle="width:250px" path="building" size="30" />
  </div>
  <div>
    <label for="floor">Floor:</label>
    <form:input cssStyle="width:250px" path="floor" size="30" />
  </div>
  <div>
    <label for="room">Room:</label>
    <form:input cssStyle="width:250px" path="room" size="30" />
  </div>
  <br/>
  <br/>
  <div class="submit">
    <a href="<c:url value="/admin/local/form/list" />" id="cancel" class="btn btn-default">Cancel</a>
    <input id="Create" type="submit" value="Create" class="btn btn-primary" />
  </div>
</form:form>