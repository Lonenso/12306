package action;

import dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.UserEntity;

public class registAction {
    private String username;
    private String password;
  //  private String repwd;

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
//    public void setRepwd(String repwd) {
//        this.repwd = repwd;
//    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
//    public String getRepwd() {
//        return repwd;
//    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        UserDAO dao=(UserDAO)ac.getBean("userDAO");
        if(!username.equals("")){
            UserEntity usr=new UserEntity();
            usr.setUsername(username);
            usr.setPassword(password);
            usr.setPermission(1);
            dao.save(usr);
            return "success";
        }else {
            return "fail";
        }
    }
}
