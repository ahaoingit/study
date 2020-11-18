package utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.net.util.Base64;

/**
 * @author ahao
 */
public class SafetyUtils {

    private static final String key = "yWPWMZ0zhA37SBud";
    private static String charset = "utf-8";
    // 偏移量
    private static int offset = 16;
    private static String transformation = "AES/CBC/PKCS5Padding";
    private static String algorithm = "AES";
    /**
     * 加密
     *
     * @param content
     * @return
     */
    public static String encrypt(String content) {
        return encrypt(content, key);
    }

    /**
     * 解密
     *
     * @param content
     * @return
     */
    public static String decrypt(String content) {
        return decrypt(content, key);
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key 加密密码
     * @return
     */
    public static String encrypt(String content, String key) {
        //加密内容为空不处理
        if (null !=content) {
            try {
                SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
                IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, offset);
                Cipher cipher = Cipher.getInstance(transformation);
                byte[] byteContent = content.getBytes(charset);
                // 初始化
                cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
                byte[] result = cipher.doFinal(byteContent);
                // 加密
                return new Base64().encodeToString(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * AES（256）解密
     *
     * @param content 待解密内容
     * @param key 解密密钥
     * @return 解密之后
     * @throws Exception
     */
    public static String decrypt(String content, String key) {
        try {

            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, offset);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, skey, iv);// 初始化
            byte[] result = cipher.doFinal(new Base64().decode(content));
            return new String(result); // 解密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
