package com.ktk.day09;

public class KimArray implements KimQueue, KimStack{
	private Object[] arr = new Object[0];
	
	public int size() {
		return arr.length;
	}
	
	public void add(Object obj) {
		Object[] before = arr;
		arr = new Object[before.length + 1];
		if(before.length > 0) System.arraycopy(before, 0, arr, 0, before.length);

		arr[arr.length - 1] = obj;
	}
	
	public Object get(int idx) {
		return arr[idx];
	}
	
	public void set(int idx, Object obj) {
		arr[idx] = obj;
	}
	
	public void remove(int idx) {
		Object[] before = arr;
		arr = new Object[before.length - 1];
		System.arraycopy(before, 0, arr, 0, idx);
		System.arraycopy(before, idx + 1, arr, idx, before.length - 1 - idx);
		
	}

	//Queue
	public Object poll(){
		if(size() == 0) return null;
		Object obj = arr[0];
		remove(0);
		return obj;
	}

	public Object pop(){
		if(size() == 0) return null;
		Object obj = arr[size() - 1];
		remove(size() - 1);
		return obj;
	}
}
