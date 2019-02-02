//package Tests.AssessmentTest;
//
//import ProfileInfo.ProfileForWomen;
//import exceptions.NonpositiveException;
//import exceptions.NotKilogramException;
//import exceptions.NotMetersException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class ProfileForWomenTest extends ProfileTest{
//
//    public void setUp(){
//        newPerson = new ProfileForWomen();
//        try {
//            newPerson.getWeightObject().setWeight(56);
//            newPerson.getHeightObject().setHeight(1.65);
//            newPerson.getAgeObject().setAge(19);
//        } catch (NotMetersException e) {
//            fail("Not expect a NotMetersException");
//        } catch (NotKilogramException e) {
//            fail("Not expect a NotKilogramException");
//        } catch (NonpositiveException e) {
//            fail("Not expect a NonpositiveException");
//        }
//        newPerson.getNameObject().setName("Jackie");
//    }
//
//
//    @Override
//    public void testGetGender() {
//        newPerson.setGender("female");
//        assertEquals("female",newPerson.getGender());
//    }
//
//    @Override
//    public void testSetName() {
//        newPerson.getNameObject().setName("John");
//        assertEquals("John",newPerson.getNameObject().getName());
//    }
//}
