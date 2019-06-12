package Razdeli_po_parnost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node<E>{
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data,Node<E> prev,Node<E> next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class DLL<E>{
    private Node<E> first,last;

    public DLL(){
        first = last = null;
    }

    public void insertFirst(E o){
        Node<E> tmp = new Node<E>(o,null,first);
        if(first == null){
            last = tmp;
        }else{
            first.prev = tmp;
        }
        first = tmp;
    }

    public void insertLast(E o){
        if(first == null){
            insertFirst(o);
        }else{
            Node<E> tmp = new Node<E>(o,last,null);
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

    public E deleteFirst(){
        if(first != null){
            Node<E> tmp = first;
            first = first.next;
            first.prev = null;
            if(first == null){
                last = null;
            }
            return tmp.data;
        }else{
            return null;
        }
    }

    public E deleteLast(){
        if(first != null){
            if(first.next == null){
                return deleteFirst();
            }else{
                Node<E> tmp = last;
                last = last.prev;
                last.next = null;
                return tmp.data;
            }
        }
        return null;
    }

    public void insertAfter(E o,Node<E> after){
        if(after == last){
            insertLast(o);
            return;
        }
        Node<E> tmp = new Node<E>(o,after,after.next);
        after.next.prev = tmp;
        after.next = tmp;
    }

    public void insertBefore(E o,Node<E> before){
        if(before == first){
            insertFirst(o);
            return;
        }
        Node<E> tmp = new Node<E>(o,before.prev,before);
        before.prev.next = tmp;
        before.prev = tmp;
    }

    public E delete(Node<E> node){
        if(node == first){
            deleteFirst();
            return node.data;
        }

        if(node == last){
            deleteLast();
            return node.data;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node.data;
    }

    public void pecati(){
        Node<E> tmp = first;
        while(tmp != null){
            if(tmp.next == null){
                System.out.println(tmp.data);
                break;
            }
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }


}

public class DivideOddEven {

    public static void podelbaNaListi(DLL<Integer> lista){
        Node<Integer> jazol = lista.getFirst();
        DLL<Integer> lista1 = new DLL<Integer>();
        DLL<Integer> lista2 = new DLL<Integer>();

        while(jazol != null){
            if((jazol.data % 2) != 0){
                lista1.insertLast(jazol.data);
                jazol = jazol.next;
            }else{
                lista2.insertLast(jazol.data);
                jazol = jazol.next;
            }
        }
        lista1.pecati();
        lista2.pecati();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        podelbaNaListi(lista);



    }
}


