package Maksimalna_tezinka_suma;

/*Дадена е низа од N позитивни природни броеви и еден број K. Да се изберат точно K
броеви од низата, така што кога ќе се спојат во една низа, следната сума:

1⋅првиотброј+2⋅вториотброј+…+K⋅K−тиотброј

е максимална. Да се испечати оваа сума.

Влез: Во првата линија ви се дадени два броеви N (1≤N≤100) и K (1≤K≤100, K≤N).
Во втората линија ви се дадени N позитивни природни броеви, секој од броевите е помал од 1,000.

Излез: Да се испечати бараната максимална тежинска сума.

Име на класата (Java): WeightedSum.

Делумно решение: Задачата се смета за делумно решена доколку се поминати 5 тест примери.

За овој тест пример секвенцата од 3 броеви за кои е исполнето дека бараната сума е
максимална е 1 9 6 (1_1+2_9+3*6).

Sample input
10 3
1 9 2 3 6 1 3 2 1 3
Sample output
37

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeightedSum {

    static int solve(int numbers[], int N, int K) {
        // vasiot kod ovde
        // mozete da napisete i drugi funkcii dokolku vi se potrebni
        return 1;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}
