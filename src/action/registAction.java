package action;

import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.UserEntity;
import service.ManagerService;

public class registAction {
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
        if(!username.equals("")){
            UserEntity usr=new UserEntity();
            usr.setUsername(username);
            usr.setPassword(password);
            usr.setPermission(1);
            int result=mgr.newuserM(usr);
            if(result==1){
                return "success";
            }else{
                return "fail";
            }
        }else {
            return "fail";
        }
    }
}
