package Views;

import Controllers.Controller;
import Models.Converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * <code>MainFrame</code> is an enhanced version of <code>JFrame</code>
 * , which allows you to convert units of lengths (millimeters, centimeters, meters, kilometers, feet, miles).
 * Contains, button "Convert", two JComboBox, two JTextField and JMenuBar "File"
 * with JMenuItem "Author", "About", "Close".
 *
 * @author Kirillov P.S.
 */
public class MainFrame extends JFrame {

    private String[] items = {"millimeter", "centimeter", "meter", "kilometer", "foot", "mile"};
    private JComboBox lengthlist1 = new JComboBox(items);
    private JComboBox lengthlist2 = new JComboBox(items);
    private JButton buttonConvert = new JButton("Convert");
    private JTextField tf1 = new JTextField(10);
    private JTextField tf2 = new JTextField(10);
    private JMenuBar menuBar = new JMenuBar();

    //creating a Converter object for converting values
    Converter valueConverter = new Converter();

    /**
     * Constructor for creating the <code>MainFrame</code>
     */
    public MainFrame() {
        setBounds(100, 100, 500, 200);
        setTitle("Length Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        menuBar = createMenuBar();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        tf2.setEnabled(false);
        panel1.add(tf1);
        panel1.add(lengthlist1);
        panel1.add(tf2);
        panel1.add(lengthlist2);
        panel2.add(buttonConvert,BorderLayout.CENTER);
        setJMenuBar(menuBar);
        add(panel1);
        add(panel2);
        ActionListener actionListener = new ButtonActionListener();
        buttonConvert.addActionListener(actionListener);
        setResizable(false);
    }

    /**
     * Constructor for customizing JMenuBar
     */
    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("Author");
        JMenuItem menuItem2 = new JMenuItem("Close");
        JMenuItem menuItem3 = new JMenuItem("About");
        menuBar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem3);
        menu.addSeparator();
        menu.add(menuItem2);
        menuItem1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AuthorFrame authorFrame = new AuthorFrame();
            }
        });
        menuItem2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        menuItem3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AboutFrame authorFrame = new AboutFrame();
            }
        });
        return menuBar;
    }

    /**
     * Listener for the button. When you click the button, the Converter method is called,
     * and depending on the units of measurement, the conversion takes place.
     */
    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (tf1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter a value");
                throw new RuntimeException("Empty field");
            }
            if (Pattern.matches("[a-zA-Zа-яА-ЯёЁ+*/&?(\\-+*.)|!@#№$;%:^\"]+", tf1.getText())) {
                JOptionPane.showMessageDialog(null, "Field should contain letters");
                throw new RuntimeException("Field should contain letters");
            }

            // convert for
            Controller controller = new Controller();
            if(lengthlist1.getSelectedItem().equals("centimeter")){
                valueConverter.ForCantimeter();
            }
            if(lengthlist1.getSelectedItem().equals("meter")){
                valueConverter.ForMeter();
            }
            if(lengthlist1.getSelectedItem().equals("kilometer")){
                valueConverter.ForKilometer();
            }
            if(lengthlist1.getSelectedItem().equals("millimeter")){
                valueConverter.ForMillimeter();
            }
            if(lengthlist1.getSelectedItem().equals("foot")){
                valueConverter.ForFoot();
            }
            if(lengthlist1.getSelectedItem().equals("mile")){
                valueConverter.ForMile();
            }
            // convert to
            if(lengthlist2.getSelectedItem().equals("centimeter")){
                tf2.setText(Float.toString(controller.LengthConverter(Float.parseFloat(tf1.getText()),
                        valueConverter.getCantimeter())));
            }
            if(lengthlist2.getSelectedItem().equals("meter")){
                tf2.setText(Float.toString(controller.LengthConverter(Float.parseFloat(tf1.getText()),
                        valueConverter.getMeter())));
            }
            if(lengthlist2.getSelectedItem().equals("mile")){
                tf2.setText(Float.toString(controller.LengthConverter(Float.parseFloat(tf1.getText()),
                        valueConverter.getMile())));
            }
            if(lengthlist2.getSelectedItem().equals("foot")){
                tf2.setText(Float.toString(controller.LengthConverter(Float.parseFloat(tf1.getText()),
                        valueConverter.getFoot())));
            }
            if(lengthlist2.getSelectedItem().equals("kilometer")){
                tf2.setText(Float.toString(controller.LengthConverter(Float.parseFloat(tf1.getText()),
                        valueConverter.getKilometer())));
            }
            if(lengthlist2.getSelectedItem().equals("millimeter")){
                tf2.setText(Float.toString(controller.LengthConverter(Float.parseFloat(tf1.getText()),
                        valueConverter.getMillimeter())));
            }
        }
    }
}