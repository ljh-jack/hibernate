package cn.lanqiao.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/19 18:29
 * 学生和课程就是多对多的情况
 */
@Data
public class Course {
    private Integer id;
    private String name;
    private Set<Account> accounts;
}
