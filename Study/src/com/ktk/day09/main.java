package com.ktk.day09;

public class main {

	public static void main(String[] args) {
		//ArrayList
		KimArray array = new KimArray();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.set(0, 0);
		array.remove(1);

		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		System.out.println("--------------------------");

		// Queue
		KimQueue que = new KimArray();
		que.add(1);
		que.add(2);
		que.add(3);

		while(true){
			Object obj = que.poll();
			if(obj == null) break;
			System.out.println(obj);
		}
		System.out.println("--------------------------");

		// Stack
		KimStack stack = new KimArray();
		stack.add(1);
		stack.add(2);
		stack.add(3);

		while(true){
			Object obj = stack.pop();
			if(obj == null) break;
			System.out.println(obj);
		}
		System.out.println("--------------------------");

		KimLinked list = new KimLinked();
		list.add(1);
		list.add(2);
		list.add(3);

		for (int i = 0; i < list.size(); i++) {
			System.out.println((Integer) list.get(i));
		}
	}

}
