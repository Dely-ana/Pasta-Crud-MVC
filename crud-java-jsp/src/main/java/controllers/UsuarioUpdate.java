package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;


@WebServlet("/UpdateUsuario")
public class UsuarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioUpdate() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
	    Usuario usuario = UsuarioDao.selectByPk(usuarioId);
	    request.setAttribute("usuario", usuario);
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("FormUpdate.jsp");
        requestDispatcher.forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   Usuario usuario = new Usuario();
	   
	    usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSexo(request.getParameter("sexo"));
		usuario.setPais(request.getParameter("pais"));
		
		UsuarioDao.create(usuario);
		
		Usuariocreateandselect usuariocreateandselect = new Usuariocreateandselect();
		usuariocreateandselect.doGet(request, response);
	}

}

		


