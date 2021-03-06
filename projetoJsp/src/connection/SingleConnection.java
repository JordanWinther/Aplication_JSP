package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 * Respons?vel por fazer a conex?o com o banco de dados.
 * @author Dark
 *
 */

public class SingleConnection {

	private static String banco ="jdbc:postgresql://localhost:5432/projetoJsp?autoReconnect=true";
	private static String password ="admin";
	private static String user ="postgres";
	private static  Connection connection = null;


	static{
		conectar();
	}
	public SingleConnection(){
		conectar();
	}
	private static void conectar(){
		try{
			if(connection == null){
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password );
				connection.setAutoCommit(false);
				JOptionPane.showMessageDialog(null, "Conectado ao banco de dados");
			}
		}catch(Exception e){
			throw  new RuntimeException("Erro ao conectar com o banco de dados.");
		}
	}
	public static Connection getConnection(){
		return connection;
	}
}
