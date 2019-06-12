package Kolok_Haash_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Map;

public class HashMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> mapa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String red = br.readLine();
            String[] poseteni = red.split(" ");

            int poseten = Integer.parseInt(poseteni[1]);

            String[] parts = poseteni[0].split("\\.");

            String domen = parts[parts.length - 1];
            for (int j = parts.length - 2; j >= 0; j--) {
                if (mapa.containsKey(domen)) {
                    int temp = mapa.get(domen);
                    mapa.remove(domen);
                    mapa.put(domen, poseten + temp);
                } else {
                    mapa.put(domen, poseten);
                }
                String t = "";
                t += (parts[j] + "." + domen);
                domen = t;
            }

            if (mapa.containsKey(domen)) {
                int temp = mapa.get(domen);
                mapa.remove(domen);
                mapa.put(domen, poseten + temp);
            } else {
                mapa.put(domen, poseten);
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String domen = br.readLine();
            if (mapa.containsKey(domen)) {
                System.out.println(mapa.get(domen));
            }
        }

        br.close();
    }
}
