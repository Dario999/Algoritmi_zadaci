package BinarySearchTree;

import java.util.*;
import java.io.*;

class BNode<E extends Comparable<E>>{
    public E info;
    public BNode<E> left;
    public BNode<E> right;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode(E info,BNode<E> left,BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree<E extends Comparable<E>>{
    private BNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }
    private BNode<E> insert(E x,BNode<E> t){
        if(t == null) {
            t = new BNode<E>(x,null,null);
        }else if(x.compareTo(t.info) < 0) {
            t.left = insert(x , t.left);
        }else if(x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
        }else;
        return t;
    }
    public void insert(E x) {
        root = insert(x,root);
    }
    void remove(E x) {

    }
    private BNode<E> find(E x,BNode<E> t){
        if(t == null) {
            return null;
        }

        if(x.compareTo(t.info) < 0) {
            return find(x,t.left);
        }else if(x.compareTo(t.info) > 0) {
            return find(x, t.right);
        }else {
            return t;
        }
    }
    public BNode<E> find(E x){
        return find(x,root);
    }
    /*private BNode<E> findMin(BNode<E> t){
        if(t == null) {
            return null;
        }else if(t.left == null) {
            return t;
        }
        return findMin(t.left);
    }
    public E findMin() {
        return elementAt(findMin(root));
    }
    private BNode<E> findMax(BNode<E> t){
        if(t == null) {
            return null;
        }else if(t.right == null) {
            return t;
        }
        return findMax(t.right);
    }
    E findMax() {
        return elementAt(findMax(root));
    }*/
    boolean isEmpty() {
        return true;
    }
    void printTree() {

    }
}

public class main {

}
