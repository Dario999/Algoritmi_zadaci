package Maraton;

import java.util.Scanner;

interface IMaraton{

    public Atleticar najdobroVreme();

    public int atleticariOd(String s);
}

class Atleticar{
    private String ime;
    private String pol;
    private int vozrast;
    private double vreme;
    private String zemja;

    public Atleticar(){
    }

    public Atleticar(String ime,String pol,int vozrast,double vreme,String zemja){
        this.ime = ime;
        this.pol = pol;
        this.vozrast = vozrast;
        this.vreme = vreme;
        this.zemja = zemja;
    }

    public void setIme(String ime){
        this.ime = ime;
    }
    public void setPol(String pol){
        this.pol = pol;
    }
    public void setVozrast(int vozrast){
        this.vozrast = vozrast;
    }
    public void setVreme(double vreme){
        this.vreme = vreme;
    }
    public void setZemja(String zemja){
        this.zemja = zemja;
    }
    public String getIme(){
        return ime;
    }
    public String getPol(){
        return pol;
    }
    public int getVozrast(){
        return vozrast;
    }
    public double getVreme(){
        return vreme;
    }
    public String getZemja(){
        return zemja;
    }

    @Override
    public String toString(){
        return ime +"\n" + vozrast +"\n" + zemja +"\n" + vreme;
    }

}

class Maraton implements IMaraton{
    private String mesto;
    private int godina;
    private Atleticar[] niza;

    public Maraton(){
    }
    public Maraton(String mesto,int godina,Atleticar[] n){
        this.mesto = mesto;
        this.godina = godina;
        niza = n;
    }

    @Override
    public String toString(){
        System.out.printf(mesto +"\n" + godina +"\n");
        for (int i=0;i<this.niza.length;i++){
            Atleticar temp = niza[i];
            if (temp != null) {
                System.out.println(temp);
            }
        }
        return "";
    }
    public Atleticar najdobroVreme(){
        Atleticar najdobar = niza[0];
        for(int i=1;i<this.niza.length;i++){
            if(niza[i].getVreme() < najdobar.getVreme()){
                najdobar = niza[i];
            }
        }
        return najdobar;
    }
    public int atleticariOd(String s){
        int vkp = 0;
        for(int i=0;i<this.niza.length;i++){
            if(niza[i].getZemja().equals(s)){
                vkp++;
            }
        }
        return vkp;
    }

}


public class ZadacaMaraton {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Atleticar[] atleticari = new Atleticar[n];

        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;

        input.nextLine();

        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Atleticar(ime,pol,vozrast,vreme,zemja);
        }

        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();

        Maraton m1 = new Maraton(mesto, godina, atleticari);
        System.out.print(m1.toString());

        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.najdobroVreme().toString());
        System.out.println("Ima vkupno " + m1.atleticariOd(zemjaP) + " atleticar/i od " + zemjaP);
    }
}
