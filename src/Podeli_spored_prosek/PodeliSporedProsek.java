package Podeli_spored_prosek;

/*Дадена е еднострано поврзана листа чии што јазли содржат по еден природен број.
 * Листата треба да се подели на две резултантни листи, т.ш. во првата листа треба
 * да се сместат сите јазли кои содржат броеви помали или еднакви на просекот на
 * листата (просек на листа претставува математички просек од сите природни броеви
 *  кои се јавуваат во листата), а во втората сите јазли кои содржат броеви поголеми
 *  од просекот на листата. Јазлите во резултантните листи се додаваат според редоследот
 *  по кој се појавуваат во дадената листа.

Во првиот ред од влезот е даден бројот на јазли во листата, а во вториот ред се дадени
броевите од кои се составени јазлите по редослед во листата. Во првиот ред од излезот
треба да се испечатат јазлите по редослед од првата резултантна листа (броеви помали или
еднакви на просекот на листата), во вториот ред од втората (броеви поголеми од просекот на листата) .

Име на класа (за Java): PodeliSporedProsek

Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.

Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не
да користат помошни структури како низи или сл.

Sample input
5
4 2 1 5 3
Sample output
2 1 3
4 5

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
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

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

}

public class PodeliSporedProsek {

    public static void podeli(SLL<Integer> lista){
        SLL<Integer> pomali = new SLL<Integer>(), pogolemi = new SLL<Integer>();

        /*
         *
         * Vasiot kod tuka
         *
         * */

        int zbir = 0;
        SLLNode<Integer> tmp = lista.getFirst();
        while(tmp != null){
            zbir += tmp.element;
            tmp = tmp.succ;
        }

        double prosek = zbir/lista.length();
        tmp = lista.getFirst();
        while(tmp != null){
            if(tmp.element.compareTo((int)prosek) > 0){
                pogolemi.insertLast(tmp.element);
            }
            if(tmp.element.compareTo((int)prosek) < 0 || tmp.element.compareTo((int)prosek) == 0){
                pomali.insertLast(tmp.element);
            }
            tmp = tmp.succ;
        }

        //Pechatenje na pomali i ednakvi od prosekot
        SLLNode<Integer> pom = pomali.getFirst();
        while (pom!=null) {
            System.out.print(pom.element);
            if(pom.succ!=null)
                System.out.print(" ");
            pom = pom.succ;
        }
        System.out.println();

        //Pechatenje na pogolemi od prosekot
        pom = pogolemi.getFirst();
        while (pom!=null) {
            System.out.print(pom.element);
            if(pom.succ!=null)
                System.out.print(" ");
            pom = pom.succ;
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException{
        SLL<Integer> lista = new SLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        podeli(lista);

    }
}