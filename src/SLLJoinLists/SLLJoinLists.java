package SLLJoinLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collections;



class SLLNode<E>{
    E data;
    SLLNode<E> next;

    SLLNode(){}
    SLLNode(E data,SLLNode<E> next){
        this.data = data;
        this.next = next;
    }
}

class SLL<E extends Comparable<E>> {
    private SLLNode<E> first;

    public SLL(){
        first = null;
    }

    public void insertFirst(E tmp){
        SLLNode<E> newNode = new SLLNode<E>(tmp,first);
        first = newNode;
    }

    public void insertLast(E element){
        if(first == null)
            insertFirst(element);
        else{
            SLLNode<E> tmp = first;
            while(tmp.next != null)
                tmp = tmp.next;
            SLLNode<E> last = new SLLNode<E>(element,null);
            tmp.next = last;
        }
    }

    public SLLNode<E> getLast(){
        if(first != null){
            SLLNode<E> tmp = first;
            while(tmp.next != null)
                tmp = tmp.next;
            return tmp;
        }
        return first;
    }

    public SLLNode<E> getPreLast(){
        if(first != null){
            SLLNode<E> tmp = first;
            while(tmp.next.next != null)
                tmp = tmp.next;
            return tmp;
        }
        return first;
    }
    public void insertAfter(E element,SLLNode<E> node){
        if(node != null){
            SLLNode<E> tmp = new SLLNode<E>(element,node.next);
            node.next = tmp;
        }
    }
    public int getLength(){
        SLLNode<E> tmp = first;
        int length = 0;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }
    public String toString(){
        String s= new String();
        SLLNode<E> tmp = first;
        while(tmp != null){
            s = s+tmp.data+" ";
            tmp = tmp.next;
        }
        return s;
    }
    public SLLNode<E> getFirst(){
        return first;
    }

    public SLL<E> joinLists(SLL<E> list1){
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> jazol1 = list1.getFirst();
        SLLNode<E> jazol2 = this.getFirst();
        int br = 0;
        while(jazol1 != null && jazol2 != null){
            if(br == 0){
                if(jazol1.data.compareTo(jazol2.data) < 0){
                    rezultat.insertLast(jazol1.data);
                    jazol1 = jazol1.next;
                }else if(jazol1.data.compareTo(jazol2.data) > 0){
                    rezultat.insertLast(jazol2.data);
                    jazol2 = jazol2.next;

                }else{
                    rezultat.insertLast(jazol2.data);
                    jazol1 = jazol1.next;
                    jazol2 = jazol2.next;

                }
                br = 1;
            }else{
                if(jazol1.data.compareTo(jazol2.data) < 0){
                    if(jazol1.data.compareTo(rezultat.getLast().data) != 0){
                        rezultat.insertLast(jazol1.data);
                        jazol1 = jazol1.next;
                    }else{
                        jazol1 = jazol1.next;
                    }
                }else if(jazol1.data.compareTo(jazol2.data) > 0){
                    if(jazol2.data.compareTo(rezultat.getLast().data) != 0){
                        rezultat.insertLast(jazol2.data);
                        jazol2 = jazol2.next;
                    }else{
                        jazol2 = jazol2.next;
                    }
                }else{
                    if(jazol2.data.compareTo(rezultat.getLast().data) != 0){
                        rezultat.insertLast(jazol2.data);
                        jazol1 = jazol1.next;
                        jazol2 = jazol2.next;
                    }else{
                        jazol1 = jazol1.next;
                        jazol2 = jazol2.next;
                    }
                }
            }
        }
        if(jazol1 != null){
            while(jazol1 != null){
                if(jazol1.data.compareTo(rezultat.getLast().data) != 0){
                    rezultat.insertLast(jazol1.data);
                    jazol1 = jazol1.next;
                }else{
                    jazol1 = jazol1.next;
                }
            }
        }
        if(jazol2 != null){
            while(jazol2 != null){
                if(jazol2.data.compareTo(rezultat.getLast().data) != 0){
                    rezultat.insertLast(jazol2.data);
                    jazol2 = jazol2.next;
                }else{
                    jazol2 = jazol2.next;
                }
            }
        }


        return rezultat;
    }

}

public class SLLJoinLists<E extends Comparable<E>> {


    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        SLL<Integer> lista1 = new SLL<Integer>();
        SLL<Integer> lista2 = new SLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        SLL<Integer> spoeni = lista1.joinLists(lista2);

        System.out.println(spoeni);
    }
}
