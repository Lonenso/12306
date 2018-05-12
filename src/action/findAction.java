package action;

import model.StationEntity;
import model.TrainEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.Record;
import dao.*;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.queryService;

public class findAction extends ActionSupport{
    private Date date;
    private String src;
    private String dst;
    private String year;
    private String month;
    private String day;
    private List<Record> record = new ArrayList<>();
    protected queryService qsr;

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

    public void setQsr(queryService qsr) {
        this.qsr = qsr;
    }

    public queryService getQsr() {
        return qsr;
    }

    public String execute(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        qsr = (queryService)ac.getBean("qsr");
        this.setDate();
        record = qsr.query1(src,dst,date);
        if(record!=null){
            return "success";
        }
        return "fail";
    }
}
//2018.1.9 13:26 更改逻辑
//2018.1.9 13:55 改用迭代器循环删除不满足条件的元素