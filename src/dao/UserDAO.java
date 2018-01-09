package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import po.UserEntity;
import util.HibernateUtil;
import java.util.List;

public class UserDAO extends HibernateDaoSupport{
    public void delete(String username){
        Session session=new HibernateUtil().getSession();
        UserEntity c =(UserEntity)session.get(UserEntity.class,username);
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
    public void delete(UserEntity c){
        getHibernateTemplate().delete(c);
    }
    public List<UserEntity> findUserByUsername(String username){
        List<UserEntity> c=(List<UserEntity>)getHibernateTemplate().find(
                "from UserEntity where username='"+username+"'");
        return c;
    }
    public List<UserEntity> findAll(){
        return (List<UserEntity>)getHibernateTemplate().find("from UserEntity");
    }
    public UserEntity get(String username) {
        return (UserEntity)getHibernateTemplate().get(UserEntity.class,username);
    }
    public void save(UserEntity c) {
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
    public void update(UserEntity c) {
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
