package com.bit.day09;

class Node{
	int val;
	Node nxt;
}

class BitLinked{
	Node firstNode;
	int cnt = 0;
	
	public void add(int su) {
		cnt++;
		Node node = new Node();
		node.val = su;
		if(cnt == 1) {
			firstNode = node;
		}
		else {
			Node temp = firstNode;
			while(true) {
				if(temp.nxt == null) break;
				else temp = temp.nxt;
			}
			temp.nxt = node;
		}
	}
	
	public int get(int idx) {
		Node temp = firstNode;
		
		for (int i = 0; i < idx; i++) {
			temp = temp.nxt;
		}
		
		return temp.val;
	}
}

public class Ex05 {

	public static void main(String[] args) {
		BitLinked list = new BitLinked();
		list.add(1111);
		list.add(2222);
		list.add(3333);
		list.add(4444);
		
		
		
		for (int i = 0; i < 4; i++) {
			System.out.println(list.get(i));
		}
	}

}
