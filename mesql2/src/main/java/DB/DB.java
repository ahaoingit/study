package DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-08-20
 */
public enum  DB {
    /**
     * 单例初始化db
     */
    db;
    private static final Map<String,Map<String, ArrayList<Object>>> dbMap= new HashMap();
    public Map getMapDb() {
        return dbMap;
    }
}
