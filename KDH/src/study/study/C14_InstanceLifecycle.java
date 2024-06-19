package study;

public class C14_InstanceLifecycle {
	
	int[] arr = new int[10];
	
	static {
		//스테틱 블록
		System.out.println("스테틱블록1 실행됨...");
		
		
	}
	
	static {
		//스테틱 블록
		System.out.println("스테틱블록2 실행됨...");
	}
	
	{
		//인스턴스 블록
		System.out.println("인스턴스블록1 실행됨...");
	}
	
	{
		//인스턴스 블록
		System.out.println("인스턴스블록2 실행됨...");
	}
	
	public C14_InstanceLifecycle() {
		// 생성자 블록
		System.out.println("생성자 실행됨");
	}
	
	public static void main(String[] args) {
		new C14_InstanceLifecycle();
	}
}
