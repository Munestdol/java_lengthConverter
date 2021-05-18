package Views;

import javax.swing.*;
import java.awt.*;

/**
 * <code> AboutFrame </code> is an enhanced version of <code> JFrame </code>
 *  , which displays information about the program.
 *
 * @author Kirillov P.S.
 */

public class AboutFrame extends JFrame {
    public AboutFrame(){
        setBounds(100, 100, 500, 300);
        setTitle("About program");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        JLabel labelInfo = new JLabel("<html><left><h2>"
                + "This application allows you to convert units of length<br>"
                + "You can convert the following length units:<br>"
                + "1. Millimeter<br>"
                + "2. Centimeter<br>"
                + "3. Meter<br>"
                + "4. Kilometer<br>"
                + "5. Foot<br>"
                + "6. Mile<br>"
                + "</h2></left></html>");
        add(labelInfo);
        setVisible(true);
    }
}
