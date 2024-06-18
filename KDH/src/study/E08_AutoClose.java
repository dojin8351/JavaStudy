package study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E08_AutoClose {
	public static void main(String[] args) {
		// 닫을 수 있는 (Closeable 인터페이스가 구현된	) 클래스는
		// try문을 사용할 때 AutoClose문법을 사용할 수 있다
		
		// try문에 ()열고 사용한 변수는 try문이 끝나면서 자동으로 닫히게 된다
		try(
			//FileReader in = new FileReader("myfiles/test1.txt");
			FileWriter out = new FileWriter("myfiles/copiedEmails.txt",true);	
		) {
			// FileWriterdml append값을 true로 주면 추가 모드가 되어서vk
			// 파일에 내용을 계속 누적시키게된다
			out.write("안녕하세요");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
