package Utils;

import org.junit.Test;

import java.net.URLDecoder;
import java.util.Random;

/**
 * TODO
 *
 * @author ahao 2020-08-22
 */
public class RandomUtils {

    public static String getRandomPhone() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < 10;++i) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }

    public static String getRandomName() {
        StringBuilder sb = new StringBuilder();
        int begin = 0x4e00;//[0x4e00,0x9fa5]
        int end = 0x9fa5;
        for (int i = 0; i < 3;++i) {
            sb.append((char)(new Random().nextInt(end-begin) + begin+1));
        }
        return sb.toString();
    }

    public static String getRandomGender() {
        return new Random().nextInt(10) > 5 ? "男":"女";
    }

    public static String getPwd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 9 ; ++i) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
    @Test
    public void testUtils() {
        System.out.println((char)(0x9fa5));
    }
}
