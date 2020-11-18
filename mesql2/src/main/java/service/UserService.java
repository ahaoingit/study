package service;

import dao.UserDao;
import domain.User;

import java.io.IOException;

/**
 * TODO
 *
 * @author ahao 2020-08-21
 */
public class UserService {
    public UserDao userDao = new UserDao();
    public Object getResult(String m) throws IOException {
        System.out.println(m);
        if ('0'==(m.charAt(0))) {
            return userDao.findAll();
        }
        if ('1'==(m.charAt(0))) {
            String[] split = m.split("=");
            return userDao.findByParam(split[1],split[2]);
        }
        if ('2' == m.charAt(0)) {
            String[] split = m.split("=");
            return userDao.deleteAll();
        }
        if ('3' == m.charAt(0)) {
            String[] split = m.split("=");
            return userDao.deleteByParam(split[1],split[2]);
        }
        if ('4' ==m.charAt(0)) {
            String[] split = m.split("=");
            return userDao.insert(Integer.parseInt(split[1]),split[2],Integer.parseInt(split[3]));
        }
        if ('5'==m.charAt(0)) {
            String[] split = m.split("=");
            System.out.println(split);
            return userDao.update(split[1],split[2],"","");
        }
        if ('6'==m.charAt(0)) {
            String[] split = m.split("=");
            return userDao.update(split[1],split[2],split[3],split[4]);
        }
        return "sql语句不合法";
    }
}
