<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.poo2.beans.Autor"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyecto poo2</title>

<%
  	String url = "http://localhost:8088/Proyectoweb01/";
%>

<a type="button" href="<%=url%>AutoresController?op=nuevo"> Nuevo autor</a>

<table border="1" id="tabla">
	<thead>
		<tr>
			<th>Id del Autor</th>
			<th>Codigo del autor</th>
			<th>Nombre del autor</th>
			<th>Nacionalidad</th>
			<th>Operaciones</th>
		</tr>
	</thead>
	<tbody>
		<%
		List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");

		// Verificar si la lista no es nula
		if (listaAutores != null) {
			// Iterar sobre la lista de autores
			for (Autor autor : listaAutores) {
		%>
		<tr>
			<td><%=autor.getIdAutor() %></td>
			<td><%=autor.getCodigoAutor()%></td>
			<td><%=autor.getNombreAutor()%></td>
			<td><%=autor.getNacionalidad()%></td>
			<td>
			<a href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">Modificar</a> 			
			<a href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar</a>
			</td>
				
		</tr>
		<%
		}
		} else {
		%>

		<tr>
			<td>No hay datos</td>
			<td>No hay datos</td>
			<td>No hay datos</td>
			<td></td>
		</tr>

		<%
		}
		%>


	</tbody>
</table>




</head>
<body>

</body>
</html>
