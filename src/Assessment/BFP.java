package Assessment;

import ProfileInfo.Profile;

public class BFP {
    private int BFPscore;
    private double BFP;
    private BMI BMI;
    Profile person;

    public BFP(Profile person, BMI BMI){
        this.person = person;
        this.BMI = BMI;
    }

    //MODIFIES: this
    //EFFECTS: count the peron's body fat percentage and give out a BFPscore
    public void assessBFP(){
        String comment = "";
        if (person.getGender().equals("male")){
            int lowCutoff = 15;
            int highCutoff = 18;
            int highScore = 50;
            int lowScore = 30;
            double param = -5.4-10.8;
            comment = generateAndCommentBFPAndBFPScore(lowCutoff, highCutoff, highScore, lowScore, param);
        }
        else if (person.getGender().equals("female")){
            int lowCutoff = 25;
            int highCutoff = 28;
            int highScore = 50;
            int lowScore = 30;
            double param = -5.4;
            comment = generateAndCommentBFPAndBFPScore(lowCutoff, highCutoff, highScore, lowScore, param);
        }
        System.out.println("Your body fat percentage is "+BFP+": "+comment);
    }

    public String generateAndCommentBFPAndBFPScore(int lowCutoff, int highCutoff, int highScore, int lowScore, double param) {
        String comment = "";
        BFP = 1.2*BMI.getBMI()+0.23*person.getAgeObject().getAge()+param;
        if(lowCutoff<=BFP&&BFP<=highCutoff){
            comment = "normal";
            BFPscore=highScore;
        } else if (BFP<lowCutoff){
            comment = "lower than normal";
            BFPscore=lowScore;
        }
        else if (BFP>highCutoff) {
            comment = "higher than normal";
            BFPscore=lowScore;
        }
        return comment;
    }

    //EFFECTS: return BFPscore
    public int getBFPscore(){
        return BFPscore;
    }

    //EFFECTS: return BFP
    public double getBFP(){
        return BFP;
    }
}
