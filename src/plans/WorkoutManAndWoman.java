package plans;

import ProfileInfo.Profile;
import models.FoodCLog;
import ui.HealthManager;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public abstract class WorkoutManAndWoman implements User {

    protected FoodCLog foodCLog = new FoodCLog();
    protected double c = 0;
    private Profile profile;
    protected double cl;
    protected HealthManager hm;
    protected String name;


    @Override
    public abstract void exercise() throws IOException;

    @Override
    //MODIFIES: this, foodCLog
    //EFFECTS: record total calories of food eaten
    //         remind of the calories budget left
    public abstract void diet(double cb);

    public void addProfile(Profile profile){
        if(profile!=this.profile){
            this.profile=profile;
            profile.addUser(this);
        }
    }



    public Profile getProfile(){
        return profile;
    }



    public void setHealthManager(HealthManager hm){
        if(this.hm != hm){
            this.hm = hm;
            hm.addUser(this);
        }
    }

//    public String getName(){
//        return name;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutManAndWoman)) return false;
        WorkoutManAndWoman that = (WorkoutManAndWoman) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
