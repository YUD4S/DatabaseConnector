import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class encapsulates the logic for establishing a connection to a database.
 * It keeps track of the database URL, username, password, and loaded JDBC driver.
 */
public class DatabaseConnector {
    private String url;
    private String user;
    private String password;
    private String loadedDriver; // Variable to track the loaded driver

    /**
     * Constructs a DatabaseConnector with the specified details.
     *
     * @param url      the database URL
     * @param user     the database user
     * @param password the password of the user
     */
    public DatabaseConnector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.loadedDriver = "None"; // Initialize with "None"
    }

    /**
     * Attempts to establish a connection to the database.
     *
     * @return a Connection object or null if the connection could not be established
     */
    public Connection connect() {
        try {
            String driverClassName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverClassName);
            loadedDriver = driverClassName; // Update loaded driver
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully.");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns a string representation of this DatabaseConnector.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "DatabaseConnector{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + "[PROTECTED]" + '\'' +
                ", loadedDriver='" + loadedDriver + '\'' +
                '}';
    }
}
