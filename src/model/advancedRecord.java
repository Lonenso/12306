package model;

public class advancedRecord{
    private Record srcRec;
    private Record dstRec;
    private String trans; //中转站
    private double totalCost;
    private String totalTime;
    private String stopTime;


    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(long diff) {
        long nh = 60 * 60 * 1000;
        long nm = 1000 * 60;
        long hour = diff / nh;
        long min = diff % nh / nm;
        this.stopTime = String.format("%02d:%02d",hour,min);
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public void setTotalCost() {
        this.totalCost = this.srcRec.getCost()+this.dstRec.getCost();
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long diff) {
        long nh = 60 * 60 * 1000;
        long nm = 1000 * 60;
        long hour = diff / nh;
        long min = diff % nh / nm;
        this.totalTime = String.format("%02d:%02d",hour,min);
    }

    public void setDstRec(Record dstRec) {
        this.dstRec = dstRec;
    }

    public void setSrcRec(Record srcRec) {
        this.srcRec = srcRec;
    }

    public Record getSrcRec() {
        return srcRec;
    }

    public Record getDstRec() {
        return dstRec;
    }
}
