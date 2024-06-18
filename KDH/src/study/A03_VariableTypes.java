package study;

public class A03_VariableTypes {
	
	/*
	 	# 정수 타입
	 	
	 		- byte 	(1byte, 8bit)
	 		2^8(256)가지의 값을 표현할 수 있다
	 		byte타입 변수에 넣을 수 있는 정수의 범위는 -128 ~ +127(256가지)
	 		
	 		- short 	(2byte, 16bit)
	 		short타입 변수에 넣을 수 있는 정수의 범위는 -32,768~ +32,767(65536가지)
	 		
	 		- char 	(unsigned 2byte)
	 		2^16값을 표현할 수 있으나 부호가 없다 (양수만 표현한다) 표현 가능한 정수 범위는 0~65536(65536가지)

	 		- int	(4byte, 32bit)
	 		int타입 변수에 넣을 수 있는 정수의 범위는 -2,147,483,648 ~ +2,147,483,647(4,294,967,296가지)
	 		 
	 		- long	(8byte, 64bit)
	 		long타입 변수에 넣을 수 있는 정수의 범위는 -9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807(18,446,744,073,709,551,616가지)
	 		
	 	# 실수 타입
	 		
	 		- float (4byte)
	 		- double (8byte)
	 		
	 	
	 	# 참/거짓 타입
	 		
	 		- boolean
	 		
	 	# 참조형 변수 타입
	 		- 문자열
	 		- 그 외 모든 타입 (모든 클래스, 객체지향 관련 내용)
	 */
	public static void main(String[] args) {
		byte max_byte = 127, min_byte = -128;
		short max_short = 32767 , min_short = -32768;
		int max_int = 2_147_483_647 , min_int = -2_147_483_648;
		long max_long = 9_223_372_036_854_775_807L;
		long min_long = -9_223_372_036_854_775_808L;
		
		// char 타입에는 0~65535의 문자 번호를 정수타입으로 보관할 수 있다.
		// (ASCII 코드표 검색)
		
		// ch1 ~ ch5번의 값을 변경하여 Lunch라고 출력되게 만들어보세요
		char ch1 = 76;
		char ch2 = 117;
		char ch3 = 110;
		char ch4 = 99;
		char ch5 = 104;
		
		System.out.println("" + ch1 + ch2 + ch3 + ch4 +ch5);
		
		char ch6 = 'L';
		char ch7 = 'u';
		char ch8 = 'n';
		char ch9 = 'c';
		char ch0 = 'h';
		
		System.out.println("" + ch6 + ch7 + ch8 + ch9 +ch0);
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		
		System.out.println("byte타입에 들어갈 수 있는 가장 큰 값은 " + max_byte + "이고, "
				+ "가장 작은 값은" + min_byte + "입니다.");
		System.out.println("short타입에 들어갈 수 있는 가장 큰 값은 " + max_short + "이고, "
				+ "가장 작은 값은" + min_short + "입니다.");
		System.out.println("int타입에 들어갈 수 있는 가장 큰 값은 " + max_int + "이고, "
				+ "가장 작은 값은" + min_int + "입니다.");
		System.out.println("long타입에 들어갈 수 있는 가장 큰 값은 " + max_long + "이고, "
				+ "가장 작은 값은" + min_long + "입니다.");
		
		// 정수 리터럴의 기본 타입은 int
		// 실수 리터럴의 기본 타입은 double
		
		// 8byte 크기의 실수 리터럴을 float타입 변수에 저장할 수 없으므로
		// 뒤에 F를 붙여 float타입 리터럴임을 명시해야 한다.
		float f1 = 123.123f;
		double d1 = 123.123;
		
		System.out.println("평균 점수: " + d1 + "점");
		System.out.println("평균 몸무게: " + f1 + "kg");
		
		// true, flase 대신 1과 0을 사용하는 언어도 있다
		boolean pass_exam = true;
		boolean goonpil = false;
		boolean late = true;
		
		System.out.println("통과 여부: " + pass_exam);
		System.out.println("군필: " + goonpil);
		System.out.println("지각 여부: " + late);
		
		String text = "My name is hamburger";
		
		System.out.println(text);
		
		
		
		
		
	}

}

