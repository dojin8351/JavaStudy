package study;

public class D10_StringBuilder {
	/*
	 	 # StringBuilder
	 	 - 문자열을 조립할 때 쓰는 기능들이 모여있는 클래스
	 	 - += 누적 연산을 사용해 문자열을 조립하는 것보다 속도가 훨씬 빠르다
	 	 - String은 내부가 배열로 되어있어서 한번 만들어지면 수정이 불가능한 객체이기 때문에
	 	   += 연산을 할때마다 새로운 객체를 생성하여 속도가 느리다
	 */
	public static void main(String[] args) {
		long start_time = System.currentTimeMillis();
		
		// +=을 할때마다 새 String 인스턴스를 만들기 때문에 엄청 느리다
		String str ="";
		for(int i = 0; i < 10; i++) {
			str += i + "\n";
		}
		System.out.println(str);
		long end_time = System.currentTimeMillis();		
		
		long start_time2 = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10; i++) {
			// append() : +=의 역할을 한다(빌더에 문자열 추가)
			sb.append(i + "\n");
		}
		// StringBuilder로 완성된 문자열을 toString()으로 뽑아 낼 수 있다
		System.out.println(sb);
		long end_time2 = System.currentTimeMillis();
		
		System.out.println("소요시간: " + (end_time - start_time) + "ms");
		System.out.println("소요시간: " + (end_time2 - start_time2) + "ms");
		
		// 기존에 있던 문자열을 스트링빌더로 만들어 활용할 수 있다
		String text = "apple";
		StringBuilder sb2 = new StringBuilder(text);
		
		// append() : 뒤에 데이터 추가
		sb2.append("/orange");
		System.out.println(sb2);
		
		// insert(offset, data) : 원하는 곳에 데이터 추가
		sb2.insert(0, "pine");
		System.out.println(sb2);
		
		// delete(start, end) : 원하는 만큼 문자 삭제 
		sb2.delete(4, 9);
		System.out.println(sb2);
		
		// replace(start, end, String) : 원하는 문자열 교체
		sb2.replace(0, 4, "grape");
		System.out.println(sb2);
		
		// substring(start, end) : 원하는 위치의 문자열을 자른 인스턴스 반환
		// substring(start) : 해당 위치부터 마지막까지..
		String sub = sb2.substring(6,10);
		String sub2 = sb2.substring(6);
		System.out.println(sub);
		System.out.println(sub2);
		System.out.println("원본은 substring후에도 유지된다: " + sb2);
		
		// reverse() : 뒤집는다
		sb2.reverse();
		System.out.println(sb2);
		
		sb2.reverse();
		System.out.println(sb2);
		
		// setCharAt(index, char) : 문자열의 한 글자를 수정할 수 있다
		sb2.setCharAt(0, 'G');
		System.out.println(sb2);
		
		// indexof(str) : 해당 문자열의 위치를 반환한다 (못찾으면 -1 반환)
		sb2.setCharAt(sb2.indexOf("o"), 'O');
		System.out.println(sb2);
	}
}
