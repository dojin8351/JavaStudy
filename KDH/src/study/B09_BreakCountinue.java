package study;
public class B09_BreakCountinue {

	/*
	 * # break 
	  	- scitch-case문 내부에서 사용하면 해당 case를 탈출한다 
	  	- 반복문 내부에서 사용하면 해당 반복문을 탈출한다
	  
	  # continue 
	  	- 반복문 내부에서 continue를 만나면 즉시 다음번 반복으로 넘어간다
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 1000; ++i) {
			System.out.println(i);

			// i값이 323 일때 break를 만나 반복문을 탈출한다
			if (i == 323) {
				break;
			}
		}
		System.out.println("------------------------------------");
		// Ctrl + Shift + F : 자동 줄 맞춤
		for (int i = 0; i < 100; ++i) {
			if (i % 2 == 0) {
				continue;
			} 

			System.out.println(i);
		}
	}

}
