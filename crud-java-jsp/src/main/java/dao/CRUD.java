package dao;

import java.util.List;

import model.Usuario;

public interface CRUD {
	public static void create (Usuario usuario) {}
	public static void delete (int usuaroId) {}
	public static List<Usuario> select (String pesquisa){return null;}
	public static Usuario selectByPk(int clientId) {return null;}
	public static void update(Usuario usuario) {}
}
