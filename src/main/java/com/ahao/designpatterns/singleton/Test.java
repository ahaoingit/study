package com.ahao.designpatterns.singleton;

import java.util.Map;

/**
 * @author ahao
 */
public class Test {
    @org.junit.Test
    public  void testForSingleton(){
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance==singleton);
    }
    @org.junit.Test
    public  void testForMap(){
        int i =0;
        Map<String, String> stringMap = SingletonForMap.getStringMap();
        stringMap.put( "a","ahao" );
        new Thread( ()->stringMap.put( "a","lil")).start();
        new Thread( ()->stringMap.put( "a","lili")).start();
        System.out.println(stringMap);
    }
}
