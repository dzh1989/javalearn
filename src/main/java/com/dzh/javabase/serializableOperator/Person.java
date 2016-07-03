package com.dzh.javabase.serializableOperator;


import java.io.Serializable;
/**
 * Created by dongzihui on 16/7/3.
 */
public class Person implements  Serializable{
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
