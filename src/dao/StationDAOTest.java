package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.StationEntity;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StationDAOTest {

    @Test
    public void delete() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");

        StationDAO dao=(StationDAO)ac.getBean("stationDAO");
        List<StationEntity> d = dao.findStationByName("k8787","南京");
        int k=d.get(0).getId();
        dao.delete(k);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void findStationByName() {
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
        StationEntity c =new StationEntity();
        c.setTrainId("k1234");
        c.setStationName("杭州");
        java.util.Date date_f = new Date();
        java.sql.Time time = new java.sql.Time(date_f.getTime());
        c.setTimeofArrival(time);
        c.setTimeofStart(time);
        c.setDate(0);
        c.setCost(88.0);
        StationDAO dao=(StationDAO)ac.getBean("stationDAO");
        dao.save(c);

        List<StationEntity> d = dao.findStationByName("k8787","南京");
        for(StationEntity k:d){
            System.out.println(k.getId()+"*"+k.getTrainId()+"*"+k.getStationName()+"*"+k.getTimeofArrival()+"*"+k.getTimeofStart()+"*"+k.getDate()+"*"+k.getCost());
        }
    }

    @Test
    public void update() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        StationDAO dao=(StationDAO)ac.getBean("stationDAO");
        List<StationEntity> d = dao.findStationByName("k8787","南京");
        StationEntity k= d.get(0);
        k.setDate(1);
        dao.update(k);

        List<StationEntity> c = dao.findStationByName("k8787","南京");
        for(StationEntity a:c){
            System.out.println(k.getId()+"*"+k.getTrainId()+"*"+k.getStationName()+"*"+k.getTimeofArrival()+"*"+k.getTimeofStart()+"*"+k.getDate()+"*"+k.getCost());
        }
    }
}
