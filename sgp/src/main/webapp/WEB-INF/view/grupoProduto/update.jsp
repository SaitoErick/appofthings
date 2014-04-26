<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   

    <form:form action="/sgp/grupoproduto" method="PUT" modelAttribute="grupoProduto">
    
        <div>
            <label for="nome">Nome:</label>
            <form:input cssStyle="width:250px" maxlength="45" path="nome" size="45"/>
        </div>
        <div>
            <label for="ativo">Ativo:</label>
            <form:checkbox path="ativo" />
        </div>
        <br/>
        <br/>
 
        <div class="submit">
        	<a href="<c:url value="/grupoproduto" />" id="voltar" class="btn">Voltar</a>
            <input id="salvar" type="submit" value="Salvar" class="btn btn-primary" />
        </div>
        <form:hidden path="id"/>
        
    </form:form>