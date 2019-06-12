package Merenja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.logging.Handler;


public class Merenja {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,String> tabela = new HashMap<>();
        for(int i=0;i<n;i++){
            String red = br.readLine();
            String[] parts = red.split(" ");
            if(!tabela.containsKey(parts[0])){
                tabela.put(parts[0],parts[1]);
            }else{
                String tmp = tabela.get(parts[0]);
                tabela.put(parts[0],tmp + " " + parts[1]);
            }
        }

        String vlez = br.readLine().trim();

        if (tabela.containsKey(vlez)) {
            int brojac =0;
            Double sum = 0.0;
            String[] delovi = tabela.get(vlez).split(" ");
            for (int i = 0; i < delovi.length; i++) {
                brojac++;
                sum += Double.parseDouble(delovi[i].replaceAll("\\,","\\."));
            }
            String gomno = String.valueOf((double)(sum/brojac)).replaceAll("\\.","\\,");
            System.out.println(vlez + " " + gomno.substring(0,3));
        }
        br.close();

    }
}
