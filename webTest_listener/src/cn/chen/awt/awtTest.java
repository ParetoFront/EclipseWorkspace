package cn.chen.awt;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class awtTest {
	public static void main(String[] args) {
		JFrame jf=new JFrame("hello");

		jf.setSize(300, 200);
		jf.setLocation(200, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new FlowLayout());   //流式布局
		JButton jb=new JButton("ok");
		jf.add(jb);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		jf.setVisible(true);
	}
}
