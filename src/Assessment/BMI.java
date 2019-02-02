package Assessment;

import ProfileInfo.Profile;

public class BMI {
    private int BMIscore;
    private double BMI;
    private Profile person;

    public BMI(Profile person){
        this.person = person;
    }

    //MODIFIES: this
    //EFFECTS: count the given person's BMI and give out a BMIscore
    public void assessBMI() {
        BMI = person.getWeightObject().getWeight()/(person.getHeightObject().getHeight()*person.getHeightObject().getHeight());
        System.out.println("Your BMI is "+BMI);
        if(BMI<18.5){
            System.out.println("You are underweight");
            BMIscore = 40;
        } else if (18.5<=BMI&&BMI<=24.9){
            System.out.println("You have normal weight");
            BMIscore = 50;
        } else if (24.9<BMI && BMI<30){
            System.out.println("Your are overweight");
            BMIscore = 40;
        } else if (BMI>=30){
            System.out.println("You are obese");
            BMIscore = 30;
        }
    }

    //EFFECTS: resturn BMI
    public double getBMI(){
        return BMI;
    }

    //REQUIRES: givenBMI is positive
    //MODIFIES: this
    //EFFECTS: set BMI to a given number
    public void setBMI(double givenBMI){
        this.BMI = givenBMI;
    }

    //EFFECTS: return BMIscore
    public int getBMIscore(){
        return BMIscore;
    }
}
