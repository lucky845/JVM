package com.atguigu.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author lucky845
 * @date 2022年03月27日 14:12
 */
@ToString
@Data
public class Person {

    private String name;
    private int age;
    private String sex;
    private byte[] images;

}
