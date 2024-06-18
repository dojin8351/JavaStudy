package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D07_Comparator {
	/*
	 	# Comparable
	 	- 이 인터페이스를 구현한 클래스는 크기 비교가 가능해진다
	 	- compareTo() 메서드를 구현해두면 크기 비교가 필요한 상황에서
	 	  해당 메서드를 호출해 크기를 비교할 수 있게 된다
	 	
	 	# Comparator
	 	- 이 인터페이스를 구현한 클래스는 크기 비교의 기준이 된다
	 	- 이 인터페이스를 구현한 클래스의 인스턴스를 필효한 상황에서 함께 전달할 수 있다
	 */
	public static void main(String[] args) {
		// Wrapper 클래스들은 Comparable이 이미 구현되어 있으므로
		// compareTo() 메서드를 직접 구현할 필요가없다
		List<Integer> nums = new ArrayList<>();
		List<String> countries = new ArrayList<>();
		
		Collections.addAll(nums, 88,89,90,15,10,11,12,13,1,99);
		
		Collections.sort(nums);
		
		System.out.println(nums);
		
		List<Grape> grapes = new ArrayList<>();
		
		grapes.add(new Grape("김씨네농장", 30, 5.8, "A+"));
		grapes.add(new Grape("박씨네농장", 28, 8.1, "B+"));
		grapes.add(new Grape("이씨네농장", 40, 6.5, "A-"));
		grapes.add(new Grape("최씨네농장", 35, 7.7, "A"));
		grapes.add(new Grape("최씨네농장", 20, 8.8, "B"));
		grapes.add(new Grape("최씨네농장", 20, 2.1, "C"));
		grapes.add(new Grape("최씨네농장", 20, 1.8, "C+"));
		
		// sort()를 할 수 있으려면 리스트의 모든 요소들이 Comparable(비교)이
		// 구현되어 있어야 한다
		
		// Comparator를 함께 전달하면 Comparable의 compareTo()대신
		// Comparator의 compare()를 사용하여 정렬해준다.
		Collections.sort(grapes, new 포도분류기_당도기준내림차순());
		Collections.sort(grapes, new Comparator<Grape>() {
			@Override
			public int compare(Grape g1, Grape g2) {
				return (int)Math.ceil(g1.sweet - g2.sweet);
				//if(g1.sweet == g2.sweet) {
				//	return 0;
				//}else if(g1.sweet > g2.sweet) {
				//	return 1;
				//}else {
				//	return -1;
				//}
			}
		});
		
		System.out.println(grapes);
	}
}

// Comparable 인터페이스를 구현한 클래스는 각 인스턴스끼리의 크기 비교가 가능해진다
// (정렬이 가능해 진다)
class Grape implements Comparable<Grape>{
	String farm;
	int qty;
	double sweet;
	String grade;
	
	
	public Grape(String farm, int qty, double sweet, String grade) {
		this.farm = farm;
		this.qty = qty;
		this.sweet = sweet;
		this.grade = grade;
				
	}
	
	@Override
	public String toString() {
		return String.format("[%s/%d알/%.1f/%s]\n", farm,qty,sweet,grade);
	}
	
	@Override
	public int compareTo(Grape g) {
		// 현재 인스턴스와 매개변수로 전달받은 인스턴스를 비교하였을 때
		// 어떤 것을 더 크다고 판정할 것인가 정해야 한다
		
		// 두 인스턴스의 크기가 같다 : 0을 리턴
		// 현재 인스턴스의 크기가 더 크다(리스트의 뒤에 있으면 좋겠다) : 1을 리턴
		// 현재 인스턴스의 크기가 더 작다(리스트의 앞에 있으면 좋겠다) : -1을 리턴
		
		// 예시 : 포도알의 개수를 기준으로 인스턴스의 크기를 비교
		if(this.qty == g.qty) {
			// 포도알 갯수와 당도를 기준으로 다시한번더 정렬
			if(this.sweet == g.sweet) {
				return 0;
			}else if(this.sweet > g.sweet) {
				return 1;
			}else {
				return -1;
			}
		}else if(this.qty > g.qty) {
			return 1;
		}else  {
			return -1;
		}
		
	}
}
//내림차순 정렬: 큰것이 먼저나오는것
//오름차순 정렬: 작은것이 먼저 나오는것

class 포도분류기_당도기준내림차순 implements Comparator<Grape>{
	
	@Override
	public int compare(Grape g1, Grape g2) {
		// 왼쪽것이 더 클 때(왼쪽 것이 뒤쪽에 나오고 싶을 때) : 1
		// 오른쪽 것이 더 클 때(오른쪽 것이 뒤쪽에 나오고 싶을 때) : -1
		// 두 인스턴스의 크기가 같을 때 : 0
		if(g1.sweet == g2.sweet) {
			return 0;
		}else if(g1.sweet > g2.sweet) {
			return 1;
		}else {
			return -1;
		}
	}
	
}


/*
 	연습1: 복숭아 클래스를 정의해보세요
 		  복숭아는 가격,등급,무게,농장이름을 필드로 가지고있다
 		  (등급은 + , - 를 매길수 있음)	
 			
 	연습2: 복숭아를 크기 비교가 가능한 객체로 만들어보세요(무게 기준)
 	
 	연습3: 복숭아를 등급 기준으로 내림차순 정렬 A등급이 앞으로 나오게끔
 		  등급이 같은경우 가격기준으로 내림차순
 		  
 	연습4: 복숭아를 농장 이름으로 오름차순 정렬 농장이름이 같은경우 등급기준 정렬
 */

