package Utils;

import domain.AppUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TODO
 *
 * @author ahao 2020-08-22
 */
public class InsertValue {
    public static void main(String[] args)  {
        for (int i = 0;i<10;++i) {
            insertThread();
        }

    }

    public static void insertThread() {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = JDBCUtils.getConnection();
                String sql = "insert into app_user values(?,?,?,?,?,?)";
                statement = connection.prepareStatement(sql);
                for (int i = 0 ; i < 1_000_00 ; ++i) {
                    AppUser user = new AppUser();
                    statement.setString(1,null);
                    statement.setString(2,user.getMobile());
                    statement.setString(3,user.getSex());
                    statement.setInt(4,  user.getAge());
                    statement.setString(5,user.getPwd());
                    statement.setString(6,user.getNickname());
                    statement.execute();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JDBCUtils.close(connection,statement,null);
            }
        }).start();
    }
}
