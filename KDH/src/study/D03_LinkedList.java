package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class D03_LinkedList {
	/*
	 	# LinkedList
	 	- ArraryList보다 데이터의 추가/삭제 속도가 더 빠른 리스트
	 	- 각 데이터 덩어리(노드)가 다음 데이터와 이전 데이터의 위치를 함께 보관한다
	 	- ArrayList와 같은 List 인터페이스이기 때문에 사용법은 똑같다
	 */
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<>();
		
		fruits.add("Strawberry");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Mandarin");
		
		// addFirst(data), addLast(data);
		fruits.addFirst("Watermelon");
		fruits.addLast("Banana");
		
		// add(index, data) : ArrayList에도 있는 기능 원하는 index에 데이터 추가
		fruits.add(3, "Coconut");	
		
		System.out.println(fruits);
		
		// remove(): 맨앞 데이터(head)를 지운다
		fruits.remove();
		
		// remove(index) : 원하는 위치의 값을 지운다
		fruits.remove(2);
		
		//removeFisrst(), removeLast()
		fruits.removeLast();
		fruits.removeFirst();
		
		System.out.println(fruits);
		
		// ArrayList 와 LinkedList는 모두 List 인터페이스 소속이기 때문에
		// List로 업캐스팅 하여 활용 가능
		List<String> list1 = new LinkedList<>();
		List<String> list2 = new ArrayList<>();
		
		list1.add("무궁화호");
		list1.add("새마을호");
		list1.add("통일호");
		
		// 더 거슬러 올라간다면 컬렉션 까지도 갈 수 있다
		// List 와 Set은 Collection 인터페이스의 자식 인터페이스이다
		Collection<String> col1 = new LinkedList<>();
		Collection<String> col2 = new HashSet<>();
		
		String[] str = new String[list1.size()];
		list1.toArray(str);
		
		String[] arr = list1.toArray(new String[list1.size()]);
		
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(arr));
		
		//업캐스팅 된 상태이기 때문에 LinkedList만의 메서드는 사용할 수 없는 상태
		// list.addFisrst();
	}

}
