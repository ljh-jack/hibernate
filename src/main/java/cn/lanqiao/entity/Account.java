package cn.lanqiao.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/19 18:28
 */
@Data
public class Account {
    private Integer id;
    private String name;
    private Set<Course> courses;
}
