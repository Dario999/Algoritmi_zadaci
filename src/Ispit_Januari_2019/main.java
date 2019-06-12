package Ispit_Januari_2019;

import java.util.*;
import java.io.*;

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getLast() {
        SLLNode<E> tmp = first;
        while(tmp.succ != null){
            tmp = tmp.succ;
        }
        return tmp;
    }

    public SLLNode<E> getFirst() {
        return first;
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


public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prv = br.readLine();
        String vtor = br.readLine();
        SLL<Integer> lista1 = new SLL<Integer>();
        SLL<Integer> lista2 = new SLL<Integer>();
        SLL<Integer> rezultat = new SLL<Integer>();
        for(int i=0;i<prv.length();i++){
            Character c = prv.charAt(i);
            lista1.insertFirst(Integer.parseInt(c.toString()));
        }
        for(int i=0;i<vtor.length();i++){
            Character c = vtor.charAt(i);
            lista2.insertFirst(Integer.parseInt(c.toString()));
        }

        SLLNode<Integer> jazol1 = lista1.getFirst();
        SLLNode<Integer> jazol2 = lista2.getFirst();

        while(jazol1 != null && jazol2 != null){
            int broj = jazol1.element + jazol2.element;
            if(broj <= 9){
                rezultat.insertFirst(broj);
            }else{
                rezultat.insertFirst(broj%10);
                broj /= 10;
                if(jazol1.succ == null || jazol2.succ == null){
                    break;
                }
                jazol1 = jazol1.succ;
                jazol2 = jazol2.succ;
                broj += jazol1.element + jazol2.element;
                while(broj >= 10 && (jazol1.succ != null) && (jazol2.succ != null)){
                    rezultat.insertLast(broj % 10);
                    broj /= 10;
                    jazol1 = jazol1.succ;
                    jazol2 = jazol2.succ;
                    broj += jazol1.element + jazol2.element;
                }
                if(broj >= 10 && (jazol1.succ != null) && (jazol2.succ != null)){
                    rezultat.insertFirst(broj);
                }
            }
            jazol1 = jazol1.succ;
            jazol2 = jazol2.succ;
        }
        while(jazol1 != null){
            rezultat.insertFirst(jazol1.element);
            jazol1 = jazol1.succ;
        }
        /*while(jazol2 != null){
            rezultat.insertFirst(jazol2.element);
            jazol2 = jazol2.succ;
        }*/

        System.out.println(rezultat);

    }
}
