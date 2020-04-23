<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<%@include file="../jsp/head.jsp"%>
<body>
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="../jsp/menu.jsp"%>

		<main class="mdl-layout__content">
			<div class="page-content">
				<div class="container">
					<div class="row">
						<div class="col-xs-12">
							<div class="page-header">
								<h1>Lista de livros <div style="font-size: 12pt" class="text-right">
									<tag:formatDate date="<%=Calendar.getInstance().getTime()%>"
										format="dd-MM-YYYY HH:mm"></tag:formatDate>
								</div></h1>
								
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>Titulo</th>
										<th>Autor</th>
										<th>Ano de Lançamento</th>
										<th>Resumo</th>
										<th>Menu de Acões</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="count" value="0" scope="page" />
									<c:forEach var="livros" items="${listLivros}">
										<c:set var="count" value="${count + 1}" scope="page" />
										<tr>
											<td><c:out value="${count}" /></td>
											<td><c:out value="${livros.titulo}" /></td>
											<td><c:out value="${livros.autor}" /></td>
											<td><c:out value="${livros.anoLancamento}" /></td>
											<td><c:out value="${livros.resumo}" /></td>
											<td><a class="btn btn-primary"
												href="/MeusLivros/edit?id=<c:out value='${livros.id}' />"><i
													class="fa fa-pencil-square-o" aria-hidden="true"></i>Editar</a>
												<a class="btn btn-danger"
												href="/MeusLivros/delete?id=<c:out value='${livros.id}' />"><i
													class="fa fa-trash-o" aria-hidden="true"></i>Deletar</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>

