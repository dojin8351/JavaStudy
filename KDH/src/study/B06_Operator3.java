package study;

public class B06_Operator3 {

	/*
	 	# 대입 연산자
	 	
	 	= : 왼쪽의 변수에 오른쪽의 값을 넣는다. 원래 있던 값에 덮어쓴다.
	 	
	 	# 복합 대입 연산자
	 	 += : 왼쪽의 변수에 오른쪽의 값을 더해서 누적시킨다
	 	 -= : 왼쪽 변수에 오른쪽의 값을 빼서 누적시킨다
	 	 /= : 왼쪽 변수에 오른쪽의 값을 나눠서 누적시킨다
	 	 *= : 왼쪽 변수에 오른쪽의 값을 곱해서 누적시킨다
	 	 %= : 왼쪽의 변수에 왼쪽의 변수를 오른쪽의 값으로 나눈 나머지를 저장한다
	 	 
	 	 ※ boolean 타입으로 하는 복합대입 연산
	 	 
	 	 &= : AND 연산을 누적시킨다
	 	 |= : OR 연산을 누적시킨다
	 	 ^= : XOR 연산을 누적시킨다
	 	 
	 	 # 단항 연산자
	 	 
	 	 	++ : 해당 변수에 1을 더해서 누적시킨다
	 	 	-- : 해당 변수에 1을 빼서 누적시킨다
	 	 	
	 	 # 단항 연산자 위치에 따른 차이
	 	 	
	 	 	- 단항 연산자가 변수 뒤에 붙어있는 경우
	 	 	  해당 줄의 모든 명령을 수행한 후 값을 변화시킨다
	 	 	  ex> a++, a--
	 	 	  
	 	 	- 단항 연산자가 변수 앞에 붙어있는 경우
	 	 	  해당 줄의 명령을 실행하기 전 먼저 값을 변화시킨다
	 	 	  ex> ++a, --a
	 */
	public static void main(String[] args) {
		int a = 10;
		
		System.out.println(a);
		a= 5;
		System.out.println(a);
		a = a + 3 ;
		System.out.println(a);
		a += 2;
		System.out.println(a);
		
		a = 30;
		
		a += 3;
		System.out.println(a);//33
		a -= 15;
		System.out.println(a);//18
		a *= 3;
		System.out.println(a);//54
		a /= 10.0; // 알아서 Typecasting
		System.out.println(a);//5
		a %= 2;
		System.out.println(a);//1
		
		//전달하면서 대입 연산을 하는 것도 가능하다
		System.out.println(a = 22);
		System.out.println(a += 3);
		System.out.println(a);
		
		boolean everyoneAgree = true;
		
		everyoneAgree &= true;
		everyoneAgree &= true;
		everyoneAgree &= false;
		everyoneAgree &= true;
		everyoneAgree &= true;
		
		// int값으로 논리 복합대입 연산을 하는 경우에는 이진법으로 연산한다
		int num = 10; // 1010
		
		num &= 3; // 0011
		
		System.out.println("모두가 동의했나요? " + everyoneAgree);
		System.out.println(num);		
		
		a = 15;
		
		a++; // a += 1;을 줄인것
		System.out.println(a);
		++a; 
		System.out.println(a);
		a--;
		System.out.println(a);
		--a;
		System.out.println(a);
		
		// ++,--가 붙는 위치에 따라 결과가 달라진다
		a = 10;
		System.out.println(++a);
		System.out.println(a);
		
	}

}
