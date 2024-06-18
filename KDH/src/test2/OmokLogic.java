package test2;

import java.util.ArrayList;
import java.util.Scanner;


public class OmokLogic {
    Scanner sc = new Scanner(System.in);
    int row = 0;
    int line = 0;
    int winCnt = 0;
    public static ArrayList putPlace = new ArrayList();
    public static char[][] omok = {
            {'┌', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┐'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'│', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '│'},
            {'└', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┘'}
    };

    public static void printPlate() {

        for(int i = 0; i< omok.length; i++) {
            for(int j = 0; j <omok[i].length; ++j) {
                System.out.printf("%-2c", omok[i][j]);
            }
            System.out.println();
        }
    }

    public static int rulingWinLose(int line, int row) {

        int winCnt = 0;
        for(int i = line; i < 10 ; i++) {
            if(omok[i][row] == '●') {
                winCnt++;
            }else {
                break;
            }
        }
        for(int i = line-1; i >= 0; --i) {
            if(omok[i][row] == '●') {
                winCnt++;
            }else {
                break;
            }
        }
        if(winCnt == 5) {
            return 1;
        }
        winCnt = 0;

        for(int i = line; i < 10 ; i++) {
            if(omok[i][row] == '○') {
                winCnt++;
            }else {
                break;
            }
        }
        for(int i = line-1; i >= 0; --i) {
            if(omok[i][row] == '○') {
                winCnt++;
            }else {
                break;
            }
        }
        if(winCnt == 5) {
            return 2;
        }
        winCnt = 0;

        for(int i = row; i < 10; i++) {
            if(omok[line][i] == '●') {
                winCnt++;
            }else {
                break;
            }
        }
        for(int i = row-1; i >= 0; --i) {
            if(omok[line][i] == '●') {
                winCnt++;
            }else {
                break;
            }
        }
        if(winCnt == 5) {
            return 1;
        }
        winCnt = 0;

        for(int i = row; i < 10; i++) {
            if(omok[line][i] == '○') {
                winCnt++;
            }else {
                break;
            }
        }
        for(int i = row-1; i >= 0; --i) {
            if(omok[line][i] == '○') {
                winCnt++;
            }else {
                break;
            }
        }
        if(winCnt == 5) {
            return 2;
        }
        winCnt = 0;
        return 0;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        printPlate();
        while(true) {
            int bline = 0;
            int brow = 0;
            while(true) {
                System.out.print("검정알 놓을 자리를 골라주세요 >> ");
                int Bline = sc.nextInt();
                int Brow = sc.nextInt();
                bline = Bline;
                brow = Brow;
                if(Bline >= 10 || Bline <= 0 || Brow >= 10 || Brow <= 0) {
                    System.out.print("범위오류. ");
                    sc.nextLine();
                    continue;
                }else if(omok[Bline][Brow] == '●' || omok[Bline][Brow] == '○') {
                    System.out.print("이미 알이 놓여있는곳 입니다. ");
                    sc.nextLine();
                    continue;
                } else {
                    omok[Bline][Brow] = '●';
                    printPlate();
                    break;
                }
            }
            if(rulingWinLose(bline,brow) == 1) {
                System.out.println("흑승!!");
                break;
            }

            int wline = 0;
            int wrow = 0;
            while(true) {
                System.out.print("하얀알 놓을 자리를 골라주세요 >> ");
                int Wline = sc.nextInt();
                int Wrow = sc.nextInt();
                wline = Wline;
                wrow = Wrow;
                if(Wline >= 10 || Wline <= 0 || Wrow >= 10 || Wrow <= 0) {
                    System.out.print("범위오류. ");
                    sc.nextLine();
                    continue;
                }else if(omok[Wline][Wrow] == '●' || omok[Wline][Wrow] == '○') {
                    System.out.print("이미 알이 놓여있는곳 입니다. ");
                    sc.nextLine();
                    continue;
                } else {
                    omok[Wline][Wrow] = '○';
                    printPlate();
                    break;
                }
            }
            if(rulingWinLose(wline,wrow) == 2) {
                System.out.println("백승!!");
                break;
            }


        }


    }

}
