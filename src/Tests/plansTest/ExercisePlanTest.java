//package Tests.plansTest;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import plans.ExercisePlanForMuscleAdder;
//import plans.ExercisePlanForWeightLoser;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ExercisePlanTest {
//
//    private ExercisePlanForWeightLoser exercisePlanForWeightLoser;
//    private ExercisePlanForMuscleAdder exercisePlanForMuscleAdder;
//
//    @BeforeEach
//    public void setUp(){
//
//        exercisePlanForWeightLoser = new ExercisePlanForWeightLoser();
//        exercisePlanForMuscleAdder = new ExercisePlanForMuscleAdder();
//    }
//
//    @Test
//    public void testIncreaseCSwimming(){
//        exercisePlanForWeightLoser.getExerciseLog().getExercises().add("swimming");
//        exercisePlanForWeightLoser.getExerciseLog().getHours().add(3.2);
//        assertEquals(2560, exercisePlanForWeightLoser.increaseC());
//    }
//
//    @Test
//    public void testIncreaseSwimmingRunningDancingBicyclingAndRopeSkipping(){
//        exercisePlanForWeightLoser.getExerciseLog().getExercises().add("swimming");
//        exercisePlanForWeightLoser.getExerciseLog().getHours().add(3.2);
//        assertEquals(2560, exercisePlanForWeightLoser.increaseC());
//        exercisePlanForWeightLoser.getExerciseLog().getExercises().add("running");
//        exercisePlanForWeightLoser.getExerciseLog().getHours().add(0.5);
//        assertEquals(2560+300, exercisePlanForWeightLoser.increaseC());
//        exercisePlanForWeightLoser.getExerciseLog().getExercises().add("dancing");
//        exercisePlanForWeightLoser.getExerciseLog().getHours().add(0.2);
//        assertEquals(2560+300+120, exercisePlanForWeightLoser.increaseC());
//        exercisePlanForWeightLoser.getExerciseLog().getExercises().add("bicycling");
//        exercisePlanForWeightLoser.getExerciseLog().getHours().add(4.3);
//        assertEquals(2560+300+120+2150, exercisePlanForWeightLoser.increaseC());
//        exercisePlanForWeightLoser.getExerciseLog().getExercises().add("rope-skipping");
//        exercisePlanForWeightLoser.getExerciseLog().getHours().add(2.0);
//        assertEquals(2560+300+120+2150+1000, exercisePlanForWeightLoser.increaseC());
//    }
//
//    @Test
//    public void testIncreaseLots(){
//        exercisePlanForMuscleAdder.getExerciseLog().getExercises().add("flat bench press");
//        exercisePlanForMuscleAdder.getExerciseLog().getExercises().add("row");
//        exercisePlanForMuscleAdder.getExerciseLog().getExercises().add("flat bench press");
//        exercisePlanForMuscleAdder.getExerciseLog().getExercises().add("lateral raises");
//        exercisePlanForMuscleAdder.getExerciseLog().getExercises().add("abs");
//        assertEquals(68,exercisePlanForMuscleAdder.increaseC());
//    }
//}
