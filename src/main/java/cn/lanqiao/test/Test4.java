package cn.lanqiao.test;

import cn.lanqiao.entity.Customer;
import cn.lanqiao.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.Before;

import java.util.List;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/20 10:16
 * 1、查询对象
 * 查询表中所有数据，⾃动完成对象的封装，返回 List 集合。
 * HQL 进⾏查询，from 关键字后⾯不能写表名，必须写表对应的实体类名。
 */
public class Test4 {
    private SessionFactory sf;
    @Before
    public void  init(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sf= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }
    @org.junit.Test
    public void testc(){
//        进行持久化操作
        try( Session session = sf.openSession()) {
//            开启事务
            Transaction tx = session.beginTransaction();
            String hql = "from People";
            Query query = session.createQuery(hql);
            List<People> list = query.list();
            for(People people:list){
                System.out.println(people);
            }
//
//
//
////            提交事务
//            tx.commit();
            //关闭session
            session.close();
        }

    }
}
