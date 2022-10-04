package conexãoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	private static final String URL = "jdbc:mysql://localhost:3306/agencia_de_viagem";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public static Connection createConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conexão obtida com sucesso!");

		}catch(ClassNotFoundException e) {
			System.out.println("Falha na conexão" + e.getMessage());
			
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Database conectado");
			return connection;
			
		}catch(SQLException e) {
			System.err.println("Falha na conexão do Database" + e.getMessage());
			return null;
			   
	   }
		
	}

}
