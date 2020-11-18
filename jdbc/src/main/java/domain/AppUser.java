package domain;

import Utils.RandomUtils;

import java.io.Serializable;
import java.util.Random;

/**
 * (AppUser)实体类
 *
 * @author makejava
 * @since 2020-08-22 12:36:28
 */
public class AppUser implements Serializable {
    private static final long serialVersionUID = 103352111667678256L;

    private Integer id;

    private String mobile;

    private String sex;

    private Integer age;

    private String pwd;

    private String nickname;


    public AppUser() {
        this.id = null;
        this.mobile= RandomUtils.getRandomPhone();
        this.sex = RandomUtils.getRandomGender();
        this.nickname = RandomUtils.getRandomName();
        this.age = new Random().nextInt(100);
        this.pwd = RandomUtils.getPwd();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}