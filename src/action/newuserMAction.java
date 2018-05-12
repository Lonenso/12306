package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.UserEntity;
import service.ManagerService;

public class newuserMAction {
    protected ManagerService mgr;
    private String username;
    private String password;
    private String radio;

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
    public void setRadio(String radio) {
        this.radio = radio;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRadio() {
        return radio;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        mgr=(ManagerService)ac.getBean("managerService");
        if(username!=null&&!username.equals("")){
            UserEntity usr=new UserEntity();
            usr.setUsername(username);
            usr.setPassword(password);
            if(radio.equals("1")) {
                usr.setPermission(1);
            }else if(radio.equals("2")){
                usr.setPermission(2);
            }else {
                return "fail";
            }
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
