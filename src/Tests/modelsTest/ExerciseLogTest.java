//package Tests.modelsTest;
//
//import models.ExerciseLogForMuscleAdder;
//import models.ExerciseLogForWeightLoser;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public  class ExerciseLogTest {
//    protected ExerciseLogForMuscleAdder exerciseLog1;
//    protected ExerciseLogForWeightLoser exerciseLog2;
//
//    @BeforeEach
//    public  void setUp(){
//        exerciseLog1 = new ExerciseLogForMuscleAdder();
//        exerciseLog2 = new ExerciseLogForWeightLoser();
//    };
//
//    @Test
//    public void testWLGetAddedExerciseOneItemInList(){
//        exerciseLog2.getExercises().add("running");
//        exerciseLog1.getExercises().add("flat bench press");
//        assertEquals("running",exerciseLog2.getAddedExercise());
//        assertEquals("flat bench press",exerciseLog1.getAddedExercise());
//    }
//
//    @Test
//    public void testWLGetAddedExerciseLotsInList(){
//        exerciseLog2.getExercises().add("running");
//        exerciseLog2.getExercises().add("swimming");
//        exerciseLog2.getExercises().add("dancing");
//        exerciseLog2.getExercises().add("rope-skipping");
//        exerciseLog1.getExercises().add("flat bench press");
//        exerciseLog1.getExercises().add("rows");
//        exerciseLog1.getExercises().add("incline dumbbell press");
//        exerciseLog1.getExercises().add("lat pull-downs");
//        assertEquals("rope-skipping",exerciseLog2.getAddedExercise());
//        assertEquals("lat pull-downs",exerciseLog1.getAddedExercise());
//    }
//
//    @Test
//    public void testGetAddedHourOneItemInList(){
//        exerciseLog2.getHours().add(5.3);
//        assertEquals(5.3,exerciseLog2.getAddedHour());
//    }
//
//    @Test
//    public void testGetAddedHourLotsInList(){
//        exerciseLog2.getHours().add(3.2);
//        exerciseLog2.getHours().add(4.3);
//        exerciseLog2.getHours().add(6.0);
//        exerciseLog2.getHours().add(2.1);
//        assertEquals(2.1,exerciseLog2.getAddedHour());
//    }
//}
