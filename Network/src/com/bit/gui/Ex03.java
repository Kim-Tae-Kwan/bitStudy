package com.bit.gui;
// 이벤트

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03{
	public static void main(String[] args) {
		Frame frame = new Frame();
		Panel panel = new Panel();
		TextField field = new TextField(20);
		WindowAdapter listener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		};
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(field.getText());
				field.setText("");
			}
		};
		
		frame.addWindowListener(listener);
		frame.setVisible(true);
		frame.setSize(500, 400);
		frame.setLocation(100, 100);
		
		panel.add(field);
		
		field.addActionListener(actionListener);
		
		Button button = new Button("exit");
		button.addActionListener(actionListener);
		
		
		panel.add(button);
		
		frame.add(panel);
		frame.repaint();
		frame.validate();
		frame.revalidate();
	}
}
