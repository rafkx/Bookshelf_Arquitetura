package factory;

import java.sql.*;

public class Connect {
	
	private static final String USERNAME="root";
	private static final String PASSWORD="mysql711";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bookshelf?rootTimezone=true&serverTimezone=UTC";
	
	public static Connection criaConexao() throws Exception{
		//Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD);
		return connect;
	}
	 public static void main (String [] args) throws Exception {
		 Connection rede = criaConexao();
		 
		 if (rede!=null) {
			 System.out.println("Conexão bem sucedida!\nSobre:"+rede);
			 rede.close();
		 }
	 }
}
