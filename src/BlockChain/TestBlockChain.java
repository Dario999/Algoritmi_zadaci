package BlockChain;

import java.util.*;
import java.io.*;


class Block<E>{
    int index;
    E data;
    int hash;
    int previousHash;

    public Block(int index,E data,int previousHash){
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = Integer.parseInt(Integer.toString(index) + data + Integer.toString(previousHash));
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(Integer.toString(index) + data + Integer.toString(previousHash));
    }

}

class SLL<E> {
    private ArrayList<Block> blockchain;

    public SLL() {
        // Construct an empty SLL
        this.blockchain = null;
    }

    public int getBlock(int i){
        return blockchain.get(i).hash;
    }

    public int getPreviousHash(int i){
        return blockchain.get(i).hash;
    }

    public void createRoot(E data){
        blockchain.get(0).index = 0;
        blockchain.get(0).previousHash = 0;
        blockchain.get(0).data = data;
    }
    public void addBlock(Block<E> b){

        blockchain.add(b);
    }

    public void deleteBlock(int hashValue){
        for(int i=0;i<blockchain.size();i++){
            if(blockchain.get(i).hash == hashValue){
                blockchain.remove(i);
                break;
            }else{
                continue;
            }
        }
    }
    public boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        for(int i=0;i<blockchain.size();i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if(!(currentBlock.hash == currentBlock.hashCode())){
                return false;
            }
            if(!(previousBlock.hash == currentBlock.previousHash)){
                return false;
            }
        }
        return true;
    }

}

public class TestBlockChain {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        SLL<String> lista = new SLL<String>();
        lista.createRoot(br.readLine());
        for(int i=1;i<n;i++){
            int index = Integer.parseInt(br.readLine());
            String data = br.readLine();
            lista.addBlock(new Block<String>(index,data,lista.getPreviousHash(i)));
        }

        String red;
        while(true){
            red = br.readLine();
            if(red.equals("KRAJ")){
                break;
            }
            int b = Integer.parseInt(red);
            if(b == 1){
                int indx = Integer.parseInt(br.readLine());
                String tmp = br.readLine();
                lista.addBlock(new Block<String>(indx,tmp,lista.getPreviousHash(indx)));
            }else if(b == 2){
                int hash = Integer.parseInt(br.readLine());
                lista.deleteBlock(hash);
            }else{
                if(lista.isChainValid()){
                    System.out.println("Da");
                }else{
                    System.out.println("Ne");
                }
            }
        }

    }
}
