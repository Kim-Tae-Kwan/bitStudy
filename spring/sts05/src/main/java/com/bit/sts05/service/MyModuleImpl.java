package com.bit.sts05.service;

public class MyModuleImpl implements MyModule {
	
	@Override
	public void func01() {
		System.out.println("ù��° ����� �����մϴ�...");
	}
	
	@Override
	public void func02(int su) {
		System.out.println(su + "�� ���� ���� �ι�° ����Դϴ�.");
	}
	
	@Override
	public String func03() {
		String msg = "����°";
		System.out.println(msg + "�� �����ϴ� ����° ���.");
		return msg;
	}

	@Override
	public void func04() {
		Object[] obj = new Object[1];
		obj[4] = "asdf";
	}
	
}
