package com.ktk.day09;


public class KimLinked {
    private Node first;
    private int cnt;

    public int size(){
        return cnt;
    }

    public void add(Object obj){
        cnt++;
        Node newNode = new Node(obj);
        if(first == null) first = newNode;
        else{
            Node temp = first;
            while(true){
                if(temp.getNext() == null) break;
                else temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public Object get(int idx){
        Node node = first;
        for (int i = 0; i < idx; i++) {
            node = node.getNext();
        }

        return node.getVal();
    }

    public void set(int idx, Object obj){

    }

    public void remove(int idx){

    }

}
