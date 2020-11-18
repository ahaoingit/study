package dao;

import DB.DB;
import domain.User;
import org.junit.Test;
import utils.SerializationUtil;
import utils.UserSettingUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-08-21
 */
public class UserDao {
    String path = "D:\\studyworkspace\\mesql2\\arr.bin";

    public List<User> findAll() throws IOException {
        Map mapDb = DB.db.getMapDb();
        Map<String, ArrayList<Object>> user = (Map<String, ArrayList<Object>>) mapDb.get(path);
        ArrayList<User> userTb = (ArrayList<User>) SerializationUtil.readObj(path);
        return userTb;
    }

    public List<User> findByParam(String attributes, String param) throws IOException {
        List<User> all = findAll();
        List<User> result = new ArrayList<>();
        for (User user : all) {
            if ("id".equals(attributes.toLowerCase())) {
                if (Integer.toString(user.getId()).equals(param)) {
                    result.add(user);
                }
            }

            if ("name".equals(attributes.toLowerCase())) {
                if (user.getName().equals(param)) {
                    result.add(user);
                }
            }

            if ("age".equals(attributes.toLowerCase())) {
                if (Integer.toString(user.getAge()).equals(param)) {
                    result.add(user);
                }
            }
        }

        return result;
    }

    public Integer deleteByParam(String attributes, String param) throws IOException {
        //所有数据
        List<User> all = findAll();
        //存储所有存留下的数据
        List<User> save = new ArrayList<>();
        for (User user : all) {
            if ("id".equals(attributes.toLowerCase())) {
                if (!Integer.toString(user.getId()).equals(param)) {
                    save.add(user);
                }
            }

            if ("name".equals(attributes.toLowerCase())) {
                if (!user.getName().equals(param)) {
                    save.add(user);
                }
            }

            if ("age".equals(attributes.toLowerCase())) {
                if (!Integer.toString(user.getAge()).equals(param)) {
                    save.add(user);
                }
            }
        }
        SerializationUtil.write(path, save);
        System.out.println(all.size() + "::" +save.size());
        return all.size() - save.size();
    }

    public Integer deleteAll() throws IOException {
        List<User> all = findAll();
        SerializationUtil.write(path, new ArrayList<User>());
        return all.size();
    }

    /**
     * @return
     */
    public int insert(int id, String name, int age) throws IOException {
        List<User> all = findAll();
        int preSize = all.size();
        all.add(new User(id, name, age));
        SerializationUtil.write(path, all);
        return all.size() - preSize;
    }

    /***.
     *@param setName: set的列
     * @param setValue: 值
     * @param paramName: 这个是where的条件
     * @param paramValue: 条件值
     *@author ahao
     *@date 2020-08-23 21:50
     *@return {@link int}
     *
     */
    public int update(String setName, String setValue, String paramName, String paramValue) throws IOException {
        List<User> all = findAll();
        int changeNum = 0;
        if ("".equals(paramName)) {
            for (int i = 0; i < all.size(); i++) {
                User user = all.get(i);
                if ("id".equals(setName.toLowerCase())) {
                    user.setId(Integer.parseInt(setValue));
                    all.set(i, user);
                    changeNum++;
                    continue;
                }

                if ("name".equals(setName.toLowerCase())) {
                    user.setName(setValue);
                    all.set(i, user);
                    changeNum++;
                    continue;
                }

                if ("age".equals(setName.toLowerCase())) {
                    user.setAge(Integer.parseInt(setValue));
                    all.set(i, user);
                    changeNum++;
                }
            }
        }else {
            for (int i = 0; i < all.size(); ++i) {
                User user = all.get(i);
                //判断where的条件
                if ("id".equals(paramName.toLowerCase())) {
                    if (user.getId() == Integer.parseInt(paramValue)) {
                        if (!UserSettingUtils.checkUserChange(user,setName,setValue)) {
                            all.set(i, UserSettingUtils.setUser(user, setName, setValue));

                            changeNum++;
                        }
                    }
                }

                if ("name".equals(paramName.toLowerCase())) {
                    if (user.getName().equals( paramValue)) {
                        //判断返回值是否加一
                        if (!UserSettingUtils.checkUserChange(user,setName,setValue)){
                            all.set(i,UserSettingUtils.setUser(user,setName,setValue));
                            changeNum++;
                        }

                    }
                }

                if ("age".equals(paramName.toLowerCase())) {
                    if (user.getAge() == Integer.parseInt(paramValue)) {
                        if (!UserSettingUtils.checkUserChange(user,setName,setValue)) {
                            all.set(i, UserSettingUtils.setUser(user, setName, setValue));
                            changeNum++;
                        }
                    }
                }
            }
        }
        SerializationUtil.write(path, all);
        return changeNum;
    }


    @Test
    public void findAllTest() throws IOException {
//        System.out.println(findAll());
//        System.out.println(update("id","27","age","66"));
//        System.out.println(findAll());
//        insert(55,"test1",66);
//        insert(55,"test2",66);
//        insert(55,"test3",66);
//        insert(55,"test4",66);
//        insert(55,"test5",66);
//        insert(55,"test6",66);
//        insert(55,"test7",66);
        System.out.println(findAll());
        Integer integer = deleteByParam("name", "test2");
        System.out.println(integer);
        System.out.println(findAll());
    }
}
