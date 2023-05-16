package Dao.JDBC;

import Dao.RoleDao;
import Domain.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Dao.H2JDBCUtils.getConnection;
import static Dao.H2JDBCUtils.printSQLException;

public class JdbcRoleDao implements RoleDao {
    private static final String INSERT_ROLES_SQL = "INSERT INTO Role  (id,name) VALUES "
            + " (?, ?);";
    private static final String SELECT_ROLE_BY_ID = "select id,name from Role where id =?";
    private static final String SELECT_ROLE_BY_NAME = "select id,name from Role where name =?";
    private static final String SELECT_ALL_ROLE = "select * from users";
    private static final String DELETE_ROLE_SQL = "delete from Role where id = ?;";
    private static final String UPDATE_ROLE_SQL = "update Role set id = ?, name =? where id = ?;";

    @Override
    public void create(Role role) {
//Log place INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROLES_SQL)) {
            preparedStatement.setString(1, role.getId().toString());
            preparedStatement.setString(2, role.getName());

            //Log place preparedStatement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void update(Role role) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE_SQL)) {
            preparedStatement.setString(1, role.getId().toString());
            preparedStatement.setString(2, role.getName());

            //Log place preparedStatement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(Role role) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROLE_SQL);) {
            statement.setLong(1, role.getId());
            if (statement.executeUpdate() > 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List findAll() {

        List<Role> roles = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                roles.add(new Role(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return roles;
    }

    @Override
    public Role findByID(Long id) {
        Role role = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID);) {
            preparedStatement.setInt(1, Math.toIntExact(id));
            //Log place preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                role = new Role(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        Role role = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_NAME);) {
            preparedStatement.setString(2, name);
            //Log place preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("id");
                role = new Role(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return role;
    }
}
