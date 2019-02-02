package plans;

import models.ExerciseLogForWeightLoser;

public class ExercisePlanForWeightLoser {

    private ExerciseLogForWeightLoser exerciseLog = new ExerciseLogForWeightLoser(this);
    private double c = 0;
    private double cPerHour;


    //MODIFIES: this, exerciseLog
    //EFFECTS: record total calories consumed by exercises
    public void recordCConsumed(){
        exerciseLog.recordExercise();
    }

    //TODO: add more exercises
    // REQUIRES: exercises and hours are not null
    //           new exercise is in the exercises database
    //EFFECTS: return total calories consumed after entering a new exercise
    public double increaseC(){
        String newExercise = exerciseLog.getNewExercise();
        double newHour = exerciseLog.getExerciseAndTime().get(newExercise);
        if (newExercise.equals("swimming")){
            cPerHour = 800;
        } else if (newExercise.equals("running")){
            cPerHour = 600;
        } else if (newExercise.equals("dancing")){
            cPerHour = 600;
        } else if (newExercise.equals("bicycling")) {
            cPerHour = 500;
        } else if (newExercise.equals("rope-skipping")) {
            cPerHour = 500;
        } else if (newExercise.equals("aerobic gymnastics")) {
            cPerHour = 412;
        } else if (newExercise.equals("HIIT")) {
            cPerHour = 516;
        } else if (newExercise.equals("SPINNING")) {
            cPerHour = 474;
        }
        c = c + cPerHour*newHour;
        return c;
    }
}
