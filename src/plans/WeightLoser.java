package plans;

import ui.HealthManager;

public class WeightLoser extends WorkoutManAndWoman {

    private ExercisePlanForWeightLoser exercisePlan = new ExercisePlanForWeightLoser();

    @Override
    public void exercise() {
        exercisePlan.recordCConsumed();
    }


    @Override
    //MODIFIES: this, foodCLog
    //EFFECTS: record total calories of food eaten
    //         remind of the calories budget left
    public void diet(double cb) {
            System.out.println("Your calories budget today is: "+cb);
            if (c<cb){
                foodCLog.recordNew();
                c = c + foodCLog.getNewAdded();
                cl = cb - c;
                if (cl>=0) {
                    System.out.println("You can still have " + cl + " calories' food.");
                } else if (cl<0){
                    double ce = -cl;
                    System.out.println("You have exceeded budget by "+ce+" calories, do exercise to burn calories!");
                }
            } else if (c>=cb){
                double ce = c - cb;
                System.out.println("No more budget, you have exceeded budget by "+ce+" calories, get exercise!");
            }
        }
}
