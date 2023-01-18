import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

public class Temperature {
    JFrame frame = new JFrame("Temperature Converter");
    JLabel label = new JLabel("Temperature Converter",JLabel.CENTER);
    JLabel output = new JLabel("");
    JTextField input = new JTextField("");
    String[] temps = {"Fahrenheit", "Celsius"};
    JComboBox choice = new JComboBox(temps);
    JButton enter = new JButton("Convert");

    double x=0;


    public Temperature() {
        frame.add(label);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(140,30,300,200);
        label.setFont(new Font("Helvetica", Font.PLAIN, 15));
        label.setPreferredSize(new Dimension(250, 100));

        frame.add(output);
        output.setFont(new Font("Helvetica", Font.PLAIN, 15));
        output.setPreferredSize(new Dimension(80, 70));
        output.setBounds(280, 150, 200, 70);

        frame.add(input);
        input.setBounds(70,100,200,30);

        frame.add(choice);
        choice.setBounds(330,100,150,30);

        frame.add(enter);
        enter.setBounds(70, 170, 100, 30);

        frame.setSize(600,400);
        frame.setLocation(670,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);

        input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = input.getText();
                double str1 = Double.parseDouble(t);
                x = str1;
            }
        });

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double y = Double.parseDouble(input.getText());
                switch(choice.getSelectedItem().toString()) {
                    case "Fahrenheit":
                        x = (y * 1.8) + 32;
                        String s = String.valueOf(x);
                        String j =String.format("%.2f",x);
                        output.setText(j+"\u00B0 Fahrenheit");
                            break;
                        case "Celsius":
                            x = (y -32) * 5/9;
                            String t = String.valueOf(x);
                            String h =String.format("%.2f",x);
                            output.setText(h+ "\u00B0 Celsius");
                            break;
                }
                }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Temperature();
            }
        });



    }
}