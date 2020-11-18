package domain;

import lombok.Data;

import java.io.*;

/**
 * TODO
 *
 * @author ahao 2020-08-20
 */
@Data
public class DbUser implements Externalizable {
    String userName;
    String password;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(userName);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.userName = (String) in.readObject();
        this.password = (String) in.readObject();
    }
}
