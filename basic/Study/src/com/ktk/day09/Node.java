package com.ktk.day09;

public class Node {
    private Object val;
    private Node node;

    public Node(Object val) {
        this.val = val;
    }

    public Object getVal(){
        return val;
    }

    public Node getNext(){
        return node;
    }

    public void setNext(Node node) {
        this.node = node;
    }
}
