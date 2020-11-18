import domain.DbUser;
import domain.User;
import org.junit.Test;
import utils.Md5Utils;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-08-20
 */
public class JunitTest {
    @Test
    public void Md5Test() throws IOException {
        System.out.println(Md5Utils.toMD5("ahao"));
        DbUser dbUser = new DbUser();
        dbUser.setUserName("ahao");
        dbUser.setPassword(Md5Utils.toMD5("123456"));
        SerializationUtil.write("DbUser.txt",dbUser);
        DbUser o = (DbUser)SerializationUtil.readObj("DbUser.txt");
        System.out.println(o);

        ArrayList<User> arrayList = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        user.setName("ahao");
        user.setId(6);
        User user2 = new User();
        user2.setId(5);
        user2.setAge(15);
        user2.setName("aho");

        arrayList.add(user);
        arrayList.add(user2);

        SerializationUtil.write("arr.bin",arrayList);
        Object o1 = SerializationUtil.readObj("arr.bin");
        System.out.println(o1);
    }
}
