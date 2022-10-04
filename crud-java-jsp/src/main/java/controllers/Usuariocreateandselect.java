package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;


@WebServlet("/createandselect")
public class Usuariocreateandselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Usuariocreateandselect() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		    
		   if(pesquisa == null) {
			   pesquisa = "";
		   }
	
        List<Usuario> usuario = UsuarioDao.select(pesquisa);		   
        request.setAttribute("usuarios", usuario);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListUsuarios.jsp");
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
		
		doGet(request, response);
	}

}
