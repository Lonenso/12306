package action;

import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ManagerService;

public class deleteuserMAction {
    private String key;
    protected ManagerService mgr;

    public void setMgr(ManagerService mgr) {
        this.mgr = mgr;
    }
    public ManagerService getMgr() {
        return mgr;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        mgr=(ManagerService)ac.getBean("managerService");
        int result=mgr.deleteuserM(key);
        if(result==1){
            return "success";
        }else {
            return "fail";
        }
    }
}
