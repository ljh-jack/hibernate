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
import org.junit.Before;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/19 18:01
 */
public class Test {
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
            Customer customer = new Customer();
            customer.setName("ljh");
            //创建 Orders
            Orders orders = new Orders();
            orders.setName("订单2");
            //建⽴关联关系
//            将顾客对象加入到订单对象中
            orders.setCustomer(customer);
            //保存
            session.save(customer);
            session.save(orders);
//            提交事务
            tx.commit();
            //关闭session
            session.close();
        }

    }
}
