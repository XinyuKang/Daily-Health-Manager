package models;

import plans.ExercisePlanForWeightLoser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExerciseLogForWeightLoser extends JFrame{
    private  ExercisePlanForWeightLoser ep;

    private JFrame frame;
    private JTextField tfInput, tfOutput;
    private HashMap<String,Double> exerciseAndTime = new HashMap<>();
    private String newExercise;
    Scanner scanner = new Scanner (System.in);

    public ExerciseLogForWeightLoser(ExercisePlanForWeightLoser ep){
        this.ep = ep;

        frame = new JFrame("Calories Counter For Weight-loser");
        frame.setLayout(new GridLayout(3, 1, 5, 5));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JButton swimming = new JButton("swimming");
        panel1.add(swimming);
        JButton running = new JButton("running");
        panel1.add(running);
        JButton dancing = new JButton("dancing");
        panel1.add(dancing);
        JButton bicycling = new JButton("bicycling");
        panel1.add(bicycling);
        JButton ropeSkipping = new JButton("rope-skipping");
        panel1.add(ropeSkipping);
        JButton aerobicGymnastics = new JButton("aerobic gymnastics");
        panel1.add(aerobicGymnastics);
        JButton HIIT = new JButton("HIIT");
        panel1.add(HIIT);
        JButton SPINNING = new JButton("SPINNING");
        panel1.add(SPINNING);


        running.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("running");
            }
        });
        swimming.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("swimming");
            }
        });
        dancing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("dancing");
            }
        });
        bicycling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("bicycling");
            }
        });
        ropeSkipping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("rope-skipping");
            }
        });
        aerobicGymnastics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("aerobic gymnastics");
            }
        });
        HIIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("HIIT");
            }
        });
        SPINNING.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExerciseAndHour("SPINNING");
            }
        });
        frame.getContentPane().add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(new JLabel("Enter hours: "));
        tfInput = new JTextField(10);
        panel2.add(tfInput);
        frame.getContentPane().add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(new JLabel("Total calories consumed: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        panel3.add(tfOutput);
        frame.getContentPane().add(panel3);

        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                double hours = Double.parseDouble(tfInput.getText());
                exerciseAndTime.put(newExercise,hours);
                tfOutput.setText(String.valueOf(ep.increaseC()));
            }
        });
    }

    public void addExerciseAndHour(String exercise){
        exerciseAndTime.put(exercise,0.);
        newExercise = exercise;
    }

    // REQUIRES: input new exercise must be in the exercise database
    //          input hour must be non-negative
    //MODIFIES: this, exercises, hours
    //EFFECTS: add new exercise to exercises and the according hours to hours
    public void recordExercise(){
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(350,120);
        frame.setVisible(true);
    }

    public String getNewExercise(){
        return newExercise;
    }

    public HashMap<String,Double> getExerciseAndTime(){
        return exerciseAndTime;
    }
}
