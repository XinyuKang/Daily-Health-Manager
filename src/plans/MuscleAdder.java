package plans;

import ui.HealthManager;

import java.io.IOException;

public class MuscleAdder extends WorkoutManAndWoman{

    private ExercisePlanForMuscleAdder exercisePlan = new ExercisePlanForMuscleAdder();
    private double minIntake;
    private double maxIntake;
    private double ca;

    @Override
    public void exercise() throws IOException {
        exercisePlan.recordCConsumed();
    }

    @Override
    public void diet(double cb) {
        minIntake = cb + 250;
        maxIntake = cb + 350;
        System.out.println("Your minimal calories intake today is: "+ minIntake+"; maximal intake is: "+maxIntake);
        if (c<minIntake){
            foodCLog.recordNew();
            c = c + foodCLog.getNewAdded();
            cl = minIntake - c;
            if (cl>=0) {
                System.out.println("You still have " + cl + " calories' food to eat in order to meet the minimum calories intake for muscle-adding");
            } else if (cl<0){
                double ce = -cl;
                if (0<=ce && ce<100) {
                    ca = 100-ce;
                    System.out.println("You have exceeded minimum intake by " + ce + " calories, feel free to eat more food less than "+ca+" calories");
                } else if (ce>=100){
                    double negca = -ca;
                    System.out.println("You have exceeded maximum intake by "+negca+" calories, better stop eating and get more weight-lifting");
                }
            }
        } else if (c>=maxIntake){
            double ce = c - maxIntake;
            System.out.println("You have exceeded maximum intake by "+ce+" calories, better stop eating and get more weight-lifting");
        }
    }
}
