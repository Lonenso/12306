package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import model.TrainEntity;
import model.HibernateUtil;

import java.util.List;
import java.util.Date;

public class TrainDAO extends HibernateDaoSupport{
    public void delete(int id){
        Session session=new HibernateUtil().getSession();
        TrainEntity c =(TrainEntity)session.get(TrainEntity.class,id);
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
    public void delete(TrainEntity c){
        getHibernateTemplate().delete(c);
    }
    public List<TrainEntity> findTrainByDate(Date _date){
        List<TrainEntity> c=(List<TrainEntity>)getHibernateTemplate().find(
                "from TrainEntity where date='"+_date+"'");
        return c;
    }
    public List<TrainEntity> findTrainByID(String train_id){
        List<TrainEntity> c=(List<TrainEntity>)getHibernateTemplate().find(
                "from TrainEntity where trainId='"+train_id+"'");
        return c;
    }
    public List<TrainEntity> findAll(){
        return (List<TrainEntity>)getHibernateTemplate().find("from TrainEntity");
    }
    public TrainEntity get(String train_id) {
        return (TrainEntity)getHibernateTemplate().get(TrainEntity.class,train_id);
    }
    public void save(TrainEntity c) {
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
    public void update(TrainEntity c) {
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
