package test2;

import java.io.*;

public class FileEncryption {
    /*
         frankenstein.txt를 시저 암호방식으로 암호화한 새파일
         파일이름 frankenstein_encrypted.enc을 생성해 보세요

         (1) char 단위로 한 글자씩 암호화 하는 속도를 측정해보기

         (2) char[] 방식으로 암호화 하는 속도를 측정해보기

         (3) Buffered클래스를 붙여 암호화 하는 속도를 측정해보기

         (4) 이미 같은 이름의 암호화 파일이 존재한다면 파일의 이름뒤에 (숫자)를 붙여 다음 파일이 생기게 만들기
             frankenstein_encrypted(1).enc
             frankenstein_encrypted(2).enc
             frankenstein_encrypted(3).enc
     */
    public static String caesar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_=+abcdefghijklmnopqrstuvwxyz {}[]\\;:'\"/?<>,.\n";

    public static StringBuilder encryptionChar(char ch, int key) {
        StringBuilder password = new StringBuilder();

        int charNum = caesar.indexOf(ch);

        if((charNum + key) > caesar.length()-1) {
            password.append(caesar.charAt((charNum + key) % (caesar.length()-1)-1));
        }else {
            password.append(caesar.charAt(charNum + key));
        }

        return password;
    }

    public static StringBuilder encryptionText(String text, int key) {
        StringBuilder password = new StringBuilder();

        for(int i = 0; i <text.length(); i++) {
            char ch = text.charAt(i);

            int charNum = caesar.indexOf(ch);

            if((charNum + key) > caesar.length()-1) {
                password.append(caesar.charAt((charNum + key) % (caesar.length()-1)-1));
            }else {
                password.append(caesar.charAt(charNum + key));
            }
        }
        return password;
    }

    public static long encryptionChar(File file) {
        long start = System.currentTimeMillis();
        try(
                FileReader in = new FileReader(file);
                FileWriter out = new FileWriter("myfiles/frankenstein_encrypted(1).enc");
        ){
            int ch;
            while((ch = in.read()) != -1) {
                out.append(encryptionChar((char)ch,1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        return end-start;

    }

    public static long encryptionChar2(File file) {
        long start = System.currentTimeMillis();
        try(
                FileReader in = new FileReader(file);
                FileWriter out = new FileWriter("myfiles/frankenstein_encrypted(2).enc");
        ){
            char[] buff = new char[1024];
            int len;
            while((len = in.read(buff)) != -1) {
                out.append(encryptionText(new String(buff,0,len) ,2));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        return end-start;
    }

    public static long encryptionBuffered(File file) {
        long start = System.currentTimeMillis();
        try(
                FileReader in = new FileReader(file);
                BufferedReader buffin = new BufferedReader(in);
                FileWriter out = new FileWriter("myfiles/frankenstein_encrypted(3).enc");
                BufferedWriter buffout = new BufferedWriter(out);
        ){
            String line;
            while((line = buffin.readLine()) != null) {
                buffout.append(encryptionText(line,3));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        return end-start;
    }

    public static void main(String[] args) {
        File book = new File("myfiles/frankenstein.txt");
        //String bookPath = book.getPath();

        System.out.println("한글자씩 암호화에 걸린시간: " + encryptionChar(book) + "ms");
        System.out.println("buff로 읽어 암호화에 걸린시간: " + encryptionChar2(book) + "ms");
        System.out.println("Bufferedreader로 걸린시간: " + encryptionBuffered(book) + "ms");
    }
}
