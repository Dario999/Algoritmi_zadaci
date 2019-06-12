package Juni_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {

    // Stekot e pretstaven na sledniot nacin:
    //depth e dlabochinata na stekot, a
    // elems[0...depth-1] se negovite elementi.
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public int getDepth() {
        return depth;
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class Stacks {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] vlez=br.readLine().split(" ");
        int x=Integer.parseInt(vlez[0]);
        int y=Integer.parseInt(vlez[1]);
        int z=Integer.parseInt(vlez[2]);
        ArrayStack<Integer> stek1=new ArrayStack(x);
        ArrayStack<Integer> stek2=new ArrayStack(y);
        ArrayStack<Integer> stek3=new ArrayStack(z);
        ArrayStack<Integer> pomosen=new ArrayStack(x+y+z);
        vlez=br.readLine().split(" ");
        int h1=0, h2=0, h3=0;
        for(int i=0; i<x; i++) {
            pomosen.push(Integer.parseInt(vlez[i]));
        }
        while(!pomosen.isEmpty()) {
            stek1.push(pomosen.pop());
            h1+=stek1.peek();
        }
        vlez=br.readLine().split(" ");
        for(int i=0; i<y; i++) {
            pomosen.push(Integer.parseInt(vlez[i]));
        }
        while(!pomosen.isEmpty()) {
            stek2.push(pomosen.pop());
            h2+=stek2.peek();
        }
        vlez=br.readLine().split(" ");
        for(int i=0; i<z; i++) {
            pomosen.push(Integer.parseInt(vlez[i]));
        }
        while(!pomosen.isEmpty()) {
            stek3.push(pomosen.pop());
            h3+=stek3.peek();
        }
        int min=Math.min(h1, Math.min(h2, h3));
        while(h1!=h2||h1!=h3) {
            while(h1>min)
                h1-=stek1.pop();
            min=Math.min(h1, Math.min(h2, h3));
            while(h2>min)
                h2-=stek2.pop();
            min=Math.min(h1, Math.min(h2, h3));
            while(h3>min)
                h3-=stek3.pop();
            min=Math.min(h1, Math.min(h2, h3));
        }
        System.out.println(min);
    }
}