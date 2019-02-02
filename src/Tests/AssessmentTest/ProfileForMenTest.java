//package Tests.AssessmentTest;
//
//
//import exceptions.NonpositiveException;
//import exceptions.NotKilogramException;
//import exceptions.NotMetersException;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class ProfileForMenTest extends ProfileTest {
//
//
//    public void setUp(){
//        try {
//            newPerson.getWeightObject().setWeight(70);
//            newPerson.getHeightObject().setHeight(1.8);
//            newPerson.getAgeObject().setAge(19);
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }
//        newPerson.getNameObject().setName("John");
//    }
//
//    @Override
//    @Test
//    public void testGetGender(){
//        newPerson.setGender("male");
//        assertEquals("male",newPerson.getGender());
//    }
//
//    @Override
//    @Test
//    public void testSetName(){
//        newPerson.getNameObject().setName("Jackie");
//        assertEquals("Jackie",newPerson.getNameObject().getName());
//    }
//
//}
