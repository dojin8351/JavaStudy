package study;


public class C06_Extend {
	/*
	 	# 클래스 상속
	 	- 이미 만들어져 있는 클래스를 그대로 물려받아 사용하는 문법
	 	- 자식 클래스는 부모로부터 모든 변수와 메서드를 물려받아 그대로 가지고 있다
	 	- 자식 클래스는 부모로부터 물려받은 변수 및 기능을 마음대로 고쳐서 사용할 수 있다
	 		(오버라이드, Override)라고 부른다
	 	- 자식 클래스에는 부모 클래스 에는 없는 기능을 새로 추가해서 사용할 수 있다
	 	- 상속시 자식 클래스에서는 반드시 부모 클래스의 생성자를 가장 먼저 호출해야 한다 
	 	
	 	# super
	 	- 자식 클래스로 생성된 인스턴스의 부모 부분을 의미한다
	 	- 자식 클래스에서 this는 자식 클래스 자신만을 의미한다
	 	- 자식 클래스와 부모 클래스에서 같은 이름을 가지고 있는 자원을 구분하기 위해서 사용한다
	 	- this()는 현재클래스의 생성자를 의미하고 super()는 부모 클래스의 생성자를 의미한다
	 	
	 	
	 */
	
	public static void main(String[] args) {
		Wolf w0 = new Wolf();
		Wolf w1 = new Wolf("늑돌이");
		Wolf w2 = new Wolf("늑순이");
		
		w0.pet();
		w1.pet();
		w2.pet();
		
		w0.run();
		
		// Wolf 클래스를 상속받은 Dog클래스에 Wolf의 기능이 그대로 들어있다
		Dog d1 = new Dog();
		d1.pet();
		d1.run();
		
		Exercise u1 = new Exercise("김도현",1500);
		u1.print();
		
	
	}

}

class Wolf{
	String name;
	int age = 0;
	
	
	public Wolf() {
		name = "이름없는 늑대";
	}
	
	public Wolf(String name) {
		this.name = name;	
	}
	
	public Wolf(int age) {
		this.age = age;
	}
	
	void pet() {
		System.out.printf("늑대 (%s,%d)를쓰다듬다 손이 물림\n", this.name, this.age);
	}
	
	void run() {
		System.out.printf("%s가 열심히 달립니다!\n", this.name);
	}
}

class Dog extends Wolf{
	
	int walkDesire = 100;
	String socialId;
	
	
	// 부모클래스에 있는 똑같은 이름의 매서드를 자식 클래스에 만들 수 있다
	
	void pet() {
		System.out.printf("강아지(%s, %d)세를 쓰다듬어 주니 매우 좋아합니다\n", this.name, this.age);
		
	}
	
	public Dog() {
		super("이름없는개");
	}
	
	public Dog(String name) {
		super(name);
	}
	
	public Dog(String name, String socialId) {
		super(name);
		this.socialId = socialId;
	}
	
	void walk() {
		System.out.printf("강아지(%s, %d)와 햄께 산책했습니다\n", this.name, this.age);
		walkDesire -= 10;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "강아지(" + name + "/" + age + ")";
	}
	
	@Override
	public boolean equals(Object obj) {		
		if(!(obj instanceof Dog)) {
			return false;
		}
		
		return this.socialId.equals(((Dog)obj).socialId);
	}
	
	@Override
	public int hashCode() {
		
		// String은 hashCode() 메서드를 오버라이드, 해놓은 클래스다
		return socialId.hashCode(); 
	}
}


class Exercise{
	String memberName;
	int caloriesBurned;
	
	public Exercise() {
		memberName = "회원이름";
		caloriesBurned = 1000;
	}
	
	public Exercise(String memberName, int caloriesBurned) {
		this.memberName = memberName;
		this.caloriesBurned = caloriesBurned;
	}
		
	void print() {
		System.out.printf("%s님이 소모해야할 칼로리는 %d입니다.\n", this.memberName, this.caloriesBurned );
	}
	
	
	
}

class Health extends Exercise{
		
	String machineName;
	int setNum;
	int setCalories;
	
	public Health() {
		machineName = "pulldown";
		setCalories = 200;
	}
	
}

/*
 	상속 관계에 있는 클래스 예시를 한번 작성해보세요
 */






