package cuisine;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteDataSource;

public class Base {
	public ResultSet rs;
	public Connection connection;
	public Statement statement;

	public Base() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public ResultSet executeQry(String instruction) throws SQLException {
		return statement.executeQuery(instruction);
	}

	public void executeStmt(String instruction) throws SQLException {
		statement.executeUpdate(instruction);
	}


	public int open() {

		int ret = 0;
		try {

			// create a database connection
			SQLiteDataSource ds = new SQLiteDataSource();
			connection = DriverManager.getConnection("jdbc:sqlite:bdd");
			statement = connection.createStatement();
			// statement.setQueryTimeout(5);
		} catch (SQLException e) {
			ret = -1;
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
		return ret;
	}

	public void close() {
		try {
			if (connection != null) {
				statement.close();
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
public static void main(String[] args) throws SQLException {
	/*example*/
	Base m = new Base();
	m.open();
	 ResultSet r = m.executeQry("SELECT * FROM Recettes;");
	 while (r.next()) {
			System.out.print(r.getString("NumRecette")+"---");
			System.out.print(r.getString("TitreRecette")+"---");
			System.out.println(r.getString("TxtRecette")+"---");

		}
	 m.close();
}
}