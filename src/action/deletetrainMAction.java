package action;

import dao.TrainDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class deletetrainMAction {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        TrainDAO dao=(TrainDAO)ac.getBean("trainDAO");
        if(dao.findAll().size()==0){
            return "fail";
        }else {
            dao.delete(Integer.parseInt(key));
            return "success";
        }
    }
}
