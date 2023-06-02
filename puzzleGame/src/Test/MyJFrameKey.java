package Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrameKey extends JFrame implements KeyListener {


    public MyJFrameKey(){
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




        // 给整个窗体添加键盘监听
        // 调用者this：本类对象，当前的界面对象，表示我要给整个界面添加监听
        // addkeyListener： 表示要给本界面添加监听
        // this：当事件被处发之后，会自信本类中的对应代码
        this.addKeyListener(this);


        this.setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    // if press without release, continue calling keyPressed
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Press without release");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("release");
        // retrieve the key
        int code = e.getKeyCode();
        System.out.println(code);
    }
}
