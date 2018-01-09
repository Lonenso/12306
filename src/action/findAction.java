package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.*;
import action.Record;
import dao.*;
import com.opensymphony.xwork2.ActionSupport;
import po.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class findAction extends ActionSupport{
    private Date date;
    private String src;
    private String dst;
    private String year;
    private String month;
    private String day;
    private List<Record> record = new ArrayList<Record>();
    private int dayCountofMills = 86400000;

    public void setDate() {
        String d = this.year+"-"+this.month+"-"+this.day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = new Date(sdf.parse(d).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public Date getDate() {
        return date;
    }

    public String getDst() {
        return dst;
    }

    public String getSrc() {
        return src;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    public List<Record> getRecord() {
        return record;
    }

    public String execute(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        this.setDate();
        TrainDAO tdao = (TrainDAO)ac.getBean("trainDAO");
        List<TrainEntity> list = tdao.findTrainByDate(date);
        if(list.size()==0){
            return "fail"; //没有当天的车
        }
        StationDAO sdao = (StationDAO)ac.getBean("stationDAO");

        //遍历当天有的车次
        for(int j=0;j<list.size();j++){
            String train_id = (String)list.get(j).getTrainId();
            List<StationEntity> srcRecord = sdao.findStationByName(train_id,src);
            List<StationEntity> dstRecord = sdao.findStationByName(train_id,dst);
            if(srcRecord.size()==1&&dstRecord.size()==1) {
                int delta = dstRecord.get(0).getDate() - srcRecord.get(0).getDate();
                Time a = dstRecord.get(0).getTimeofArrival();
                Time b = srcRecord.get(0).getTimeofStart();

                if (delta > 0 || delta==0 && a.getTime()>b.getTime()) {
                    Date time = null;
                    Time startT = srcRecord.get(0).getTimeofStart();
                    Time endT = dstRecord.get(0).getTimeofArrival();
                    int firstClass = (int)list.get(j).getFirstClass();
                    int secondClass = (int)list.get(j).getSecondClass();
                    int stateCabins = (int)list.get(j).getStateCabins();
                    int hard = (int)list.get(j).getHard();
                    int soft = (int)list.get(j).getSoft();
                    Record rec = new Record();
                    rec.setTrain_id(train_id);
                    rec.setSrc(src);
                    rec.setDst(dst);
                    rec.setFirstClass(firstClass);
                    rec.setSecondClass(secondClass);
                    rec.setStateCabins(stateCabins);
                    rec.setHard(hard);
                    rec.setSoft(soft);
                    rec.setCost(dstRecord.get(0).getCost() - srcRecord.get(0).getCost());
                    rec.setStartT(startT);
                    rec.setEndT(endT);
                    long endTime = endT.getTime();
                    long startTime = startT.getTime();
                    long diff = endTime - startTime + delta * dayCountofMills;
                    rec.setTime(diff);
                    rec.setDelta(delta);
                    record.add(rec);
                }
            }
        }
        if(record!=null){
            return "success";
        }
        return "fail";
    }
}
