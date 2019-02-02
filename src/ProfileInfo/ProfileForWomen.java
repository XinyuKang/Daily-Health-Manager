package ProfileInfo;

import ProfileInfo.Profile;

public class ProfileForWomen extends Profile {

    private void setGender(){
        gender = "female";
    }

    @Override
    public void setProfileForMan() {
    }

    public void setProfileForWoman(){
        profile = new ProfileForWomen();
        setGender();
        setProfile();
    }
}
