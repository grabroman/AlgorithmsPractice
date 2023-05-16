package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2CreateExample {
    private static final String createTableSQL = "CREATE TABLE USERS (" +
            "                               id INT AUTO_INCREMENT  PRIMARY KEY," +
            "                               login VARCHAR(250) NOT NULL," +
            "                               password VARCHAR(250) NOT NULL," +
            "                               email VARCHAR(250) DEFAULT NULL," +
            "                               first_name VARCHAR(250) NOT NULL," +
            "                               last_name VARCHAR(250) NOT NULL" +
            ");";
    private static final String droptable = "DROP TABLE IF EXISTS USERS;";
    private static final String insertTableSQL = "INSERT INTO USERS (id,login,password,email,first_name, last_name) VALUES" +
            "                                                             (3524,'ball12','13236654','danvega@gmail.com','Dan', 'Vega')," +
            "                                                             (563,'master','68496','jenair@gmail.com','Jen', 'Vega')," +
            "                                                             (453,'Puma','6849686g','bella@yandex.com','Bella', 'Vega');";

    public static void main(String[] argv) throws SQLException {
        H2CreateExample createTableExample = new H2CreateExample();
        createTableExample.createTable();
//        createTableExample.insertTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement()) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    public void insertTable() throws SQLException {

        System.out.println(insertTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(insertTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}
