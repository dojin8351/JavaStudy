package study;
public class B13_Array {
	/*
	 	# 배열(Array)
	 	- 같은 타입 변수를 여러개 선언하고 싶을 때 사용하는 문법
	 	- 배열을 선언할 때는 선언과 동시에 배열의 크기를 정해야 한다
	 	- 배열을 선언한 후 각 변수를 방 번호(index)로 구분한다
	 	- 배열의 인덱스는 0번부터 길이-1번까지 존재한다
	 	- 배열은 변수와는 다르게 선언과 동시에 모든 방이 초기화 되어있다
	 		(정수: 0, 실수: 0, boolean: false, 참조형: null)
	 		
	 	# 배열의 선언
	 	
	 	1. 타입[]변수먕 = new타입[크기];
	 	2. 타입[]변수명 = {값1, 값2, 값3 ...};
	 	3. 타입[]변수명 = new타입[]{값1, 값2, 값3 ...};
	 	
	 	※ 배열은 한번 선언되고 난 이후에는 크기 변경이 불가능 하다
	 */
	public static void main(String[] args) {
		
		// int타입 변수 100개를 선언한 것과 같다
		// (크기 100짜리 int형 배열을 선언)
		int[] numbers = new int[100];
		
		// 배열로 선언한 변수를 사용하고 싶을 때는 배열이름 뒤에 방 번호를 붙여야 한다
		// 배열의 방 번호는 0번부터 시작한다
		
		//선언한 배열에 값 대입하기
		numbers[0] = 10;
		numbers[1] = 13;
		numbers[2] = 99;
		numbers[3] = (int)(Math.random()*50+20);
		numbers[4] = 'A';
		
		// 마지막 인덱스는 (배열의 크기 -1)번이다
		numbers[99] = 1000;
		//numbers[100] = -123;
		
		// 배열의 값 꺼내서 활용하기
		System.out.println(numbers[0]);
		System.out.println(numbers[1] + numbers[2]);
		System.out.println(numbers[3]);
		
		// 배열은 for문으로 활용하기 딱 좋게 설계되어 있다
		// 배열.length로 해당 배열의 길이를 쉽게 구할 수 있따
		// (문자열은 "".length()로 소괄호를 붙여야 한다는 차이점 있음)
		for(int i = 0; i < numbers.length; ++i) {
			System.out.printf("numbers[%d] =%d\n", i, numbers[i]);			
		}
		
		// 값을 한번도 넣은적 없는 변수에는 0이 자동으로 들어가 있지 않다
		//int a, b, c;
		
		// 배열은 선언과 동시에 정해진 값으로 초기화 미리 해둠
		int[] numArr = new int[3];
		
		System.out.println(numArr[0]);
		System.out.println(numArr[1]);
		System.out.println(numArr[2]);
		
		boolean[] passTest = new boolean[30];
		
		passTest[3] = true;
		passTest[15] = true;
		
		for(int i = 0; i < passTest.length; ++i) {
			System.out.printf("passTest[%d]=%s\n", i, passTest[i]);
		}
		String[] strArr = new String[5];
		
		strArr[3] = "Good job!!";
		
		for(int i = 0; i < strArr.length; ++i) {
			System.out.printf("strArr[%d]=%s\n", i, strArr[i]);
		}
		
		// 여러가지 배열선언방식 2번
		int[] nums = {1, 3, 5, 7, 9};
		char[] message = {'H', 'e' , 'l', 'l', 'o', '!', '~'};
		String[] cmds = {"Is", "ipconfig", "chmod", "netstat"};
		String[] urls = new String[] {"naver.com", "google.com"};
		double[] avgs = new double[] {99.8, 75.5, 70.0, 60.8, '김', 3.1234f};
				
		// 배열은 그냥 출력하면 내용이 제대로 출력되지 않고 메모리상의 위치가 출력된다
		// 예외로 char[]은 문자열 취급을 받아 내용이 문자열처럼 출력된다
		System.out.println(nums);
		System.out.println(message);
		System.out.println(cmds);
		System.out.println(avgs);
		System.out.println(urls);
		//3번방식
	}

}
