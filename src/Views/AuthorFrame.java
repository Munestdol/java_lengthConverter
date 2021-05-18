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
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel textLabel = new JLabel("<html>" +
                "Автор<br>" +
                "студент группы 10702418<br>" +
                "Кириллов Павел Сергеевич<br>" +
                "munestdol@gmail.com<br>" +
                "</html>");
        Font font = new Font(Font.DIALOG, Font.BOLD, 16);
        textLabel.setFont(font);

        panel.add(addImageLabel());
        panel.add(textLabel);
        add(panel, BorderLayout.CENTER);
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
        Image scaledImage = image.getScaledInstance(400, 400, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        return imageLabel;
    }
}
