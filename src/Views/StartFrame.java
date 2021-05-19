package Views;

import javax.swing.*;
import java.awt.*;
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
    //creating elements for creat JFrame
    private JButton startButton;
    private JButton closeButton;
    private Timer timer;
    private Thread mainFrameThread;
    private GridBagConstraints constraints;
    //creating a MainFrame object
    private MainFrame mainFrame;

    /**
     * Starts a parallel thread, where <code>MainFrame</code> is being created,
     * creates visible <code>StartFrame</code> object and runs 60 seconds timer,
     * which closes the <code>StartFrame</code> if no button was pressed.
     */
    public StartFrame() {
        mainFrameThread = new Thread(() -> mainFrame = new MainFrame());
        mainFrameThread.start();

        final int delayMilliseconds = 60000;
        timer = new Timer(delayMilliseconds, e -> System.exit(0));

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

        timer.start();
    }
    /**
     * Method that calls methods that add elements for <code> StartFrame </code>
     */
    private void addStartFrameText() {
        addHeadLabel();
        addBodyLabel();
        addImageLabel();
        addInfoLabel();
        addBotLabel();
    }
    /**
     * The method that adds the JLabel for the head.
     */
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
    /**
     * The method that adds the JLabel for the body.
     */
    private void addBodyLabel() {
        JLabel bodyLabel = new JLabel("<html><center><h1>Курсовая работа<br>"
                + "по дисциплине «Программирование на Java»<br>"
                + "Конвертор едениц измерения длин<br></h1></center></html>");
        bodyLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(bodyLabel, constraints);
    }

    /**
     * The method that adds the Image.
     */
    private void addImageLabel() {
        ClassLoader loader = getClass().getClassLoader();
        URL url = loader.getResource("Image/icon.png");
        if (url == null) {
            return;
        }
        Image image = new ImageIcon(url).getImage();
        Image scaledImage = image.getScaledInstance(200, 200, SCALE_FAST);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(imageLabel, constraints);
    }

    /**
     * The method that adds the JLabel.
     */
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
    /**
     * JButton setting method for starting the main application
     */
    private JButton createStartButton() {
        JButton button = new JButton("Start");
        button.addActionListener(e -> switchToMainFrame());
        return button;
    }
    /**
     * JButton setting method for closing the main application
     */
    private JButton createCloseButton() {
        JButton button = new JButton("Close");
        button.addActionListener(e -> System.exit(0));
        return button;
    }

    /**
     * The method that adds the JButton.
     */
    private void addButtons() {
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weightx = 0.5;
        constraints.ipady = 20;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, constraints);
        constraints.gridx = 1;
        add(closeButton, constraints);
    }

    /**
     * Method to go to the main window.
     */
    private void switchToMainFrame() {
        timer.stop();
        try {
            mainFrameThread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        dispose();
        mainFrame.setVisible(true);
    }
    /**
     * The method that adds the JLabel for the bot.
     */
    private void addBotLabel(){
        JLabel bottomLabel = new JLabel("<html><h2>Минск, 2021<br></h2></html>");
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(bottomLabel, constraints);
    }
}
