package requetes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteDataSource;
import org.apache.commons.net.ftp.FTPClient;

public class Base {
	public ResultSet rs;
	public Connection connection;
	public Statement statement;

	public Base() throws IOException {
		/*FTPClient client = new FTPClient();
		client.connect("192.168.1.254", 21);
		client.login("freebox","0362232425");
		System.out.println(client.getRemoteAddress());
		System.out.println(client.changeWorkingDirectory("./Disque%20Dur/"));	
		
		String serverFile = "ftp://192.168.1.254/Disque%20dur/bdd";
		String localfile = "toto";
		
		URL url = new URL(serverFile);
		URLConnection con = url.openConnection();
		BufferedInputStream in = new BufferedInputStream(con.getInputStream());
		FileOutputStream out = new FileOutputStream(localfile);
		
		int i = 0;
		byte[] bytesIn = new byte[1024];
		while ((i = in.read(bytesIn)) >= 0)
		{
			out.write(bytesIn, 0, i);
		}
		out.close();
		in.close();
		*/
		/*// Download
		RandomAccessFile outfile2 = new RandomAccessFile("./toto", "rw");
		try {
			FileOutputStream fileStream = new FileOutputStream(outfile2.getFD());
			if (client.retrieveFile("./prout", fileStream)) {
				// Download OK
				System.out.println("C'est bon ?");
			} else {
				// Erreur
				System.out.println("C'est pas bon :'(");
			}
		} finally {
			outfile2.close();
		}*/
		
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public ResultSet executeQry(String instruction) throws SQLException {
		
		ResultSet r = statement.executeQuery(instruction);
		
		return r;
	}

	public void executeStmt(String instruction) throws SQLException {
		
		statement.executeUpdate(instruction);
		
	}


	public void open() {

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
public static void main(String[] args) throws SQLException, IOException {
	/*example*/
	Base m = new Base();
	m.open();
	ResultSet r = m.executeQry("SELECT * FROM Recettes where NumRecette <= 10;");
	 while (r.next()) {
			System.out.print(r.getString("NumRecette")+"---");
			System.out.print(r.getString("TitreRecette")+"---");
			System.out.println(r.getString("TxtRecette")+"---");

		}
	 m.close();
}
}