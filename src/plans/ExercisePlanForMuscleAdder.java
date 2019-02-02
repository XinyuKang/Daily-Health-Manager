package plans;

import models.ExerciseLogForMuscleAdder;

import java.io.IOException;

public class ExercisePlanForMuscleAdder {
    public ExerciseLogForMuscleAdder exerciseLog = new ExerciseLogForMuscleAdder(this);
    private double c = 0;
    private int cPerGroup;



    //MODIFIES: this, exerciseLog
    //EFFECTS: record total calories consumed by exercises
    public void recordCConsumed() throws IOException {
        exerciseLog.recordExercise();
    }

    //TODO: add more exercises
    // REQUIRES: exercises and hours are not null
    //           new exercise is in the exercises database
    //EFFECTS: return total calories consumed after entering a new exercise
    public double increaseC(){
        String newExercise = exerciseLog.getAddedExercise();
        int grounpNumber = exerciseLog.getAddedGroupNumber();
        if (newExercise.equals("Barbell Squat")){
            cPerGroup = 10;
        } else if (newExercise.equals("Axe Hold")){
            cPerGroup = 10;
        } else if (newExercise.equals("Biceps Press Narrow Grip")){
            cPerGroup = 19;
        } else if (newExercise.equals("Biceps Curls With SZ-bar")) {
            cPerGroup = 20;
        } else if (newExercise.equals("Deadhang")) {
            cPerGroup = 28;
        } else if (newExercise.equals("Dumbbell Incline Curl")) {
            cPerGroup = 28;
        } else if (newExercise.equals("Hammercurls")) {
            cPerGroup = 30;
        } else if (newExercise.equals("Military Press")) {
            cPerGroup = 30;
        } else if (newExercise.equals("Pike Push Ups")) {
            cPerGroup = 25;
        } else if (newExercise.equals("Triceps Dips")) {
            cPerGroup = 25;
        } else if (newExercise.equals("Wall Pushup")) {
            cPerGroup = 30;
        } else if (newExercise.equals("Crunches")) {
            cPerGroup = 10;
        }else if (newExercise.equals("Hollow Hold")) {
            cPerGroup = 10;
        }else if (newExercise.equals("Burpees")) {
            cPerGroup = 10;
        }else if (newExercise.equals("Butterfly")) {
            cPerGroup = 10;
        }
        c = c + cPerGroup*grounpNumber;
        return c;
    }

    //EFFECTS: return exerciseLog
    public ExerciseLogForMuscleAdder getExerciseLog(){
        return exerciseLog;
    }
}
