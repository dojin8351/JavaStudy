package study;

public class C12_Final {
	/*
	 	# final
	 	- 변수앞에 final을 붙이면 이후로는 변경할 수 없는 변수가 된다(상수)
	 	- 메서드 앞에 fanal을 붙이면 해당 메서드를 오버라이드 하는것이 금지된다
	 	- 클래스 앞에 final을 붙이면 해당 클래스를 상속 하는것이 금지된다
	 */
	public static void main(String[] args) {
		final int a = 10;
		final double PI = 3.14;
		
		//String은 final class이기 때문에 익명 상속도 불가능하다
		//String str = new String() {};
	}
}
