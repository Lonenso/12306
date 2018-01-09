package action;

import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.UserEntity;

public class newuserMAction {
    private String username;
    private String password;
    private String radio;

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
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
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
            dao.save(usr);
            return "success";
        }else {
            return "fail";
        }
    }
}
