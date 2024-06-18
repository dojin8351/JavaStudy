package study;


public class C04_Static {
	/*
	 	# static (정적 영역, 클래스 영역 <=> 인스턴스 영역)
	 	- 인스턴스 영역의 반대 개념
	 	- 같은 클래스로 만들어진 모든 인스턴스들이 함께 사용하는 공동 영역
	 	- 앞에 static가 붙은 자원들은 모든 인스턴스들이 함께 사용하는 공동의 자원이 된다
	 	- static 영역의 자원은 인스턴스 이름이 아닌 클래스 이름으로 접근이 가능하다
	 	- static 영역은 인스턴스가 하나도 생성되지 않은 시점에도 존재한다
	 	  (최초로 해당 클래스가 호출되었을 때 생성된다)
	 	- static의 값은 인스턴스 영역에 대입할수 있지만 인스턴스영역 의 값을 static영역에 사용할수는 없다
	 	
	 	# static을 붙일 수 있는 자원
	 	
	 	- static 변수 (모든 인스턴스에서 항상 같은 값을 가지는 공동의 변수)
	 	- static메서드 (인스턴스가 존재하지 않을 때도 동작할 수 있는 메서드)
	 	- 클래스 내부의 static 클래스 (?)
	 	
	 */
	public static void main (String[] args) {
		// 인스턴스를 하나도 생성하지 않은 시점에도 static 자원을 활용할 수 있다
		System.out.println(TrumphCard.card_width);
		System.out.println(TrumphCard.card_height);
		
		TrumphCard spade_a = new TrumphCard(0,0);
		TrumphCard spade_2 = new TrumphCard(1,0);
		TrumphCard heart_10 = new TrumphCard(9,1);
		
		
		
		System.out.println("스페이드A의 너비: " + spade_a.card_width);
		System.out.println("스페이드2의 너비: " + spade_2.card_width);
		System.out.println("하트10의 너비: " + heart_10.card_width);
		
		System.out.println(TrumphCard.printCardInfo());
	}
}

class TrumphCard{
	
	// 카드의 모양과 랭크는 모든 인스턴스에서 달라야 하는 값이다
	int rank; // A ~ K
	int suit; //하트 1, 스페이드 0, 다이아 2, 클로버 3
	
	// 카드 너비 높이는 모든 인스턴스에서 다를 필요가 없는 값이다
	// 이런 성질의 변수를 인스턴스 값으로 두면 메모리의 공간이 낭비된다
	static int card_width = 100;
	static int card_height = 150;
	
	public TrumphCard(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	static void setCardWidth(int card_width) {
		TrumphCard.card_width = card_width;
	}
	
	// static 메서드 : 인스턴스 변수는 활용할 수 없는 메서드
	public static String printCardInfo() {
		return "카드 넓이: " + card_width;
		
		//System.out.println("이 카드의 랭크: " + rank);
		
		
	}
}
//myobj 패키지에 static 자원을 포함한 클래스를 하나 설계해보세요