/*
package Tests.AssessmentTest;

import Assessment.*;
import ProfileInfo.Profile;
import ProfileInfo.ProfileForMen;
import ProfileInfo.ProfileForWomen;
import exceptions.NonpositiveException;
import exceptions.NotKilogramException;
import exceptions.NotMetersException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthAssessmentTest {
    private HealthAssessment ha;
    private Profile newPerson;



    @Test
    public void testConstructor() throws IOException, NotMetersException, NonpositiveException, NotKilogramException {
        newPerson = new ProfileForWomen();
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        newPerson.setHeight(1.65);
        newPerson.setWeight(56);
        ha = new HealthAssessment(newPerson);
        assertEquals(newPerson,ha.getPerson());
        assertEquals(ha.getBMIscore()+ha.getBFPscore(), ha.getHealthIndex());
    }


    @Test
    public void testAssessBMIUnder() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(36);
        newPerson.setHeight(1.5);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
            //todo
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(16,ha.getBMI());
        assertEquals(40,ha.getBMIscore());
    }

    @Test
    public void testAssessBMIEqualEighteenPointFive() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(36.26);
        newPerson.setHeight(1.4);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(18.5,ha.getBMI());
        assertEquals(50,ha.getBMIscore());
    }

    @Test
    public void testAssessBMINormal() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(57.8);
        newPerson.setHeight(1.7);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(20,ha.getBMI());
        assertEquals(50,ha.getBMIscore());
    }

    @Test
    public void testAssessBMIEqualTwentyFourPointNine() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(56.025);
        newPerson.setHeight(1.5);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(24.9,ha.getBMI());
        assertEquals(50,ha.getBMIscore());
    }

    @Test
    public void testAssessBMIOver() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(58.5);
        newPerson.setHeight(1.5);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(26,ha.getBMI());
        assertEquals(40,ha.getBMIscore());
    }

    @Test
    public void testAssessBMIEqualThirty() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(67.5);
        newPerson.setHeight(1.5);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(30,ha.getBMI());
        assertEquals(30,ha.getBMIscore());
    }

    @Test
    public void testAssessBMIObese() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(78.75);
        newPerson.setHeight(1.5);
        try {
            newPerson.setAge(19);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.assessBMI();
        assertEquals(35,ha.getBMI());
        assertEquals(30,ha.getBMIscore());
    }

    @Test
    public void testAssessBFPMaleNormal() throws IOException {
        newPerson = new ProfileForMen();
        try {
            newPerson.setAge(20);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(23);
        ha.assessBFP();
        assertEquals(15.999999999999996,ha.getBFP());
        assertEquals(50,ha.getBFPscore());
    }

    @Test
    public void testAssessBFPMaleLower() throws IOException {
        newPerson = new ProfileForMen();
        try {
            newPerson.setAge(20);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(20);
        ha.assessBFP();
        assertEquals(12.400000000000002,ha.getBFP());
        assertEquals(30,ha.getBFPscore());
    }

    @Test
    public void testAssessBFPMaleHigher() throws IOException {
        newPerson = new ProfileForMen();
        try {
            newPerson.setAge(20);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(30);
        ha.assessBFP();
        assertEquals(24.400000000000002,ha.getBFP());
        assertEquals(30,ha.getBFPscore());
    }

    @Test
    public void testAssessBFPFemaleNormal() throws IOException {
        newPerson = new ProfileForWomen();
        try {
            newPerson.setAge(20);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(23);
        ha.assessBFP();
        assertEquals(26.799999999999997,ha.getBFP());
        assertEquals(50,ha.getBFPscore());
    }

    @Test
    public void testAssessBFPFemaleLower() throws IOException {
        newPerson = new ProfileForWomen();
        try {
            newPerson.setAge(30);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(15);
        ha.assessBFP();
        assertEquals(19.5,ha.getBFP());
        assertEquals(30,ha.getBFPscore());
    }

    @Test
    public void testAssessBFPFemaleHigher() throws IOException {
        newPerson = new ProfileForMen();
        try {
            newPerson.setAge(20);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(40);
        ha.assessBFP();
        assertEquals(36.400000000000006,ha.getBFP());
        assertEquals(30,ha.getBFPscore());
    }

    @Test
    public void testBasicMetabolism() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(60);
        newPerson.setHeight(1.75);
        try {
            newPerson.setAge(30);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        assertEquals(1091.8335000000002,ha.basicMetabolism());
    }

    @Test
    public void testSetBMI() throws IOException, NotKilogramException, NonpositiveException, NotMetersException {
        newPerson = new ProfileForWomen();
        newPerson.setWeight(60);
        newPerson.setHeight(1.75);
        try {
            newPerson.setAge(30);
        } catch (NonpositiveException e) {
            e.printStackTrace();
        }
        ha = new HealthAssessment(newPerson);
        ha.setBMI(20);
        assertEquals(20,ha.getBMI());
        ha.setBMI(15.7);
        assertEquals(15.7,ha.getBMI());
    }


}
*/
