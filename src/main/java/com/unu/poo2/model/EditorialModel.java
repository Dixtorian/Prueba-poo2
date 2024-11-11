package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unu.poo2.beans.Editorial;

public class EditorialModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	Statement st;
	
	public List<Editorial> listarEditorial() throws SQLException {
		try {
			List<Editorial> lista = new ArrayList<>();
			String sql = "CALL sp_listarEditorial()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setIdeditorial(rs.getInt("ideditorial"));
				editorial.setNomEditorial(rs.getString("nomEditorial"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
				lista.add(editorial);
			}
			this.cerrarConexion();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE,null,ex);
			this.cerrarConexion();
			return null;
		}
	}
	
	public int insertarEditorial(Editorial editorial) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarEditorial(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, editorial.getNomEditorial());
			cs.setString(2, editorial.getContacto());
			cs.setString(3, editorial.getTelefono());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return 0;
		}
	}
}
