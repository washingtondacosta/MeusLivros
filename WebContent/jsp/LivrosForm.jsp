<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<%@include file="../jsp/head.jsp"%>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="../jsp/menu.jsp"%>
		<main class="mdl-layout__content">
		<div class="page-content">
			<div class="mdl-grid center-items">
				<div class="mdl-cell mdl-cell--4-col">
					<div class="mdl-card mdl-shadow--6dp">
						<div
							class="mdl-card__title mdl-color--primary mdl-color-text--white">
							<h2 class="mdl-card__title-text">
								<c:if test="${livros != null}">Editar Livros</c:if>
								<c:if test="${livros == null}">Adicionar Livros</c:if>
							</h2>
						</div>
						<div class="mdl-card__supporting-text">
							<c:if test="${livros != null}">
								<form name="myForm" action="update" method="post" onsubmit="return validateForm()">
							</c:if>
							<c:if test="${livros == null}">
								<form name="myForm" action="insert" method="post" onsubmit="return validateForm()">
							</c:if>
							<c:if test="${livros != null}">
								<input type="hidden" name="id"
									value="<c:out value='${livros.id}' />" />
							</c:if>

							<div class="mdl-textfield mdl-js-textfield">
								<input class="mdl-textfield__input" type="text" name="titulo"
									value="<c:out value='${livros.titulo}' />" id="titulo" /> <label
									class="mdl-textfield__label" for="titulo">Titulo</label>
							</div>

							<div class="mdl-textfield mdl-js-textfield">
								<input class="mdl-textfield__input" type="text"
									name="autor"
									value="<c:out value='${livros.autor}' />" id="autor" />
								<label class="mdl-textfield__label" for="autor">Autor</label>
							</div>

							<div class="mdl-textfield mdl-js-textfield">
							
							<c:choose>
							<c:when test = "${livros != null }"> 
							<input class="mdl-textfield__input" type="text" name="anolancamento" value="<c:out value='${livros.anoLancamento}' />" id="anoLancamento" />
							</c:when>
							<c:otherwise>
							<input class="mdl-textfield__input" type="text" name="anolancamento" value="<c:out value='' />" id="anolancamento" />
							</c:otherwise>
							</c:choose>
							
								 <label
									class="mdl-textfield__label" for="anoLancamento">Ano de Lançamento</label>
							</div>

							<div class="mdl-textfield mdl-js-textfield">
								<input class="mdl-textfield__input" type="textarea" name="resumo"
									value="<c:out value='${livros.resumo}' />" id="Resumo" /> <label
									class="mdl-textfield__label" for="Resumo">Resumo</label>
							</div>
							<input type="submit" class="btn btn-primary"
								value="Salvar">
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
		</main>
	</div>
	<script type="text/javascript">
	function validateForm() {
	    var x = document.forms["myForm"]["anoLancamento"].value;
	    if (x == "") {
	        alert("Informe o ano de lançamento");
	        return false;
	    }
	}
	</script>
</body>
</html>

