<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="span3" id="sidebar">
    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="nav-header active">
            <a href="#"><i ></i>Local</a>
        </li>
        <li class="menuItem">
            <a href="<c:url value="/admin/local/form/create" />">Create</a>
        </li>
        <li class="menuItem">
            <a href="<c:url value="/admin/local/form/list" />">Search</a>
        </li>
    </ul>
    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="nav-header active">
            <a href="#"><i ></i>Thing</a>
        </li>
        <li class="menuItem">
            <a href="<c:url value="/admin/thing/form/create" />">Create</a>
        </li>
        <li class="menuItem">
            <a href="<c:url value="/admin/thing/form/list" />">Search</a>
        </li>
    </ul>
</div>