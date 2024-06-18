package study;
public class B05_Switch {
	/*
	 	# scitch-case문
	 	- ()안의 값에 따라 실행할 코드를 결정하는 문법
	 	- ()안에 boolean 타입 값은 사용할 수 없다
	 	- 해당하는 case가 없는 경우 default를 실행한다
	 	- if문으로 완벽하게 대처 가능하기 때문에 자주 사용하는 문법은 아니다
	 	- break를 적지 않으면 break를 만날때까지 밑에있는 모든 case를 실행한다
	 */
	
	public static void main (String[] args) {
		int a = 11;
		switch (a) {
			case 10:
				System.out.println("Hello~!");
				break;
			case 11:
				System.out.println("Good bye~~~");
				break;
			default:
				System.out.println("Command Not Found...");
				break;
		
		}
		
		int num = 1;
		switch (Math.abs(num % 2)) {
			case 1:
				System.out.println(num + "은 홀수입니다.");
				break;
			case 0:
				System.out.println(num + "은 짝수입니다");
				break;
		}
		String cmd = "dir";
		
		switch (cmd) {
			case "cd":
				System.out.println("디렉토리 변경");
				break;
			case "dir":
				System.out.println("현재 디렉토리 정보");
				break;
			default:
				System.out.println("명령어를 찾지 못함");
				break;
		}
	}

}
