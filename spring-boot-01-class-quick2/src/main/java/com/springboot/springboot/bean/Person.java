package com.springboot.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties: 告诉Spring Boot将奔雷中的所有属性和配置文件中相关的配置进行绑定
 *      prefix = "person":配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能用容器提供的@ConfiguratioonProperties功能
 */
//读取指定的properties文件
//@PropertySource(value = {"classpath:person.properties"})
@Component
//下面将@ConfigurationProperties注释，改用底层Value
@ConfigurationProperties(prefix = "person") //将此注释，用@PropertySource传入指定文件
//@Validated //启动校验，和下面的@Email联用
public class Person {

    /**
     * <bean class="Person">
     *  <property name="LastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"><property/>
     * <bean/>
     */
//    @Value("${person.last-name}")
//    @Email //用于检验是否为Email值
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("${person.boss}")
    private Boolean boss;
//    @Value("${person.birth}")
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
