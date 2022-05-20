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
 * 2、分⻚查询
 * HQL 分⻚查询可以通过调⽤ query 的⽅法来完成。
 * 1、setFirstResult() 设置起始下标
 * 2、setMaxResults() 设置截取⻓度
 */
public class Test5 {
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
            query.setFirstResult(1);
            query.setMaxResults(3);
            List<People> list = query.list();
            for(People people:list){
                System.out.println(people);
            }

            session.close();
        }

    }
}
