package study;


public class C02_OOP_T {
	/*
	   실제로 존재하는 객체를 하나 참조하여 클래스를 생성한 후 테스트 해보세요
	   (책 금지, 변수 3개 이상, 매서드 2개 이상)
	*/
	public static void main (String[] args) {
		
		Cafe c1 = new Cafe();
		Cafe c2 = new Cafe();
		Cafe c3 = new Cafe();
		
		c1.changeName("빽다방");
		c2.changeName("얼음값500원카페");
		c3.changeName("스벅");
		
		c1.addMenu("아메리카노", 10, 2000);
		c1.addMenu("빽사이즈 아메리카노", 20, 3000);
		
		
		c2.addMenu("아메리카노", 10, 1800);
		
		c3.addMenu("민트초코", 50, 6100);
		
		c1.printCafeInfo();
		c2.printCafeInfo();
		c3.printCafeInfo();
	}

}
class Cafe{
	// 나중에 인스턴스 생성시의 기본값을 설정해 놓을 수 있다
	String name = "기본카페이름";
	int area = 10;
	int seat = 20;
	int table = 5;
	CafeMenu[] menu = new CafeMenu[6];
	int menuCount = 0;
	
	// 매개변수명과 인스턴스변수명이 같은 경우 this를 활용해 구분해 줄 수 있다
	void changeName(String name) {
		this.name = name;
	}
	
	void printCafeInfo() {
		System.out.printf("카페이름: %s\n", this.name);
		System.out.printf("카페면적: %d\n", this.area);
		System.out.printf("카페좌석수: %d\n", this.seat);
		System.out.printf("카페테이블수: %d\n", this.table);
		
		System.out.println("#### 메뉴판 ####");
		for( int i = 0; i <menu.length; ++i) {
			if(menu[i] != null) {
			System.out.printf("- %s : %d원(%dkcal)\n",
					menu[i].name, menu[i].price, menu[i].calories);
			}else {
				System.out.println(menu[i]);
			}
			
		}
	}
	
	void addMenu(String name, int calories, int price) {
		CafeMenu toAdd = new CafeMenu();
		
		toAdd.name = name;
		toAdd.calories = calories;
		toAdd.price = price;
		
		this.menu[this.menuCount++] = toAdd;
	}
}

class CafeMenu{
	String name;
	int calories;
	int price;
}