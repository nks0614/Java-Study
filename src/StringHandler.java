import java.util.Scanner;

public class StringHandler {
    //https://programmers.co.kr/learn/courses/30/lessons/12918
    //programmers 문자열 다루기 기본
    public static void main(String[] args) {
        boolean answer = true;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);

            if(Character.isDigit(temp) == false){
                answer = false;
            }
        }

        System.out.println(answer);


    }
}
