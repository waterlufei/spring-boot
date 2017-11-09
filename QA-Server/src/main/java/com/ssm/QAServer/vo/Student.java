package com.ssm.QAServer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xiabin on 2017/5/27.
 */
@ApiModel(value = "Student",description = "学生信息描述")
public class Student {
    @ApiModelProperty("学号")
    public int id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private int age;

    @ApiModelProperty("性别")
    private String address;

    @ApiModelProperty("班级")
    private String cls;

    @ApiModelProperty("家庭住址")
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
