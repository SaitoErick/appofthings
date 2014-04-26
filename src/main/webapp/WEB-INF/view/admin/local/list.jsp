<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- block -->
<div class="block">
  <div class="block-content collapse in">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>Base</th>
          <th>Building</th>
          <th>Floor</th>
          <th>Room</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${locals}" var="local">
          <tr>
	        <td>${local.base}</td>
	        <td>${local.building}</td>
	        <td>${local.floor}</td>
	        <td>${local.room}</td>
            <td>
              <div class="btn-group">
                <a class="btn" href="/admin/local/form/view/${local.id}"><i class="icon-eye-open"></i></a>
                <a class="btn" href="/admin/local/form/update/${local.id}"><i class="icon-pencil"></i></a>
                <a class="btn" href="/admin/local/form/delete/${local.id}"><i class="icon-remove"></i></a>
              </div>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<!-- /block -->