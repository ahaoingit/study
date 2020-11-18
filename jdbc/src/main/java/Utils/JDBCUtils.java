package Utils;

import java.sql.*;

/**
 * TODO
 *
 * @author ahao 2020-08-22
 */
public class JDBCUtils {
    private static String mysqlDriver = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "ahao123";
    private static String url = "jdbc:mysql://localhost:3306/study";
    static {
        try {
            Class.forName(mysqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }

    public static void close(Connection conn, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }




}
