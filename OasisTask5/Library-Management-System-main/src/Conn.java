import java.sql.*;

public class Conn {

    public static Connection getCon() {
        Connection con = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "1522");
            
           
            if (con != null) {
                System.out.println("Connection successful: " + con);
            } else {
                System.out.println("Connection failed.");
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred while connecting to the database.");
            e.printStackTrace();
        }
        
        
        return con;
    }

    public static void main(String[] args) {
        // Example of how to use the getCon() method.
        Connection connection = getCon();
        
        // Always close the connection when you're done with it.
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing the connection.");
                e.printStackTrace();
            }
        }
    }
}