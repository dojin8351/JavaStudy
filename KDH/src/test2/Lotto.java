package test2;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {

    static ArrayList<Integer> winNumberList = new ArrayList<>();

    public static ArrayList<Integer> winNumber() {

        while(winNumberList.size() != 6) {
            int ran = (int)(Math.random() * 45+1);
            if(winNumberList.contains(ran)) {
                continue;
            }else {
                winNumberList.add(ran);
            }

        }

        return winNumberList;
    }

    public static ArrayList<Integer> myNumber() {
        ArrayList<Integer> myNumberList = new ArrayList<>();

        while(myNumberList.size() != 6) {
            int ran = (int)(Math.random() * 45+1);
            if(myNumberList.contains(ran)) {
                continue;
            }else {
                myNumberList.add(ran);
            }

        }

        return myNumberList;
    }


    public static void main(String[] args) {

        ArrayList<Integer> winNum = new ArrayList<>(winNumber());
        Collections.sort(winNum);

        int cnt = 0;
        int bonusNum = 0;
        int matchCnt = 0;

        while(true) {
            int ran = (int)(Math.random()*45+1);
            if(winNum.contains(ran) != true) {
                bonusNum = ran;
                break;
            }
        }

        while(true) {
            ArrayList<Integer> myNum = new ArrayList<>(myNumber());
            Collections.sort(myNum);

            System.out.printf("%d번째 구매 당첨번호: %s + 보너스번호: %d\n나의 로또 번호: %s\n",cnt++, winNum, bonusNum,myNum);

            if((winNum.equals(myNum))){
                System.out.println("---------------------------------------------------------");
                System.out.println("1등 당첨");
                System.out.printf("%d번째 구매 당첨번호: %s + 보너스번호: %d\n나의 로또 번호: %s\n",cnt++, winNum, bonusNum,myNum);
                System.out.println("---------------------------------------------------------");

                break;

            } else {
                for(int i = 0; i < myNum.size();i++) {
                    if(winNum.contains(myNum.get(i))) {
                        matchCnt++;
                    }
                }
                if(myNum.contains(bonusNum) && matchCnt == 5) {

                    System.out.println("---------------------------------------------------------");
                    System.out.println("2등 당첨");
                    System.out.printf("%d번째 구매 당첨번호: %s + 보너스번호: %d\n나의 로또 번호: %s\n",cnt++, winNum, bonusNum,myNum);
                    System.out.println("---------------------------------------------------------");

                    break;

                }
                matchCnt=0;

            }
        }
    }
}
