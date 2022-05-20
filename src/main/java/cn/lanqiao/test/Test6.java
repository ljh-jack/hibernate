package cn.lanqiao.test;

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
 * @date 2022/5/20 10:19
 * 3、where 条件查询
 * HQL 直接追加 where 关键字作为查询条件，与 SQL 没有区别。
 */
public class Test6 {
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
            String hql = "from People where id = 6";
            Query query = session.createQuery(hql);
            People people = (People) query.list().get(0);
            System.out.println(people);

            session.close();
        }

    }
}
