package study;


public class C06_ExtendT {

	public static void main(String[] args) {
		

	}

}

class Building{
	double progress;
	
	void build() {
		progress += 5.5;
	}
}

class PurchaseBuilding extends Building {
	//상속받은 자식 클래스는 반드시 부모의 생성자인 super()를 가장 먼저 호출해야한다
	//하지만 기본 생성자는 생략이 가능하기 때문에 안적은것처럼 보이는 경우도 있다
	public PurchaseBuilding() {
		super();
		int a =10;
	}
	void purchase() {}
	void sell() {}
}

class UpgradeBuilding extends Building{
	void upgrade() {}
}

class CreationBuilding extends Building{
	void creat() {}
}