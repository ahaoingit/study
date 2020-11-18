package dao;

import entity.ChatGroup;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;

/**
 * TODO
 *对于群组操作只有 增查
 * @author ahao 2020-08-29
 */
public class ChatGroupDao {
    private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    public ChatGroup findGroup(String gname) throws SQLException {
        String sql = "select * from chat_group where gname = ?";
        ChatGroup group = queryRunner.query(sql, new BeanHandler<ChatGroup>(ChatGroup.class), gname);
        return group;
    }

    public int insertGroup(ChatGroup chatGroup) throws SQLException {
        String sql = "insert into chat_group values(?,?)";
        int update = queryRunner.update(sql, null,chatGroup.getGname());
        return update;
    }
    @Test
    public void test() throws SQLException {
        ChatGroup group = new ChatGroup();
        group.setGname("ahaoGroup");
        //insertGroup(group);
        String ahaoGroup = findGroup("ahaoGroup").getGname();
        System.out.println(ahaoGroup);
    }
}
