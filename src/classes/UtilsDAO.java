package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilsDAO {

	private static Connection c;
	
	public static void setConnection()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection()
	{
		if(c != null)
		{
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String selectData()
	{
		StringBuilder retval = new StringBuilder();
		String sql = "SELECT * FROM CARS";
		try {
			Statement stmt = c.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			String separator = System.getProperty("line.separator");
			while(rs.next())
			{
				retval.append(
						String.format("ID: %d | PRODUCER: %s | WEIGHT: %.2f | PRICE: %.2f" + separator, rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4))
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retval.toString();
	}
	
	/* Just to fake the data... */
	public static void insertData()
	{
		String sqlDropTable = "drop table if exists CARS";
		String sqlCreateTable = "create table CARS " +
				"(ID INT PRIMARY KEY NOT NULL," +
				"PRODUCER TEXT NOT NULL, WEIGHT REAL, PRICE REAL)";
		String sqlInsert = "INSERT INTO CARS (ID, PRODUCER, WEIGHT, PRICE) " +
						   "VALUES (1, 'BMW', 1700, 24000)";
		Statement stmt;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(sqlDropTable);
			stmt.executeUpdate(sqlCreateTable);
			stmt.executeUpdate(sqlInsert);
			stmt.close();
			c.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
