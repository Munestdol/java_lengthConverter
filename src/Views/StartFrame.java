package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import static java.awt.Image.SCALE_FAST;

/**
 * A <code>StartFrame</code> is an extended version of <code>JFrame</code>
 * that shown while the <code>MainFrame</code> is creating. Contains
 * information about the project, "Start" and "Close" buttons.
 *
 * @author Kirillov P.S.
 */
public class StartFrame extends JFrame {
    private JButton startButton;
    private JButton closeButton;
    private GridBagConstraints constraints;

    public StartFrame() {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        addStartFrameText();
        startButton = createStartButton();
        closeButton = createCloseButton();
        addButtons();
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addStartFrameText() {
        addHeadLabel();
        addBodyLabel();
        addInfoLabel();
        addImageLabel();
    }

    private void addHeadLabel() {
        JLabel headLabel = new JLabel("<html><center><h2>"
                + "Белорусский национальный технический университет<br>"
                + "Факультет информационных технологий и робототехники<br>"
                + "Кафедра программного обеспечения информационных систем "
                + "и технологий<br></h2></center></html>");
        headLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        Insets oldInsets = constraints.insets;
        constraints.insets = new Insets(0, 10, 50, 10);
        add(headLabel, constraints);
        constraints.insets = oldInsets;
    }

    private void addBodyLabel() {
        JLabel bodyLabel = new JLabel("<html><center><h1>Курсовая работа<br>"
                + "по дисциплине «Программирование на Java»<br>"
                + "Конвертер длин<br></h1></center></html>");
        bodyLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(bodyLabel, constraints);
    }

    private void addImageLabel() {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("Image//icon.png");
        if (url == null) {
            return;
        }
        Image image = new ImageIcon(url).getImage();
        Image scaledImage = image.getScaledInstance(300, 300, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(imageLabel, constraints);
    }

    private void addInfoLabel() {
        JLabel infoLabel = new JLabel("<html><h2>"
                + "Выполнил: студент группы 10702418<br>"
                + "Кириллов Павел Сергеевич<br><br>"
                + "Преподаватель: к.ф.-м.н., доц.<br>"
                + "Сидорик Валерий Владимирович<br></h2></html>");
        constraints.gridwidth = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(infoLabel, constraints);
    }

    private JButton createStartButton() {
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainFrame mainFrame = new MainFrame();
                dispose();
            }
        });
        return button;
    }

    private JButton createCloseButton() {
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        return button;
    }

    private void addButtons() {
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0.5;
        constraints.ipady = 20;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, constraints);
        constraints.gridx = 1;
        add(closeButton, constraints);
    }
}