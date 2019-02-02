package plans;

import ProfileInfo.Profile;
import ui.HealthManager;

import java.io.IOException;

public interface User {
    void exercise() throws IOException;
    void diet(double cb);
    Profile getProfile();
    void addProfile(Profile profile);
//    void updateProfile();
    void setHealthManager(HealthManager hm);
//    void setProfileForMan();
//    void setProfileForWoman();
//    String getName();
}
