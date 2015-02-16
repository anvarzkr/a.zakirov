package ru.kpfu.itis.group11408.zakirov.fast_multiply;

/**
 * Created by Anvar on 10.02.2015.
 */
public class Polynom {

    public enum Operation {
        PLUS,
        MINUS
    }

    double[] koeff;
    int len;

    public Polynom (double[] koeff){
        this.koeff = koeff;
        this.len = koeff.length;
    }

    public Polynom (String str){
        boolean sized = false;

        for (int i = 0; i < str.length(); i++){
            if ( (str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != 'x' && str.charAt(i) != 'X')
                continue;
            String numString = "";
            while (i < str.length() && ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.')){
                numString += str.charAt(i);
                i++;
            }
            double koeffX = (numString.length() != 0) ? Double.parseDouble(numString) : 1;
            //System.out.println("koeff = " + koeffX);

            while (i < str.length() && (str.charAt(i) < '0' || str.charAt(i) > '9'))
                i++;
            int num = 0, p = 1;
            numString = "";
            while (i < str.length() && ((str.charAt(i) >= '0' && str.charAt(i) <= '9'))){
                numString += str.charAt(i);
                i++;
            }
            int degX = ((numString.length() != 0) ? Integer.parseInt(numString) : 0);
            //System.out.println("deg = " + degX);


            if (!sized) {
                this.koeff = new double[degX + 1];
                this.len = this.koeff.length;
                sized = true;
            }
            this.koeff[degX] = koeffX;
        }
    }

    public static void main(String[] args) {
        Polynom polynom = new Polynom(new double[]{1, 1, 2});
        System.out.println();
        System.out.println("Polynom fast_multiply = new Polynom(new double[]{1, 1, 2});");
        System.out.println(polynom);

        Polynom polynom2 = new Polynom("x^2 + 4");
        System.out.println();
        System.out.println("Polynom polynom2 = new Polynom(\"x^2 + 4\");");
        System.out.println(polynom2);
        Polynom polynom3 = new Polynom(new Polynom(new double[]{3, 2, 1}).toString());

        System.out.println();
        System.out.println("Polynom polynom3 = new Polynom(new Polynom(new double[]{3, 2, 1}).toString());");
        System.out.println(polynom3);

        polynom.plus(new Polynom(new double[]{1, -1, 1, 4, 0}));
        System.out.println();
        System.out.println("fast_multiply.plus(new Polynom(new double[]{1, -1, 1, 4, 0}));");
        System.out.println(polynom);
        polynom.plus(polynom2);
        System.out.println();
        System.out.println("fast_multiply.plus(polynom2);");
        System.out.println(polynom);
        polynom.minus(new Polynom(new double[]{1, -1, 1, 4}));
        System.out.println();
        System.out.println("fast_multiply.minus(new Polynom(new double[]{1, -1, 1, 4}));");
        System.out.println(polynom);
        polynom.multiply(new Polynom(new double[]{2, -1, 2, 2}));
        System.out.println();
        System.out.println("fast_multiply.multiply(new Polynom(new double[]{2, -1, 2, 2}));");
        System.out.println(polynom);
    }

    public void plus(Polynom anotherPolynom){
        doOperation(Operation.PLUS, anotherPolynom);
    }

    public void minus(Polynom anotherPolynom){
        doOperation(Operation.MINUS, anotherPolynom);
    }

    public void multiply(Polynom anotherPolynom){
        int newDeg = (this.len - 1) + (anotherPolynom.len - 1);
        double[] newKoeff = new double[newDeg + 1];

        for (int i = 0; i < this.len; i++)
            for (int j = 0; j < anotherPolynom.len; j++)
                newKoeff[i + j] += this.koeff[i] * anotherPolynom.koeff[j];

        this.koeff = newKoeff;
        this.len = newKoeff.length;
    }

    private void doOperation(Operation oper, Polynom anotherPolynom){
        double[] tmpKoeff = (anotherPolynom.len > this.len) ? anotherPolynom.koeff : this.koeff ;
        int k = tmpKoeff.length - 1;
        double eps = 0.0001;

        if (anotherPolynom.len > this.len)
            for (int i = 0; i < this.len; i++)
                tmpKoeff[i] += ((oper == Operation.PLUS) ? 1 : -1 ) * this.koeff[i];
        else
            for (int i = 0; i < anotherPolynom.len; i++)
                tmpKoeff[i] += ((oper == Operation.PLUS) ? 1 : -1 ) *anotherPolynom.koeff[i];

        for (; (tmpKoeff[k] > -eps && tmpKoeff[k] < eps); k--);
        k++;

        double[] newKoeff = new double[Math.max(k, 1)];
        for (int j = 0; j < newKoeff.length; j++)
            newKoeff[j] = tmpKoeff[j];

        this.koeff = newKoeff;
        this.len = newKoeff.length;
    }

    public String toString(){
        double eps = 0.0001;
        String retString = "";
        for (int i = this.len - 1; i >= 0; i--)
            if (!(this.koeff[i] > -eps && this.koeff[i] < eps) || this.len == 1) retString += ((i != this.len - 1) ? " + " : "") + this.koeff[i] + ((i != 0) ? ("*x^" + i) : "");

        return retString;
    }
}
