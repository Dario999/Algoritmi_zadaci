package Rodendeni;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;


public class Rodendeni {
    public static void main(String[] args) throws IOException{

        HashMap<String,String> mapa = new HashMap<String,String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            String red = br.readLine();
            String[] odvoeni = red.split(" ");
            String[] datum = odvoeni[1].split("\\.");
            if(!mapa.containsKey(datum[1])) {
                mapa.put(datum[1], odvoeni[0]);
                continue;
            }
            String tekoven = mapa.get(datum[1]);
            if(!tekoven.contains(odvoeni[0])) {
                mapa.put(datum[1], tekoven + " " + odvoeni[0]);
            }
        }

        String kluc = br.readLine();
        if(mapa.containsKey(kluc)) {
            System.out.println(mapa.get(kluc));
        }else {
            System.out.println("Nema");
        }


    }
}
