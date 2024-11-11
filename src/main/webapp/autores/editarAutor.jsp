<%@page import="com.unu.poo2.beans.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Autor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>

	<%@ include file='../cabecera.jsp' %>
	<%
	Autor autor;
	HttpSession sesion = request.getSession();

	if (request.getAttribute("autor") == null) {
		autor = new Autor();
	} else {
		autor = (Autor) request.getAttribute("autor");
	}
	%>

	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type="hidden" name="op" value="modificar" /> <input
			type="hidden" name="idautor" value="<%=autor.getIdAutor()%>" />

		<h1>REGISTRO DE AUTOR</h1>
		Codigo: <input type="text" name="codigo"
			value="<%=autor.getCodigoAutor()%>">
		<div class="group">
			<label for="nombre"> <br> Nombre: <input type="text"
				name="nombre" value="<%=autor.getNombreAutor()%>">
			</label>
		</div>
		<div class="group">
			<label> <br> Nacionalidad: <input type="text"
				name="nacionalidad" value="<%=autor.getNacionalidad()%>"> <br>
			</label>
		</div>
		<input type="submit" class="btn btn-info" value="Guardar"
			name="Guardar"> <a class="btn btn-danger"
			href="<%=url%>AutoresController?op=listar">Cancelar</a>
	</form>

</body>
</html>

