package Speluvanje1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Speluvanje1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,String> tabela = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String zbor = br.readLine();
            tabela.put(zbor,zbor);
        }

        String[] delovi = br.readLine().split(" ");
        boolean flag = true;
        for (int i = 0; i < delovi.length; i++) {
            String zbor = delovi[i];
            if(!Character.isLetter(delovi[i].charAt(zbor.length()-1))){
                zbor = zbor.substring(0,zbor.length()-1);
                zbor = zbor.toLowerCase();
            }else{
                zbor = zbor.toLowerCase();
            }

            if(!tabela.containsKey(zbor)){
                if(zbor.length()!=0){
                    System.out.println(zbor);
                    flag = false;
                }
            }
        }

        if (flag){
            System.out.println("Bravo");
        }

    }
}
