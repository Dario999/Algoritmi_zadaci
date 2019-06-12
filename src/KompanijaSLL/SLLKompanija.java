package KompanijaSLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode{
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id,int plata,SLLNode succ){
        this.id = id;
        this.plata = plata;
        this.succ = succ;
    }
}

class SLL{
    private SLLNode first;

    public SLL(){
        this.first = null;
    }

    public void insertFirst(int id,int plata){
        SLLNode ins = new SLLNode(id,plata,first);
        first = ins;
    }

    public void insertLast(int id,int plata){
        if(first!=null){
            SLLNode tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id,plata,null);
            tmp.succ = ins;
        }else{
            insertFirst(id,plata);
        }
    }

    public void delete(SLLNode node){
        if(first != null){
            SLLNode tmp = first;
            while(tmp.succ != null&&tmp.succ.succ != null) {
                if(tmp == node){
                    tmp = tmp.succ.succ;
                    return;
                }
                tmp = tmp.succ;
            }
        }
    }

    public SLLNode getFirst(){
        return first;
    }

    public SLL removeLower(int iznos){
        SLL lista1 = new SLL();
        if(first!=null){
            SLLNode tmp = first;
            while (tmp != null){
                if(tmp.plata>=iznos){
                    lista1.insertLast(tmp.id,tmp.plata);
                    tmp = tmp.succ;
                }else {
                    tmp = tmp.succ;
                }
            }
        }
        return lista1;
    }

    public SLL sortiraj_opagacki(){
        int new_ID,new_Plata;
        if(first!=null){
            SLLNode jazol1 = first;
            if(jazol1 != null && jazol1.succ != null){
                SLLNode jazol2 = null;
                while(jazol1 != null){
                    jazol2 = jazol1.succ;
                    while(jazol2!=null){
                        if(jazol1.id<jazol2.id){
                            new_ID = jazol1.id;
                            new_Plata = jazol1.plata;
                            jazol1.id = jazol2.id;
                            jazol1.plata = jazol2.plata;
                            jazol2.id = new_ID;
                            jazol2.plata = new_Plata;
                        }
                        jazol2 = jazol2.succ;
                    }
                    jazol1 = jazol1.succ;
                }
            }
        }
        return this;
    }

    public void print(){
        SLLNode tmp = first;
        if(tmp!=null){
            while(tmp!=null) {
                System.out.println(tmp.id + " " + tmp.plata);
                tmp = tmp.succ;
            }
        }else {
            System.out.println("nema");
        }
    }

}


public class SLLKompanija {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SLL lista = new SLL();
        String s = null;
        for(int i=0;i<n;i++){
            lista.insertLast(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()));
        }

        lista = lista.removeLower(Integer.parseInt(br.readLine()));
        if(lista!=null){
            lista.sortiraj_opagacki();
            lista.print();
        }

    }
}
