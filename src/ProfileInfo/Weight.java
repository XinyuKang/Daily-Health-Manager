package ProfileInfo;

import exceptions.NonpositiveException;
import exceptions.NotKilogramException;

import java.util.Scanner;

public class Weight{

    Scanner scanner = new Scanner(System.in);
    protected boolean whetherSetWeightAgain = true;
    private double weight = 0;

    //EFFECTS: return weight of the person
    public double getWeight(){
        return weight;
    }

    //MODIFIES: this
    //EFFECTS: set weight of the person to given weight
    public void setWeight() throws NotKilogramException, NonpositiveException {
        weight = scanner.nextDouble();
        if (weight>643){
            throw new NotKilogramException();
        } else if (weight<=0){
            throw new NonpositiveException();
        }
    }

    public void setProfileWeight() {
        //System.out.println("Please enter your weight (in kilograms)");
//        weight = scanner.nextDouble();
        while (whetherSetWeightAgain) {
            try {
                setWeight();
                whetherSetWeightAgain = false;
            } catch (NotKilogramException e) {
                System.out.println("Cannot input weight that's not in kilograms!");
                System.out.println("Please renter an appropriate weight: ");
            } catch (NonpositiveException e) {
                System.out.println("Cannot input non-positive weight!");
                System.out.println("Please renter a valid weight: ");
            } finally {
                System.out.println("Record weight successfully");
            }
        }
    }

    public void setWhetherSetWeightAgain(boolean b){
        whetherSetWeightAgain = b;
    }
}
