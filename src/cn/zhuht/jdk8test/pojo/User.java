package cn.zhuht.jdk8test.pojo;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * author zhuhaitao
 * date 2019/3/26 18:05
 **/
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private Integer age;
    private Double weight;

    public User(String name, Integer age, Double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
