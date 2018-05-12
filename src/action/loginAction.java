package action;
import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.UserEntity;
import service.ManagerService;

import java.util.List;

public class loginAction {
    private String username;
    private String password;
    protected ManagerService mgr;

    public void setMgr(ManagerService mgr) {
        this.mgr = mgr;
    }
    public ManagerService getMgr() {
        return mgr;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        mgr=(ManagerService)ac.getBean("managerService");
        int result=mgr.login(username,password);
        if(result==1){
            return "normal";
        }else if(result==2){
            return "manage";
        }else{
            return "fail";
        }
    }
}
