/******************************************************************************
 *  Execution:    java putzplan.java
 *
 *  A minimal Java program with a graphical user interface. The
 *  GUI prints out the number of times the user clicks a button.
 *
 *  % java GUI
 *
 * stolen from https://introcs.cs.princeton.edu/java/15inout/GUI.java.html
 ******************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Random;

class Putzplan implements ActionListener {
//    private int clicked = 0;
    private JLabel label = new JLabel(" ");
    private JFrame frame = new JFrame();

    private String jetzt = "jetzt";

    private Random rng = new Random();

    public Putzplan() {

        // the clickable button
        JButton button = new JButton("Wann bin ich dran?");
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
//        panel.setSize(600, 400);
        panel.setPreferredSize(new Dimension(800, 300));
        panel.setMinimumSize(new Dimension(400,70));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setLayout(new GridLayout(1, 1, 15, 15));
        panel.add(button);
        panel.add(label);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Putzplan");
        frame.pack();
        frame.setVisible(true);
    }

    // select a random task
    public String getTask(/*int c*/) {

        LinkedList<String> tasks = new LinkedList<String>();
        tasks.add("Geh mal Bier holen!");
        tasks.add("Räum die Küche auf!");
        tasks.add("Wisch mal durch's Bad.");
        tasks.add("Im Schlafzimmer müsste man mal aufräumen …");
        tasks.add("Sortier die Dinge auf dem Schreibtisch!");
        tasks.add("Saug die Terrasse!");
        tasks.add("Ist die Waschmaschine frei?");

        int c = rng.nextInt(tasks.size());
        return tasks.get(c);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
//        clicked++;
        if (rng.nextInt(4)>=3) {
            label.setText(getTask());
        }
        else {
            label.setText(jetzt);
            jetzt += "!";
        }
    }

    // create one Frame
    public static void main(String[] args) {
        new Putzplan();
    }
}