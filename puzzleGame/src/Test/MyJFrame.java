package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jbt = new JButton("Cilck me");
    JButton jbt2 = new JButton("Catch me if you can ");

    public MyJFrame(){
        this.setSize(603,680);
        // set title
        this.setTitle("Jigsaw Game v1.0");
        // set on top
        this.setAlwaysOnTop(true);
        // set location
        this.setLocationRelativeTo(null);
        // close the window and shut dowm JVM
        // EXIT_ON_CLOSE = 3
        // close when one of the window is closed
        this.setDefaultCloseOperation(3);
        // cancel to place at center
        this.setLayout(null);



        jbt.setBounds(0,0,100,50);
        jbt.addActionListener(this);

        jbt2.setBounds(100,0,100,50);
        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Catch me if you can ");
            }
        });
        jbt2.addActionListener(this);

        this.getContentPane().add(jbt);
        this.getContentPane().add(jbt2);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == jbt){
            jbt.setBounds(0,0,200,200);
        } else if (src == jbt2){
            Random r  = new Random();
            jbt2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
