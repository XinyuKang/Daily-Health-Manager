package ProfileInfo;

import exceptions.NonpositiveException;

import java.util.Scanner;

public class Age{

    Scanner scanner = new Scanner(System.in);
    protected boolean whetherSetAgeAgain = true;
    private int age = 0;


    //EFFECTS: return age of the person
    public int getAge(){
        return age;
    }

    //MODIFIES: this
    //EFFECTS: set age of the person to given age
    public void setAge() throws NonpositiveException {
        age = scanner.nextInt();
        if (age <= 0){
            throw new NonpositiveException();
        }
    }

    public void setProfileAge() {
        //System.out.println("What's your age?");
//        age = scanner.nextInt();
        while (whetherSetAgeAgain) {
            try {
                setAge();
                whetherSetAgeAgain = false;
            } catch (NonpositiveException e) {
                System.out.println("Cannot input non-positive age!");
                System.out.println("Please renter a valid age: ");
            } finally {
                System.out.println("Record age successfully");
            }
        }
    }

    public void setWhetherSetAgeAgain(boolean b){
        whetherSetAgeAgain = b;
    }
}
