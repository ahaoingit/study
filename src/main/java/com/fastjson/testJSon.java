package com.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * TODO
 *
 * @author ahao 2020-08-28
 */
public class testJSon {
    @Test
    public void objToJson() {
        User user = new User();
        user.setAge(12);
        user.setName("ahao");
        String json = JSON.toJSON(user).toString();
        User user1 = JSON.parseObject(json, User.class);
        System.out.println(json);
        System.out.println(user1);
    }
}
