package Assessment;

import ProfileInfo.Profile;

import java.io.IOException;

public class HealthAssessment{

    private Profile person;
    private int healthIndex;
    private BMI BMI;
    private BFP BFP;
    private HealthHistory healthHistory;

    //REQUIRES: given person is not null
    //EFFECTS: construct Health Assessment, pass a person, count health index
    public HealthAssessment(Profile person) throws IOException {
        BMI = new BMI(person);
        BFP = new BFP(person,BMI);
        healthHistory = new HealthHistory();
        this.person =person;
        assessBMI();
        assessBFP();
        printHealthAssessmentReport();
        saveAndLoadHealthAssessmentHistory(person);
    }

    private void printHealthAssessmentReport() {
        double basicMetabolism = basicMetabolism();
        System.out.println("Your basic metabolism is: "+ basicMetabolism);
        healthIndex = BMI.getBMIscore() + BFP.getBFPscore();
        System.out.println("Overall, your health index is: "+healthIndex+" (out of 100)");
    }

    private void saveAndLoadHealthAssessmentHistory(Profile person) throws IOException {
        saveNewHealthAssessment("HealthAssessmentHistory.txt", person, BMI.getBMI(), BFP.getBFP(), healthIndex);
        System.out.println("Here's the track of your health changes");
        loadHealthAssessmentHistory("HealthAssessmentHistory.txt");
    }

    private void loadHealthAssessmentHistory(String readFileName) throws IOException {
        healthHistory.loadHealthAssessmentHistory(readFileName);
    }

    private void saveNewHealthAssessment(String saveFileName, Profile person, double BMI, double BFP, int healthIndex) throws IOException {
        healthHistory.saveNewHealthAssessment(saveFileName,person,BMI,BFP,healthIndex);
    }


    //MODIFIES: this
    //EFFECTS: count the given person's BMI and give out a BMIscore
    private void assessBMI() {
        BMI.assessBMI();
    }


    //MODIFIES: this
    //EFFECTS: count the peron's body fat percentage and give out a BFPscore
    private void assessBFP(){
        BFP.assessBFP();
    }

    private String generateAndCommentBFPAndBFPScore(int lowCutoff, int highCutoff, int highScore, int lowScore, double param) {
        return BFP.generateAndCommentBFPAndBFPScore(lowCutoff,highCutoff,highScore,lowScore,param);
    }

    //MODIFIES: this
    //EFFECTS: return the person's basic metabolism
    public double basicMetabolism(){
        return 655.096 + 9.563*person.getWeightObject().getWeight()+1.85*person.getHeightObject().getHeight()-4.676*person.getAgeObject().getAge();
    }


    //EFFECTS: return the person
    public Profile getPerson(){
        return person;
    }

    public HealthHistory getHealthHistory() {
        return healthHistory;
    }
}



