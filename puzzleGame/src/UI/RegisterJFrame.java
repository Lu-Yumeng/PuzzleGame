package UI;

import javax.swing.*;
import java.awt.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame() {
        // 3. Register Window
       this.setSize(488,500);

        this.setTitle("Register Page");
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
