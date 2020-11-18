package entity;

import java.io.Serializable;

/**
 * (ChatUser)实体类
 *
 * @author makejava
 * @since 2020-08-29 00:22:06
 */
public class ChatUser implements Serializable {
    private static final long serialVersionUID = -14606854043562502L;

    private Integer uid;

    private String nickname;

    private String pwd;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}