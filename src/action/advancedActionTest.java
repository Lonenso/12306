package action;

import org.junit.Test;

import static org.junit.Assert.*;

public class advancedActionTest {
    @Test
    public void getSrc() throws Exception {
    }

    @Test
    public void getDst() throws Exception {
    }

    @Test
    public void getDate() throws Exception {
    }

    @Test
    public void setSrc() throws Exception {
    }

    @Test
    public void setDst() throws Exception {
    }

    @Test
    public void setDate() throws Exception {
    }

    @Test
    public void getAdvancedRec() throws Exception {
    }

    @Test
    public void setAdvancedRec() throws Exception {
    }

    @Test
    public void setCount() throws Exception {
    }

    @Test
    public void getCount() throws Exception {
    }

    @Test
    public void getTomorrow() throws Exception {
    }

    @Test
    public void execute() throws Exception {
        advancedAction aA = new advancedAction();
        aA.setYear("2018");
        aA.setMonth("1");
        aA.setDay("8");
        aA.setDate();
        aA.setSrc("郑州");
        aA.setDst("哈尔滨");
        System.out.println(aA.execute());
    }

}