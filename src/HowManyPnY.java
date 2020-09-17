import java.util.Scanner;

public class HowManyPnY {

    public static void main(String[] args) {
        System.out.println(Solution("ooo"));
    }

    public static boolean Solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);


            if (temp == 'p' || temp == 'P') {
                p++;
            } else if (temp == 'y' || temp == 'Y') {
                y++;
            }
        }

        if (p != y) {
            answer = false;
        }

        return answer;
    }


// 다른 사람 풀이! 엄청 간단하다!
//    boolean solution(String s) {
//        s = s.toUpperCase();
//
//        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
//    }

}
