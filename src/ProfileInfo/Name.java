package ProfileInfo;

import java.util.Scanner;

public class Name{

    Scanner scanner = new Scanner(System.in);
    private String name;

    //EFFECTS: return name of the person
    public String getName(){
        return name;
    }

    //MODIFIES: this
    //EFFECTS: set name of the person to given name
    public void setName(String name){
        this.name = name;
    }

    public void setProfileName() {
        //System.out.println("Please enter your name:");
        name = scanner.nextLine();
        setName(name);
    }
}
