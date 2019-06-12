package Patuvanje;

import java.util.Scanner;
import java.lang.Exception;

abstract class Patuvanje{
    String ime;
    int cena;

    Patuvanje(String ime, int cena) {
        super();
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme(){
        return ime;
    }
    public int getCena(){
        return cena;
    }
    public int getPM(){
        return 0;
    }
    public abstract int vratiVremeVoDenovi();

    public static int vratiMiniCena(Patuvanje[] niza,int n,Patuvanje zaSporedba){
        int minCena = 0;
        for(int i=0;i<n;i++){
            if(niza[i].vratiVremeVoDenovi()>zaSporedba.vratiVremeVoDenovi()){
                minCena = niza[i].getCena();
                break;
            }
        }
        if(minCena!=0){
            for(int i=0;i<n;i++){
                if (niza[i].vratiVremeVoDenovi() > zaSporedba.vratiVremeVoDenovi() && minCena > niza[i].getCena()){
                    minCena = niza[i].getCena();
                }
            }
        }
        return minCena;
    }


}

class PraznicnoPatuvanje extends Patuvanje{
    private int poceten;
    private int pmesec;
    private int kraen;
    private int kmesec;

    public PraznicnoPatuvanje(String ime,int cena,int p,int pm,int k,int km){
        super(ime,cena);
        try{
            if(pm > km){
                throw new Exception("mesec");
            }else if(pm == km && p > k){
                throw new Exception("den");
            }else{
                this.poceten = p;
                this.pmesec = pm;
                this.kraen = k;
                this.kmesec = km;
            }
        }catch(Exception e){
            System.out.println("Iskluchok");
            if(e.getMessage() == "mesec"){
                poceten = k;
                pmesec = km;
                kraen = p;
                kmesec = pm;
            }else{
                poceten = k;
                pmesec = pm;
                kraen = p;
                kmesec = km;
            }
        }
    }

    public int getPM(){
        return pmesec;
    }
    @Override
    public int vratiVremeVoDenovi(){
        int i = 30 - poceten;
        i += (kmesec - pmesec - 1) * 30;
        i += kraen;
        return i;
    }
    @Override
    public String getIme(){
        return super.getIme();
    }
}


class GodishenOdmor extends Patuvanje{
    private int vreme;

    public GodishenOdmor(String ime,int cena,int vreme){
        super(ime,cena);
        this.vreme = vreme;
    }
    public int vratiVremeVoDenovi(){
        return vreme;
    }
    public int getCena(){
        return super.getCena() - 1000;
    }
    @Override
    public String getIme(){
        return super.getIme();
    }
}

public class Test {


    public static void main(String[] args) {


        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        Patuvanje nizaPatuvanje[]=new Patuvanje[n];

        for (int i=0;i<n;i++){
            int tip=in.nextInt();
            if (tip==0){
                String ime=in.next();
                int cena =in.nextInt();
                int vreme=in.nextInt();
                nizaPatuvanje[i]=new GodishenOdmor(ime,cena,vreme);
            }
            else {
                String ime=in.next();
                int cena =in.nextInt();
                int pocD=in.nextInt();
                int pocM=in.nextInt();
                int krajD=in.nextInt();
                int krajM=in.nextInt();
                nizaPatuvanje[i]=new PraznicnoPatuvanje(ime,cena,pocD,pocM, krajD,krajM);

            }
        }

        //решение на барање 1
        for(int i=0;i<nizaPatuvanje.length;i++){
            if(nizaPatuvanje[i].getPM() == 6){
                System.out.print(nizaPatuvanje[i].getIme() + " ");
            }
        }
        System.out.println();
        //решение на барање 2
        int vkp = 0;
        for(int i=0;i<nizaPatuvanje.length;i++){
            vkp += nizaPatuvanje[i].vratiVremeVoDenovi();
        }
        float pros = (float) vkp/nizaPatuvanje.length;
        System.out.println(pros);
        //решение на барање 3
        String ime = in.next();
        int cena = in.nextInt();
        int vreme = in.nextInt();
        GodishenOdmor odmor = new GodishenOdmor(ime,cena,vreme);
        //решение на барање 4
        int miniCena = Patuvanje.vratiMiniCena(nizaPatuvanje,nizaPatuvanje.length,odmor);
        System.out.println(miniCena);



    }

}
