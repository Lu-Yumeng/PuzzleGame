package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyJFrameButton extends JFrame implements MouseListener {

    JButton jbt = new JButton("Cilck me");

    public MyJFrameButton(){
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
        jbt.addMouseListener(this);

        this.getContentPane().add(jbt);

        this.setVisible(true);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press without release");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Release mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exit");
    }
}
