package com.unu.poo2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
	private String url = "jdbc:mysql://localhost:3306/bdBibliotecaga"; // URL de la base de datos
    private String usuario = "root"; // Usuario de la base de datos
    private String contrasena = "123456"; // Contraseña de la base de datos
    protected Connection conexion;

    // Método para abrir la conexión
    public void abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
            conexion = DriverManager.getConnection(url, usuario, contrasena); // Establecer la conexión
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close(); // Cierra la conexión
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
