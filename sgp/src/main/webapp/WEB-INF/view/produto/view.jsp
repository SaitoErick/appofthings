<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   

	<div>
		<label for="login">Descri&ccedil;&atilde;o:</label>
		<input type="text" style="width:250px" value="${produto.descricao}" size="45" readonly="readonly" />
	</div>
	<div>
		<label for="nome">C&oacute;digo Barras:</label>
		<input type="text" style="width:250px" value="${produto.codigoBarras}" size="45" readonly="readonly" />
	</div>
	<div>
		<label for="email">Pre&ccedil;o Venda:</label>
		<input type="text" style="width:250px" value="${produto.precoVenda}" size="20" readonly="readonly" />
	</div>
	<div>
		<label for="email">Grupo Produto:</label>
		<input type="text" style="width:250px" value="${produto.grupoProduto != null ? produto.grupoProduto.nome : ''}" size="45" readonly="readonly" />
	</div>
    <div>
        <label for="ativo">Ativo:</label>
        <input type="text" style="width:250px" value="${produto.ativo ? 'Sim' : 'N&atilde;o'}" size="20" readonly="readonly" />
    </div>
	<br />
	<br />
	
	<div class="submit">
		<a href="<c:url value="/produto" />" id="voltar" class="btn">Voltar</a>
	</div>
