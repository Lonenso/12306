package action;

import org.junit.Test;

import static org.junit.Assert.*;

public class findActionTest {
    @Test
    public void setDate() throws Exception {
    }

    @Test
    public void setSrc() throws Exception {
    }

    @Test
    public void setDst() throws Exception {
    }

    @Test
    public void getDate() throws Exception {
    }

    @Test
    public void getDst() throws Exception {
    }

    @Test
    public void getSrc() throws Exception {
    }

    @Test
    public void setRecord() throws Exception {
    }

    @Test
    public void getRecord() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        findAction fA = new findAction();
        fA.setYear("2018");
        fA.setMonth("1");
        fA.setDay("25");
        fA.setDate();
        fA.setSrc("泉州");
        fA.setDst("北京");
        System.out.println(fA.execute());
    }

}