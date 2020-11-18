package entity;

import java.io.Serializable;

/**
 * (ChatGroupUser)实体类
 *
 * @author makejava
 * @since 2020-08-29 00:22:06
 */
public class ChatGroupUser implements Serializable {
    private static final long serialVersionUID = 507615720534432138L;

    private Integer guId;

    private Integer uid;

    private Integer gid;


    public Integer getGuId() {
        return guId;
    }

    public void setGuId(Integer guId) {
        this.guId = guId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

}