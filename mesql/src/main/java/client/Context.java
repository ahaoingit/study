package client;

import Enity.Db;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public enum  Context {
    /**
     * 全局存储所有的database
     */
    context;
    private static final Map<String, Db> map = new HashMap<>();
    public  Map<String, Db> getMap() {
        return map;
    }
}
