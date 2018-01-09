package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StationDAO;
import dao.TrainDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.StationEntity;
import po.TrainEntity;
import sun.swing.plaf.synth.DefaultSynthStyle;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class advancedAction extends ActionSupport{
    private String src;
    private String dst;
    private Date date;
    private int count; //存在几趟直达
    private List<advancedRecord> advancedRec = new ArrayList<>();
    private int dayCountofMills = 86400000;
    private int timeZoneMo = 28800000;

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

    public void setDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = new Date(sdf.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public Date getTomorrow(Date d){
        Date tomorrow = new Date(d.getTime()+dayCountofMills);
        return tomorrow;
    }

    public void setData(List<StationEntity> srcRecord,List<StationEntity> stopRecord1,List<StationEntity> stopRecord2 ,List<StationEntity> dstRecord,TrainEntity j, TrainEntity m,String stopStation){
        advancedRecord aRec = new advancedRecord();
        Record ahead = new Record();
        Record behind = new Record();
        Time startT = srcRecord.get(0).getTimeofStart();
        Time endT = stopRecord1.get(0).getTimeofArrival();
        int delta = stopRecord1.get(0).getDate() - srcRecord.get(0).getDate();
        ahead.setTrain_id(j.getTrainId());
        ahead.setSrc(src);
        ahead.setDst(stopStation);
        ahead.setStartT(startT);
        ahead.setEndT(endT);
        long endTime = endT.getTime();
        long startTime = startT.getTime();
        long diff = endTime - startTime;
        ahead.setTime(diff);
        ahead.setFirstClass(j.getFirstClass());
        ahead.setSecondClass(j.getSecondClass());
        ahead.setHard(j.getHard());
        ahead.setStateCabins(j.getStateCabins());
        ahead.setSoft(j.getSoft());
        ahead.setCost(stopRecord1.get(0).getCost() - srcRecord.get(0).getCost());
        ahead.setDelta(delta);
        Time startT2 =stopRecord2.get(0).getTimeofStart() ;
        Time endT2 = dstRecord.get(0).getTimeofArrival();
        int delta2 = dstRecord.get(0).getDate()-stopRecord2.get(0).getDate();
        behind.setTrain_id(m.getTrainId());
        behind.setSrc(stopStation);
        behind.setDst(dst);
        behind.setStartT(startT2);
        behind.setEndT(endT2);
        long endTime2 = endT2.getTime();
        long startTime2 = startT2.getTime();
        long diff2 = endTime2 - startTime2;
        behind.setTime(diff2);
        behind.setFirstClass(m.getFirstClass());
        behind.setSecondClass(m.getSecondClass());
        behind.setStateCabins(m.getStateCabins());
        behind.setHard(m.getHard());
        behind.setSoft(m.getSoft());
        behind.setCost(dstRecord.get(0).getCost() - stopRecord2.get(0).getCost());
        behind.setDelta(delta2);
        aRec.setSrcRec(ahead);
        aRec.setDstRec(behind);
        aRec.setTrans(stopStation);
        aRec.setTotalCost();
        aRec.setTotalTime(diff+diff2);
        advancedRec.add(aRec);
    }

    public String execute() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        TrainDAO tdao = (TrainDAO) ac.getBean("trainDAO");
        List<TrainEntity> trainList = tdao.findTrainByDate(date);//得到所有当天运行的车次
        List<TrainEntity> srcTrainList = new ArrayList<>();//得到当天运行的车次中起点可以为src且dst不可能为终点的车次
        List<StationEntity> srcRecord;
        List<TrainEntity> stopTrainList = new ArrayList<>();
        if (trainList == null) {
            return "fail";  //当日没有车次运行
        }

        count = 0;
        StationDAO sdao = (StationDAO) ac.getBean("stationDAO");
        for (TrainEntity i : trainList) {
            int x = sdao.findStationByName(i.getTrainId(), src).size();
            int y = sdao.findStationByName(i.getTrainId(), dst).size();
            if (x != 0 && y == 0) {
                srcTrainList.add(i);
                stopTrainList.add(i);
            }
            if (x != 0 && y != 0) {
                count++;
            }
        }
        List<StationEntity> stationList;
        for (TrainEntity j : srcTrainList) {
            double cost = sdao.findStationByName(j.getTrainId(), src).get(0).getCost();
            stationList = sdao.findStationByTrainId(j.getTrainId(), cost);
            srcRecord = sdao.findStationByName(j.getTrainId(), src);
            java.util.Date srcDateTime = new java.util.Date(date.getTime() + srcRecord.get(0).getTimeofStart().getTime() + timeZoneMo);
            for (StationEntity k : stationList) {
                String stopStation = k.getStationName();
                int oldDate = k.getDate();
                List<StationEntity> stopRecord1 = sdao.findStationByName(j.getTrainId(), stopStation);
                Date _stopDate = new Date(date.getTime() + oldDate * dayCountofMills);
                java.util.Date stopDate1 = new java.util.Date(date.getTime() + oldDate * dayCountofMills + stopRecord1.get(0).getTimeofArrival().getTime() + timeZoneMo);
                java.util.Date allowDate = new java.util.Date(stopDate1.getTime() + dayCountofMills);//stopDate1~allowDate间的train_id都满足条件
                //计算获得满足条件的train_id（时间上满足）
                List<TrainEntity> list1 = tdao.findTrainByDate(_stopDate);
                for (TrainEntity i : list1) {
                    List<StationEntity> stopRecord2 = sdao.findStationByName(i.getTrainId(), stopStation);
                    List<StationEntity> dstRecord = sdao.findStationByName(i.getTrainId(), dst);
                    for (StationEntity e : stopRecord2) {
                        if (e.getTimeofStart().getTime() < k.getTimeofArrival().getTime()) {
                            stopRecord2.remove(e);
                        }
                    }
                    if (stopRecord2.size() == 1 && dstRecord.size() == 1) {
                        int delta = dstRecord.get(0).getDate() - stopRecord2.get(0).getDate();
                        Time a = dstRecord.get(0).getTimeofArrival();
                        Time b = stopRecord2.get(0).getTimeofStart();
                        if (delta > 0 || delta == 0 && a.getTime() > b.getTime()) {
                            setData(srcRecord, stopRecord1, stopRecord2, dstRecord, j, i, stopStation);
                        }
                    }
                }
                List<TrainEntity> list4 = tdao.findTrainByDate(getTomorrow(_stopDate));
                for (TrainEntity q : list4) {
                    List<StationEntity> stopRecord2 = sdao.findStationByName(q.getTrainId(), stopStation);
                    List<StationEntity> dstRecord = sdao.findStationByName(q.getTrainId(), dst);
                    for (StationEntity f : stopRecord2) {
                        if (f.getTimeofStart().getTime() > k.getTimeofArrival().getTime()) {
                            stopRecord2.remove(f);
                        }
                    }
                    if (stopRecord2.size() == 1 && dstRecord.size() == 1) {
                        int delta = dstRecord.get(0).getDate() - stopRecord2.get(0).getDate();
                        Time a = dstRecord.get(0).getTimeofArrival();
                        Time b = stopRecord2.get(0).getTimeofStart();
                        if (delta > 0 || delta == 0 && a.getTime() > b.getTime()) {
                            setData(srcRecord, stopRecord1, stopRecord2, dstRecord, j, q, stopStation);
                        }
                    }
                }
            }
        }
        if(advancedRec.size()!=0){
            return "success";
        }else{
            return "fail";
        }
    }
}
//TODO:加上错误原因，返回不同的界面