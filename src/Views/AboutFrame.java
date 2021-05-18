package Views;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static java.awt.Image.SCALE_DEFAULT;
import static java.awt.Image.SCALE_FAST;

/**
 * <code> AboutFrame </code> is an enhanced version of <code> JFrame </code>
 *  , which displays information about the program.
 *
 * @author Kirillov P.S.
 */

public class AboutFrame extends JFrame {
    public AboutFrame(){
        setTitle("About program");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel labelInfo = new JLabel("<html><left>"
                + "This application allows you to convert units of length<br>"
                + "You can convert the following length units:<br>"
                + "1. Millimeter<br>"
                + "2. Centimeter<br>"
                + "3. Meter<br>"
                + "4. Kilometer<br>"
                + "5. Foot<br>"
                + "6. Mile<br>"
                + "</left></html>");
        Font font = new Font(Font.DIALOG, Font.BOLD, 16);
        labelInfo.setFont(font);
        panel.add(addImageLabel());
        panel.add(labelInfo);
        add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JLabel addImageLabel() {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("Image//aboutProgram.png");
        if (url == null) {
            return null;
        }
        Image image = new ImageIcon(url).getImage();
        Image scaledImage = image.getScaledInstance(500, 250, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        return imageLabel;
    }
}
