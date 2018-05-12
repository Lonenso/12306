package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "train", schema = "12306", catalog = "")
public class TrainEntity {
    private int id;
    private String trainId;
    private int firstClass;
    private int secondClass;
    private int stateCabins;
    private int hard;
    private int soft;
    private Date date;

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
    @Column(name = "first_class")
    public int getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(int firstClass) {
        this.firstClass = firstClass;
    }

    @Basic
    @Column(name = "second_class")
    public int getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(int secondClass) {
        this.secondClass = secondClass;
    }

    @Basic
    @Column(name = "state_cabins")
    public int getStateCabins() {
        return stateCabins;
    }

    public void setStateCabins(int stateCabins) {
        this.stateCabins = stateCabins;
    }

    @Basic
    @Column(name = "hard")
    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    @Basic
    @Column(name = "soft")
    public int getSoft() {
        return soft;
    }

    public void setSoft(int soft) {
        this.soft = soft;
    }

    @Basic
    @Column(name = "_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainEntity that = (TrainEntity) o;
        return id == that.id &&
                firstClass == that.firstClass &&
                Objects.equals(trainId, that.trainId) &&
                Objects.equals(secondClass, that.secondClass) &&
                Objects.equals(stateCabins, that.stateCabins) &&
                Objects.equals(hard, that.hard) &&
                Objects.equals(soft, that.soft) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, trainId, firstClass, secondClass, stateCabins, hard, soft, date);
    }
}
