//package study;
//
//import java.util.Arrays;
//import myobj.Book;
//public class C05_ReferencesType {
//	/*
//	 	# 기본형 데이터 타입
//	 	- int, float, short, double, byte, long... 등
//	 	  소문자로 시작하는 타입들
//	 	- 기본형 데이터 타입 변수에는 실제 값이 저장된다
//	 	- 기본형 데이터 타입에는 .을 찍고 사용할 수 없다
//
//	 	# 참조형 데이터 타입
//	 	- String
//	 	- 배열
//	 	- 그외 모든 클래스들
//	 	- 참조형 데이터 타입 변수에는 원본을 가리키는 주소값이 저장된다
//	 	- 참조형 변수에는 .을 찍고 변수에 저장된 주소를 참조할 수 있다
//
//	 */
//
//	// 기본형 타입 매개변수의 경우
//	public static void prinitiveType(int num) {
//		num = 123;
//	}
//
//	//참조형 타입 배열의 경우
//
//	public static void referencesType1(double[] arr) {
//		if(arr != null && arr.length != 0) {
//			arr[0] = 99.999;
//		}
//	}
//
//	// 내가 만든 클래스인 경우
//	public static void referencesType2(Book book) {
//		book.page = 121;
//	}
//
//	// 문자열의 경우
//	public static void referencesType3(String str) {
//		str = "Babo";
//	}
//
//
//	public static void main(String[] args) {
//
//		int a = 15;
//		System.out.println("기본형 before: " + a);
//		prinitiveType(a);
//		System.out.println("기본형 After: " + a);
//
//		//배열의 경우
//		double[] b = new double[3];
//
//		b[0] = 10.123;
//		b[1] = 11.3;
//		b[2] = 9.8;
//		System.out.println("배열의 before: " + Arrays.toString(b));
//		referencesType1(b);
//		System.out.println("배열의 After: " + Arrays.toString(b));
//
//		// 내가 만든 배열
//		Book c =new Book();
//		c.page = 1;
//		c.total_page = 10;
//
//		System.out.println("클래스 인스턴스의 Before: " + c.page);
//		referencesType2(c);
//		System.out.println("클래스 인스턴스의 After: " + c.page);
//
//		// 기본형 처럼 동작하게 구현되어있는 참조형
//		String d = new String("Hello!");
//
//		System.out.println("String의 Befor: " + d);
//		referencesType3(d);
//		System.out.println("String의 After:" + d);
//	}
//
//}
package study;

