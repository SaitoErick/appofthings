<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
    <div>
        <label for="nome">Nome:</label>
        <input type="text" style="width:250px" value="${grupoProduto.nome}" size="20" readonly="readonly" />
    </div>
    <div>
        <label for="ativo">Ativo:</label>
        <input type="text" style="width:250px" value="${grupoProduto.ativo ? 'Sim' : 'N&atilde;o'}" size="20" readonly="readonly" />
    </div>
	<br />
	<br />
	
	<div class="submit">
		<a href="<c:url value="/grupoproduto" />" id="voltar" class="btn">Voltar</a>
	</div>
