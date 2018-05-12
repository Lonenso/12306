package service;

import dao.StationDAO;
import dao.TrainDAO;
import dao.UserDAO;
import model.StationEntity;
import model.TrainEntity;
import model.UserEntity;

import java.util.List;

public class ManagerService {
    private UserDAO userdao;
    private StationDAO stationDAO;
    private TrainDAO trainDAO;

    public UserDAO getUserdao() {
        return userdao;
    }
    public void setUserdao(UserDAO userdao) {

        this.userdao = userdao;
    }
    public StationDAO getStationDAO() {
        return stationDAO;
    }
    public void setStationDAO(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }
    public TrainDAO getTrainDAO() {
        return trainDAO;
    }
    public void setTrainDAO(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }

    public int newuserM(UserEntity user){
        List<UserEntity> usr=userdao.findUserByUsername(user.getUsername());
        if(usr.size()==0) {
            userdao.save(user);
            return 1;
        }else{
            return 0;
        }
    }
    public int newstationM(StationEntity station){
        List<TrainEntity> tra=trainDAO.findTrainByID(station.getTrainId());
        if(tra.size()!=0) {
            stationDAO.save(station);
            return 1;
        }else{
            return 0;
        }
    }
    public int newtrainM(TrainEntity train){
        List<TrainEntity> traid=trainDAO.findTrainByID(train.getTrainId());
        List<TrainEntity> tradate=trainDAO.findTrainByDate(train.getDate());
        for(TrainEntity i:traid) {
            for (TrainEntity j : tradate) {
                i.getTrainId().equals(j.getTrainId());
                return 0;
            }
        }
        trainDAO.save(train);
        return 1;
    }
    public int deleteuserM(String username){
        if(userdao.findAll().size()==0){
            return 0;
        }else {
            userdao.delete(username);
            return 1;
        }
    }
    public int deletestationM(String key){
        if(stationDAO.findAll().size()==0){
            return 0;
        }else {
            stationDAO.delete(Integer.parseInt(key));
            return 1;
        }
    }
    public int deletetrainM(String key){
        if(trainDAO.findAll().size()==0){
            return 0;
        }else {
            trainDAO.delete(Integer.parseInt(key));
            return 1;
        }
    }
    public int login(String username,String password){
        if(username!=null) {
            List<UserEntity> usr = userdao.findUserByUsername(username);
            if (usr.size()!=0&&usr.get(0).getPassword().equals(password)) {
                if (usr.get(0).getPermission() == 1) {
                    return 1;
                } else if (usr.get(0).getPermission() == 2) {
                    return 2;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }else {
            return 0;
        }
    }
}
