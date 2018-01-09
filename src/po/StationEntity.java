package po;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "station", schema = "12306", catalog = "12306")
public class StationEntity {
    private int id;
    private String trainId;
    private String stationName;
    private Time timeofArrival;
    private Time timeofStart;
    private int date;
    private Double cost;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "train_id")
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "station_name")
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Basic
    @Column(name = "timeofArrival")
    public Time getTimeofArrival() {
        return timeofArrival;
    }

    public void setTimeofArrival(Time timeofArrival) {
        this.timeofArrival = timeofArrival;
    }

    @Basic
    @Column(name = "timeofStart")
    public Time getTimeofStart() {
        return timeofStart;
    }

    public void setTimeofStart(Time timeofStart) {
        this.timeofStart = timeofStart;
    }

    @Basic
    @Column(name = "_date")
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Basic
    @Column(name = "_cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
        return id == that.id &&
                date == that.date &&
                Objects.equals(trainId, that.trainId) &&
                Objects.equals(stationName, that.stationName) &&
                Objects.equals(timeofArrival, that.timeofArrival) &&
                Objects.equals(timeofStart, that.timeofStart) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, trainId, stationName, timeofArrival, timeofStart, date, cost);
    }
}
