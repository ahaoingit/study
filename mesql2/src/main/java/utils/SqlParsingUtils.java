package utils;

import exception.SqlIllegalException;
import handler.DeleteHandle;
import handler.InsertHandel;
import handler.SelectHandle;
import handler.UpdateHandle;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public class SqlParsingUtils {
    /**
     * sql 去除空格 取出关键参数
     * @param sql
     * @return
     */
    public static String[] trimSpaces(String sql) {
        sql = sql.toLowerCase();
        sql = sql.trim();
        return sql.split("\\s+");
    }

    /**
     * 数据分发处理
     */
    public static String getParam(String sql) throws SqlIllegalException, SQLException {
        String[] strings = trimSpaces(sql);
        if ("select".equals(strings[0])) {
           return new SelectHandle().select(sql);
        }else if ("delete".equals(strings[0])) {
            return new DeleteHandle().getParam(sql);
        }else if ("update".equals(strings[0])) {
            return new UpdateHandle().getParam(sql);
        }else if ("insert".equals(strings[0])) {
            return new InsertHandel().getParam(sql);
        }else {
            throw new SqlIllegalException("Illegal sql");
        }
    }
}
