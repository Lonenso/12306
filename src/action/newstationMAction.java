package action;

import dao.StationDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.StationEntity;
import java.sql.Time;

public class newstationMAction {
    private String train_id;
    private String station_name;
    private String timeofArrival;
    private String timeofStart;
    private String _date;
    private String _cost;

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
    public void setTimeofArrival(String timeofArrival) {
        this.timeofArrival = timeofArrival;
    }
    public void setTimeofStart(String timeofStart) {
        this.timeofStart = timeofStart;
    }
    public void set_date(String _date) {
        this._date = _date;
    }
    public void set_cost(String _cost) {
        this._cost = _cost;
    }
    public String getTrain_id() {
        return train_id;
    }
    public String getStation_name() {
        return station_name;
    }
    public String getTimeofArrival() {
        return timeofArrival;
    }
    public String getTimeofStart() {
        return timeofStart;
    }
    public String get_date() {
        return _date;
    }
    public String get_cost() {
        return _cost;
    }
    public String execute()throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        StationDAO dao=(StationDAO)ac.getBean("stationDAO");
        if(train_id!=null&&!train_id.equals("")){
            StationEntity newstation=new StationEntity();
            newstation.setTrainId(train_id);
            newstation.setStationName(station_name);
            newstation.setTimeofArrival(Time.valueOf(timeofArrival));
            newstation.setTimeofStart(Time.valueOf(timeofStart));
            newstation.setDate(Integer.parseInt(_date));
            newstation.setCost(Double.valueOf(_cost));
            dao.save(newstation);
            return "success";
        }else {
            return "fail";
        }
    }
}
