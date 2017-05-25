package com.techeffic.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Mybatis 3+的缓存必须要实现序列化接口
 * SpringMVC自动转化为xml格式数据需要实体类配置xml对应注解
 */
@XmlRootElement(name = "user")
public class User implements Serializable{

    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String remark;

    public Integer getId() {
        return id;
    }
    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    @XmlElement//此注解不能使用在字段上 否则会对set/get方法都起作用 导致springMVC解析/生成xml时报【com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException: 1 counts of IllegalAnnotationExceptions  **类的两个属性具有相同名称**】的异常
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }
    @XmlElement
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }
    @XmlElement
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }
    @XmlElement
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}