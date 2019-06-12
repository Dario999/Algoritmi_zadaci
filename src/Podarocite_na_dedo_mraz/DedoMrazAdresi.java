package Podarocite_na_dedo_mraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    K key;
    E value;

    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "(" + key + "," + value + ")";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}

public class DedoMrazAdresi {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> dobriDeca = new CBHT<String, String>(2*N);// Vie ja odreduvate goleminata na tabelata

        // vo imeDobriDeca se zachuvuvaat iminjata na dobrite deca
        String[] imeDobriDeca = new String[N];
        // tuka se zachuvuvaat soodvetnite adresi na decata
        String[] adresaDobriDeca = new String[N];
        String pom,pom1, pom2;
        for (int i = 0; i < N; i++) {
            pom1 = br.readLine();
            pom2 = br.readLine();
            imeDobriDeca[i] = pom1;
            adresaDobriDeca[i] = pom2;
            dobriDeca.insert(imeDobriDeca[i],adresaDobriDeca[i]);
        }

        int M = Integer.parseInt(br.readLine());
        CBHT<String, String> promenetiUlici = new CBHT<String, String>(2*M);// Vie ja odreduvate goleminata na tabelata

        // vo staroIme se zachuvuvaat starite iminja na ulici
        String[] staroIme = new String[M];
        // tuka se zachuvuvaat noite iminja na ulici
        String[] novoIme = new String[M];
        for (int i = 0; i < M; i++) {
            pom = br.readLine();
            String[] del = pom.split(" ");
            staroIme[i] = del[0];
            novoIme[i] = del[1];
            promenetiUlici.insert(staroIme[i],novoIme[i]);
        }

        //tuka se zapishuva imeto na deteto shto treba da se proveri
        String deteZaProverka = br.readLine();

        SLLNode<MapEntry<String,String>> tmp = null;

        if ((tmp = dobriDeca.search(deteZaProverka))!=null){
            String adresa = tmp.element.value;
            String[] splitted = adresa.split(" ");
            if(splitted[2].equals("Skopje") && splitted[3].equals("Macedonia")){
                SLLNode<MapEntry<String,String>> tmp1 = null;
                if((tmp1 = promenetiUlici.search(splitted[0]))!=null){
                    System.out.println(tmp1.element.value + " " + splitted[1]
                        + " " + splitted[2] + " " + splitted[3]);
                }else {
                    System.out.println(splitted[0] + " " + splitted[1]
                            + " " + splitted[2] + " " + splitted[3]);
                }
            }else {
                System.out.println(tmp.element.value);
            }
        }else {
            System.out.println("Nema poklon");
        }

    }
}