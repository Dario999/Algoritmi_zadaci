package Kolokvium;

/**Се организира прв колоквиум по предметот Алгоритми и структури на податоци.
 * За таа цел се отвара анкета по предметот на која студентите се пријавуваат.
 Анкетата има дадено 2 избори:

 1)	Полагам во било кој термин

 2)	Испитот ми се преклопува со Математика

 Студентите се поставуваат во термините според редоследите во кои се примени (почнувајќи од првиот).
 Сите студенти сакаат да полагаат колку е можно порано па затоа дел од студентите мамат и во
 анкетата наведуваат дека истиот ден полагаат и Математика.Асистентите бараат список на студенти кои
 полагаат Математика и добиваат. Потоа се започнува со распределба на студентите во термини:
 прво во термините се доделуваат студентите кои се пријавиле дека полагаат и Математика
 (по редоследот по кој се пријавиле), меѓутоа секој од овие студенти се проверува дали навистина
 полага и Математика и ако мамел се сместува на крај од списокот на студенти кои избрале дека полагаат било кој
 термин. Потоа се изминуваат останатите студенти и се доделуваат во термини.

 Влез: Се дава прво капацитетот на студенти по термин (т.е. по колку студенти во еден термин може да полагаат).
 Следно се дава бројот и списокот на студенти кои истиот ден полагаат и Математика (според редоследот по
 кој се пријавиле). Потоа се дава бројот и списокот на останатите студенти (според редоследот по
 кој се пријавиле). На крај се дава број и список на студенти кои навистина полагаат Математика.
 На излез се печати број на термин, па студентите кои полагаат во тој термин.

 Име на класа (за Јава): Kolokvium
 Sample input
 2
 4
 IlinkaIvanoska
 IgorKulev
 MagdalenaKostoska
 HristinaMihajloska
 3
 VladimirTrajkovik
 SlobodanKalajdziski
 AnastasMisev
 1
 IlinkaIvanoska
 Sample output
 1
 IlinkaIvanoska
 VladimirTrajkovik
 2
 SlobodanKalajdziski
 AnastasMisev
 3
 IgorKulev
 MagdalenaKostoska
 4
 HristinaMihajloska

 */

import java.util.Scanner;

class ArrayQueue<E> {
    E[] elems;
    int length, front, rear;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public E peek() {
        if (length > 0)
            return elems[front];
        else {
            System.out.println("Redicata e prazna");
            return null;
        }
    }

    public void clear() {
        length = 0;
        front = rear = 0;
    }

    public void enqueue(E x) {
        elems[rear++] = x;
        if (rear == elems.length)
            rear = 0;
        length++;
    }

    public E dequeue() {
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)
                front = 0;
            length--;
            return frontmost;
        } else {
            System.out.println("Redicata e prazna");
            return null;
        }
    }
}

public class Kolokvium {
    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        ArrayQueue<String> redAPS = new ArrayQueue<String>(50);
        ArrayQueue<String> redAPSMatematika = new ArrayQueue<String>(50);

        int i,j,brStudentiTermin,brStudentiAPS,brStudentiAPSMatematika,brStudentiMatematika;

        brStudentiTermin=Integer.parseInt(br.nextLine());
        brStudentiAPSMatematika=Integer.parseInt(br.nextLine());
        String[] imeStudentiAPSMatematika = new String[brStudentiAPSMatematika];

        for(i=0; i<brStudentiAPSMatematika; i++)
        {
            String red = br.nextLine();
            String[] pom = red.split(" ");
            imeStudentiAPSMatematika[i] = pom[0];
            redAPSMatematika.enqueue(imeStudentiAPSMatematika[i]);
        }

        brStudentiAPS=Integer.parseInt(br.nextLine());
        String[] imeStudentiAPS = new String[brStudentiAPS];

        for(i=0; i<brStudentiAPS; i++)
        {
            String red = br.nextLine();
            String[] pom = red.split(" ");
            imeStudentiAPS[i] = pom[0];
            redAPS.enqueue(imeStudentiAPS[i]);
        }

        brStudentiMatematika=Integer.parseInt(br.nextLine());
        String[] imeStudentiMatematika = new String[brStudentiMatematika];

        for(i=0; i<brStudentiMatematika; i++)
        {
            String red = br.nextLine();
            String[] pom = red.split(" ");
            imeStudentiMatematika[i] = pom[0];
            //redAPS.enqueue(imeStudentiMatematika[i]);
        }

        // Vasiot kod ovde...


    }
}
