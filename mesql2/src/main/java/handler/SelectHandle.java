package handler;

import utils.SqlParsingUtils;

/**
 * TODO
 *
 * @author 2020-08-21
 */
public class SelectHandle {

    /** 0 查询全部        1=param=value 按照条件查询  2 删除所有    3=param=value按条件删除         4=param1=param2=param3 插入
     * 5=param1=param2=""="" 更新全部     6=param1=param2=param3=param4更新部分
     * string数据格式
     * @param param
     * @return
     */
    public String select(String param) {
        String[] strings = SqlParsingUtils.trimSpaces(param);
        for (String s:strings) {
            if ("where".equals(s)) {
                return "1="+strings[strings.length-1];
            }
        }
        return "0";
    }
}
