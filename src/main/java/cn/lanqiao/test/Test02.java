package cn.lanqiao.test;

import cn.lanqiao.entity.Account;
import cn.lanqiao.entity.Course;
import cn.lanqiao.entity.Customer;
import cn.lanqiao.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ljh
 * @version 1.0
 * @date 2022/5/19 19:01
 */
public class Test02 {
    private SessionFactory sf;
    @Before
    public void  init(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sf= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }
    @org.junit.Test
    public void testc(){
//        进行持久化操作
        try(Session session = sf.openSession()) {
//            开启事务
            Transaction tx = session.beginTransaction();
            Course course = new Course();
            course.setName("Java");
            Account account = new Account();
            account.setName("张三");
            Set<Course> courses = new HashSet<>();
            courses.add(course);
            account.setCourses(courses);
            session.save(course);
            session.save(account);
//            提交事务
            tx.commit();
            //关闭session
            session.close();
        }

    }
}
