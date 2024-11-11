package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Autor;
import com.unu.poo2.beans.Editorial;
import com.unu.poo2.model.EditorialModel;

/**
 * Servlet implementation class EditorialController
 */
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	EditorialModel modelo = new EditorialModel();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				listar(request, response);
				return;
			}
			String operacion = request.getParameter("op");

			switch (operacion) {
			case "listar":
				listar(request, response);
				break;				
			case "nuevo":
				request.getRequestDispatcher("/editoriales/nuevaEditorial.jsp").forward(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			/*
			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;*/
			}
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		try {
			request.setAttribute("listaEditorial", modelo.listarEditorial());

			Iterator<Editorial> it = modelo.listarEditorial().iterator();
			while (it.hasNext()) {
				Editorial e = it.next();
			}

			request.getRequestDispatcher("/editoriales/listaEditorial.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {

			Editorial miEditorial = new Editorial();
			miEditorial.setNomEditorial(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono(request.getParameter("telefono"));

			if (modelo.insertarEditorial(miEditorial) > 0) {
				request.getSession().setAttribute("exito", "editorial registrada exitosamente");
				response.sendRedirect(request.getContextPath() + "/EditorialController?op=listar");
			} else {
				request.getSession().setAttribute("fracaso",
						"La editorial no ha sido ingresada" + "ya hay una editorial con este nombre");
				response.sendRedirect(request.getContextPath() + "/EditorialController?op=listar");
			}

		} catch (IOException | SQLException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
