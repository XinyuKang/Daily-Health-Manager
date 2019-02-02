package ProfileInfo;

import Assessment.Observer;
import exceptions.NonpositiveException;
import exceptions.NotKilogramException;
import exceptions.NotMetersException;
import plans.User;
import ui.Subject;


public abstract class Profile implements Observer {

    protected String gender;
    protected Height height = new Height();
    protected Weight weight = new Weight();
    protected Age age = new Age();
    protected Name name = new Name();
    protected Profile profile;
    protected User user;
    protected int numHA = 1;


    public void setProfile() {
        System.out.println("Please enter your name:");
        name.setProfileName();
        System.out.println("What's your age?");
        age.setProfileAge();
        System.out.println("Please enter your height (in meters)");
        height.setProfileHeight();
        System.out.println("Please enter your weight (in kilograms)");
        weight.setProfileWeight();
    }

    public void updateProfile() {
        age.setWhetherSetAgeAgain(true);
        height.setWhetherSetHeightAgain(true);
        weight.setWhetherSetWeightAgain(true);
        System.out.println("Please enter your new age: ");
        age.setProfileAge();
        System.out.println("Please enter your new height (in meters)");
        height.setProfileHeight();
        System.out.println("Please enter your new weight (in kilograms): ");
        weight.setProfileWeight();
        numHA += 1;
    }

    public void addUser(User user){
        if(user!=this.user){
            this.user = user;
            user.addProfile(this);
        }
    }

    public Profile getProfile(){
        return profile;
    }

    public Height getHeightObject(){
        return height;
    }

    public Weight getWeightObject(){
        return weight;
    }

    //EFFECTS: return gender of the person
    public String getGender() {
        return gender;
    }

    public void setGender(String gender){this.gender = gender;}


    public Age getAgeObject(){
        return age;
    }

    public Name getNameObject(){
        return name;
    }


    //MODIFIES: this
    //EFFECTS: set height of the person to given height
    public void setHeight() throws NotMetersException, NonpositiveException {
        this.height.setHeight();
        }


    //MODIFIES: this
    //EFFECTS: set weight of the person to given weight
    public void setWeight() throws NotKilogramException, NonpositiveException {
        this.weight.setWeight();
    }


    //MODIFIES: this
    //EFFECTS: set age of the person to given age
    public void setAge() throws NonpositiveException {
        this.age.setAge();
    }


    //MODIFIES: this
    //EFFECTS: set name of the person to given name
    public void setName(String name){
        this.name.setName(name);
    }

    public void update(){
        System.out.println("You have made "+numHA+" times of health assessment so far");
    }

    public abstract void setProfileForMan();

    public abstract void setProfileForWoman();
}
