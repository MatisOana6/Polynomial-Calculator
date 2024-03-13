package test;

import tp.operations.Polynomial;
import tp.operations.Operatii;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    @Test
    public void addTest(){
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
            String op1_expected = "-6.0+6.0x-x^2+x^3";
            String str1 = p3.toString();
            assertEquals(op1_expected, str1);

    }
    @Test
    public void substractTest() {
            Polynomial p1 = new Polynomial();
            p1.newTerm(3, 1);
            p1.newTerm(2, -2);
            p1.newTerm(1, 6);
            p1.newTerm(0, -5);

            Polynomial p2 = new Polynomial();
            p2.newTerm(2, 1);
            p2.newTerm(0, -1);

            Operatii op = new Operatii();
            Polynomial p4 = op.substract(p1, p2);
            String op2_expected = "-4.0+6.0x-3.0x^2+x^3";
            String str2 = p4.toString();
            assertEquals(op2_expected, str2);

    }
        @Test
        public void multiplyTest() {
                Polynomial p1 = new Polynomial();
                p1.newTerm(3, 1);
                p1.newTerm(2, -2);
                p1.newTerm(1, 6);
                p1.newTerm(0, -5);

                Polynomial p2 = new Polynomial();
                p2.newTerm(2, 1);
                p2.newTerm(0, -1);

                Operatii op = new Operatii();
                Polynomial p5 = op.multiply(p1, p2);
                String op3_expected = "5.0-6.0x-3.0x^2+5.0x^3-2.0x^4+x^5";
                String str3 = p5.toString();
                assertEquals(op3_expected, str3);

        }

        @Test
        public void deriveTest() throws Exception {
                Polynomial p1 = new Polynomial();
                p1.newTerm(3, 1);
                p1.newTerm(2, -2);
                p1.newTerm(1, 6);
                p1.newTerm(0, -5);

                Operatii op = new Operatii();
                Polynomial p6 = op.derivative(p1);
                String op4_expected = "6.0-4.0x+3.0x^2";
                String str4 = p6.toString();
                assertEquals(op4_expected, str4);
        }

        @Test
        public void integrateTest() {
                Polynomial p1 = new Polynomial();
                p1.newTerm(3, 1);
                p1.newTerm(2, -2);
                p1.newTerm(1, 6);
                p1.newTerm(0, -5);

                Operatii op = new Operatii();
                Polynomial p7 = op.integration(p1);
                String op5_expected = "5.0x+3.0x^2+0.67x^3+0.25x^4";
                String str5 = p7.toString();
                assertEquals(op5_expected, str5);
        }

        @Test
        public void divideTest() throws Exception {
                Polynomial p1 = new Polynomial();
                p1.newTerm(3, 1);
                p1.newTerm(2, -2);
                p1.newTerm(1, 6);
                p1.newTerm(0, -5);

                Polynomial p2 = new Polynomial();
                p2.newTerm(2, 1);
                p2.newTerm(0, -1);

                Operatii op = new Operatii();
                Polynomial[] p8 = op.divide(p1, p2);
                String op6_expected = "-2.0+x";
                String op7_expected = "-7.0+7.0x";

                String str6 = p8[0].toString();
                 String str7 = p8[1].toString();
                 assertEquals(op6_expected, str6);
                 assertEquals(op7_expected, str7);

        }
}



