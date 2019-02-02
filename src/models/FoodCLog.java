package models;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodCLog {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Double> foodcs = new ArrayList<>();
    public double newCalories;


    // REQUIRES: input new food calories is non-negative
    //MODIFIES: this, foodcs
    //EFFECTS: add new food calories to foodCLog
    public void recordNew(){
        System.out.println("Input new food calories: ");
        newCalories = scanner.nextDouble();
        foodcs.add(newCalories);
    }


    //REQUIRES: foodcs has at least 1 item
    //EFFECTS: return the latest added food calories
    public double getNewAdded(){
        return foodcs.get(foodcs.size()-1);
    }



    //EFFECTS: return number of items in the set
    public int size(){
        return foodcs.size();
    }
}
