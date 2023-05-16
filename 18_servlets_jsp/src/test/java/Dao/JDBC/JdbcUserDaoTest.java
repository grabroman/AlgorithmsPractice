package Dao.JDBC;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import Dao.H2JDBCUtils;
import Dao.UserDao;
import Domain.entity.User;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.hamcrest.MatcherAssert;
import org.junit.After;


class JdbcUserDaoTest {

    private static String JDBC_URL = "jdbc:h2:/home/grabovetskyi/Downloads/x710/Mask2/17_sql_jdbc/src/main/rescource/db/Users";
    private static String USER = "Roma";
    private static String PASSWORD = "19960422";


//    private static final String JDBC_URL = "jdbc:h2:mem:test";
//    private static final String USER = "sa";
//    private static final String PASSWORD = "";

    private Connection connection;

//    @BeforeClass
//    public static void createSchema() throws Exception {
//        RunScript.execute(JDBC_URL, USER, PASSWORD, "db.sql", StandardCharsets.UTF_8, false);
//    }
//    @Before
//    public void insertRows() throws Exception {
//        connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
//        cleanUserTable();
//        insert(new User(3524L,"ball12","13236654","danvega@gmail.com","Dan", "Vega"));
//        insert(new User(563L,"master","68496","djenair@gmail.com","Jen", "Green"));
//        insert(new User(453L,"Puma","6849686g","bella@yandex.com","Bella", "Vega"));
//    }
    @After
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
    }
    private DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @org.junit.jupiter.api.Test
    void create() {
        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser= new User(899L,"master12","88496","djenair@gmail.com","Jeny", "Greenie");
        userDao.create(myuser);
        myuser=userDao.findByID(899L);
        MatcherAssert.assertThat(myuser.getFirstName(), is("Jeny"));
        MatcherAssert.assertThat(myuser.getLastName(), is("Greenie"));
        MatcherAssert.assertThat(myuser.getLogin(), is("master12"));
        userDao.remove(myuser);

    }

    @org.junit.jupiter.api.Test
    void update() {
        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser= new User(563L,"'12master12'","88496","djenair@gmail.com","Jennnnny", "Greennnnness");
        userDao.update(myuser);
        myuser=userDao.findByID(563L);
        System.out.println(myuser);
         myuser= new User(563L,"'master12'","88496","djenair@gmail.com","Jenny", "Greenness");
        userDao.update(myuser);

    }

    @org.junit.jupiter.api.Test
    void remove() {
        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser= new User(563L,"master","68496","djenair@gmail.com","Jen", "Green");
        userDao.remove(myuser);
         myuser=userDao.findByLogin("iDoNotExist");
        MatcherAssert.assertThat(myuser, is(nullValue()));
    }

    @org.junit.jupiter.api.Test
    void findAll() {
    }

    @org.junit.jupiter.api.Test
    void findsAndReadsExistingPersonByID() {

        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser=userDao.findByID(6549899L);
        System.out.println(myuser);

        MatcherAssert.assertThat(myuser.getFirstName(), is("Jeny"));
        MatcherAssert.assertThat(myuser.getLastName(), is("Greenie"));
        MatcherAssert.assertThat(myuser.getLogin(), is("master12"));
    }
    @org.junit.jupiter.api.Test
    void returnsNullWhenPersonCannotBeFoundByFirstLogin() {
        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser=userDao.findByLogin("iDoNotExist");
        MatcherAssert.assertThat(myuser, is(nullValue()));
    }
    @org.junit.jupiter.api.Test
    void findsAndReadsExistingPersonByLogin() {
        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser=userDao.findByLogin("master12");
        System.out.println(myuser);
        MatcherAssert.assertThat(myuser.getFirstName(), is("Jeny"));
        MatcherAssert.assertThat(myuser.getLastName(), is("Greenie"));
        MatcherAssert.assertThat(myuser.getLogin(), is("master12"));
    }
    @org.junit.jupiter.api.Test
    void findsAndReadsExistingPersonByEmail() {
        UserDao userDao= new JdbcUserDao(new H2JDBCUtils(JDBC_URL,USER,PASSWORD));
        User myuser=userDao.findByEmail("djenair@gmail.com");
        System.out.println(myuser);
        MatcherAssert.assertThat(myuser.getFirstName(), is("Jeny"));
        MatcherAssert.assertThat(myuser.getLastName(), is("Greenie"));
        MatcherAssert.assertThat(myuser.getLogin(), is("master12"));
    }
    private void insert(User person) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO USERS (id,login,password, email, first_name,last_name) VALUES (?, ?, ?,?, ?, ?)");
            statement.setString(1, person.getId().toString());
            statement.setString(2, person.getLogin());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getFirstName());
            statement.setString(6, person.getLastName());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }
    private void cleanUserTable() throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM USERS");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }
}