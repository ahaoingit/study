package com.ahao.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ahao
 */
public class SingletonForMap {
    private volatile static Map<String , String> stringMap = new HashMap<>(  );
    private volatile static SingletonForMap obj;

    public  static SingletonForMap getObj() {
        if (obj == null){
            synchronized (SingletonForMap.class){
                if (obj == null){
                    obj = new SingletonForMap();
                }
            }
        }
        return obj;
    }

    public static Map<String, String> getStringMap() {
        return stringMap;
    }
}
