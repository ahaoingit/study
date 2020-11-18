package utils;

import domain.User;

/**
 * TODO
 *用来判断sql语句种执行user中的哪个set
 * @author ahao 2020-08-23
 */

public class UserSettingUtils {
    public static User setUser(User user , String attributes , String value) {
        if ("id".equals(attributes.toLowerCase())) {
            user.setId(Integer.parseInt(value));
        }

        if ("name".equals(attributes.toLowerCase())) {
            user.setName(value);
        }

        if ("age".equals(attributes.toLowerCase())) {
            user.setAge(Integer.parseInt(value));
        }
        return user;
    }

    /**
     * 检测此user是否需要改变
     * @param user
     * @param attributes
     * @param value
     * @return
     */
    public static Boolean checkUserChange(User user,String attributes,String value) {
        if ("id".equals(attributes.toLowerCase())) {
            return user.getId() == Integer.parseInt(value);
        }

        if ("name".equals(attributes.toLowerCase())) {
            return user.getName() == value;
        }

        if ("age".equals(attributes.toLowerCase())) {
            return user.getAge() == Integer.parseInt(value);
        }
        return false;
    }
}
