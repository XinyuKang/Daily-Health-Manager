package Assessment;

import ProfileInfo.Profile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class HealthHistory extends Observable implements Observer{
    private List<String> lines;
    private ArrayList<String> partsOfLine;
    private ArrayList<Double> weights = new ArrayList<>();
    private ArrayList<Double> BMIs = new ArrayList<>();
    private ArrayList<Double> BFPs = new ArrayList<>();
    private HealthGraph healthGraph;

    public HealthHistory(){
        healthGraph = new HealthGraph(weights,BMIs,BFPs);
        addObserver(healthGraph);
    }

    public void loadHealthAssessmentHistory(String readFileName) throws IOException {
        // assigns history variable from file data
        BufferedReader br = new BufferedReader(new FileReader(readFileName));
        if (br.readLine() == null){
            System.out.println("No health history in store!");
        } else {
            lines = Files.readAllLines(Paths.get(readFileName));
            for (String line : lines) {
                ArrayList<String> partsOfLine = splitOnSpace(line);
                System.out.print("Age: " + partsOfLine.get(0) + " ");
                System.out.print("Height: " + partsOfLine.get(1) + " ");
                System.out.print("Weight: " + partsOfLine.get(2) + " ");
                weights.add(Double.parseDouble((partsOfLine.get(2))));
                System.out.print("BMI: " + partsOfLine.get(3) + " ");
                BMIs.add(Double.parseDouble((partsOfLine.get(3))));
                System.out.print("BFP: " + partsOfLine.get(4) + " ");
                BFPs.add(Double.parseDouble((partsOfLine.get(4))));
                System.out.println("Health Index: " + partsOfLine.get(5));

            }
            if(weights.size()>=2) {
                System.out.println("See the graph for change of weight");
                setChanged();
                notifyObservers();
            }
        }
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public void saveNewHealthAssessment(String saveFileName, Profile person, double BMI, double BFP, int healthIndex) throws IOException {
        //weights.add(person.getWeightObject().getWeight());
        lines = Files.readAllLines(Paths.get(saveFileName));
        PrintWriter writer = new PrintWriter(saveFileName, "UTF-8");
        lines.add(Integer.toString(person.getAgeObject().getAge()) + " " +
                Double.toString(person.getHeightObject().getHeight()) + " " +
                Double.toString(person.getWeightObject().getWeight()) + " " +
                Double.toString(BMI) + " " + Double.toString(BFP) + " " + Integer.toString(healthIndex));
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }


    private int countNoLines(){
        int no = 0;
        for (String line : lines) {
            no += 1;
        }
        return no;
    }

    @Override
    public void update() throws IOException {
        lines = Files.readAllLines(Paths.get("HealthAssessmentHistory.txt"));
        if(countNoLines()>=2) {
            ArrayList<String> partsOfLineOld = getCertainLine(2);
            ArrayList<String> partsOfLineNew = getCertainLine(1);
            analyseWeight(partsOfLineOld, partsOfLineNew);
            analyseBMI(partsOfLineOld, partsOfLineNew);
            analyseBFP(partsOfLineOld, partsOfLineNew);
            analyseHealthIndex(partsOfLineOld, partsOfLineNew);
        }
    }

    private void analyseWeight(ArrayList<String> partsOfLineOld, ArrayList<String> partsOfLineNew) {
        if (largerNew(2,partsOfLineOld,partsOfLineNew)){
            double i = Double.parseDouble(partsOfLineNew.get(2))-Double.parseDouble(partsOfLineOld.get(2));
            System.out.println("You have gained "+i+" kilograms");
        } else {
            double i = Double.parseDouble(partsOfLineOld.get(2))-Double.parseDouble(partsOfLineNew.get(2));
            System.out.println("You have loosen "+i+" kilograms");
        }
    }

    private void analyseBFP(ArrayList<String> partsOfLineOld, ArrayList<String> partsOfLineNew) {
        if (largerNew(4,partsOfLineOld,partsOfLineNew)){
            double i = 100*(Double.parseDouble(partsOfLineNew.get(4))-Double.parseDouble(partsOfLineOld.get(4)))/Double.parseDouble(partsOfLineOld.get(4));
            System.out.println("Your body fat percentage has increased by "+i+"%");
        } else {
            double i = 100*(Double.parseDouble(partsOfLineOld.get(4))-Double.parseDouble(partsOfLineNew.get(4)))/Double.parseDouble(partsOfLineOld.get(4));
            System.out.println("Your body fat percentage has decreased by "+i+"%");
        }
    }

    private void analyseBMI(ArrayList<String> partsOfLineOld, ArrayList<String> partsOfLineNew) {
        if (largerNew(3,partsOfLineOld,partsOfLineNew)){
            double i = 100*(Double.parseDouble(partsOfLineNew.get(3))-Double.parseDouble(partsOfLineOld.get(3)))/Double.parseDouble(partsOfLineOld.get(3));
            System.out.println("Your BMI has increased by "+i+"%");
        } else {
            double i = 100*(Double.parseDouble(partsOfLineOld.get(3))-Double.parseDouble(partsOfLineNew.get(3)))/Double.parseDouble(partsOfLineOld.get(3));
            System.out.println("Your BMI has decreased by "+i+"%");
        }
    }

    private void analyseHealthIndex(ArrayList<String> partsOfLineOld, ArrayList<String> partsOfLineNew) {
        if (largerNew(5,partsOfLineOld,partsOfLineNew)){
            double i = Double.parseDouble(partsOfLineNew.get(5))-Double.parseDouble(partsOfLineOld.get(5));
            System.out.println("Your health index has increased by "+i+"points, Good Job!");
        } else {
            double i = Double.parseDouble(partsOfLineOld.get(5))-Double.parseDouble(partsOfLineNew.get(5));
            System.out.println("Your health index has decreased by "+i+"points, don't give up, stick to the plan!");
        }
    }

    private boolean largerNew(int i,ArrayList<String> partsOfLineOld, ArrayList<String> partsOfLineNew){
        return Double.parseDouble(partsOfLineNew.get(i))>Double.parseDouble(partsOfLineOld.get(i));
    }

    private ArrayList<String> getCertainLine(int i2) throws IOException {
        String lastButOneLine = Files.readAllLines(Paths.get("HealthAssessmentHistory.txt")).get(countNoLines() - i2);
        return splitOnSpace(lastButOneLine);
    }

    public ArrayList<Double> getWeights(){
        return weights;
    }
}
