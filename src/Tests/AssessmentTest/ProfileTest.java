//package Tests.AssessmentTest;
//
//import ProfileInfo.Profile;
//import ProfileInfo.ProfileForMen;
//import exceptions.NonpositiveException;
//import exceptions.NotKilogramException;
//import exceptions.NotMetersException;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public abstract class ProfileTest {
//    protected Profile newPerson = new ProfileForMen();;
//
//
//    @Test
//    public void testAgeNegativeException(){
//        try{
//        newPerson.getAgeObject().setAge(-19);
//        fail("Expect NonpositiveException but failed to throw!");
//        newPerson.getHeightObject().setHeight(1.72);
//        newPerson.getWeightObject().setWeight(56);
//        } catch (NotMetersException e){
//            fail("Not expect a NotMetersException");
//        } catch (NotKilogramException e){
//            fail("Not expect a NotKilogramException");
//        } catch(NonpositiveException e){ }
//        assertTrue(newPerson.getAgeObject().getAge()!= -19);
//        assertTrue(newPerson.getHeightObject().getHeight()!=1.72);
//        assertTrue(newPerson.getWeightObject().getWeight()!=56);
//    }
//
//    @Test
//    public void testSetHeightNegativeException(){
//        try {
//            newPerson.getAgeObject().setAge(19);
//            newPerson.getHeightObject().setHeight(-1.72);
//            fail("Expect NonpositiveException but failed to throw!");
//            newPerson.getWeightObject().setWeight(55);
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        } catch (NonpositiveException e) { }
//        assertEquals(19, newPerson.getAgeObject().getAge());
//        assertTrue(newPerson.getHeightObject().getHeight()!= -1.72);
//        assertTrue(newPerson.getWeightObject().getWeight()!=55);
//    }
//
//    @Test
//    public void testSetWeightNegativeException(){
//        try {
//            newPerson.getAgeObject().setAge(19);
//            newPerson.getHeightObject().setHeight(1.72);
//            newPerson.getWeightObject().setWeight(-55);
//            fail("Expect NonpositiveException but failed to throw!");
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        } catch (NonpositiveException e) { }
//        assertEquals(19, newPerson.getAgeObject().getAge());
//        assertEquals(1.72,newPerson.getHeightObject().getHeight());
//        assertTrue(newPerson.getWeightObject().getWeight()!= -55);
//    }
//
//    @Test
//    public void testSetHeightNotMetersException(){
//        try {
//            newPerson.getAgeObject().setAge(19);
//            newPerson.getHeightObject().setHeight(3);
//            fail("Expect NotMetersException but failed to throw!");
//            newPerson.getWeightObject().setWeight(55);
//        } catch (NotMetersException e) {
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }
//        assertEquals(19, newPerson.getAgeObject().getAge());
//        assertTrue(newPerson.getHeightObject().getHeight()!= 3);
//        assertTrue(newPerson.getWeightObject().getWeight()!= 55);
//    }
//
//    @Test
//    public void testSetWeightNotKilogramsException(){
//        try {
//            newPerson.getAgeObject().setAge(19);
//            newPerson.getHeightObject().setHeight(1.72);
//            newPerson.getWeightObject().setWeight(700);
//            fail("Expect NotKilogramException but failed to throw!");
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NotKilogramException e) {
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }
//        assertEquals(19, newPerson.getAgeObject().getAge());
//        assertEquals(1.72,newPerson.getHeightObject().getHeight());
//        assertTrue(newPerson.getWeightObject().getWeight()!= 700);
//    }
//
//    @Test
//    public void testNonpositiveAndNotMetersException(){
//        try {
//            newPerson.getAgeObject().setAge(-19);
//            fail("Expect NonpositiveException but failed to throw!");
//        }catch (NonpositiveException e) {}
//        try{
//            newPerson.getHeightObject().setHeight(3);
//            fail("Expect NotMetersException but failed to throw!");
//        } catch (NotMetersException e) {
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }try {
//            newPerson.getWeightObject().setWeight(55);
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        }
//        assertTrue(newPerson.getAgeObject().getAge()!= -19);
//        assertTrue(newPerson.getHeightObject().getHeight()!= 3);
//        assertEquals(55,newPerson.getWeightObject().getWeight());
//    }
//
//    @Test
//    public void testNonpositiveAndNotKilogramException(){
//        try {
//            newPerson.getAgeObject().setAge(-19);
//            fail("Expect NonpositiveException but failed to throw!");
//        }catch (NonpositiveException e) {}
//        try{
//            newPerson.getHeightObject().setHeight(1.72);
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }try {
//            newPerson.getWeightObject().setWeight(700);
//            fail("Expect NotKilogramException but failed to throw!");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        } catch (NotKilogramException e) {
//        }
//        assertTrue(newPerson.getAgeObject().getAge()!= -19);
//        assertTrue(newPerson.getWeightObject().getWeight()!= 700);
//        assertEquals(1.72,newPerson.getHeightObject().getHeight());
//    }
//
//    @Test
//    public void testNonpositiveAndNotKilogramAndNotMetersException(){
//        try {
//            newPerson.getAgeObject().setAge(-19);
//            fail("Expect NonpositiveException but failed to throw!");
//        }catch (NonpositiveException e) {}
//        try{
//            newPerson.getHeightObject().setHeight(3);
//            fail("Expect NotMetersException but failed to throw!");
//        } catch (NotMetersException e) {
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }try {
//            newPerson.getWeightObject().setWeight(700);
//            fail("Expect NotKilogramException but failed to throw!");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        } catch (NotKilogramException e) {
//        }
//        assertTrue(newPerson.getAgeObject().getAge()!= -19);
//        assertTrue(newPerson.getWeightObject().getWeight()!= 700);
//        assertTrue(newPerson.getHeightObject().getHeight()!= 3);
//    }
//
//    @Test
//    public void testNotKilogramAndNotMetersException(){
//        try {
//            newPerson.getAgeObject().setAge(19);
//        }catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }
//        try{
//            newPerson.getHeightObject().setHeight(3);
//            fail("Expect NotMetersException but failed to throw!");
//        } catch (NotMetersException e) {
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }try {
//            newPerson.getWeightObject().setWeight(700);
//            fail("Expect NotKilogramException but failed to throw!");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        } catch (NotKilogramException e) {
//        }
//        assertTrue(newPerson.getAgeObject().getAge()== 19);
//        assertTrue(newPerson.getWeightObject().getWeight()!= 700);
//        assertTrue(newPerson.getHeightObject().getHeight()!= 3);
//    }
//
//    @Test
//    public void testNoExceptionThrown(){
//        try {
//            newPerson.getAgeObject().setAge(19);
//        }catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }
//        try{
//            newPerson.getHeightObject().setHeight(1.72);
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }try {
//            newPerson.getWeightObject().setWeight(70);
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        }
//        assertTrue(newPerson.getAgeObject().getAge()== 19);
//        assertTrue(newPerson.getWeightObject().getWeight()== 70);
//        assertTrue(newPerson.getHeightObject().getHeight()== 1.72);
//    }
//
//    @Test
//    public abstract void testGetGender();
//
//
//    @Test
//    public abstract void testSetName();
//}
