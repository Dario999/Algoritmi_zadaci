package MatricaNaSostedstvo;

import java.util.*;
import java.io.*;

class Graph<E>{
    int num_nodes;
    E nodes[];
    int adjMat[][];

    public Graph(int num_nodes){
        this.num_nodes = num_nodes;
        nodes = (E[])new Object[num_nodes];
        adjMat = new int[num_nodes][num_nodes];
        for(int i=0;i<this.num_nodes;i++)
            for(int j=0;j<this.num_nodes;j++)
                adjMat[i][j] = 0;
    }
    int adjacent(int x,int y){
        return (adjMat[x][y]!=0)?1:0;
    }
    void addEdge(int x,int y){
        adjMat[x][y] = 1;
        adjMat[y][x] = 1;
    }
    void deleteEdge(int x,int y){
        adjMat[x][y] = 0;
        adjMat[y][x] = 0;
    }
    E get_node_value(int x){

        return nodes[x];
    }
    void set_node_value(int x,E a){

        nodes[x] = a;
    }
    public int getNum_nodes(){

        return num_nodes;
    }
    public void setNum_nodes(int num_nodes){

        this.num_nodes = num_nodes;
    }

}

public class main {
    public static void main(String[] args){
        Graph g;
        int start_node;
        int end_node;
        Hashtable<String,Integer> h;

    }
}
