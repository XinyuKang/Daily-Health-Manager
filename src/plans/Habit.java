package plans;


import models.HabitTable;

import javax.swing.*;
import java.util.Scanner;

public class Habit {
    Scanner scanner = new Scanner(System.in);
    HabitTable habitTable = new HabitTable();


    //MODIFIES: this, habitTable
    //EFFECTS: print a habit table showing whether habits are completed
    //         enable the person to complete more
    public void checkHabit(){
        habitTable.pack();
        habitTable.setSize(600,200);
        habitTable.setVisible(true);
        habitTable.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        System.out.println("Check out the table and check the habits completed!");
        //completeMore();
    }

    public HabitTable getHabitTable(){
        return habitTable;
    }

    //REQUIRES: the entered new habit number is within the number of habits in table
    //MODIFIES: this, habitTable
    //EFFECTS: update the habit table according to new habit completed
//    public void completeMore(){
//        System.out.println("What's your new completed habit today?");
//        System.out.println("Please enter the habit number");
//        int newHabitNumber = scanner.nextInt();
//        habitTable.setValueTrue(newHabitNumber-1,2);
//        System.out.println("Habit table has been updated!");
//    }

    //TODO: allow add and remove habits
    /*public void addHabit(String newHabit){
        habitList.add(newHabit);
        System.out.println("Habit "+newHabit+ " added successfully!");
    }

    public void removeHabit(String habit){
        if(habitList.contains(habit)){
            habitList.remove(habit);
            System.out.println("Habit "+habit+" removed from the habit list successfully!");
        } else {
            System.out.println("There's no such habit in the list!");
            System.out.println("Unsuccessful remove");
        }
    }*/
}
