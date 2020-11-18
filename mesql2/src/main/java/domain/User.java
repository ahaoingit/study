package domain;

import lombok.Data;
import utils.SerializationUtil;

import java.io.*;
import java.net.Socket;

/**
 * TODO
 *
 * @author ahao 2020-08-20
 */
@Data
public class User implements Externalizable {
    private static final long serialVersionUID = 42L;
    int id ;
    String name;
    int age;
    public User() {}
    public User(int id,String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        this.name =(String) in.readObject();
        this.age = in.readInt();
    }
}
