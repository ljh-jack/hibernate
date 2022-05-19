package cn.lanqiao.entity;

import lombok.Data;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/19 17:31
 *
 * 数据库中⼀的⼀⽅是主表，多的⼀⽅时候从表，通过主外键关系来维护
 */

@Data
public class Orders {
    private Integer id;
    private String name;
    private Customer customer;

}
