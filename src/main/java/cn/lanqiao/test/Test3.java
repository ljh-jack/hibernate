package cn.lanqiao.test;

import cn.lanqiao.entity.Customer;
import cn.lanqiao.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/20 9:44
 */
public class Test3 {
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
//            创建顾客
            Customer customer = session.get(Customer.class,1);
            System.out.println(customer.getOrders().size());
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
