package handle;

import Enity.Db;
import Enity.Table;
import Enity.User;
import exception.NoSuchDb;
import exception.NoSuchTb;
import client.Context;

import java.util.*;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public class SelectHandle {
    /**
     * 查询一个表的所有数据
     * @param tbName
     * @param dbName
     */
    public List selectAll(String dbName , String tbName) throws NoSuchDb, NoSuchTb {
        List obs = new ArrayList();
        Map<String, Db> map = Context.context.getMap();
        Db db = map.get(dbName);
        if (db == null) {
            throw new NoSuchDb("没有以此命名的数据库"+dbName);
        }else {
            Map<String, Table> tables = db.getTables();
            Table table = tables.get(tbName);
            if (table == null) {
                throw  new NoSuchTb("无此表:"+tbName);
            }else {
                 obs = table.getObs();
            }
        }
        return obs;
    }


//    public List select(String dbName , String tbName , String... param) {
//        List result = new ArrayList();
//
//    }




    public static void main(String[] args) throws NoSuchTb, NoSuchDb {
        SelectHandle selectHandle = new SelectHandle();
        Map<String, Db> map = Context.context.getMap();
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setName("ahao");
        users.add(user);

        Table<User,Integer> table = new Table();
        table.setObs(users);
        table.setId(user.getId());
        Db db = new Db();

        Map<String , Table> tableMap = new HashMap<>();
        tableMap.put("user",table);
        db.setTables(tableMap);

        map.put("userb",db);

        List list = selectHandle.selectAll("userb", "user");
        System.out.println(list);
    }

}
