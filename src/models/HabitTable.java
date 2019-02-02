package models;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HabitTable extends JFrame {
    private JList list;
    private DefaultTableModel model;
    private int counter = 15;
    private JTable habitTable;

    public HabitTable(){
        String[] columnNames = {"habit number","habit name","completed?"};
        Object[] [] data = {
                {1,"have breakfast",false},
                {2,"drink at least 8 bottles of water",false},
                {3,"sleep before 11:00",false},
                {4,"seven minutes full",false},
                {5,"no carbonated beverage",false},
                {6,"no night snack",false},
        };
        model = new DefaultTableModel(data,columnNames);
        habitTable = new JTable(model){
            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        habitTable.setPreferredScrollableViewportSize(new Dimension(500,50));
        JScrollPane scrollPane = new JScrollPane(habitTable);
        getContentPane().add(scrollPane);
//        setLayout(new BorderLayout());
//        JButton addButton = new JButton("Add Element");
//        JButton removeButton = new JButton("Remove Element");
//        for (int i = 0; i < 15; i++)
//            model.addElement("Element " + i);
//
//        addButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                model.addElement("Element " + counter);
//                counter++;
//            }
//        });
//        removeButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (model.getSize() > 0)
//                    model.removeElementAt(0);
//            }
//        });
//
//        add(scrollPane, BorderLayout.NORTH);
//        add(addButton, BorderLayout.WEST);
//        add(removeButton, BorderLayout.EAST);
    }

    public DefaultTableModel getModel(){
        return model;
    }
}
