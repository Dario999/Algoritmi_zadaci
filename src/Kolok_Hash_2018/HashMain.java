package Kolok_Hash_2018;

import java.util.*;
import java.io.*;
/*
3
www.google.com 500
www.finki.ukim.com.mk 100
www.facebook.com 300
2
ukim.com.mk
com

Sample output:
100
800
 */
public class HashMain {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> mapa = new HashMap<String,Integer>();
        for(int i=0;i<n;i++) {
            String redica = br.readLine();
            String[] podeleni = redica.split(" ");
            int poseten = Integer.parseInt(podeleni[1]);
            String[] domen = podeleni[0].split("\\.");
            String temp = domen[domen.length-1];
            for(int j=(domen.length-2);j>=0;j--) {
                if(mapa.containsKey(temp)) {
                    int pom = mapa.get(temp);
                    mapa.remove(temp);
                    mapa.put(temp, pom + poseten);
                }else {
                    mapa.put(temp, poseten);
                }
                String t = "";
                t += (domen[j] + "." + temp);
                temp = t;
            }
            if(mapa.containsKey(temp)) {
                int pom = mapa.get(temp);
                mapa.remove(temp);
                mapa.put(temp, pom + poseten);
            }else {
                mapa.put(temp, poseten);
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            String domen = br.readLine();
            if(mapa.containsKey(domen)) {
                System.out.println(mapa.get(domen));
            }
        }
        br.close();
    }
}