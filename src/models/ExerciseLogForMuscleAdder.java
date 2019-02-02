package models;

import API.ParseAPI;
import plans.ExercisePlanForMuscleAdder;
import ui.HealthManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseLogForMuscleAdder extends JFrame {
    private ExercisePlanForMuscleAdder ep;

    private JTextField tfInput, tfOutput;
    private JTextField tfInstruction;
    private JPanel panel2;

    private JButton checkDone;
    private JFrame frame;
    private ArrayList<String> exercises = new ArrayList<>();
    private ArrayList<Integer> groupNumbers = new ArrayList<>();
    private ParseAPI API = new ParseAPI();
    private BufferedImage eImage;

    public ExerciseLogForMuscleAdder(ExercisePlanForMuscleAdder ep){
        this.ep = ep;

        frame = new JFrame("Calories Counter For Muscle-builder");
        frame.setLayout(new GridLayout(2, 2, 5, 5));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JButton barbellSquat = new JButton("Barbell Squat");
        panel1.add(barbellSquat);
        JButton axeHold = new JButton("Axe Hold");
        panel1.add(axeHold);
        JButton BPNG = new JButton("Biceps Press Narrow Grip");
        panel1.add(BPNG);
        JButton BCWS = new JButton("Biceps Curls With SZ-bar");
        panel1.add(BCWS);
        JButton Deadhang = new JButton("Deadhang");
        panel1.add(Deadhang);
        JButton DIC = new JButton("Dumbbell Incline Curl");
        panel1.add(DIC);
        JButton Hammercurls = new JButton("Hammercurls");
        panel1.add(Hammercurls);
        JButton MP = new JButton("Military Press");
        panel1.add(MP);
        JButton PPU = new JButton("Pike Push Ups");
        panel1.add(PPU);
        JButton TD = new JButton("Triceps Dips");
        panel1.add(TD);
        JButton WP = new JButton("Wall Pushup");
        panel1.add(WP);
        JButton Crunches = new JButton("Crunches");
        panel1.add(Crunches);
        JButton HH = new JButton("Hollow Hold");
        panel1.add(HH);
        JButton Burpees = new JButton("Burpees");
        panel1.add(Burpees);
        JButton Butterfly = new JButton("Butterfly");
        panel1.add(Butterfly);

        //TODO
//        checkDone = new JButton("check exercise history");
//        panel1.add(checkDone);
        frame.getContentPane().add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(new JLabel("Instruction: "));
        tfInstruction = new JTextField("");
        tfInstruction.setEditable(false);
        panel2.add(tfInstruction);
        panel2.add(new JLabel("The diagram shows the most used muscles: "));
        frame.getContentPane().add(panel2);


        barbellSquat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Braced Squat.PNG");
                getDescriptionAndDo("Barbell Squat");
               // addPic("Braced Squat.PNG");
            }
        });
        axeHold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Axe Hold.PNG");
                getDescriptionAndDo("Axe Hold");
               // addPic("Axe Hold.PNG");
            }
        });
        BPNG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Biceps Press Narrow Grip.PNG");
                getDescriptionAndDo("Biceps Press Narrow Grip");
                //addPic("Biceps Press Narrow Grip.PNG");
            }
        });
        BCWS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Biceps Curls With SZ-bar.PNG");
                getDescriptionAndDo("Biceps Curls With SZ-bar");
                //addPic("Biceps Curls With SZ-bar.PNG");
            }
        });
        Deadhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("emptyImage.PNG");
                getDescriptionAndDo("Deadhang");
                //addPic("emptyImage.PNG");
            }
        });
        DIC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Dumbbell Incline Curl.PNG");
                getDescriptionAndDo("Dumbbell Incline Curl");
               // addPic("Dumbbell Incline Curl.PNG");
            }
        });
        Hammercurls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("HammerCurls.PNG");
                getDescriptionAndDo("Hammercurls");
               // addPic("HammerCurls.PNG");
            }
        });
        MP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("emptyImage.PNG");
                getDescriptionAndDo("Military Press");
                //addPic("emptyImage.PNG");
            }
        });
        PPU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Pike Push Ups.PNG");
                getDescriptionAndDo("Pike Push Ups");
                //addPic("Pike Push Ups.PNG");
            }
        });
        TD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Triceps Dips.PNG");
                getDescriptionAndDo("Triceps Dips");
//                addPic("Triceps Dips.PNG");
            }
        });
        WP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Wall Pushup.PNG");
                getDescriptionAndDo("Wall Pushup");
//                addPic("Wall Pushup.PNG");
            }
        });
        Crunches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Crunches.PNG");
                getDescriptionAndDo("Crunches");
//                addPic("Crunches.PNG");
            }
        });
        HH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Hollow Hold.PNG");
                getDescriptionAndDo("Hollow Hold");
//                addPic("Hollow Hold.PNG");
            }
        });
        Burpees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("emptyImage.PNG");
                getDescriptionAndDo("Burpees");
//                addPic("emptyImage.PNG");
            }
        });
        Butterfly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPic("Butterfly.PNG");
                getDescriptionAndDo("Butterfly");
//                addPic("Butterfly.PNG");
            }
        });

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(new JLabel("Enter groups: "));
        tfInput = new JTextField(10);
        panel3.add(tfInput);
        frame.getContentPane().add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel4.add(new JLabel("Total calories consumed: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        panel4.add(tfOutput);
        frame.getContentPane().add(panel4);

        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int gn = Integer.parseInt(tfInput.getText());
                groupNumbers.add(gn);
                tfOutput.setText(String.valueOf(ep.increaseC()));
            }
        });
    }

    private void addPic(String picName){
        try {
            eImage = ImageIO.read(this.getClass().getResource(picName));
            Image scaledImage = eImage.getScaledInstance(panel2.getWidth()-40,panel2.getHeight()-40,Image.SCALE_SMOOTH);
            JLabel picLabel = new JLabel(new ImageIcon(scaledImage));
            for(int i = 0; i < panel2.getComponentCount(); i++){
                if(panel2.getComponent(i) instanceof JLabel){
                    panel2.remove(i);
                }
            }
            panel2.add(picLabel);
            panel2.revalidate();
            panel2.repaint();
            frame.revalidate();
            frame.repaint();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void getDescriptionAndDo(String exerciseName){
        try {
            API.parse(exerciseName);
            tfInstruction.setText(API.getExParser().getInstructions());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
            exercises.add(exerciseName);
    }

    // REQUIRES: input new exercise must be in the exercise database
    //          input hour must be non-negative
    //MODIFIES: this, exercises, hours
    //EFFECTS: add new exercise to exercises and the according hours to hours
    public void recordExercise() {
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(350, 120);
        frame.setVisible(true);
    }


    //REQUIRES: the given exercises list is not null
    //EFFECTS: return the latest exercise added
    public String getAddedExercise() {
        return exercises.get(exercises.size() - 1);
    }

    public int getAddedGroupNumber(){
        return groupNumbers.get(exercises.size() - 1);
    }

    //EFFECTS: return the exercises list
    public ArrayList<String> getExercises() {
        return exercises;
    }

}
