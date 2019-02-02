package ui;

import Assessment.Observer;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public abstract class Subject extends JFrame {

    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void notifyObserver() throws IOException {
        for (Observer o: observers){
            o.update();
        }
    }
}
