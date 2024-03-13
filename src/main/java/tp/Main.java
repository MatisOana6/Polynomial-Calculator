package tp;

import tp.gui.Interface;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
                    window.PolynomialCalculator.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
/**
        Polynomial p1 = new Polynomial();
        p1.newTerm(3, 1);
        p1.newTerm(2, -2);
        p1.newTerm(1, 6);
        p1.newTerm(0, -5);

        Polynomial p2 = new Polynomial();
        p2.newTerm(2, 1);
        p2.newTerm(0, -1);

        Operatii op = new Operatii();
        Polynomial p3 = op.add(p1, p2);
        Polynomial p4 = op.substract(p1, p2);
        Polynomial p5 = op.multiply(p1, p2);
        Polynomial p6 = op.derivative(p1);
        Polynomial p7 = op.integration(p1);

        System.out.println("Polynomial p1: " + p1);
        System.out.println("Polynomial p2: " + p2);
        System.out.println("Polynomial sum: " + p3);
        System.out.println("Polynomial substract: " + p4);
        System.out.println("Polynomial multiply: " + p5);
        System.out.println("Polynomial derivative of p6: " + p6);
        System.out.println("Polynomial integration of p1: " + p7);
        try {

            Polynomial[] p8 = divide(p1, p2);
            Polynomial quotient = p8[0];
            Polynomial remainder = p8[1];
            System.out.println("Polynomial division of p1 and p2: " + quotient + remainder);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }**/
    }
}

