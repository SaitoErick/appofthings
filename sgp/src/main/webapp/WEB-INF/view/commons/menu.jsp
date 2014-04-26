<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

				<div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                    	
                    	<security:authorize ifAnyGranted="ROLE_ADMIN">
	                        <li class="active">
	                            <a href="#"><i class="icon-chevron-right"></i>Usu&aacute;rios</a>
	                        </li>
	                        <li>
	                            <a href="<c:url value="/admin/usuario/create" />"><i class="icon-chevron-right"></i>Cadastrar</a>
	                        </li>
	                        <li>
	                            <a href="<c:url value="/admin/usuario" />"><i class="icon-chevron-right"></i>Listar</a>
	                        </li>
                        </security:authorize>
                        
                        <!-- GRUPO DE PRODUTO -->
                        <li class="active">
                            <a href="#"><i class="icon-chevron-right"></i>Grupo de Produto</a>
                        </li>
                        <li>
                            <a href="<c:url value="/grupoproduto/create" />"><i class="icon-chevron-right"></i>Cadastrar</a>
                        </li>
                        <li>
                            <a href="<c:url value="/grupoproduto" />"><i class="icon-chevron-right"></i>Listar</a>
                        </li>
                        
                        <!-- PRODUTO -->
                        <li class="active">
                            <a href="#"><i class="icon-chevron-right"></i>Produto</a>
                        </li>
                        <li>
                            <a href="<c:url value="/produto/create" />"><i class="icon-chevron-right"></i>Cadastrar</a>
                        </li>
                        <li>
                            <a href="<c:url value="/produto" />"><i class="icon-chevron-right"></i>Listar</a>
                        </li>
                        
                    </ul>
                </div>