package dao;

import entity.ChatGroup;
import entity.ChatGroupUser;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author ahao 2020-08-29
 */
public class ChatGroupUserDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    public int insertGU(ChatGroupUser chatGroupUser) throws SQLException {
        String sql = "insert into chat_group_user values(?,?,?)";
        return queryRunner.update(sql,null,chatGroupUser.getUid(),chatGroupUser.getGid());
    }

    @Test
    public void test() throws SQLException {
        ChatGroupUser chatGroupUser = new ChatGroupUser();
        chatGroupUser.setGuId(12);
        chatGroupUser.setUid(123);
        System.out.println(insertGU(chatGroupUser));
    }
}
