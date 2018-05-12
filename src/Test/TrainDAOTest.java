package Test;

import dao.TrainDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.TrainEntity;

import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TrainDAOTest {
    @Test
    public void delete() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");

        TrainDAO dao=(TrainDAO)ac.getBean("trainDAO");
        dao.delete(2);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void findTrainByDate() {
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
        TrainEntity c =new TrainEntity();
        c.setTrainId("k8787");
        c.setFirstClass(56);
        c.setSecondClass(45);
        c.setStateCabins(48);
        c.setHard(0);
        c.setSoft(12);
        java.util.Date date_f = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date_f.getTime());
        c.setDate(sqlDate);
        TrainDAO dao=(TrainDAO)ac.getBean("trainDAO");
        dao.save(c);

        List<TrainEntity> d = dao.findTrainByDate(sqlDate);
        for(TrainEntity k:d){
            System.out.println(k.getTrainId()+"*"+k.getFirstClass()+"*"+k.getSecondClass()+"*"+k.getStateCabins()+"*"+k.getHard()+"*"+k.getSoft()+"*"+k.getDate());
        }
    }

    @Test
    public void update() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        TrainDAO dao=(TrainDAO)ac.getBean("trainDAO");
        List<TrainEntity> d = dao.findTrainByID("k1234");
        TrainEntity k= d.get(0);
        k.setSecondClass(6);
        dao.update(k);

        List<TrainEntity> c = dao.findTrainByID("k1234");
        for(TrainEntity a:c){
            System.out.println(k.getTrainId()+"*"+k.getFirstClass()+"*"+k.getSecondClass()+"*"+k.getStateCabins()+"*"+k.getHard()+"*"+k.getSoft()+"*"+k.getSecondClass()+k.getDate());
        }
    }
}
