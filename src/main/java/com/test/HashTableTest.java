package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

/**
 * TODO
 *
 * @author ahao 2020-09-14
 */
public class HashTableTest {
    private Hashtable<String,String> hashtable = new Hashtable<>();
    {
        hashtable.put("1","a");
        hashtable.put("12","a2");
        hashtable.put("13","a0");
    }

    @Test
    public void forEach() {
        List<?> list = new ArrayList<>();
    }
}
