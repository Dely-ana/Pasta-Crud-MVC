package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;


@WebServlet("/DeleteUsuario")
public class UsuarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		UsuarioDao.delete(usuarioId);
		
		Usuariocreateandselect usuariocreateandselect = new Usuariocreateandselect();
		usuariocreateandselect.doGet(request, response);
	}

}
