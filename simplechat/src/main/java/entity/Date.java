package entity;

import lombok.Data;

import java.nio.IntBuffer;

/**
 * TODO
 *
 * @author ahao 2020-08-30
 */
@Data
public class Date {
    public static final Integer GROUPMSG=0;
    public static final Integer PRIVATEMSG=1;
    private Integer type;
    private String fromUser;
    private String toUser;
    private String msg;
}
