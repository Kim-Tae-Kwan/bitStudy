package com.bit.gui;

import java.awt.*;

import javax.swing.*;

public class Ex01 {

	public static void main(String[] args) {
		// GUI
		// AWT - 운영체제 의존적.
		// SWING - 운영체제 종속성 없음, 자바직접.

		// 배치 관리자 - 컴포넌트 요소를 화면에 위치와 크기를 자동 결정.
		// 1. FlowLayout.   -> 중앙정렬, 컴포넌트 사이즈는 내용에 따라 결정.
		// 2. GridLayout.
		// 3. BorderLayout. -> 가장 많이 사용.
		// 4. CardLayout.   -> 화면 전환.
		// 5. GridBagLayout.
		// 6. 배치관리자 사용 안함. -> 위치, 크기 직접 설정해야함.
		
		Frame frame = new Frame();
		frame.setVisible(true); // 화면에 표출.
		frame.setSize(400, 300);
		frame.setLocation(300, 300);
		
		Button button = new Button();
		button.setLabel("first");
		button.setLocation(100,100);
		button.setSize(100, 100);
		Button button2 = new Button();
		button2.setLabel("second");
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.add(button);
		panel.add(button2);
		frame.add(panel);
	}
}
