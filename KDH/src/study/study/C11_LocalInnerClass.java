//package study;
//
//
//public class C11_LocalInnerClass {
//	/*
//	 	 # 지역 내부 클래스
//	 	 - 클래스는 메서드 내부에서도 선언할 수 있다
//	 	 - 해당 메서드가 끝나면 클래스의 수명도 끝난다
//	 	 - 해당 메서드 밖에서는 사용할 수 없는 아주 일시적인 클래스이다
//
//	 	 # 익명 지역 내부 클래스
//	 	 - 클래스를 메서드 내부에서 익명으로 상속받아 사용하는 방식
//	 	 - 생성자 뒤에 {}를 열어서 해당 클래스를 수정하자마자 사용하는 방식이다
//	 	 - 이름을 지정할 수 없기 떄문에 익명 클래스라고 부른다
//	 */
//
//	public static void doSomething2(Book book) {
//		System.out.println(book.page);
//		System.out.println(book.total_page);
//		book.print();
//	}
//
//	public static void doSomething() {
//		// 지역 내부 클래스는 다른 메서드만 오더라도 사용할 수 없게 된다
//		// Student stu = new Student();
//	}
//
//	public static void main(String[] args) {
//		class Student{
//			int kor;
//			int eng;
//			int math;
//
//			int getTotal() {
//				return kor + eng + math;
//			}
//		}
//
//		Student stu = new Student();
//
//		stu.kor = 100;
//		stu.eng = 100;
//		stu.math = 100;
//
//		System.out.println(stu.getTotal());
//
//		// 상속과 업캐스팅을 활용하면 다른곳에서도 활용할 수 있게 된다
//		class HistoryBook extends myobj.Book{
//			public HistoryBook() {
//			super.page = 300;
//			super.page = 900;
//			}
//
//			@Override
//			public void print() {
//				System.out.println("역사책입니다.");
//			}
//		}
//		HistoryBook book1 = new HistoryBook();
//		HistoryBook book2 = new HistoryBook();
//
//		//doSomething2(book1);
//		doSomething2(book2);
//
//		//인스턴스 생성과 동시에 클래스 수정(익명 지역 내부 클래스)
//		doSomething2(new Book() {
//			@Override
//			public void print() {
//				System.out.println("익명의 클래스에서 덮어쓴프린트 입니다.");
//			}
//		});
//
//		Book b1 = new Book();
//
//		class ComicBook extends Book{
//			@Override
//			public void print() {
//				System.out.println("마음대로 수정했음.");
//			}
//		}
//
//		// 부모타입을 원하는 메서드에 부모 타입 인스턴스를 전달
//		doSomething2(new Book());
//		// 부모 타입을 필요로하는 매개변수에 자식 타입을 전달(다형성)
//		doSomething2(new ComicBook());
//		// 부모 타입을 필요로하는 매개변수에 바로 상속받은 이름 없는 타입을 전달(다형성)
//		doSomething2(new Book() {
//			@Override
//			public void print() {
//				System.out.println("Book을 상속받아서 기능을 마음대로 고쳐 썻지만"
//						+ "이 클래스의 이름이 무엇인지는 모릅니다.");
//			}
//		});
//
//	}
//}
package study;


