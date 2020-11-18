package dao;

import entity.ChatUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author ahao 2020-08-29
 */
public class ChatUserDao {
    /***.
     *@param chatUser:
     *@author ahao
     *@date 2020-08-29 18:35
     *@return {@link int}
     *添加用户
     */
    public int insertUser(ChatUser chatUser) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into chat_user values(?,?,?)";
        return qr.update(sql,null,chatUser.getNickname(),chatUser.getPwd());
    }

    /**
     * 根据nickname 查询用户
     * @param nickname
     * @return
     * @throws SQLException
     */
    public ChatUser findUser(String nickname) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from chat_user where nickname = ?";
        return qr.query(sql,new BeanHandler<>(ChatUser.class),nickname);
    }
    @Test
    public void test() throws SQLException {
        ChatUser chatUser = new ChatUser();
        chatUser.setNickname("ahao");
        chatUser.setPwd("123456");
        insertUser(chatUser);
        System.out.println(findUser("ahao"));
    }
}
