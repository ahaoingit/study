package utils;

import domain.User;

import java.io.*;
import java.nio.file.Path;

/**
 * TODO
 *
 * @author ahao 2020-08-20
 */
public class SerializationUtil {
    public static void write(String path, Object obj) throws IOException {
        File file = new File(path);
        ObjectOutputStream objectOutputStream = null;
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(obj);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            objectOutputStream.close();
        }
    }

    public static Object readObj(String path) throws IOException {
        ObjectInputStream objectInputStream = null;
        Object o = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            o = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            objectInputStream.close();
        }
        return o;
    }
}
