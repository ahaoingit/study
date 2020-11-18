package entity;

import java.io.Serializable;

/**
 * (ChatGroup)实体类
 *
 * @author makejava
 * @since 2020-08-29 00:22:04
 */
public class ChatGroup implements Serializable {
    private static final long serialVersionUID = 398499464560924872L;

    private Integer gid;
    private String gname;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

}