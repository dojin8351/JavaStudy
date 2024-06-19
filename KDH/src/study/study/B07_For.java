package study;

public class B07_For {
		
	/*
	 	# 반복문 (Loop)
	 	
	 	- for, while, forEach, do-while(x)
	 	- 똑같은 코드를 여러번 반복하고 싶을 때 사용한다
	 	
	 	# for문
	 	  for (초기값; 반복조건; 증감값){
	 	  	반복 조건이 참인 동안 반복될코드
	 	  }
	 	  
	 	  - 초기값 : for문을 처음 시작하면 단 한번 실행되는 곳
	 	  			주로 반복자(iterator)를 초기화 하는데에 사용한다
	 	  - 반복조건 : 조건이 true인 동안 {}안의 내용을 계속 실행한다
	 	  			false면 {}안의 내용을 무시하고 반복문이 종료된다
	 	  - 증감값 : {}안의 코드를 모두 실행하고 나면 실행하는 곳
	 	  			주로 반복자의 값을 변화시키는 용도로 사용한다
	 */
	public static void main(String[] args) {
		
		/*
		 	1. 가장 기본적인 for문 
		 	- 초기값에는 0을 주고 조건에는 반복하고 싶은 횟수를 적고
		 	  증가는 1씩 진행하는 방식
		 	- 원하는 휫수만큼 반복하고 싶을 때 가장 많이 사용하는 형태
		 	
		 */
		for (int i = 0; i < 10; ++i) {
		System.out.println("Hello world! " + i);				
		}
		
		/*
		 	2. 값을 자유롭게 설정한 for문
		 	- for문을 자유롭게 변경하여 용도에 맞게 사용하는 경우
		*/
		//ex> 50 ~1까지 거꾸로 출력하고 싶은 경우
		for (int i = 50; i > 0; --i) {
			System.out.println("i: " + i);
		}
		//ex> 2의 제곱을 출력해보고 싶은 경우
		for (int i = 1; i < 10000; i *= 2) {
			System.out.println("i: " + i);
		}
		//ex> 3의 제곱을 출력해보고 싶은 경우
		for (int i = 1; i < 10000; i *= 3) {
			System.out.println("i: " + i);
		}
		
		// <연습> byte 타입의 모든 값을 최소값 부터 최대값 까지 출력해보세요
		//for (int b1 = -128; b1 < 128; b1++) {
			//if ( b1 == 127) {
				//System.out.print(b1 + "\n");
			//} else {
			//System.out.print(b1 + ",");
			//}
		//}	
		// <연습2> char타입의 모든 문자를 최소값부터 최대값까지 출력해보세요
		//for (int c = 0; c <= 65536; c++) {
			
			//System.out.println((char)c);
			}
		/*
		 	 3. 각 자리의 값을 생략한 for문
		 	 - 각 자리의 값은 적지 않아도 된다
		 	 - 반복 조건을 생략하면 무한 반복을 한다
		 	 
		 */
		//char a = '7';
		//for(;a < 100;) {
		//System.out.println("프로그램이 끝났습니다!" + a);
		//a += a;
		//}
	}

//}