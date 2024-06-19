package study;


public class C01_FunctionOverloading {
	/*
	 	# 함수 오버로딩 (Overloading)
	 	- 같은 이름의 함수를 다양한 버전으로 여러개 만드는것
	 	- 같은 이름으로 다른 버전이 되기 위해서는 매개변수의 개수 또는 타입이 달라야 한다
	 	- 리턴 타입이 다른것만으로는 다른 버전으로 인정되지 않는다
	 	
	 	
	 */
	
	public static int add(int a) {
		return a ;
	}
	
	
	// 리턴 타입이 다른것만으로는 오버로딩을 할 수 없다
	//public static double add(int a) {
	//	return a +10.0;
	//}
	
	// 매개변수의 개수는 같지만 타입이 다른 오버로딩
		public static double add(double a) {
			return a +10.0;
		}
	
	//매개변수의 개수가 다른 오버로딩
	public static int add(int a, int b) {
		return a +b;
	}
	
	public static void main(String[] args) {
		C00_Function.rabbit();
		
		System.out.println(add(5,6));
		System.out.println(add(3, 3));
		

	}

}
