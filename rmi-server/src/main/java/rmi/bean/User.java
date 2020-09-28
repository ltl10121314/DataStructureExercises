package rmi.bean;

import java.io.Serializable;

/**
 * @author liutianlong
 * @date 2020/9/29 0:07
 * @description 用户信息，用于远程调用传输，必须实现Serializable接口
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name : " + this.name + ", age : " + this.age;
    }
}