package Dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.H2JDBCUtils;
import Dao.UserDao;
import Domain.entity.User;


public class JdbcUserDao implements UserDao {
    private H2JDBCUtils h2JDBCUtils;
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (ID,LOGIN,PASSWORD,EMAIL,FIRST_NAME,LAST_NAME) VALUES "
            + " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select ID,LOGIN,PASSWORD,EMAIL,FIRST_NAME,LAST_NAME from users where ID =?";
    private static final String SELECT_USER_BY_LOGIN = "select ID,LOGIN,PASSWORD,EMAIL,FIRST_NAME,LAST_NAME from users where LOGIN =?";
    private static final String SELECT_USER_BY_EMAIL = "select ID,LOGIN,PASSWORD,EMAIL,FIRST_NAME,LAST_NAME from users where EMAIL =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where ID = ?;";
    private static final String UPDATE_USERS_SQL = "update users set LOGIN = ?,PASSWORD= ?,EMAIL= ? ,FIRST_NAME= ?,LAST_NAME= ? where ID = ?;";

    public JdbcUserDao() {
    }

    public JdbcUserDao(H2JDBCUtils h2JDBCUtils) {
        this.h2JDBCUtils = h2JDBCUtils;

    }

    @Override
    public void create(User user) {
        //Log place INSERT_USERS_SQL);
        try (Connection connection = h2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getId().toString());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getFirstName());
            preparedStatement.setString(6, user.getLastName());
            //Log place preparedStatement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = h2JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setLong(6, user.getId());
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeUpdate();
//            if (statement.executeUpdate() <= 0) {
//                throw new SQLException();
//            }
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void remove(User user) {
        try (Connection connection = h2JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setLong(1, user.getId());
            if (statement.executeUpdate() > 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
    }


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = h2JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("ID");
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                users.add(new User(id, login, password, email, firstName, lastName));
            }
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
        return users;
    }

    @Override
    public User findByID(Long id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = h2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, Math.toIntExact(id));
            //Log place preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                user = new User(id, login, password, email, firstName, lastName);
            }
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = h2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);) {
            preparedStatement.setString(1, login);
            System.out.println(preparedStatement);
            //Log place preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("ID");
                 login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                user = new User(id, login, password, email, firstName, lastName);
            }
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = h2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
            preparedStatement.setString(1, email);
            //Log place preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("ID");
                String login = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                user = new User(id, login, password, email, firstName, lastName);
            }
        } catch (SQLException e) {
            h2JDBCUtils.printSQLException(e);
        }
        return user;
    }

//    private static String jdbcURL = "jdbc:h2:/home/grabovetskyi/Downloads/x710/Mask2/17_sql_jdbc/src/main/rescource/db/Users";
//    private static String jdbcUsername = "Roma";
//    private static String jdbcPassword = "19960422";


}
