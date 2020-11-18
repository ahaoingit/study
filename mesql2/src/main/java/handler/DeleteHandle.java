package handler;

import utils.SqlParsingUtils;

/**
 * TODO
 *
 * @author 2020-08-21
 */
public class DeleteHandle {
    public String getParam(String sql) {
        String[] strings = SqlParsingUtils.trimSpaces(sql);
        for (String s:strings) {
            if ("where".equals(s)) {
                return "2="+strings[strings.length-1];
            }
        }
        return "2";
    }
}
