package tp.gui;

import tp.operations.Operatii;
import tp.operations.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    public JFrame PolynomialCalculator;
    private JTextField polinom1;
    private JTextField polinom2;
    private JTextField result;
    private final JPanel panel = new JPanel();
    private Object SwingConstants;
    public Interface() {
        initialize();
    }
    private void fadeIn(JLabel label) {
        for (float i = 0.0f; i <= 1.0f; i += 0.01f) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            label.setOpaque(true);
            label.setForeground(new Color(0, 0, 128, (int) (i * 255)));
            label.setBackground(new Color(240, 255, 255, (int) (i * 255)));
        }
    }
    private void initialize() {

        PolynomialCalculator = new JFrame();
        PolynomialCalculator.getContentPane().setForeground(new Color(245, 245, 245));
        PolynomialCalculator.setBackground(SystemColor.activeCaption);
        PolynomialCalculator.getContentPane().setBackground(new Color(245, 245, 245));
        PolynomialCalculator.setTitle("Polynomial Calculator");
        PolynomialCalculator.setBounds(100, 100, 468, 581);
        PolynomialCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PolynomialCalculator.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        PolynomialCalculator.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(new Color(135, 206, 250));

        polinom1 = new JTextField();
        polinom1.setFont(new Font("Arial", Font.BOLD, 14));
        polinom1.setForeground(new Color(51, 51, 51));
        polinom1.setBackground(new Color(220, 220, 220));
        polinom1.setBounds(166, 65, 250, 56);
        PolynomialCalculator.getContentPane().add(polinom1);
        polinom1.setColumns(10);

        polinom2 = new JTextField();
        polinom2.setForeground(new Color(51, 51, 51));
        polinom2.setFont(new Font("Arial", Font.BOLD, 14));
        polinom2.setBackground(new Color(220, 220, 220));
        polinom2.setBounds(166, 128, 250, 56);
        PolynomialCalculator.getContentPane().add(polinom2);
        polinom2.setColumns(10);

        result = new JTextField();
        result.setFont(new Font("Arial", Font.BOLD, 13));
        result.setForeground(new Color(153, 0, 0));
        result.setBackground(new Color(192, 192, 192));
        result.setBounds(101, 190, 315, 56);
        PolynomialCalculator.getContentPane().add(result);
        result.setColumns(10);

        JLabel lblNewLabel = new JLabel("Polynom 1");
        lblNewLabel.setForeground(new Color(70, 130, 180));
        lblNewLabel.setBackground(new Color(222, 184, 135));
        lblNewLabel.setBounds(34, 79, 122, 26);
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        PolynomialCalculator.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Polynom 2");
        lblNewLabel_1.setForeground(new Color(70, 130, 180));
        lblNewLabel_1.setBackground(new Color(222, 184, 135));
        lblNewLabel_1.setBounds(34, 140, 122, 26);
        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
        PolynomialCalculator.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Result");
        lblNewLabel_3.setForeground(new Color(70, 130, 180));
        lblNewLabel_3.setBackground(new Color(255, 248, 220));
        lblNewLabel_3.setBounds(34, 203, 81, 29);
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 15));
        PolynomialCalculator.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_2 = new JLabel("Polynomial Calculator");
        lblNewLabel_2.setBackground(new Color(211, 211, 211));
        lblNewLabel_2.setBounds(114, 10, 243, 26);
        lblNewLabel_2.setForeground(new Color(77, 77, 77));
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 19));
        PolynomialCalculator.getContentPane().add(lblNewLabel_2);
        fadeIn(lblNewLabel_2);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setForeground(new Color(77, 77, 77));
        btnNewButton.setBackground(new Color(153, 204, 255));
        btnNewButton.setBounds(34, 264, 190, 66);
        btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = polinom1.getText();
                Polynomial polynomial1 = new Polynomial();
                polynomial1.regexMethod(polynomialString1);

                String polynomialString2 = polinom2.getText();
                Polynomial polynomial2 = new Polynomial();
                polynomial2.regexMethod(polynomialString2);

                Polynomial resultPoly = Operatii.add(polynomial1, polynomial2);
                result.setText(resultPoly.toString());
            }
        });
        PolynomialCalculator.getContentPane().add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Substract");
        btnNewButton_2.setForeground(new Color(77, 77, 77));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = polinom1.getText();
                Polynomial polynomial1 = new Polynomial();
                polynomial1.regexMethod(polynomialString1);

                String polynomialString2 = polinom2.getText();
                Polynomial polynomial2 = new Polynomial();
                polynomial2.regexMethod(polynomialString2);

                Polynomial resultPolinoms = Operatii.substract(polynomial1, polynomial2);
                result.setText(resultPolinoms.toString());
            }
        });
        btnNewButton_2.setBackground(new Color(153, 204, 255));
        btnNewButton_2.setBounds(226, 264, 190, 66);
        btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
        PolynomialCalculator.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Multiply");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = polinom1.getText();
                Polynomial polynomial1 = new Polynomial();
                polynomial1.regexMethod(polynomialString1);

                String polynomialString2 = polinom2.getText();
                Polynomial polynomial2 = new Polynomial();
                polynomial2.regexMethod(polynomialString2);

                Polynomial resultP = Operatii.multiply(polynomial1, polynomial2);
                result.setText(resultP.toString());
            }
        });
        btnNewButton_1.setForeground(new Color(77, 77, 77));
        btnNewButton_1.setBackground(new Color(176, 196, 222));
        btnNewButton_1.setBounds(34, 326, 190, 66);
        btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
        PolynomialCalculator.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_3 = new JButton("Divide");
        btnNewButton_3.setForeground(new Color(77, 77, 77));
        btnNewButton_3.setBackground(new Color(176, 196, 222));
        btnNewButton_3.setBounds(226, 326, 190, 66);
        btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = polinom1.getText();
                Polynomial polynomial1 = new Polynomial();
                polynomial1.regexMethod(polynomialString1);

                String polynomialString2 = polinom2.getText();
                Polynomial polynomial2 = new Polynomial();
                polynomial2.regexMethod(polynomialString2);

                Polynomial[] resultP = null;
                try {
                    resultP = Operatii.divide(polynomial1, polynomial2);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                Polynomial quotient = resultP[0];
                Polynomial remainder = resultP[1];

                String resultString = "Quotient: " + quotient.toString() + "\n" + "Remainder: " + remainder.toString();
                result.setText(resultString);
            }
        });
        PolynomialCalculator.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Derive");
        btnNewButton_4.setForeground(new Color(77, 77, 77));
        btnNewButton_4.setBackground(new Color(173, 216, 230));
        btnNewButton_4.setBounds(34, 392, 190, 66);
        btnNewButton_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = polinom1.getText();
                Polynomial polynomial1 = new Polynomial();
                polynomial1.regexMethod(polynomialString1);

                Polynomial resultPoly = Operatii.derivative(polynomial1);
                result.setText(resultPoly.toString());
            }
        });
        PolynomialCalculator.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Integrate");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String polynomialString1 = polinom1.getText();
                Polynomial polynomial1 = new Polynomial();
                polynomial1.regexMethod(polynomialString1);

                Polynomial resultPoly = Operatii.integration(polynomial1);
                result.setText(resultPoly.toString());
            }
        });
        btnNewButton_5.setForeground(new Color(77, 77, 77));
        btnNewButton_5.setBackground(new Color(173, 216, 230));
        btnNewButton_5.setBounds(226, 392, 190, 66);
        btnNewButton_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
        PolynomialCalculator.getContentPane().add(btnNewButton_5);

        JButton btnNewButton_16 = new JButton("CE");
        btnNewButton_16.setForeground(new Color(77, 77, 77));
        btnNewButton_16.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btnNewButton_16.setBackground(new Color(137, 186, 252));
        btnNewButton_16.setBounds(34, 462, 382, 56);
        btnNewButton_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_16.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        polinom1.setText(" ");
                        polinom2.setText(" ");
                        result.setText(" ");
                    }
                });
            }
        });
        PolynomialCalculator.getContentPane().add(btnNewButton_16);
    }
}