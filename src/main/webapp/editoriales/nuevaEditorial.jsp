<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String url = "http://localhost:8088/Proyectoweb01/";
	%>
	<div class="container">
		<h3>Nuevo autor</h3>

		<form role="form" action="<%=url%>EditorialController" method="POST">
		
			<input type="hidden" name="op" value="insertar"> <label
				for="codigo">Nombre de la editorial</label>
			<div class="input-group">
				<input type="text" class="form-control" name="nombre" id="nombre"
					value="" placeholder="Ingresa el nombre de la editorial">
			</div>


			<label for="nombre">Contacto de la editorial</label> <input type="text"
				class="form-control" name="contacto" id="contacto" value=""
				placeholder="Ingresa el contacto de la editorial"> <span
				class="input-group-addon"><span
				class="glyphicon glyphicon-asterisk"></span></span>


			<div class="form-group">
				<label for="contacto">Telefono de la editorial</label>
				<div class="input-group">
					<input type="text" class="form-control" id="telefono" value=""
						name="telefono"
						placeholder="Ingresa la nacionalidad del autor"> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<input type="submit" class="btn btn-info" value="Guardar"
				name="Guardar"> <a class="btn btn-danger"
				href="<%=url%>EditorialController?op=listar">Cancelar</a>
		</form>
	</div>
</body>
</html>