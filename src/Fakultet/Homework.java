package Fakultet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Homework {

    static int minBrojKazneni(int a[]){
        for (int i = 0; i < a.length-1; i++){
            for (int j = i+1; j < a.length; j++)
                if (a[i] < a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
        }

        int suma = 0;
        int pom = 0;
        for(int i=0;i<a.length;i++){
            suma += a[i];
            for(int j=i+1;j<a.length;j++){
                pom += a[j];
            }
        }

        return suma + pom;
    }

    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];

        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = minBrojKazneni(a);

        System.out.println(rez);

        br.close();
    }

}
