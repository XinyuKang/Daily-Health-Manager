package ui;

import Assessment.HealthAssessment;
import ProfileInfo.Profile;
import ProfileInfo.ProfileForMen;
import ProfileInfo.ProfileForWomen;
import com.sun.javafx.logging.JFRInputEvent;
import plans.User;
import plans.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class HealthManager extends Subject{

    private Scanner scanner = new Scanner(System.in);
    private User user;
    private List<User> users = new ArrayList<>();
    private String gender;
    private int choice;
    private Habit habit = new Habit();
    private HealthAssessment ha;
    private Profile profile;


    public HealthManager() throws IOException {
        clearHistory();
        start();
        int day=1;
        while(true) {
            System.out.println("day:"+day);
            if(day>=2){askUserIdentity();}
            improve();
            askNextStep();
            askUpdate();

            day = day +1;
        }
    }

    private void resetHabitTable() {
        for (int i = 0; i<=5; i++) {
            habit.getHabitTable().getModel().setValueAt(false, i, 2);
        }
    }

    public void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
            user.setHealthManager(this);
        }
    }

    private void askUserIdentity() throws IOException {
        System.out.println("Choose: ");
        System.out.println("(1) Continue yesterday's account");
//        System.out.println("(2) Change to another existing account");
        System.out.println("(2) Create a new account");
        int choice = scanner.nextInt();
        if (choice == 1){ }
//        else if (choice == 2){
//            changeToAnotherAccount(); }
            else if (choice == 2){
            new HealthManager();
        }
    }

//    private void changeToAnotherAccount() throws IOException {
//        System.out.println("Which account do you want to change to? Enter the account's name: ");
//        String name = scanner.nextLine();
//        scanner.nextInt();
//        for (User u: users){
//            if(u.getProfile().getNameObject().getName().equals(name)){
//                user = u;
//            } else{
//                System.out.println("No such existing account, please create a new one!");
//                new HealthManager();
//            }
//        }
//    }


    // REQUIRES: gender is either female or male;
    //           age should be an integer
    //           height should be in meters
    //           weight should be in kilograms
    //MODIFIES: this, person
    //EFFECTS: set basic information of a given person
    //         assess the person's health condition and give out a health index
    private void start() throws IOException {
        System.out.println("What's your gender?(enter 'male' or 'female')");
        gender = scanner.nextLine();
        if (gender.equals("male")){
            System.out.println("What is your recent health aim? choose one below:");
            System.out.println("(1) lose weight");
            System.out.println("(2) add muscle");
            int choice = scanner.nextInt();
            if (choice == 1){
                user = new WeightLoser();
            } else if (choice == 2){
                user = new MuscleAdder();
            }
            //ProfileForMen profile = new ProfileForMen();
            profile = new ProfileForMen();
//            profile.addUser(user);
            profile.setProfileForMan();
//            user.addProfile(profile);
//            ha = new HealthAssessment(user.getProfile());
//            addUser(user);
//            addObserver(profile);
        } else if (gender.equals("female")){
            System.out.println("What is your recent health aim? choose one below:");
            System.out.println("(1) lose weight");
            System.out.println("(2) add muscle");
            System.out.println("(3) build flexibility");
            System.out.println("(4) pregnant health keeping");
            int choice = scanner.nextInt();
            if (choice == 1){
                user = new WeightLoser();
            } else if (choice == 2){
                user = new MuscleAdder();
            } else if (choice == 3){
                //woman = new FlexibilityBuilder();
            } else if (choice == 4){
                //woman = new PregnantWoman();
            }
            profile = new ProfileForWomen();
            profile.setProfileForWoman();
        }
        profile.addUser(user);
        user.addProfile(profile);
        ha = new HealthAssessment(user.getProfile());
        addUser(user);
        addObserver(profile);
        addObserver(ha.getHealthHistory());
    }


    //MODIFIES: foodCLog, exerciseLog, habitTable
    //EFFECTS: react to the person's choice to improve health
    private void improve() throws IOException {
        System.out.println("What do you want to record?");
        System.out.println("(1) Record food or make diet plans");
        System.out.println("(2) Record exercise");
        System.out.println("(3) Keep track of daily healthy habits");
        System.out.println("Please select your choice(enter 1,2,or 3):");
        choice = scanner.nextInt();
        System.out.println("Your choice is: "+ choice);
            if (choice == 1) {
                user.diet(ha.basicMetabolism());
            } else if (choice == 2) {
                user.exercise();
            } else if (choice == 3) {
                resetHabitTable();
                habit.checkHabit();
            }
    }


    //MODIFIES: foodCLog, exerciseLog, habitTable
    //EFFECTS: after the previous choice, react to the person's next choice
    private void askNextStep() throws IOException {
        System.out.println("Wanna keep on doing this or change to another subject?");
        System.out.println("(1) Continue this");
        System.out.println("(2) Change to another");
        System.out.println("(3) That's enough for today!");

        System.out.println("Please make a choice(enter 1,2,or 3):");
        int anotherChoice = scanner.nextInt();
        System.out.println("Your choice is :"+anotherChoice);
        if (anotherChoice == 1){
            continueThis();
        } else if (anotherChoice == 2) {
            improve();
        } else if (anotherChoice == 3){
            return;
        }
        askNextStep();
    }


    //MODIFIES: foodCLog, exerciseLog, habitTable
    //EFFECTS: continue to record the same thing
    private void continueThis() throws IOException {
            if (choice == 1) {
                user.diet(ha.basicMetabolism());
            } else if (choice == 2) {
                user.exercise();
            } else if (choice == 3) {
                habit.checkHabit();
            }
    }

    private void askUpdate() throws IOException {
        System.out.println("Congratulations! You've finished your health management today!");
        System.out.println("Do you want to update your health assessment to record new body evaluations?");
        System.out.println("(1) yes (2) no, call it a day");
        System.out.println("Your choice is: ");
        int choice = scanner.nextInt();
        if (choice == 1){
                user.getProfile().updateProfile();
                ha = new HealthAssessment(user.getProfile());
                notifyObserver();
            System.out.println("Have you made any progress? Stick to your plan! A new day begins!");
        } else if (choice == 2){
            System.out.println("Great! Stick to your plan! A new day begins!");
        }
    }

    private void clearHistory() throws FileNotFoundException {
        File historyFile = new File("HealthAssessmentHistory.txt");
        PrintWriter writer = new PrintWriter(historyFile);
        writer.print("");
        writer.close();
    }
}
