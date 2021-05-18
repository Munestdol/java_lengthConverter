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
        JPanel textPanel = new JPanel();
        //textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout(2,1));
        JLabel[] textLabels = new JLabel[]{
                new JLabel("Автор"),
                new JLabel("студент группы 10702418"),
                new JLabel("Кириллов Павел Сергеевич"),
                new JLabel("munestdol@gmail.com")
        };
        Font font = new Font(Font.DIALOG, Font.BOLD, 16);
        for (JLabel label : textLabels) {
            label.setFont(font);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            textPanel.add(label);
        }
        textPanel.add(addImageLabel());
        JButton backButton = new JButton("Back");
        add(textPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
        addImageLabel();
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JLabel addImageLabel() {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("Image//author.jpg");
        if (url == null) {
            return null;
        }
        Image image = new ImageIcon(url).getImage();
        Image scaledImage = image.getScaledInstance(300, 300, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        return imageLabel;
    }
}
