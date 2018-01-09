package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import util.HibernateUtil;
import po.StationEntity;

import java.util.Date;
import java.util.List;


public class StationDAO extends HibernateDaoSupport{
    public void delete(int id){
        Session session=new HibernateUtil().getSession();
        StationEntity c =(StationEntity)session.get(StationEntity.class,id);
        try{
            if(c!=null){
                Transaction tran=session.beginTransaction();
                session.delete(c);
                tran.commit();
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void delete(StationEntity c){
        getHibernateTemplate().delete(c);
    }
    public List<StationEntity> findStationByName(String train_id,String station_name){
        List<StationEntity> c=(List<StationEntity>)getHibernateTemplate().find(
                "from StationEntity where trainId='"+train_id+"' and stationName='"+station_name+"'");
        return c;
    }
    public List<StationEntity> findStationByTrainId(String train_id, double cost){
        List<StationEntity> c=(List<StationEntity>)getHibernateTemplate().find(
                "from StationEntity where trainId='"+train_id+"' and cost > "+cost);
        return c;
    }
    public List<StationEntity> findAll(){
        return (List<StationEntity>)getHibernateTemplate().find("from StationEntity");
    }
    public StationEntity get(int id) {
        return (StationEntity)getHibernateTemplate().get(StationEntity.class,id);
    }
    public void save(StationEntity c) {
        Session session= new HibernateUtil().getSession();
        Transaction tran = session.beginTransaction();
        try{
            session.save(c);
            tran.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void update(StationEntity c) {
        Session session=new HibernateUtil().getSession();
        Transaction tran =session.beginTransaction();
        try{
            session.update(c);
            tran.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
