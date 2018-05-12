package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StationDAO;
import dao.TrainDAO;
import model.Record;
import model.advancedRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.StationEntity;
import model.TrainEntity;
import service.queryService;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class advancedAction extends ActionSupport{
    private String src;
    private String dst;
    private Date date;
    private String year;
    private String month;
    private String day;
    private List<advancedRecord> advancedRec = new ArrayList<>();
    private int count; //存在几趟直达
    private int dayCountofMills = 86400000;

    protected queryService qsr;

    public queryService getQsr() {
        return qsr;
    }

    public void setQsr(queryService qsr) {
        this.qsr = qsr;
    }

    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
    }

    public Date getDate() {
        return date;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public void setDate() {
        String d = this.year+"-"+this.month+"-"+this.day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = new Date(sdf.parse(d).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
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

    public List<advancedRecord> getAdvancedRec() {
        return advancedRec;
    }

    public void setAdvancedRec(List<advancedRecord> advancedRec) {
        this.advancedRec = advancedRec;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }



    public String execute() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        qsr = (queryService)ac.getBean("qsr");
        this.setDate();
        advancedRec = qsr.query2(src,dst,date);
        if(advancedRec.size()!=0){
            return "success";
        }else{
            return "fail";
        }
    }
}
//TODO:加上错误原因，返回不同的界面