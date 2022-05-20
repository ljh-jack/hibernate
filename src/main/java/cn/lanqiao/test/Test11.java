package cn.lanqiao.test;

import cn.lanqiao.entity.Customer;
import cn.lanqiao.entity.Orders;
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
 * @date 2022/5/20 10:24
 */
public class Test11 {
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
            String hql1 = "from Customer where name = :name";
            Query query1 = session.createQuery(hql1);
            query1.setString("name","张三");
            Customer customer = (Customer) query1.uniqueResult();
            String hql2 = "from Orders where customer = :customer";
            Query query2 = session.createQuery(hql2);
            query2.setEntity("customer",customer);
            List<Orders> list = query2.list();
            for(Orders orders:list){
                System.out.println(orders);
            }
            session.close();
        }

    }
}
