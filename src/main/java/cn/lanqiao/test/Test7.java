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
 * @date 2022/5/20 10:21
 * 4、模糊查询
 * 查询名称包含 “三” 的所有记录
 */
public class Test7 {
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
            String hql = "from People where name like '%三%'";
            Query query = session.createQuery(hql);
            List<People> list = query.list();
            for(People people:list){
                System.out.println(people);
            }
            session.close();
        }

    }
}
