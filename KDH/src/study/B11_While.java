package study;


public class B11_While {
	/*
	 	# while문
	 	- for문과 사용법이 약간 다른 반복문
	 	- 초기값과 증감값의 위치가 정해져 있지 않아 더 자 유롭게 사용할 수 있다
	 	- ()안의 내용이 true 인 동안 {}의 내용을 계속 반복한다
	 	- 증감값의 위치에 따라 결과가 달라질 수 있으므로 주의한다
	 */
	public static void main(String[] args) {
		
		
		
		int i = 0;
		while(true) {
			if(i == 9) {
				System.out.println("Hello!" + i);
				break;
			}
			System.out.println("Hello!" + i);
			i++;
		}
		
		i = 0;
		while(i<10) {
			System.out.println("Hello!" + ++i);
		}
		//1~10까지 10개
		i = 0;
		while(i++<10) {
			System.out.println("Hello!" + i);
		}
		//10을 썻지만 1 ~ 9까지 9개 나오므로 잘 사용하지 않는다.
		i = 0;
		while(++i<10) {
			System.out.println("Hello!" + i);
		}
	}

}
