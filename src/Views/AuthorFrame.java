package Views;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static java.awt.Image.SCALE_FAST;

/**
 * <code> AuthorFrame </code> is an enhanced version of <code> JFrame </code>
 * , which displays information about the author.
 *
 * @author Kirillov P.S.
 */

public class AuthorFrame extends JFrame {

    private GridBagConstraints constraints;

    public AuthorFrame() {
        setTitle("About author");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        addImageLabel();
        JLabel labelInfo = new JLabel("<html><left><h2>"
                + "Author: Kirillov Pavel<br>"
                + "Group: 10702418<br>"
                + "</h2></left></html>");
        add(labelInfo);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addImageLabel() {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("Image//author.jpg");
        if (url == null) {
            return;
        }
        Image image = new ImageIcon(url).getImage();
        Image scaledImage = image.getScaledInstance(300, 300, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(imageLabel, constraints);
    }
}
