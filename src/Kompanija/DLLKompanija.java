package Kompanija;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Node<E>{
    E ID,plata;
    Node<E> prev;
    Node<E> next;

    public Node(E ID,E plata,Node<E> prev,Node<E> next){
        this.ID = ID;
        this.plata = plata;
        this.prev = prev;
        this.next = next;
    }
}

class DLL<E extends Comparable<E>>{
    private Node<E> first,last;

    public DLL(){
        first = last = null;
    }

    public void insertFirst(E id,E plata){
        Node<E> tmp = new Node<E>(id,plata,null,first);
        if(first == null){
            last = tmp;
        }else{
            first.prev = tmp;
        }
        first = tmp;
    }

    public void insertLast(E id,E plata){
        if(first == null){
            insertFirst(id,plata);
        }else{
            Node<E> tmp = new Node<E>(id,plata,last,null);
            last.next = tmp;
            last = tmp;
        }
    }

    public Node<E> getFirst(){
        return first;
    }

    public Node<E> getLast(){
        return last;
    }

    public void deleteFirst(){
        if(first != null){
            first = first.next;
            first.prev = null;
            if(first == null){
                last = null;
            }
        }
    }

    public void deleteLast(){
        if(first != null){
            if(first.next != null){
                last = last.prev;
                last.next = null;
            }
        }
    }

    public void insertAfter(E id,E plata,Node<E> after){
        if(after == last){
            insertLast(id,plata);
            return;
        }
        Node<E> tmp = new Node<E>(id,plata,after,after.next);
        after.next.prev = tmp;
        after.next = tmp;
    }

    public void insertBefore(E id,E plata,Node<E> before){
        if(before == first){
            insertFirst(id,plata);
            return;
        }
        Node<E> tmp = new Node<E>(id,plata,before.prev,before);
        before.prev.next = tmp;
        before.prev = tmp;
    }

    public void delete(Node<E> node){
        if(node == first){
            deleteFirst();
        }

        if(node == last){
            deleteLast();
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void pecati(){
        Node<E> tmp = first;
        if(first != null){
            while(tmp != null){
                if(tmp.next == null){
                    System.out.println(tmp.ID + " " + tmp.plata);
                    break;
                }
                System.out.println(tmp.ID + " " + tmp.plata);
                tmp = tmp.next;
            }
        }else
            System.out.println("nema");
    }

    public void sortirajSporedId(){
        E new_ID,new_Plata;
        if(first != null){
            Node<E> jazol1 = first;
            if(jazol1.next != null && jazol1 != null){
                Node<E> jazol2 = jazol1.next;
                while(jazol1 != null){
                    jazol2 = jazol1.next;
                    while(jazol2 != null){
                        if(jazol1.ID.compareTo(jazol2.ID) < 0){
                            new_ID = jazol1.ID;
                            new_Plata = jazol1.plata;
                            jazol1.ID = jazol2.ID;
                            jazol1.plata = jazol2.plata;
                            jazol2.ID = new_ID;
                            jazol2.plata = new_Plata;
                        }
                        jazol2 = jazol2.next;
                    }
                    jazol1 = jazol1.next;
                }
            }}

    }

}

public class DLLKompanija {

    public static DLL<Integer> otstraniSporedPlata(DLL<Integer> lista,int plata){
        Node<Integer> jazol = lista.getFirst();
        DLL<Integer> lista1 = new DLL<Integer>();
        while(jazol != null){
            if(jazol.plata >= plata){
                lista1.insertLast(jazol.ID,jazol.plata);
                jazol = jazol.next;
            }else
                jazol = jazol.next;
        }
        return lista1;
    }

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        DLL<Integer> lista = new DLL<Integer>();
        int N = s.nextInt();
        int[] ID = new int[N];
        int[] plata = new int[N];
        for(int i=0;i<N;i++){
            ID[i] = s.nextInt();
            plata[i] = s.nextInt();
            lista.insertLast(ID[i], plata[i]);
        }
        int p = s.nextInt();
        DLL<Integer> rezultat = new DLL<Integer>();
        rezultat = otstraniSporedPlata(lista,p);
        rezultat.sortirajSporedId();
        rezultat.pecati();
        s.close();


    }
}


