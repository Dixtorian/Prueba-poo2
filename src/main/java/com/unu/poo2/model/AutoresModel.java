package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.unu.poo2.beans.Autor;

public class AutoresModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	Statement st;
	
	public List<Autor> listarAutores() throws SQLException {
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "CALL sp_listarAutores()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setCodigoAutor(rs.getString("codAutor"));
				autor.setNombreAutor(rs.getString("nomAutor"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);
			}
			this.cerrarConexion();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return null;
		}
	}
	
	
	public int insertarAutor(Autor autor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarAutor(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, autor.getCodigoAutor());
			cs.setString(2, autor.getNombreAutor());
			cs.setString(3, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return 0;
		}
	}
		 
	public int eliminarAutor(int idautor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return 0;
		}

	}
	
	
	public int modificarAutor(Autor autor) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarAutor(?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, autor.getIdAutor());
			cs.setString(2, autor.getCodigoAutor());
			cs.setString(3, autor.getNombreAutor());
			cs.setString(4, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public Autor obtenerAutor(int idautor) throws SQLException {
		try {
			String sql = "CALL sp_obtenerAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			rs = cs.executeQuery();
			if (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setCodigoAutor(rs.getString("codAutor"));
				autor.setNombreAutor(rs.getString("nomAutor"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				this.cerrarConexion();
				return autor;
			}
			this.abrirConexion();
			return null;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return null;
		}
	}

	public int totalAutores() throws SQLException {
		try {
			int totalaut = 0;
			String sql = "SELECT COUNT(codigo) as totalaut FROM autor";
			this.abrirConexion();
			st = conexion.prepareStatement(sql);
			rs = st.getResultSet();
			while (rs.next()) {
				totalaut = rs.getInt("totalaut");
			}
			return totalaut;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		} finally {
			this.cerrarConexion();
		}
	}
	}
