package client;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public class SqlParsing {
    /**
     * sql 去除空格 取出关键参数
     * @param sql
     * @return
     */
    public static String[] trimSpaces(String sql) {
        sql = sql.trim();
        return sql.split("\\s+");
    }

    /**
     * 数据分发处理
     */
    public static void distribution(String sql) {
        String[] strings = trimSpaces(sql);
        if ("create".equals(strings[0]) && "database".equals(strings[1])){

        }
    }

}
