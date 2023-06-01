package UI;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame{

    int[][] data = new int[4][4];

    public GameJFrame(){
        initJFrame();
        // set Menu
        initMenu();

        // shuffle data
        initData();

        initImage();

        // display
        this.show();
        // gameJFrame.setVisible(true);
    }

    private void initData() {
        int[] arr = new int[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // shuffle
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }

        // return a 4*4 array
        // traverse new 2D array

        // traverse the 1D array
        for (int i = 0; i < arr.length; i++) {
            data[i/4][i%4] = arr[i];
        }
    }

    private void initJFrame() {
        // 1. Main Window set width and height
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
    }

    private void initMenu(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionjMenu = new JMenu("Function");
        JMenu aboutUsjMenu = new JMenu("About Us");

        JMenuItem changePic = new JMenuItem("Change Pic");
        JMenuItem replayGame = new JMenuItem("Replay game");
        JMenuItem relogin = new JMenuItem("Relogin");
        JMenuItem closeGame = new JMenuItem("Close game");
        functionjMenu.add(changePic);
        functionjMenu.add(replayGame);
        functionjMenu.add(relogin);
        functionjMenu.add(closeGame);

        JMenuItem aboutUs = new JMenuItem("about us");
        aboutUsjMenu.add(aboutUs);

        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutUsjMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initImage(){
        int num;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num = data[i][j];
                System.out.println(num);
//                if (num == 0) continue;
                // Create ImageIcon
                ImageIcon icon = new ImageIcon("/Users/luyumeng/PuzzleGame/image/animal/animal1/"+num+".jpg");
                // Create JLabel
                JLabel jlabel= new JLabel(icon);
                // set location
                jlabel.setBounds(j*105,i*105,105,105);
                // Add JLabel to JFrame
                this.getContentPane().add(jlabel);

            }
        }
    }
}
