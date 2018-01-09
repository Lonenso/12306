package action;

import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class deleteuserMAction {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
        if(dao.findUserByUsername(key).size()==0) {
            return "fail";
        }else {
            dao.delete(key);
            return "success";
        }
    }
}
