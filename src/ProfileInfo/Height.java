package ProfileInfo;

import exceptions.NonpositiveException;
import exceptions.NotMetersException;

import java.util.Scanner;

public class Height{

    Scanner scanner = new Scanner(System.in);
    private double height = 0;
    private boolean whetherSetHeightAgain = true;

    //EFFECTS: return height of the person
    public double getHeight(){
        return height;
    }

    //MODIFIES: this
    //EFFECTS: set height of the person to given height
    public void setHeight() throws NotMetersException, NonpositiveException {
        height = scanner.nextDouble();
        if (height>2.72){
            throw new NotMetersException();
        } else if (height<=0){
            throw new NonpositiveException();
        }
    }

    public void setProfileHeight() {
        //System.out.println("Please enter your height (in meters)");
//        height = scanner.nextDouble();
        while (whetherSetHeightAgain) {
            try {
                setHeight();
                whetherSetHeightAgain = false;
            } catch (NotMetersException e) {
                System.out.println("Cannot input height that's not in meters!");
                System.out.println("Please renter an appropriate height: ");
            } catch (NonpositiveException e) {
                System.out.println("Cannot input non-positive height!");
                System.out.println("Please renter a valid height: ");
            } finally {
                System.out.println("Record height successfully");
            }
        }
    }

    public void setWhetherSetHeightAgain(boolean b){
        whetherSetHeightAgain = b;
    }
}
