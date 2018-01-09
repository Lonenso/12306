package action;
import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.UserEntity;

import java.util.List;

public class loginAction {
    private String username;
    private String password;

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
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
        if(username!=null) {
            List<UserEntity> usr = dao.findUserByUsername(username);
            if (usr.get(0).getPassword().equals(password)) {
                if (usr.get(0).getPermission() == 1) {
                    return "normal";
                } else if (usr.get(0).getPermission() == 2) {
                    return "manage";
                } else {
                    return "fail";
                }
            } else {
                return "fail";
            }
        }else {
            return "fail";
        }
    }
}
