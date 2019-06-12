package KumanovskiDijalekt;

import java.util.*;
import java.io.*;


public class KumanovskiDijalekt {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,String> tabela = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] red = br.readLine().split(" ");
            tabela.put(red[0],red[1]);
        }

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            String word = line[i];
            if(!Character.isLetter(word.charAt(word.length()-1))){
                char c = word.charAt(word.length()-1);
                word = word.substring(0,word.length()-1);
                boolean big = false;
                if(Character.isUpperCase(word.charAt(0))){
                    big = true;
                }
                word = word.toLowerCase();
                if(tabela.containsKey(word)){
                    String zbor = tabela.get(word);
                    if(big==true){
                        System.out.print(Character.toUpperCase(zbor.charAt(0)) + zbor.substring(1,zbor.length()) + c +" ");
                    }else {
                        System.out.print(zbor+c+ " ");
                    }
                }else {
                    System.out.print(line[i]+" ");
                }
            }else {
                boolean big = false;
                if(Character.isUpperCase(word.charAt(0))){
                    big = true;
                }
                word = word.toLowerCase();
                if(tabela.containsKey(word)){
                    String zbor = tabela.get(word);
                    if(big==true){
                        System.out.print(Character.toUpperCase(zbor.charAt(0)) + zbor.substring(1,zbor.length())+ " ");
                    }else {
                        System.out.print(zbor+" ");
                    }
                }else {
                    System.out.print(line[i]+" ");
                }
            }
        }

    }
}


