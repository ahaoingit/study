package handler;

import org.junit.Test;
import utils.SqlParsingUtils;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author 2020-08-21
 */
public class InsertHandel {
    public String getParam(String sql) throws SQLException {
        String[] strings = SqlParsingUtils.trimSpaces(sql);
        if (strings[strings.length-1].startsWith("values")) {
            String substring = strings[strings.length - 1].substring(7, strings[strings.length-1].length()-1);
            String replace = substring.replace(',', '=');
            return "4="+replace;
        }else {
            throw new SQLException("sql 语句格式错误");
        }
    }

    @Test
    public void testY() throws SQLException {
        getParam("insert into user values(85,'test5',22)");
    }
}
