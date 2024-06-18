package study;

public class C10_InnerClass {
	/*
	 	# 클래스 내부에도 클래스를 만들 수 있다
	 	
	 	- 해당 클래스의 인스턴스 변수에 영향을 받는 클래스를 만들 수 있다
	 	- 클래스 내부의 스태틱 클래스는 인스턴스와는 무관하지만 스태틱 변수에는
	 	  영향을 받을 수 있다
	 */
	
	int n;
	
	int l = 7;
	static int  L = 8;
	public C10_InnerClass(int n) {
		this.n = n;
	}
	
	class Bus{
		int num = n;
		int fee;
		int type;
	}
	
	static class Subway{
		int line = L;
		int color;
	}
	
	public static void main(String[] args) {
		// 클래스 내부의 인스턴스 클래스는
		// 바깥 클래스의 실체가 우선 생겨야 내부에 있는 클래스를 사용할 수 있다
		C10_InnerClass inner1 = new C10_InnerClass(13);
		C10_InnerClass inner2 = new C10_InnerClass(55);
		
		C10_InnerClass.Bus bus1 = inner1.new Bus();
		C10_InnerClass.Bus bus2 = inner2.new Bus();
		
		System.out.println(bus1.num);
		System.out.println(bus2.num);
		
		bus1 = bus2;
		
		//클래스 내부의 스태틱 클래스는
		// 바깥  클래스의 인스턴스 없이도 바로 사용할 수 있다
		C10_InnerClass.Subway subway = new C10_InnerClass.Subway();
		
		System.out.println(subway.line);
		
		Candy candy = new CandyFactory(1,1).getCandy();
		System.out.println(candy.flavor);
	}
}

class Candy{
	String flavor;
	
	Candy() {}
}

class CandyFactory{
	
	String[] koreanNames = {"레몬", "딸기맛", "사과맛"};
	String[] englishNames = {"Lemon", "StrawBerry", "Apple"};
	int fnum;
	int language;
	
	private class MyCandy extends Candy{
		public MyCandy() {
			switch(language) {
			case 0:
				flavor = koreanNames[fnum];
				break;
			default:
				flavor = englishNames[fnum];
				break;
			}
			
		}
	}
	
	public CandyFactory(int fnum, int language) {
		this.fnum = fnum;
		this.language = language;
	}
	
	public Candy getCandy() {
		return new MyCandy();
	}
}






