package UI;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame(){
        // 2. Login Window
        this.setSize(488,430);

        this.setTitle("Login Page");
        // set on top
        this.setAlwaysOnTop(true);
        // set location
        this.setLocationRelativeTo(null);
        // close the window and shut dowm JVM
        // EXIT_ON_CLOSE = 3
        this.setDefaultCloseOperation(3);




        this.setVisible(true);
    }
}
