package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S03_JButton extends JFrame {
	
	public S03_JButton(String title) {
		super(title);
		
		JButton btn1 = new JButton("버튼1");
		
		// 버튼 크기 설정하기 (레이아웃이 null일때만 적용)
		btn1.setSize(300, 200);
		
		// 버튼 위치 설정하기 (레이아웃이 null일때만 적용)
		btn1.setLocation(100, 100);
		
		// 버튼 텍스트 바꾸기 (html태그가 먹힘)
		btn1.setText("<html>궁서체입니다<br> 안녕하세요</html>");
		
		// 버튼 글꼴 바꾸기 (글꼴, 스타일, 크기)
		// 스타일 - Font.BOLD, font.Italic
		btn1.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 35));
		
		// 버튼을 눌렀을 때의 동작 설정 (이벤트 추가)
		// 버튼을 누를때마다 ActionListener 인터페이스를 구현한 클래스의
		// actionPerformed() 메서드가 실행된다
		btn1.addActionListener(new ActionListener() {
			int cnt = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; ++i) {
					
					System.out.println("Hi!" + cnt++);
				}
			}
		});
		
		this.add(btn1);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new S03_JButton("JFrame Title");
	}
}
