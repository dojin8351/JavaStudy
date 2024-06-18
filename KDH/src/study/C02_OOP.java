package study;


public class C02_OOP {
	/*
	 	# 객체 지향 프로그래밍 (Object Oriented Programming)
	 	- 변수와 함수들을 무분별하게 사용하다보니 정신없어서 생겨난 방식
	 	- 변수와 함수들을 세상에 실제로 존재하는 개념(객체)으로 묶어서 생각하면
	 	  프로그램의 유지보수 및 가독성 측면에서 도움이 된다
	 	- 객체 내부의 변수는 현재 상태를 나타내고 
	 	  객체 내부의 함수는 해당 객체의 기능 및 동작을 나타낸다
	 	
	 	 ex: 책
	 	 - 책의 현재 상태를 변수로 표현한 것: 
	 	   현재 펼쳐진 페이지, 책의 최대 페이지, 책의 커버 재질, 
	 	   작가의 이름, 작가의 영어이름, 책의 가격...
	 	   
	 	 - 책의 기능 및 동작을 매서드로 표현한 것 : 
	 	   다음 페이지로 넘기기(현재 페이지 + 1), 원하는 페이지 펼치기, 
	 	   구매하기, 첫 페이지로 가기, 책의 원하는 페이지를 찢기
	 	   
	 	 # 클래스(Class)
	 	 - 객체지향 프로그래밍에서 의미하는 객체를 프로그래밍 언어로 표현하는 문법
	 	 - 클래스는 정의한 시점에서는 실체가 없는 객체의 설계도이다
	 	 - 클래스를 통해 만들어내는 실체를 인스턴스(instance)라고 부른다
	 */
	public static void main(String[] args){
		
		// Book이라는 설계도를 통해 실체(인스턴스)를 찍어내야 사용할 수 있다
		// new를 통해 인스턴스르 찍어낼 때마다 메모리상에 필요한 만큼의 공간을 확보한다
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		
		b1.currentPage = 130;
		b2.currentPage = 13;
		b3.currentPage = 0;
		
		b1.totalPage = 200;
		b2.totalPage = 80;
		b3.totalPage = 1000;
		
		
		
		for(int i = 0; i < 1000;i++) {
			b3.nextPage();
		}
		// 찍어낸 실체마다 변수의 현재 상태가 다르다
		System.out.println("책 1의 현재 페이지: " + b1.currentPage);
		System.out.println("책 2의 현재 페이지: " + b2.currentPage);
		System.out.println("책 3의 현재 페이지: " + b3.currentPage);
		
		Monthsubscription a1 = new Monthsubscription();
		
		a1.bankBalance = 10000; 				
		a1.price = 3000;
		a1.month = 5;
		
		a1.SubscriptionResults();
		
//		boolean cheat = true;
//		for(int i = 1; i <= a1.month; i++) {
//			if(a1.bankBalance >= a1.price * a1.month) {
//				cheat = true;
//			}else {
//				cheat = false;
//			}
//		}
//		if(cheat) {
//			System.out.println(a1.month + "개월 구독완료");
//		}else {
//			System.out.println(a1.month + "개월 구독실패 " + (a1.month * a1.price - a1.bankBalance) + "원 부족합니다.");
//		}
		
		
	}

}
// 생각한 객체를 프로그래밍 언어로 표현한 것을 클래스라고 한다
class Book{
	int currentPage;
	int totalPage;
	int typeOfCover;
	String authorName;
	
	// this : 나중에 생성될 인스턴스 자기 자신을 의미하는 키워드
	void nextPage() { 
		if(this.currentPage < this.totalPage) {
			++this.currentPage ;
			
		}
		
	}
}

/*
   실제로 존재하는 객체를 하나 참조하여 클래스를 생성한 후 테스트 해보세요
   (책 금지, 변수 3개 이상, 매서드 2개 이상)
*/
class  Monthsubscription {
		
	int bankBalance;
	int price;	
	int month;
	
	void SubscriptionResults() {
		boolean cheat = true;
		for(int i = 1; i <= month; i++) {
			if(bankBalance >= price * month) {
				cheat = true;
			}else {
				cheat = false;
			}
		}
		if(cheat) {
			System.out.println(month + "개월 구독완료");
		}
		else {
			System.out.println(month + "개월 구독실패 " + (month * price - bankBalance) + "원 더 가져오세요ㅎ");
		}			
	}
	
	
}











