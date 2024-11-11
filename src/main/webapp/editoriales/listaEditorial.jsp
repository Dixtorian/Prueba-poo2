<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.unu.poo2.beans.Editorial"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de editoriales</title>

 <%
  	String url = "http://localhost:8088/Proyectoweb01/";
 %>
 
 <a type="button" href="<%=url%>EditorialController?op=nuevo"> Nueva Editorial</a>
 
 <table border="1" id="tabla">
	<thead>
		<tr>
			<th>Id de la editorial</th>
			<th>Nombre de la editorial</th>
			<th>Contacto</th>
			<th>Telefono</th>
		</tr>
	</thead>
	<tbody>
		<%
		List<Editorial> listaEditorial = (List<Editorial>) request.getAttribute("listaEditorial");

		// Verificar si la lista no es nula
		if (listaEditorial != null) {
			// Iterar sobre la lista de autores
			for (Editorial editorial : listaEditorial) {
		%>
		<tr>
			<td><%=editorial.getIdeditorial() %></td>
			<td><%=editorial.getNomEditorial()%></td>
			<td><%=editorial.getContacto()%></td>
			<td><%=editorial.getTelefono()%></td>		
		</tr>
		<%
		}
		} else {
		%>

		<tr>
			<td>No hay datos</td>
			<td>No hay datos</td>
			<td>No hay datos</td>
			<td>No hay datos</td>
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