import java.util.Scanner;

public class StringHandler {
    //https://programmers.co.kr/learn/courses/30/lessons/12918
    //programmers 문자열 다루기 기본
    public static void main(String[] args) {
        boolean answer = true;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.length() == 4 || s.length() == 6){
            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);

                if(Character.isDigit(temp) == false){
                    answer = false;
                }
            }
        }
        else{
            answer = false;
        }


        System.out.println(answer);
    }

// 다른 사람 풀이! 되게 충격적이였습니다!
//     if(s.length() == 4 || s.length() == 6){
//        try{
//            int x = Integer.parseInt(s);
//            return true;
//        } catch(NumberFormatException e){
//            return false;
//        }
//    }
//      else return false;
}
