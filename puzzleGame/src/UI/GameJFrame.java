package UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.Kernel;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] data = new int[4][4];
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    int[] position = new int[2];
    String path = "image/animal/animal1/";
    int cnt = 0;


    JMenuItem girl = new JMenuItem("Girls");
    JMenuItem animal = new JMenuItem("Animal ");
    JMenuItem sports = new JMenuItem("Sports");

    JMenuItem replayGame = new JMenuItem("Replay game");
    JMenuItem relogin = new JMenuItem("Relogin");
    JMenuItem closeGame = new JMenuItem("Close game");
    JMenuItem aboutUs = new JMenuItem("about us");

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

        this.addKeyListener(this);
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
            if(arr[i] == 0){
                position[0] = i/4;
                position[1] = i%4;
            }
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

        JMenu changePic = new JMenu("Change Pic");
        changePic.add(girl);
        changePic.add(animal);
        changePic.add(sports);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sports.addActionListener(this);


        replayGame.addActionListener(this);
        relogin.addActionListener(this);
        closeGame.addActionListener(this);
        aboutUs.addActionListener(this);

        functionjMenu.add(changePic);
        functionjMenu.add(replayGame);
        functionjMenu.add(relogin);
        functionjMenu.add(closeGame);

        aboutUsjMenu.add(aboutUs);

        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutUsjMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initImage(){
        this.getContentPane().removeAll();

        if ( victory()== true){
            JLabel win = new JLabel(new ImageIcon("image/win.png"));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
        }

        JLabel stepcnt = new JLabel("Step: "+cnt);
        stepcnt.setBounds(50,30,100,20);
        this.getContentPane().add(stepcnt);

        int num;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num = data[i][j];
                if (num == 16) continue;
                // Create ImageIcon
                ImageIcon icon = new ImageIcon(path+num+".jpg");
                // Create JLabel
                JLabel jlabel= new JLabel(icon);
                // set frame 0: raise 1: lowered
                jlabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // set location
                jlabel.setBounds(j*105+83,i*105+134,105,105);
                // Add JLabel to JFrame
                this.getContentPane().add(jlabel);

            }
        }

        // first load image will appear on top
        ImageIcon bg = new ImageIcon("image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65){
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);

            ImageIcon bg = new ImageIcon("image/background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // if already win, no reaction
        if (victory() == true){
            return;
        }

        // up 38/ down 40/ left 37 / right 39
        int code = e.getKeyCode();
        if (code == 37){
            if (position[1] == 3 ){
                return;
            }
            // left
            int tmp = data[position[0]][position[1]+1];
            data[position[0]][position[1]] = tmp;
            data[position[0]][position[1]+1] = 0;
            position[1]++;
            cnt ++;

        } else if (code == 38){
            if (position[0] == 3 ){
                return;
            }
            // up
            int tmp = data[position[0]+1][position[1]];
            data[position[0]][position[1]] = tmp;
            data[position[0]+1][position[1]] = 0;
            position[0]++;
            cnt ++;
        }  else  if (code == 39){
            if (position[1] == 0 ){
                return;
            }
            // right
            int tmp = data[position[0]][position[1]-1];
            data[position[0]][position[1]] = tmp;
            data[position[0]][position[1]-1] = 0;
            position[1]--;
            cnt ++;
        }  else  if (code == 40){
            if (position[0] == 0 ){
                return;
            }
            // down
            int tmp = data[position[0]-1][position[1]];
            data[position[0]][position[1]] = tmp;
            data[position[0]-1][position[1]] = 0;
            position[0]--;
            cnt ++;
        } else if(code == 65){
        } else if(code == 87){
            // W
//            JLabel win = new JLabel(new ImageIcon(""));
            data = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
            };
        }
        initImage();
    }

    public boolean victory(){
        // check whether data == win
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]){
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object jbtn = e.getSource();
        // System.out.println(jbtn);
        Random r = new Random();
        if (jbtn == replayGame){
            System.out.println("replay");
            // shuffle
            initData();
            //
            cnt = 0;
            // reload image
            initImage();
        } else if (jbtn == relogin){
            System.out.println("relogin");
            // close current window
            this.setVisible(false);
            // open login page
            new LoginJFrame();
        } else if (jbtn == aboutUs){
            System.out.println("about us");
            JDialog dialog = new JDialog();
            JLabel jlabel = new JLabel(new ImageIcon("image/damie.jpg"));
            // correspond to the pop out window
            jlabel.setBounds(0,0,258,258);
            dialog.getContentPane().add(jlabel);
            dialog.setSize(344,344);
            dialog.setAlwaysOnTop(true);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        } else if(jbtn == closeGame){
            System.out.println("close");
            System.exit(0);
        } else if (jbtn == girl){
            path = "image/girl/girl";
            int num = r.nextInt(13)+1;
            path += num+"/";
            initData();
            cnt = 0;
            initImage();
        } else if (jbtn == animal){
            path = "image/animal/animal";
            int num = r.nextInt(8)+1;
            path += num+"/";
            initData();
            cnt = 0;
            initImage();
        } else if (jbtn == sports){
            path = "image/sport/sport";
            int num = r.nextInt(9)+1;
            path += num+"/";
            initData();
            cnt = 0;
            initImage();
        }
    }
}
