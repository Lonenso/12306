package Test;

import action.loginAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class loginActionTest {

    @Test
    public void setUsername() {
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void getUsername() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void execute() throws Exception {
        String username="xll";
        String password="123";
        loginAction a=new loginAction();
        a.execute();
    }
}