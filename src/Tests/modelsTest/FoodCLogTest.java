//package Tests.modelsTest;
//
//import models.FoodCLog;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class FoodCLogTest {
//    private FoodCLog newFoodCLog;
//
//    @BeforeEach
//    public void setUp(){
//        newFoodCLog = new FoodCLog();
//    }
//
//    @Test
//    public void testRecordOne(){
//        assertEquals(0,newFoodCLog.size());
//        newFoodCLog.recordNew();
//        assertEquals(1,newFoodCLog.size());
//        assertEquals(newFoodCLog.newCalories,newFoodCLog.getNewAdded());
//    }
//
//    @Test
//    public void testRecordLots(){
//        assertTrue(newFoodCLog.size() == 0);
//        for (int i=1;i<=10;i++){
//            newFoodCLog.recordNew();
//            assertEquals(i,newFoodCLog.size());
//            assertEquals(newFoodCLog.newCalories,newFoodCLog.getNewAdded());
//        }
//    }
//
//
//    @Test
//    public void testGetNewAddedOne(){
//        newFoodCLog.recordNew();
//        assertEquals(newFoodCLog.newCalories,newFoodCLog.getNewAdded());
//    }
//
//    @Test
//    public void testGetNewAddedLots(){
//        for(int i=1;i<=10;i++){
//            newFoodCLog.recordNew();
//            assertEquals(newFoodCLog.newCalories,newFoodCLog.getNewAdded());
//        }
//    }
//
//    @Test
//    public void testSize(){
//        assertEquals(0,newFoodCLog.size());
//        for(int i=1;i<=10;i++){
//            newFoodCLog.recordNew();
//            assertEquals(i,newFoodCLog.size());
//        }
//    }
//
//
//}
