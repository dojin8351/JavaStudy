package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button1 = new JButton();
		
        ImageIcon icon = new ImageIcon("image/메인페이지.png");
        JLabel label = new JLabel(icon);
        
        button1.setBounds(325, 502,100,50);
        
        frame.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);  // 라벨을 프레임에 추가
        frame.pack();  // 프레임 크기를 내용물에 맞게 조정
        
        frame.setVisible(true);
	}
	
	
}



