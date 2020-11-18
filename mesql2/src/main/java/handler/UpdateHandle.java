package handler;

import org.junit.Test;
import utils.SqlParsingUtils;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author 2020-08-21
 */
public class UpdateHandle {
    public String getParam(String sql) throws SQLException {
        String[] strings = SqlParsingUtils.trimSpaces(sql);
        for (String s:strings) {
            if ("where".equals(s)) {
                return "6="+strings[3]+"="+strings[strings.length-1];
            }
        }
        return "5="+strings[3];
    }

    @Test
    public void test() throws SQLException {
        System.out.println(getParam("update user set age=16"));
    }
}
