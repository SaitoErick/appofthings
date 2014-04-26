<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

	      <form:errors path="body" cssClass="error" />
	      <spring:hasBindErrors name=""></spring:hasBindErrors>
	    
	      <form class="form-signin" action="<c:url value='j_spring_security_check'/>" method="POST">
	        <h2 class="form-signin-heading">Login</h2>
	        <input type="text" name="j_username" class="input-block-level" placeholder="Usuario">
	        <input type="password" name="j_password" class="input-block-level" placeholder="Senha">
	        <label class="checkbox">
	          <input type="checkbox" value="remember-me"> Remember me
	        </label>
	        <button class="btn btn-large btn-primary" type="submit">Entrar</button>
	      </form>
