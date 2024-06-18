package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    /*
     숫자 야구 게임을 만들어보세요
     1. 게임이 시작되면 정답이 랜덤으로 생성된다
         (정답은 랜덤 4자리 중복없는 숫자)

     2. 플레이어는 9번의 기회가 주어지며 4자리의 숫자를 마음대로 입력할수 있다
     3. 플레이어가 입력한 숫자의 번호와 위치가 정답의 것과 모두 일치하면 스트라이크
     4. 플레이어가 입력한 숫자는 맞고 위치가 다르면 볼
     5. 9번의 기회안에 모든 숫자와 위치를 맞추면 사용자의 승리
     6. 모든 기회 소진시 플레이어의 패배

     ex> 정답이 2591인 경우
     a
         플레이어가 2988 이라고 입력하면 1strike 1ball
    */
    static char[] nums= {'1', '2', '3', '4', '5', '6', '7', '8', '9','0'};

    public static ArrayList userInput(String text) throws RangeOver, notNumber {
        ArrayList arr = new ArrayList<>();
        if(text.length() != 4) {
            throw new RangeOver("4자리 까지만 입력이 가능합니다");
        }else {
            for(int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                arr.add(ch);
                if(ch < 48 || ch > 57) {
                    throw new notNumber("숫자만 입력해주세요");
                }
            }
            return arr;
        }
    }

    public static ArrayList answerNum() {
        ArrayList winNum = new ArrayList<>();
        while(winNum.size() != 4) {
            int ran = (int)(Math.random()*nums.length);
            if(winNum.contains(nums[ran])) {
                continue;
            }else {
                winNum.add(nums[ran]);
            }

        }
        return winNum;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList winNum = new ArrayList();
        winNum = answerNum();
        int ballCnt = 0;
        int strikeCnt = 0;
        int lifeCnt = 9;

        System.out.println("정답번호: " + winNum + ", 남은 기회: " + lifeCnt );

        int num = 0;
        while(num < 9) {
            try {
                --lifeCnt;
                System.out.print("4자리의 숫자를 입력해주세요 >> ");
                ArrayList userNum = new ArrayList();
                userNum = userInput(sc.next());
                System.out.println("유저번호: " + userNum);
                if(winNum.equals(userNum)) {
                    System.out.println("정답입니다 플레이어 승리!!");
                    break;
                }else {
                    for(int i = 0; i < userNum.size(); i++) {
                        if(winNum.contains(userNum.get(i))) {

                            if(userNum.indexOf(userNum.get(i)) == winNum.indexOf(userNum.get(i))) {
                                strikeCnt++;
                            }else {
                                ballCnt++;
                            }
                        }
                    }
                    System.out.printf("Strike: %d, Ball: %d, 남은 기회: %d\n",strikeCnt, ballCnt, lifeCnt);
                    ballCnt = 0;
                    strikeCnt = 0;

                }
                if(lifeCnt == 0) {
                    System.out.println("모든라이프 소진 플레이어 패배!");
                    break;
                }


            } catch (RangeOver e) {
                System.out.println("4자리만 입력이 가능합니다 다시 입력해 주세요 >> ");
                lifeCnt++;
                sc.nextLine();
                continue;
            } catch (notNumber e) {
                System.out.println("숫자만 다시 입력해주세요 >> ");
                lifeCnt++;
                sc.nextLine();
                continue;
            }
            num++;
        }
    }
}

class RangeOver extends Exception{
    public RangeOver(String message) {
        super(message);
    }
}
class notNumber extends Exception{
    public notNumber(String message) {
        super(message);
    }
}
