package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.UserEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;


import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void delete() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");

        UserDAO dao=(UserDAO)ac.getBean("userDAO");
        dao.delete("zrh");

    }

    @Test
    public void delete1() {
    }

    @Test
    public void findUserByUsername() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void save() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        UserEntity c =new UserEntity();
        c.setUsername("zrh");
        c.setPassword("zyh12138");
        c.setPermission(1);
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
     //   dao.save(c);

        List<UserEntity> d = dao.findUserByUsername("xll");
        for(UserEntity k:d){
            System.out.println(k.getUsername()+"*"+k.getPassword()+"*"+k.getPermission());
        }
    }

    @Test
    public void update() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
        List<UserEntity> d = dao.findUserByUsername("zyh");
        UserEntity k= d.get(0);
        k.setPassword("dagseww");
        dao.update(k);

        List<UserEntity> c = dao.findUserByUsername("zyh");
        for(UserEntity a:c){
            System.out.println(a.getUsername()+"*"+a.getPassword()+"*"+a.getPermission());
        }
    }
}
