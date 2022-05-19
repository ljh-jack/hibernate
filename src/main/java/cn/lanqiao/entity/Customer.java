package cn.lanqiao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/19 17:31
 * 顾客和订单是一对多的情况
 * 数据库中⼀的⼀⽅是主表，多的⼀⽅时候从表，通过主外键关系来维护
 */
@Data
//@Entity
//@Table(name="customer")
public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;
//    @Column(name = "name")
    private String name;
    private Set<Orders> orders;
}
