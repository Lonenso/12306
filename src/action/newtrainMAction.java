package action;

import dao.TrainDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.TrainEntity;
import java.sql.Date;

public class newtrainMAction {
    private String train_id;
    private String first_class;
    private String second_class;
    private String state_cabins;
    private String hard;
    private String soft;
    private String _date;

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }
    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }
    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }
    public void setState_cabins(String state_cabins) {
        this.state_cabins = state_cabins;
    }
    public void setHard(String hard) {
        this.hard = hard;
    }
    public void setSoft(String soft) {
        this.soft = soft;
    }
    public void set_date(String _date) {
        this._date = _date;
    }
    public String getTrain_id() {
        return train_id;
    }
    public String getFirst_class() {
        return first_class;
    }
    public String getSecond_class() {
        return second_class;
    }
    public String getState_cabins() {
        return state_cabins;
    }
    public String getHard() {
        return hard;
    }
    public String getSoft() {
        return soft;
    }
    public String get_date() {
        return _date;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        TrainDAO dao=(TrainDAO)ac.getBean("trainDAO");
        if(train_id!=null&&!train_id.equals("")){
            TrainEntity newtrain=new TrainEntity();
            newtrain.setTrainId(train_id);
            newtrain.setFirstClass(Integer.parseInt(first_class));
            newtrain.setSecondClass(Integer.parseInt(second_class));
            newtrain.setStateCabins(Integer.parseInt(state_cabins));
            newtrain.setHard(Integer.parseInt(hard));
            newtrain.setSoft(Integer.parseInt(soft));
            newtrain.setDate(Date.valueOf(_date));
            dao.save(newtrain);
            return "success";
        }else {
            return "fail";
        }
    }
}
