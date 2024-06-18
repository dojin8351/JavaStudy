package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    public static String[] suits = {"♡", "◇", "♠", "♣"};
    public static String[] ranks = {"A", "2", "3", "4","5","6","7",
            "8","9","10","J","Q","K"};
    static int[] VALUES = {11,2,3,4,5,6,7,8,9,10,10,10,10};
    public static ArrayList<Integer> values = new ArrayList<>();
    public static ArrayList<String> cardDeck = new ArrayList<>();
    public static ArrayList<String> usedCard = new ArrayList<>();
    public static ArrayList<Integer> scoreDeck = new ArrayList<>();
    public static ArrayList<String> comCard = new ArrayList<>();
    public static ArrayList<String> userCard = new ArrayList<>();

    public static String drawCard() {

        for(int i = 0; i < suits.length; i++) {
            for(int j = 0; j < ranks.length; j++) {
                cardDeck.add(suits[i] + ranks[j]);
            }
        }
        while(true) {
            String card = cardDeck.get((int)(Math.random()*cardDeck.size()));
            if(usedCard.size() == 52) {
                usedCard.removeAll(cardDeck);
            }
            if(usedCard.contains(card)) {
                continue;
            }else {
                usedCard.add(card);
                return card;
            }
        }

    }

    public static void scoreDeck() {
        for(int i = 0; i < VALUES.length; i++) {
            values.add(VALUES[i]);
        }

        for(int i = 0; i < 4; i++) {
            scoreDeck.addAll(values);
        }

    }

    public static int scoringSystem(ArrayList arr) {
        int sum = 0;
        int aceCnt = 0;
        for(int i = 0; i < arr.size(); i++) {
            int score = scoreDeck.get(cardDeck.indexOf(arr.get(i)));
            sum += score;
            if(score == 11) {
                aceCnt++;
            }
        }
        while(aceCnt > 0 && sum > 21) {
            sum -= 10;
            --aceCnt;
        }

        return sum;
    }

    public static void comPlay() {

        if(scoringSystem(comCard) < 21) {

            while(scoringSystem(comCard) <= 16) {
                comCard.add(drawCard());
                System.out.println("Com CARD: " + comCard + " 점수: " + scoringSystem(comCard));

            }
        }
    }

    public static void result() {
        if(scoringSystem(comCard) > 21) {
            System.out.println("PLAYER WIN COM(BURST)");
        }else if(scoringSystem(comCard) > scoringSystem(userCard)) {
            System.out.println("PLAYER LOSE");
        }else if(scoringSystem(comCard) < scoringSystem(userCard)) {
            System.out.println("PLAYER WIN");
        }else if(scoringSystem(comCard) == scoringSystem(userCard)){
            System.out.println("DRAW");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        scoreDeck();

        for(int i = 0; i < 2 ;i++) {
            comCard.add(drawCard());
            userCard.add(drawCard());
        }

        System.out.println("Com CARD: [??, " + comCard.get(1) + "]");
        System.out.println("PLAYER CARD: " + userCard);
        while(true) {

            System.out.print("카드를 더뽑으시러면 \"1\", 그만 뽑으시려면 \"2\">> ");
            int num = sc.nextInt();

            if(num == 1) {

                userCard.add(drawCard());

                System.out.println("PLAYER CARD: " + userCard);
                if(scoringSystem(userCard) > 21) {
                    System.out.println("PLAYER LOSE(BURST)");
                    System.out.println(scoringSystem(userCard));
                    break;
                }else if(scoringSystem(userCard) == 21) {
                    System.out.println("BLACK JACK!");
                }
            } else if(num == 2) {
                System.out.println("STOP!!");
                System.out.println("PLAYER CARD: " + userCard + " 점수: " + scoringSystem(userCard));
                System.out.println("Com CARD: " + comCard + " 점수: " + scoringSystem(comCard));

                comPlay();

                result();
                break;
            }else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요>> ");
                sc.nextLine();
                continue;
            }
        }


    }

}
