package ProfileInfo;

import ProfileInfo.Profile;

public class ProfileForMen extends Profile {

    private void setGender(){
        gender = "male";
    }

    public void setProfileForMan() {
        profile = new ProfileForMen();
        setGender();
        setProfile();
    }

    @Override
    public void setProfileForWoman() {
    }
}
