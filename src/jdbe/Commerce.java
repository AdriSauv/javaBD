package jdbe;

import java.sql.*;
import java.util.*;

public class Commerce {
	
	private Connection cnx;
	private String str = "";
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	
	public Commerce(Connection cnx) {
		super();
		this.cnx = cnx;
	}
	
	public void dropTables() throws SQLException {
		str = "DROP TABLE IF EXISTS concerner"; ps = cnx.prepareStatement(str); ps.execute();
		str = "DROP TABLE IF EXISTS composer"; ps = cnx.prepareStatement(str); ps.execute();
		str = "DROP TABLE IF EXISTS livraison"; ps = cnx.prepareStatement(str); ps.execute();
		str = "DROP TABLE IF EXISTS commande"; ps = cnx.prepareStatement(str); ps.execute();
		str = "DROP TABLE IF EXISTS fournisseur"; ps = cnx.prepareStatement(str);ps.execute();
		str = "DROP TABLE IF EXISTS client";ps = cnx.prepareStatement(str);ps.execute();
		str = "DROP TABLE IF EXISTS produit";ps = cnx.prepareStatement(str);ps.execute();
		str = "DROP TABLE IF EXISTS facture";ps = cnx.prepareStatement(str);ps.execute();
		str = "DROP TABLE IF EXISTS tva";ps = cnx.prepareStatement(str);ps.execute();
		str = "DROP TABLE IF EXISTS agence";ps = cnx.prepareStatement(str);ps.execute();
	}
	
	public void creerTable() throws SQLException {
		str = "CREATE TABLE IF NOT EXISTS agence(noag int auto_increment, nomag VARCHAR(99), PRIMARY KEY(noag));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS tva(codetva int auto_increment, tauxtva double, PRIMARY KEY(codetva));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS facture(nofac int auto_increment, datefac date, PRIMARY KEY(nofac));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS produit(refprod int auto_increment, desiprod VARCHAR(99), codetva int, PRIMARY KEY(refprod), "
				+ "FOREIGN KEY(codetva) REFERENCES tva(codetva));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS client(cocli int auto_increment, nomcli VARCHAR(99), ruecli VARCHAR(99), villecli VARCHAR(99), noag int, PRIMARY KEY(cocli), "
				+ "FOREIGN KEY(noag) REFERENCES agence(noag));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS fournisseur(nofrs int auto_increment, nomfrs VARCHAR(99), adrfrs VARCHAR(99), telfrs VARCHAR(99), PRIMARY KEY(nofrs));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS commande(nobc int auto_increment, datebc date, cocli int, nofrs int, PRIMARY KEY(nobc), "
				+ "FOREIGN KEY(cocli) REFERENCES client(cocli), FOREIGN KEY(nofrs) REFERENCES fournisseur(nofrs));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS livraison(nobl int auto_increment, datebl date, nobc int, nofac int, PRIMARY KEY(nobl), "
				+ "FOREIGN KEY(nofac) REFERENCES facture(nofac), FOREIGN KEY(nobc) REFERENCES commande(nobc));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS composer(nobl int, refprod int, qteliv int, PRIMARY KEY(nobl, refprod), "
				+ "FOREIGN KEY(refprod) REFERENCES produit(refprod), FOREIGN KEY(nobl) REFERENCES livraison(nobl));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
		str = "CREATE TABLE IF NOT EXISTS concerner(nobc int, refprod int, qtecom int, punit double, PRIMARY KEY(nobc, refprod), "
				+ "FOREIGN KEY(refprod) REFERENCES produit(refprod), FOREIGN KEY(nobc) REFERENCES commande(nobc));\n";
		ps = cnx.prepareStatement(str);
		ps.execute();
	}
	
	public void insererData() throws SQLException {
		str = "INSERT INTO agence (nomag) VALUES\n"
				+ "('sud-est'),\n"
				+ "('sud-ouest'),\n"
				+ "('sud'),\n"
				+ "('nord'),\n"
				+ "('nord-est'),\n"
				+ "('nord-ouest'),\n"
				+ "('ANTARIA'),\n"
				+ "('ABYSSE');";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO client (nomcli, ruecli, villecli, noag) VALUES\n"
				+ "('Atef', 'general de gaule', 'Lille', 8),\n"
				+ "('Chloe', 'des braves', 'Cergy', 7);";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO tva (tauxtva) VALUES\n"
				+ "(20),\n"
				+ "(10);";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO produit (desiprod, codetva) VALUES\n"
				+ "('Ecran', 1),\n"
				+ "('Souris', 1),\n"
				+ "('Tapis', 2),\n"
				+ "('Tableau', 2),\n"
				+ "('Roue', 1),\n"
				+ "('Unite', 1),\n"
				+ "('Chevre', 2),\n"
				+ "('Carabine', 1),\n"
				+ "('Chocolat', 2),\n"
				+ "('Feu de camp', 2);";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO fournisseur (nomfrs, adrfrs, telfrs) VALUES\n"
				+ "('OREXAD', 'Bondue', '123456789'),\n"
				+ "('INSY2S', 'Lille', '123456789');";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO facture (datefac) VALUES\n"
				+ "('2023-05-01'),\n"
				+ "('2023-04-11'),\n"
				+ "('2022-12-04'),\n"
				+ "('2022-12-13');";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO commande (datebc, cocli, nofrs) VALUES\n"
				+ "('2023-05-23', 1, 2),\n"
				+ "('2023-04-29', 2, 1);";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO livraison (datebl, nobc, nofac) VALUES\n"
				+ "('2023-05-23', 1, 1),\n"
				+ "('2023-05-15', 2, 2);";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO composer (nobl, refprod, qteliv) VALUES\n"
				+ "(1, 1, 5),\n"
				+ "(1, 2, 7),\n"
				+ "(1, 3, 5),\n"
				+ "(1, 9, 23),\n"
				+ "(2, 7, 3),\n"
				+ "(2, 8, 2);";
		ps = cnx.prepareStatement(str);
		ps.execute();
		
		str = "INSERT INTO concerner (nobc, refprod, qtecom, punit) VALUES\n"
				+ "(1, 1, 5, 200),\n"
				+ "(1, 2, 7, 9),\n"
				+ "(1, 3, 5, 4),\n"
				+ "(1, 9, 23, 2),\n"
				+ "(2, 7, 3, 120),\n"
				+ "(2, 8, 3, 999);";
		ps = cnx.prepareStatement(str);
		ps.execute();
	}

}
