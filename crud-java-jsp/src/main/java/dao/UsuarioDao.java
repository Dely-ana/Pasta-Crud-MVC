package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexãoBD.Conectar;
import model.Usuario;

public class UsuarioDao implements CRUD {
	private static Connection connection = Conectar.createConnection();
	private static String Sql;
	
	public static void create (Usuario usuario) {
		Sql= "INSERT INTO usuario ( nome, cpf, telefone, email, sexo, pais) VALUES (?,?,?,?,?,?)";
	
	try {
		PreparedStatement psm = connection.prepareStatement(Sql);
		psm.setString(1,usuario.getNome());
		psm.setString(2,usuario.getCpf());
		psm.setString(3,usuario.getTelefone());
		psm.setString(4,usuario.getEmail());
		psm.setString(5,usuario.getSexo());
		psm.setString(6,usuario.getPais());
		
		psm.executeUpdate();
		
		System.out.println("--Inserção correta no Banco de dados--");
		
		
	}catch (SQLException e) {
		System.out.println("--Inserção incorreta no Banco de dados-- "+ e.getMessage());
	}	
		
}
	
	public static void delete (int usuarioId) {
		Sql = "DELETE FROM usuario WHERE id = ?";
		
	try {
		PreparedStatement pstm = connection.prepareStatement(Sql);
		pstm.setInt(1, usuarioId);
		pstm.executeUpdate();
		
		System.out.println("--Exclusão feita com sucesso do usuario--");
	
		
	}catch(SQLException e){
		System.out.println("--Exclusão sem sucesso do usuario--" + e.getMessage());
		
	}
		
		
		
	}
	
	
	public static List<Usuario> select (String pesquisa){
		 
		Sql = String.format("SELECT * FROM usuario WHERE nome like '%s%%' OR cpf like '%s%%'",pesquisa, pesquisa);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
	try {
		
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(Sql);
		
    while(rs.next()) {
    	Usuario usuario = new Usuario();
    	
    	usuario.setId(rs.getInt("id"));
    	usuario.setNome(rs.getString("nome"));
    	usuario.setCpf(rs.getString("cpf"));
    	usuario.setTelefone(rs.getString("telefone"));
    	usuario.setEmail(rs.getString("email"));
    	usuario.setSexo(rs.getString("sexo"));
    	usuario.setPais(rs.getString("pais"));
    	usuarios.add(usuario);
			
		}
    
        System.out.println("--Inserção correta do select usuarios--");   
        return usuarios;
    
    
	}catch(SQLException e) {
		System.out.println("--Inserção incorreta do select usuarios--" + e.getMessage());
		return null;
	}	
	
	}
	
	public static Usuario selectByPk(int usuarioId) {
		
		 
		Sql = String.format("SELECT * FROM usuario WHERE id = %d", usuarioId);
		
	try {
		
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(Sql);
		Usuario usuario = new Usuario();
		
    while(rs.next()) {
    	
    	usuario.setNome(rs.getString("nome"));
    	usuario.setCpf(rs.getString("cpf"));
    	usuario.setTelefone(rs.getString("telefone"));
    	usuario.setEmail(rs.getString("email"));
    	usuario.setSexo(rs.getString("sexo"));
    	usuario.setPais(rs.getString("pais"));
			
		}
    
        System.out.println("--Inserção correta do selectByPk usuarios--");   
        return usuario;
    
	}catch(SQLException e) {
		System.out.println("--Inserção incorreta do selectByPk usuarios--" + e.getMessage());
		return null;
	}	
		
	
	}
	public static void update(Usuario usuario) {
		Sql= "UPDATE usuario SET nome=?, cpf=?, telefone=?, email=?, sexo=?, pais=? WHERE id=?";
		
		try {
			PreparedStatement psm = connection.prepareStatement(Sql);
			psm.setString(1,usuario.getNome());
			psm.setString(2,usuario.getCpf());
			psm.setString(3,usuario.getTelefone());
			psm.setString(4,usuario.getEmail());
			psm.setString(5,usuario.getSexo());
			psm.setString(6,usuario.getPais());
			psm.setInt(8, usuario.getId());
			
			psm.executeUpdate();
			
			System.out.println("--Inserção correta do update no Banco de dados--");
			
			
		}catch (SQLException e) {
			System.out.println("--Inserção incorreta do update no Banco de dados-- "+ e.getMessage());
		}	
		
		
	}

}
