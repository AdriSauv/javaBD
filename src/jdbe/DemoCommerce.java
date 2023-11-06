package jdbe;

import java.sql.*;
import java.util.*;

public class DemoCommerce {
	public static void main(String[] a) throws SQLException {
		CreerConnection db = new CreerConnection();
		Connection cnx = null;
		cnx = db.myCnx();
		Commerce c = new Commerce(cnx);
		
		
//		c.dropTables();
//		c.creerTable();
//		c.insererData();
		
		
		
	}
}
