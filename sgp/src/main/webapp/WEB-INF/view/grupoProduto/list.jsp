<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">Grupos de Produto</div>
                                    <div class="pull-right"><span class="badge badge-info">${grupoProdutos.size()}</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Nome</th>
                                                <th>Ativo</th>
                                                <th>A&ccedil;&otilde;es</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${grupoProdutos}" var="grupoProduto">
												<tr>
	                                                <td>${grupoProduto.id}</td>
								                    <td>${grupoProduto.nome}</td>
								                    <td>${grupoProduto.ativo ? "Sim" : "N&atilde;o"}</td>
								                    <td>
								                    	<div class="btn-group">
															<a class="btn" href="/sgp/grupoproduto/${grupoProduto.id}"><i class="icon-eye-open"></i></a>
															<a class="btn" href="/sgp/grupoproduto/update/${grupoProduto.id}"><i class="icon-pencil"></i></a>
								                    		<a class="btn" href="/sgp/grupoproduto/delete/${grupoProduto.id}"><i class="icon-remove"></i></a>
								                    	</div>
													</td>
	                                            </tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->