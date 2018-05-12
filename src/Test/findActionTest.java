package Test;

import action.findAction;
import org.junit.Test;
import service.queryService;

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
        fA.setDay("11");
        fA.setDate();
        fA.setSrc("北京");
        fA.setDst("沈阳");
        System.out.println(fA.execute());
    }

}