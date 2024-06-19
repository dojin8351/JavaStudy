//package study;
//
//import myobj.Apple;
//
///*
//	 	# Object Class
//	 	- 모든 클래스들의 최고 조상 클래스
//	 	- 자바에 존재하는 모든 객체는 Object 클래스의 자손이다
//	 	- Object 클래스의 매서드는 모든 클래스 내부에 이미 상속받아져 존재하고 있다
//	 	- Object 클래스의 매서드는 주로 해당 클래스에 맞는 형태로
//	 	  오버라이드 하여 사용하게끔 설계되어있다
//
//	 	 # toString()
//	 	 - "해당 객체를 문자열로 표현한다면 어떤 모양이어야 하는가"를 정의해두는 메서드
//	 	 - 자바의 모든 객체는 toString()을 통해 문자열로 표현될 수 있다
//	 	 - Object 클래스에 정의되어있는 toString()의 원형은 해당 클래스의 이름과
//	 	   메모리 상의 주소값을 출력하게 되어있다
//	 	 - toString() 기본 동작이 싫다면 해당 매서드를 오버라이드하여 사용하면 된다
//
//	 	 # equals(obj)
//	 	 - "두 인스턴스가 같다고 판정하는 기준은 무엇인가" 를 정의해두는 메서드
//	 	 - 매개변수로 전달받은 인스턴스와 현재 인스턴스(this)를 비교하여 결과를 리턴한다
//	 	 - Object 클래스에 정의되어있는 기본 동작은 두 인스턴스가 같은 인스턴스인지를 비교하게 끔 만들어져 있다
//
//	 	 # hashcode()
//	 	 - "해당 객체를 유일하게 구분할 수 있는 값은 무엇인가"를 정의해두는 메서드
//	 	 - 해당 인스턴스의 지문 같은 역할을 하는 메서드
//	 	 - Object 클래스에 정의되어있는 기본 동작은 해당 인스턴스의
//	 	   주소값을 리턴하게끔 구현되어 있다
//	 */
//
//public class C08_Object {
//	public static void main(String[] args) {
//		Wolf w1 = new Dog("춘식이");
//		Object o1 = new Dog("몽실이");
//		Dog d1 = new Dog("춘자", "1234");
//		Dog d2 = new Dog("춘자", "3456");
//		Dog d3 = new Dog("진돌이", "1234");
//
//		System.out.println(d1.toString());
//		System.out.println(o1.toString());
//
//		System.out.println(d2);
//		System.out.println(o1);
//		System.out.println(w1);
//
//		System.out.println(d1.equals(d2));
//		System.out.println(d1.equals(d3));
//		System.out.println(d1.equals(new Apple()));
//
//		System.out.println(d1.hashCode());
//		System.out.println(d2.hashCode());
//		System.out.println(d3.hashCode());
//
//		// String은 hashCode()가 구현되어 있는 클래스이기 때문에
//		// hashCode()메서드 실행시 메모리 주소대신 문자열 값에 기반한 숫자값이 생성된다
//		String str1 = new String("abcd");
//		String str2 = new String("abcd");
//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//
//
//
//	}
//
//}
//
///*
// 	toString(), equals(), hashCode()를 모두 사용할 만한 적절한 클래스를 하나 설계해 보세요
// */
//
//
//
//
//
//
//
//
//
//
package study;


