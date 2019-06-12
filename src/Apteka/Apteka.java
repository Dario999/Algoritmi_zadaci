package Apteka;

import java.lang.reflect.MalformedParametersException;
import java.net.Socket;
import java.util.*;
import java.io.*;

class Key implements Comparable<Key>{
    public String ime;

    public Key(String ime){
        this.ime = ime;
    }

    @Override
    public int hashCode() {
        return  ((29*(29*(int)ime.charAt(0)+(int)ime.charAt(1)) + (int)ime.charAt(2))%102780);
    }

    @Override
    public int compareTo(Key k){
        if(k == null){
            return 1;
        }
        return ime.compareTo(k.ime);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Key key = (Key)obj;
        return ime.equals(key.ime);
    }
}

class Lek{
    public String name;
    public String poz;
    public int cena;
    public int brParcinja;

    public Lek(String name,int poz,int cena,int brParcinja){
        this.name = name;
        if(poz == 1){
            this.poz = "POZ";
        }else {
            this.poz = "NEG";
        }
        this.cena = cena;
        this.brParcinja = brParcinja;
    }

    public boolean buy(int amount){
        if(brParcinja<amount){
            return false;
        }else{
            brParcinja -= amount;
            return true;
        }
    }

    public String toString(){
        return name + "\n" + poz + "\n" + cena + "\n" + brParcinja;
    }
}

public class Apteka {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Key,Lek> tabela = new HashMap<Key, Lek>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            Key key = new Key(parts[0].toUpperCase().trim());
            //System.out.println(key.ime);
            Lek lek = new Lek(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
            tabela.put(key,lek);
        }

        String line = br.readLine();
        while (!line.equals("KRAJ")){
            line = line.toUpperCase().trim();
            //System.out.println(line);
            int amount = Integer.parseInt(br.readLine());
            if(tabela.containsKey(new Key(line))){
                Lek lek = tabela.get(new Key(line));
                if(lek.poz.equals("POZ")){
                    if(lek.buy(amount)){
                        System.out.println(lek);
                        System.out.println("Napravena naracka");
                    }else {

                    }
                }else {
                    System.out.println(lek);
                    System.out.println("Napravena naracka");
                }
            }else {
                System.out.println("Nema takov lek");
            }
            line = br.readLine();
        }

    }

}

