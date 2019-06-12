package AritmetickiIzraz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    static int presmetaj(char c[], int l, int r) {
        // Vasiot kod tuka
        // Osnoven sluchaj;
        if (r - l == 4) {
            char prvaBrojka = c[l + 1];
            char vtoraBrojka = c[r - 1];
            char znak = c[l + 2];
            if (znak == '+') {
                int p = Character.getNumericValue(prvaBrojka);
                int v = Character.getNumericValue(vtoraBrojka);
                return p + v;
            } else {
                int p = Character.getNumericValue(prvaBrojka);
                int v = Character.getNumericValue(vtoraBrojka);
                return p - v;
            }
        }

        int BrojOtvoreniZagradi = 0;

        for (int i = l; i < r; i++) {

            char curentChar = c[i];

            if (curentChar == '(') {
                BrojOtvoreniZagradi++;
            } else if (curentChar == ')') {
                BrojOtvoreniZagradi--;
            } else if (curentChar == '+'&&BrojOtvoreniZagradi == 1) {
                return presmetaj(c, l + 1, i - 1) + presmetaj(c, i + 1, r - 1);
            } else if (curentChar == '-'&&BrojOtvoreniZagradi == 1) {
                return presmetaj(c, l + 1, i - 1) - presmetaj(c, i + 1, r - 1);
            }
        }
        return 0;

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
