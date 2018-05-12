package service;

import dao.StationDAO;
import dao.TrainDAO;
import model.Record;
import model.StationEntity;
import model.TrainEntity;
import model.advancedRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class queryService {
    private TrainDAO tdao;
    private StationDAO sdao;
    private List<Record> record = new ArrayList<Record>();
    private List<advancedRecord> advancedRec = new ArrayList<>();
    public int dayCountofMills = 86400000;
    private int timeZoneMo = 28800000;

    public StationDAO getSdao() {
        return sdao;
    }

    public void setSdao(StationDAO sdao) {
        this.sdao = sdao;
    }

    public TrainDAO getTdao() {
        return tdao;
    }

    public void setTdao(TrainDAO tdao) {
        this.tdao = tdao;
    }

    public Date getTomorrow(Date d){
        Date tomorrow = new Date(d.getTime()+dayCountofMills);
        return tomorrow;
    }

    public void setData(String src,String dst ,List<StationEntity> srcRecord,List<StationEntity> stopRecord1,List<StationEntity> stopRecord2 ,List<StationEntity> dstRecord,TrainEntity j, TrainEntity m,String stopStation){
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
        long diff = endTime - startTime + delta * dayCountofMills;
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
        long diff2 = endTime2 - startTime2 + delta2 * dayCountofMills;
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

    public List<Record> query1(String src, String dst, Date date){
        List<StationEntity> d = sdao.findStationOnlyByName(src);
        List<TrainEntity> e = new ArrayList<>();
        List<TrainEntity> list = new ArrayList<>();
        for(StationEntity b:d){
            Date currDate = new Date(date.getTime()-b.getDate()*dayCountofMills);
            e = tdao.findTrainByDate(currDate);
            if(e.size()!=0) {
                Iterator<TrainEntity> it = e.iterator();
                while(it.hasNext()){
                    TrainEntity x = it.next();
                    if (x.getTrainId().equals(b.getTrainId())) {
                        list.add(x);
                    }
                }
            }
        }
        if(list.size()==0){
            return null;
        }

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
        return record;
    }
    public List<advancedRecord> query2(String src,String dst,Date date){
        List<StationEntity> d = sdao.findStationOnlyByName(src);
        List<TrainEntity> e = new ArrayList<>();
        List<TrainEntity> trainList = new ArrayList<>();
        for(StationEntity b:d){
            Date currDate = new Date(date.getTime()-b.getDate()*dayCountofMills);
            e = tdao.findTrainByDate(currDate);
            if(e.size()!=0) {
                Iterator<TrainEntity> it = e.iterator();
                while(it.hasNext()){
                    TrainEntity x = it.next();
                    if (x.getTrainId().equals(b.getTrainId())) {
                        trainList.add(x);
                    }
                }
            }
        }


        List<TrainEntity> srcTrainList = new ArrayList<>();//得到当天运行的车次中起点可以为src且dst不可能为终点的车次
        List<StationEntity> srcRecord;
        List<TrainEntity> stopTrainList = new ArrayList<>();
        if (trainList == null) {
            return null;  //当日没有车次运行
        }
//        count=0;

        for (TrainEntity i : trainList) {
            int x = sdao.findStationByName(i.getTrainId(), src).size();
            int y = sdao.findStationByName(i.getTrainId(), dst).size();
            if (x != 0 && y == 0) {
                srcTrainList.add(i);
                stopTrainList.add(i);
            }
//            if (x != 0 && y != 0) {
//                count++;
//            }
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

                List<StationEntity> f = sdao.findStationOnlyByName(stopStation);
                List<TrainEntity> g;
                List<TrainEntity> list1 = new ArrayList<>();
                for(StationEntity h:f){
                    Date currDate = new Date(_stopDate.getTime()-h.getDate()*dayCountofMills);
                    g = tdao.findTrainByDate(currDate);
                    if(g.size()!=0) {
                        Iterator<TrainEntity> it = g.iterator();
                        while(it.hasNext()){
                            TrainEntity x = it.next();
                            if (x.getTrainId().equals(h.getTrainId())) {
                                list1.add(x);
                            }
                        }
                    }
                }

                //当天
                for (TrainEntity i : list1) {
                    List<StationEntity> stopRecord2 = sdao.findStationByName(i.getTrainId(), stopStation);
                    List<StationEntity> dstRecord = sdao.findStationByName(i.getTrainId(), dst);
                    Iterator<StationEntity> it = stopRecord2.iterator();
                    while(it.hasNext()){
                        StationEntity x = it.next();
                        Time t1 = x.getTimeofStart();
                        Time t2 = k.getTimeofArrival();
                        if(t1!=null&&t2!=null){
                            if (t1.getTime() <= t2.getTime()) {
                                it.remove();
                            }
                        }
                    }
                    if (stopRecord2.size() == 1 && dstRecord.size() == 1) {
                        int delta = dstRecord.get(0).getDate() - stopRecord2.get(0).getDate();
                        Time a = dstRecord.get(0).getTimeofArrival();
                        Time b = stopRecord2.get(0).getTimeofStart();
                        if (delta > 0 || delta == 0 && a.getTime() > b.getTime()) {
                            setData(src,dst,srcRecord, stopRecord1, stopRecord2, dstRecord, j, i, stopStation);
                        }
                    }
                }

                List<StationEntity> i = sdao.findStationOnlyByName(stopStation);
                List<TrainEntity> l;
                List<TrainEntity> list4 = new ArrayList<>();
                for(StationEntity n:i){
                    Date currDate = new Date(getTomorrow(_stopDate).getTime()-n.getDate()*dayCountofMills);
                    l = tdao.findTrainByDate(currDate);
                    if(l.size()!=0) {
                        Iterator<TrainEntity> it = l.iterator();
                        while(it.hasNext()){
                            TrainEntity x = it.next();
                            if (x.getTrainId().equals(n.getTrainId())) {
                                list4.add(x);
                            }
                        }
                    }
                }

                //第二天
                for (TrainEntity q : list4) {
                    List<StationEntity> stopRecord2 = sdao.findStationByName(q.getTrainId(), stopStation);
                    List<StationEntity> dstRecord = sdao.findStationByName(q.getTrainId(), dst);
                    Iterator<StationEntity> it = stopRecord2.iterator();
                    while(it.hasNext()){
                        StationEntity x = it.next();
                        Time t1 = x.getTimeofStart();
                        Time t2 = k.getTimeofArrival();
                        if(t1!=null&&t2!=null){
                            if (t1.getTime() >= t2.getTime()) {
                                it.remove();
                            }
                        }
                    }

                    if (stopRecord2.size() == 1 && dstRecord.size() == 1) {
                        int delta = dstRecord.get(0).getDate() - stopRecord2.get(0).getDate();
                        Time a = dstRecord.get(0).getTimeofArrival();
                        Time b = stopRecord2.get(0).getTimeofStart();
                        if (delta > 0 || delta == 0 && a.getTime() > b.getTime()) {
                            setData(src,dst,srcRecord, stopRecord1, stopRecord2, dstRecord, j, q, stopStation);
                        }
                    }
                }
            }
        }
        return advancedRec;
    }
}
