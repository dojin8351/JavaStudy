package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


class FlowLayoutExample {

	JFrame frameObj;

// constructor
	FlowLayoutExample() {
		// creating a frame object
		frameObj = new JFrame();

		// creating the buttons
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton b10 = new JButton("10");

		// adding the buttons to frame
		frameObj.add(b1);
		frameObj.add(b2);
		frameObj.add(b3);
		frameObj.add(b4);
		frameObj.add(b5);
		frameObj.add(b6);
		frameObj.add(b7);
		frameObj.add(b8);
		frameObj.add(b9);
		frameObj.add(b10);

		// parameter less constructor is used
		// therefore, alignment is center
		// horizontal as well as the vertical gap is 5 units.
		frameObj.setLayout(new FlowLayout(5));

		frameObj.setSize(700, 100);
		frameObj.setVisible(true);
	}

}

class GridLayoutExample {
	JFrame frameObj;

	GridLayoutExample() {
		frameObj = new JFrame();

 
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");

		frameObj.add(btn1);
		frameObj.add(btn2);
		frameObj.add(btn3);
		frameObj.add(btn4);
		frameObj.add(btn5);
		frameObj.add(btn6);
		frameObj.add(btn7);
		frameObj.add(btn8);
		frameObj.add(btn9);
		
		// 보더 레이아웃이 아닌 다른 레이아웃은 컨테이너에 설정해줘야 한다
		// GridLayout은 행과 열의 크기를 설정 할 수 있다
		frameObj.setLayout(new GridLayout(3, 3, 10, 20));
		
		frameObj.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameObj.setLocation(400, 100);
		frameObj.setSize(300, 300);
		frameObj.setVisible(true);
	}
}

class BorderLayoutWithoutRegionExample {
	JFrame jframe;

	BorderLayoutWithoutRegionExample() {
		jframe = new JFrame();

		JButton btn1 = new JButton("NORTH");
		JButton btn2 = new JButton("SOUTH");
		JButton btn3 = new JButton("EAST");
		JButton btn4 = new JButton("WEST");
		JButton btn5 = new JButton("CENTER");

		jframe.setLayout(new BorderLayout(7, 7));

		jframe.add(btn1);
		jframe.add(btn2);
		jframe.add(btn3);
		jframe.add(btn4);
		jframe.add(btn5);

		jframe.setSize(300, 300);
		jframe.setVisible(true);
	}
}

class Border {
	JFrame f;

	Border() {

		// 프레임 인스턴스 생성 (JFrame으로 만든 인스턴스는 기본적으로 BorderLayout이다)
		f = new JFrame();

		// 버튼 인스턴스 생성
		JButton b1 = new JButton("NORTH");
		JButton b2 = new JButton("SOUTH");
		JButton b3 = new JButton("EAST");
		JButton b4 = new JButton("WEST");
		JButton b5 = new JButton("CENTER");
		
		// 보더 레이아웃이 설정된 컨테이너에 컴포넌트를 붙일 때 방향을 설정 할 수 있다
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.add(b3, BorderLayout.EAST);
		f.add(b4, BorderLayout.WEST);
		f.add(b5, BorderLayout.CENTER);
		
		// 프레임의 기본 X버튼 동작이 눌렀을때 창을 사라지게 함 (DISPOSE_ON_CLOSE)
		// 프로그램이 제대로 종료되게 하려면 EXIT_ON_CLOSE로 변경해야 함
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);

	}
}

class CardLayoutExample1 extends JFrame implements ActionListener {

	CardLayout crd;
	JButton btn1, btn2, btn3;
	Container cPane;

	CardLayoutExample1() {
		cPane = getContentPane();
		crd = new CardLayout();

		cPane.setLayout(crd);

		btn1 = new JButton("Apple");
		btn2 = new JButton("Boy");
		btn3 = new JButton("Cat");

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		cPane.add("a", btn1);
		cPane.add("b", btn2); 
		cPane.add("c", btn3);

	}

	public void actionPerformed(ActionEvent e) {
		crd.next(cPane);
	}
}

public class S02_Layout {

	/*
	 * 
	 * # 레이아웃 (Layout)
	 * 
	 * - 컨테이너에는 레이아웃을 설정할 수 있다 - 레이아웃은 해당 컨테이너에 컴포넌트를 배치하는 방식을 결정한다 - 컨테이너의 레이아웃을
	 * null로 설정하면 컴포넌트를 모두 직접 배치해야 한다
	 * 
	 */

	public static void main(String[] args) {
		new Border();
		new BorderLayoutWithoutRegionExample();
		new CardLayoutExample1();
		new GridLayoutExample();
		new FlowLayoutExample();
	}
}
