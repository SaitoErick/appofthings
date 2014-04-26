<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
		    <form:form action="/sgp/admin/usuario" method="POST" modelAttribute="usuario">
		        <div>
		            <label for="login">Login:</label>
		            <form:input cssStyle="width:250px" maxlength="30" path="login" size="20"/>
		        </div>
		        <div>
		            <label for="telefone">Senha:</label>
		            <form:input cssStyle="width:250px" path="password" size="20"/>
		        </div>
		        <div>
		            <label for="nome">Nome:</label>
		            <form:input cssStyle="width:250px" path="nome" size="30"/>
		        </div>
		        <div>
		            <label for="email">Email:</label>
		            <form:input cssStyle="width:250px" maxlength="30" path="email" size="30"/>
		        </div>
		        <div>
		            <label for="enabled">Ativo:</label>
		            <form:checkbox path="enabled" />
		        </div>
		        <br/>
		        <br/>
		 
		        <div class="submit">
		        	<a href="<c:url value="/admin/usuario" />" id="voltar" class="btn">Voltar</a>
		            <input id="Cadastrar" type="submit" value="Cadastrar" class="btn btn-primary" />
		        </div>
		        
		    </form:form>
