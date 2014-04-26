<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">Usu&aacute;rios</div>
                                    <div class="pull-right"><span class="badge badge-info">${usuarios.size()}</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Usu&aacute;rio</th>
                                                <th>Nome</th>
                                                <th>E-mail</th>
                                                <th>Ativo</th>
                                                <th>A&ccedil;&otilde;es</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${usuarios}" var="usuario">
												<tr>
	                                                <td>${usuario.id}</td>
	                                                <td>${usuario.login}</td>                    
								                    <td>${usuario.nome}</td>
								                    <td>${usuario.email}</td>
								                    <td>${usuario.enabled ? "Sim" : "N&atilde;o"}</td>
								                    <td>
								                    	<div class="btn-group">
															<a class="btn" href="/sgp/admin/usuario/${usuario.id}"><i class="icon-eye-open"></i></a>
															<a class="btn" href="/sgp/admin/usuario/update/${usuario.id}"><i class="icon-pencil"></i></a>
								                    		<a class="btn" href="/sgp/admin/usuario/delete/${usuario.id}"><i class="icon-remove"></i></a>
								                    	</div>
													</td>
	                                            </tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->