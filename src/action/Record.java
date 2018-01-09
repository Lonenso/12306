package action;

import java.sql.Date;
import java.sql.Time;

public class Record {
    private String train_id;
    private String src;
    private String dst;
    private String time;
    private int firstClass;
    private int secondClass;
    private int stateCabins;
    private int hard;
    private int soft;
    private double cost;
    private Time startT;
    private Time endT;
    private int delta; //0 当天 1 次日 依此类推

    public void setDst(String dst) {
        this.dst = dst;
    }

    public void setTime(long diff) {
        long nh = 60 * 60 * 1000;
        long nm = 1000 * 60;
        long hour = diff / nh;
        long min = diff % nh / nm;
        this.time = String.format("%02d:%02d",hour,min);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setFirstClass(int firstClass) {
        this.firstClass = firstClass;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    public void setSecondClass(int secondClass) {
        this.secondClass = secondClass;
    }

    public void setSoft(int soft) {
        this.soft = soft;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setStateCabins(int stateCabins) {
        this.stateCabins = stateCabins;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getDst() {
        return dst;
    }

    public double getCost() {
        return cost;
    }

    public int getFirstClass() {
        return firstClass;
    }

    public int getHard() {
        return hard;
    }

    public int getSecondClass() {
        return secondClass;
    }

    public int getSoft() {
        return soft;
    }

    public int getStateCabins() {
        return stateCabins;
    }

    public String getSrc() {
        return src;
    }

    public String getTrain_id() {
        return train_id;
    }

    public String getTime() {
        return time;
    }

    public void setEndT(Time endT) {
        this.endT = endT;
    }

    public void setStartT(Time startT) {
        this.startT = startT;
    }

    public Time getEndT() {
        return endT;
    }

    public Time getStartT() {
        return startT;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }
}

