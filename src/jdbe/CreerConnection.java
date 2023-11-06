package jdbe;

import java.sql.*;

//connector
public class CreerConnection {
	
	public Connection  myCnx() {
		Connection cn = null;
		
		//Création chaine de connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd4","xyz","xyz");
			System.out.println("Connexion réussie");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
