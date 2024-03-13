package tp.operations;

import java.util.Map;

public class Operatii {
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.getPolynomial().entrySet()) {
            int exponent = entry.getKey();
            double coeff = entry.getValue();
            res.putMonom(exponent, coeff);
        }
        for (Map.Entry<Integer, Double> entry : p2.getPolynomial().entrySet()) {
            int exponent = entry.getKey();
            double coeff = entry.getValue();
            res.putMonom(exponent, coeff);
        }
        return res;
    }

    public static Polynomial substract(Polynomial p1, Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.getPolynomial().entrySet()) {
            int exponent = entry.getKey();
            double coeff = entry.getValue();
            res.putMonom(exponent, coeff);
        }
        for (Map.Entry<Integer, Double> entry : p2.getPolynomial().entrySet()) {
            int exponent = entry.getKey();
            double coeff = -entry.getValue();
            res.putMonom(exponent, coeff);
        }
        return res;
    }

    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.getPolynomial().entrySet()) {
            int exponent1 = entry.getKey();
            double coeff1 = entry.getValue();
            for (Map.Entry<Integer, Double> entry2 : p2.getPolynomial().entrySet()) {
                int exponent2 = entry2.getKey();
                double coeff2 = entry2.getValue();
                int exp_result = exponent1 + exponent2;
                double coeff_result = coeff1 * coeff2;
                res.newTerm(exp_result, coeff_result);
            }
        }
        return res;
    }

    public static Polynomial derivative(Polynomial p) {
        Polynomial res = new Polynomial();
        int highDeg = p.getDegree();
        for (Map.Entry<Integer, Double> entry : p.getPolynomial().entrySet()) {
            int exponent = entry.getKey();
            double coeff = entry.getValue();
            int exponentNew = exponent - 1;
            if (exponentNew >= 0) {
                double coeffNew = coeff * exponent;
                res.newTerm(exponentNew, coeffNew);
            } else if (exponent == highDeg && coeff == 0) {
                res.newTerm(exponentNew, 0);
            }
        }
        return res;
    }

    public static Polynomial integration(Polynomial p) {
        Polynomial res = new Polynomial();
        boolean first = true;
        for (Map.Entry<Integer, Double> entry : p.getPolynomial().entrySet()) {
            int exponent = entry.getKey();
            int newExponent = exponent + 1;
            if (newExponent != 0) {
                double coeff = entry.getValue() / newExponent;
                String formattedCoeff = String.format("%.2f", coeff);
                double newCoeff = Double.parseDouble(formattedCoeff);
                if (first && newCoeff < 0) {
                    res.newTerm(newExponent, -newCoeff);
                    first = false;
                } else if (newCoeff < 0) {
                    res.newTerm(newExponent, -newCoeff);
                } else {
                    res.newTerm(newExponent, newCoeff);
                }
            }
        }
        return res;
    }

    public static Polynomial[] divide(Polynomial dividend, Polynomial divisor) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(dividend);
        if (divisor.zeroCheck()) {
            throw new ArithmeticException("Division by zero");
        } else {
            for (Map.Entry<Integer, Double> entry : dividend.getPolynomial().entrySet()) {
                int divisor_new = entry.getKey();
                double dividendCoeff = entry.getValue();
                if (divisor_new < divisor.getDegree()) {
                    continue;
                }
                double divisorCoeff = divisor.getCoefficient(divisor.getDegree());// Obtine coeficientul termenului de cel mai inalt grad din divisor
                if (dividendCoeff == 0) {//Daca coeficientul termenului din dividend este zero atunci nu se poate face impartirea, asa ca trece la urmatorul termen
                    continue;
                }
                double new_coeff = dividendCoeff / divisorCoeff;
                Polynomial pol_aux = new Polynomial();
                pol_aux.newTerm(divisor_new - divisor.getDegree(), new_coeff);//Adauga un termen nou cu exponentul
                // potrivit si coeficientul calculat
                quotient = add(quotient, pol_aux); // aduna pol_aux, adica noul termen la cat
                pol_aux = multiply(pol_aux, divisor);  // inmulteste pol-aux cu divizorul
                remainder = substract(remainder, pol_aux);  // extrage rezultatul inmultirii din rest
            }
            quotient.remove();      // elimina termeni cu coef=0 din cat si rest
            remainder.remove();
            return new Polynomial[]{quotient, remainder};
        }
    }
}
