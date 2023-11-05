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
	
	
	public static void main(String[] a) throws SQLException {
		CreerConnection db = new CreerConnection();
		Connection cnx = null;
		cnx = db.myCnx();
		PreparedStatement ps; // requete pour MaJ
		Statement st = cnx.createStatement(); // requetes interrogations
		ResultSet rs; // jeu de résultat
		
		//Lancer requetes
		//PreparedStatement ( sans résultat)

		String[] createTableStatements = { 
				"CREATE TABLE IF NOT EXISTS client (coCli INT PRIMARY KEY, nomCli VARCHAR(255), rueCli VARCHAR(255), villeCli VARCHAR(255), noAg INT);",
				"CREATE TABLE IF NOT EXISTS commande (noBc INT PRIMARY KEY, dateBc DATE, coCli INT, FOREIGN KEY (coCli) REFERENCES client(coCli));",
				"CREATE TABLE IF NOT EXISTS facture (noFac INT PRIMARY KEY, dateFac DATE);",
				"CREATE TABLE IF NOT EXISTS livraison (noBl INT PRIMARY KEY, dateBl DATE, noBc INT, noFac INT, FOREIGN KEY (noBc) REFERENCES commande(noBc), FOREIGN KEY (noFac) REFERENCES facture(noFac));",
				"CREATE TABLE IF NOT EXISTS tva (codeTva INT PRIMARY KEY, tauxTva DECIMAL(5,2));",
				"CREATE TABLE IF NOT EXISTS produit (refProd INT PRIMARY KEY, desiProd VARCHAR(255), codeTva INT, FOREIGN KEY (codeTva) REFERENCES tva(codeTva));",
				"CREATE TABLE IF NOT EXISTS agence (noAg INT PRIMARY KEY, noMag VARCHAR(255));",
				"CREATE TABLE IF NOT EXISTS composer (noBl INT, refProd INT, qteLiv INT, PRIMARY KEY (noBl, refProd), FOREIGN KEY (noBl) REFERENCES livraison(noBl), FOREIGN KEY (refProd) REFERENCES produit(refProd));",
				"CREATE TABLE IF NOT EXISTS concerner (noBc INT, refProd INT, qteCom INT, pUnit DECIMAL(8,2), PRIMARY KEY (noBc, refProd), FOREIGN KEY (noBc) REFERENCES commande(noBc), FOREIGN KEY (refProd) REFERENCES produit(refProd));"
				
		};
		
		for (String createTableStatement : createTableStatements) {
		    ps = cnx.prepareStatement(createTableStatement);
		    ps.execute();
		}
		
		
		//Insert into client

		
		String[] insertStatements = {
//				"INSERT INTO client (coCli, nomCli, rueCli, villeCli, noAg) VALUES (1, 'Dupont Marie','4 rue de la Paix', 'Lens', 1)",
//				"INSERT INTO client (coCli, nomCli, rueCli, villeCli, noAg) VALUES (2, 'Solimando Adrien', '87 rue de la Gare', 'Lyon', 2)",
//				"INSERT INTO client (coCli, nomCli, rueCli, villeCli, noAg) VALUES (3, 'Podowsky Louise', '21 rue du 4 Novembre', 'Strasbourg', 1)",
//				"INSERT INTO client (coCli, nomCli, rueCli, villeCli, noAg) VALUES (4, 'McCain John', '42 Wall St.', 'New York', 1)"
				
//				"INSERT INTO commande (noBc, dateBc, coCli) VALUES (6547816, '2023-12-01', 1)",
//				"INSERT INTO commande (noBc, dateBc, coCli) VALUES (9876541, '2023-12-04', 2)",
//				"INSERT INTO commande (noBc, dateBc, coCli) VALUES (4657982, '2023-11-22', 4)",
//				"INSERT INTO commande (noBc, dateBc, coCli) VALUES (2356897, '2023-12-10', 1)",
//				
//				"INSERT INTO facture (noFac, dateFac) VALUES (001, '2023-12-01')",
//				"INSERT INTO facture (noFac, dateFac) VALUES (002, '2023-12-04')",
//				"INSERT INTO facture (noFac, dateFac) VALUES (003, '2023-11-22')",
//				"INSERT INTO facture (noFac, dateFac) VALUES (004, '2023-12-10')"
				
//				"INSERT INTO livraison (noBl, dateBl, noBc, noFac) VALUES (101, '2024-01-04', 6547816, 001)",
//				"INSERT INTO livraison (noBl, dateBl, noBc, noFac) VALUES (102, '2024-01-07', 9876541, 002)",
//				"INSERT INTO livraison (noBl, dateBl, noBc, noFac) VALUES (103, '2024-01-01', 4657982, 003)",
//				"INSERT INTO livraison (noBl, dateBl, noBc, noFac) VALUES (104, '2024-01-02', 2356897, 004)"
//				
//				"INSERT INTO produit (refProd, desiProd, codeTva) VALUES (1001, 'Montre', 1)",
//				"INSERT INTO produit (refProd, desiProd, codeTva) VALUES (1002, 'Trotinette Electrique', 2)",
//				"INSERT INTO produit (refProd, desiProd, codeTva) VALUES (1003, 'Tesla model X', 1)",
//				"INSERT INTO produit (refProd, desiProd, codeTva) VALUES (1004, 'Violon', 1)"
//				
//				"INSERT INTO tva (codeTva, tauxTva) VALUES (1, 0.10)",
//				"INSERT INTO tva (codeTva, tauxTva) VALUES (2, 0.15)"
//				
//				"INSERT INTO agence (noAg, noMag) VALUES (1, 'Amazon')",
//				"INSERT INTO agence (noAg, noMag) VALUES (2, 'Fedex')"
//				
//				"INSERT INTO composer (noBl, refProd, qteLiv) VALUES (101, 1001, 13)",
//				"INSERT INTO composer (noBl, refProd, qteLiv) VALUES (102, 1002, 4)",
//				"INSERT INTO composer (noBl, refProd, qteLiv) VALUES (103, 1003, 8)",
//				"INSERT INTO composer (noBl, refProd, qteLiv) VALUES (104, 1004, 1)"
//				
//				"INSERT INTO concerner (noBc, refProd, qteCom, pUnit) VALUES (6547816, 1001, 5, 100.00)",
//				"INSERT INTO concerner (noBc, refProd, qteCom, pUnit) VALUES (9876541, 1002, 1, 430.00)",
//				"INSERT INTO concerner (noBc, refProd, qteCom, pUnit) VALUES (4657982, 1003, 1, 48000.00)",
//				"INSERT INTO concerner (noBc, refProd, qteCom, pUnit) VALUES (2356897, 1004, 2, 1423.00)"
		};
		
		for (String insertStatement : insertStatements) {
		    st.executeUpdate(insertStatement);
		}
		
		//Statement ( retourt avec resultat ) 
		
		  String selectQuery = "SELECT * FROM produit p order by p.desiProd ASC;"; 
		  st = cnx.createStatement(); 
		  rs = st.executeQuery(selectQuery);
		 
		
		//Parcourir resultat 
		
		  while (rs.next()) {
			  int refProd = rs.getInt("refProd");
			  String desiProd = rs.getString("desiProd");
			  System.out.println("reference :" + refProd + ", Produit : " + desiProd);  
		  }
		  
		  rs.close();
		  st.close();
	}
}
