package tp.operations;
import java.util.*;
import java.util.regex.*;
public class Polynomial {
    private Map<Integer, Double> polynomial; // Map of exponent to coefficient
    public Polynomial() {

        polynomial = new TreeMap<>();
    }
    public Polynomial(Polynomial polynomial) {

        this.polynomial = new TreeMap<>(polynomial.polynomial);
    }

    public void putMonom(int degree, double coeff)
    {
        if(!polynomial.containsKey(degree))//daca TreeMap-ul nu contine un anumit grad
        {
            polynomial.put(degree,coeff);//adauga gradul si coeficientul corespunzator in Tree Map
        }
        else
        {
            double coeff_new = polynomial.get(degree);// ia coeficientul existent
            coeff_new += coeff;//adauga coeficientul nou la cel existent
            polynomial.put(degree, coeff_new);//se reactualizeaza TreeMap
        }
    }
    public Polynomial(String polynom)
    {

        regexMethod(polynom);
    }
    public Map<Integer, Double> getPolynomial() {

        return polynomial;
    }

    public void setPolynomial(Map<Integer, Double> polynomial) {

        this.polynomial = polynomial;
    }
    public void newTerm(int degree, double coefficient) {
        if (coefficient != 0) {
            if (degree >= 0 && !polynomial.containsKey(degree)) {//daca gradul este pozitiv si nu exista in TreeMap
                polynomial.put(degree, coefficient);
            } else if (degree >= 0) {
                double new_coefficient = polynomial.get(degree) + coefficient;
                if (new_coefficient == 0) {
                    polynomial.remove(degree);//daca coeff este 0, sterge termenul din Map
                } else {
                    polynomial.put(degree, new_coefficient);//actualizeaza TreeMap
                }
            } else {
                if (coefficient < 0) {
                    polynomial.put(degree, -coefficient);//adauga gradul si coeficientul opus
                } else {
                    polynomial.put(degree, coefficient);
                }
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean firstTerm = true;
        for (int exponent : polynomial.keySet()) {
            double coefficient = polynomial.get(exponent);
            String sign = "";
            if (coefficient > 0 && !firstTerm) {
                sign = "+";
            } else if (coefficient < 0) {
                sign = "-";
                coefficient = -coefficient;
            }
            if (coefficient != 0)//În cazul în care coeficientul este diferit de zero, se creează variabila
            // "variable" care conține variabila polinomului (x sau x^exponent). Dacă exponentul este 0, variabila este lăsată goală.
            // Dacă exponentul este 1, variabila conține doar "x". În caz contrar, variabila conține "x^" urmat de exponent.
            {
                String variable = exponent == 0 ? "" : (exponent == 1 ? "x" : "x^" + exponent);//Dacă exponentul este 1, atunci termenul
                // va avea o variabilă x la puterea întâi,
                // așa că variable este setat la "x"
                String value = coefficient == 1 && exponent != 0 ? "" : Double.toString(coefficient);// Dacă coeficientul este 1 și exponentul nu este 0,
                // atunci nu este nevoie să includem coeficientul în termenul afișat, așa că value este setat la șirul vid.
                result.append(sign).append(value).append(variable);
                firstTerm = false;
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    //verifică dacă toți coeficienții polinomului sunt egali cu zero.
    public boolean zeroCheck() {
        for (Map.Entry<Integer, Double> entry : polynomial.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
    public double getCoefficient(int exponent) {
        if (this.polynomial.containsKey(exponent)) {
            return polynomial.get(exponent);
        } else {
            return 0.0;
        }
    }
    public int getDegree() {
        int maxDegree = -1;
        for (int exponent : polynomial.keySet()) {
            if (exponent > maxDegree) {
                maxDegree = exponent;
            }
        }
        return maxDegree;
    }

    //elimina termenii ai caror coeficientii sunt 0
    public void remove() {
        Set<Integer> exponents = new HashSet<>(polynomial.keySet());
        for (int exponent : exponents) {
            double coeff = polynomial.get(exponent);
            if (coeff == 0) {
                polynomial.remove(exponent);
            }
        }
    }

    public void regexMethod(String polynom) {
        Pattern p = Pattern.compile("([-+]?\\d*\\.?\\d*)?x\\^([0-9]+)");
        Matcher m = p.matcher(polynom);
        boolean isFirstTerm = true;
        while (m.find()) //loop pentru a
        {
            double coeff;
            if (m.group(1) == null || m.group(1).isEmpty()) {// Daca coeficientul nu este specificat, atunci are valoarea 1
                coeff = 1.0;
            } else if (m.group(1).equals("-")) {//Daca coeficientul este "-", atunci are valoarea -1
                coeff = -1.0;
            }
            else if (m.group(1).equals("+")) {
                coeff = 1.0;
            }else {//se parseaza coeficientul din string la double
                coeff = Double.parseDouble(m.group(1));
            }
            if (isFirstTerm) {//Daca este primul monom, se verifica semnul coeficientului
                if (coeff < 0) {
                    polynom = "-" + polynom;// Daca coeficientul este negativ, se adauga semnul la inceputul polinomului
                }
                isFirstTerm = false;//se seteaza la false pentru a arata ca s-a trecut de primul monom care a fost procesat
            }
            putMonom(Integer.parseInt(m.group(2)), coeff);//aici se adauga moonomul in polinom
        }
    }
}





