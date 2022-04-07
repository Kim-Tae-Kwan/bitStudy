package com.bit.gui;

import java.awt.*;

//컴포넌트 종류.

public class Ex02 extends Frame{

	public Ex02() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
		Panel panel = new Panel();
		
		Button button = new Button("안녕");
		button.setFont(font);
		
		Label label = new Label("test");
		
		TextField field = new TextField("", 20);
		field.setText("zzzz");
		
		TextArea area = new TextArea("내용 입력.", 1, 10);
		System.out.println(area.getText());
		
		Checkbox checkbox = new Checkbox("aaaa");
		Checkbox checkbox1 = new Checkbox("bbbb");
		Checkbox checkbox2 = new Checkbox("cccc");
		System.out.println(checkbox.getState());
		
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox radio = new Checkbox("aaaa", cbg, false);
		Checkbox radio2 = new Checkbox("bbbb", cbg, true);
		Checkbox radio3 = new Checkbox("cccc", cbg, false);
		
		Choice choice = new Choice();
		choice.addItem("item1");
		choice.addItem("item2");
		choice.addItem("item3");
		choice.addItem("item4");
		choice.addItem("item5");
		choice.select(2);
		System.out.println(choice.getSelectedIndex());
		System.out.println(choice.getSelectedItem());
		
		List list = new List();
		list.add("첫번째");
		list.add("두번째");
		list.add("세번째");
		list.add("네번째");
		list.add("다섯번째");
		System.out.println(list.getItem(1));
		System.out.println(list.getSelectedIndex());
		System.out.println(list.getSelectedItem());
		
		panel.add(button);
		panel.add(label);
		panel.add(field);
		panel.add(area);
		panel.add(checkbox);
		panel.add(checkbox1);
		panel.add(checkbox2);
		panel.add(radio);
		panel.add(radio2);
		panel.add(radio3);
		panel.add(choice);
		panel.add(list);
		
		add(panel);
		setSize(500, 400);
		setLocation(100, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex02();
	}

}
