<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
		    <form:form action="/sgp/produto" method="POST" modelAttribute="produto">
		        <div>
		            <label for="descricao">Descri&ccedil;&atilde;o:</label>
		            <form:input cssStyle="width:250px" maxlength="30" path="descricao" size="45"/>
		        </div>
		        <div>
		            <label for="codigoBarras">C&oacute;digo de Barras:</label>
		            <form:input cssStyle="width:250px" path="codigoBarras" size="45"/>
		        </div>
		        <div>
		            <label for="precoVenda">Pre&ccedil;o de Venda:</label>
		            <form:input cssStyle="width:250px" path="precoVenda" size="30"/>
		        </div>
		        <div>
		            <label for="ativo">Ativo:</label>
		            <form:checkbox path="ativo" />
		        </div>
		        <br/>
		        <br/>
		        <div class="submit">
		        	<a href="<c:url value="/produto" />" id="voltar" class="btn">Voltar</a>
		            <input id="Cadastrar" type="submit" value="Cadastrar" class="btn btn-primary" />
		        </div>
		    </form:form>
