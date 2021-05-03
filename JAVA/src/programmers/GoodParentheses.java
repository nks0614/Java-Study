package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GoodParentheses {

    public static void main(String[] args) {
        System.out.println(solution("(())()"));
    }

    //stack 사용
    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Boolean> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.add(true);
            }
            else{
                if(stack.empty()){
                    answer = false;
                    break;
                }
                else{
                    stack.pop();
                }
            }
        }

        if(!stack.empty()){
            answer = false;
        }

        return answer;
    }

    // stack 미사용
//    boolean solution(String s) {
//        boolean answer = false;
//        int count = 0;
//        for(int i = 0; i<s.length();i++){
//            if(s.charAt(i) == '('){
//                count++;
//            }
//            if(s.charAt(i) == ')'){
//                count--;
//            }
//            if(count < 0){
//                break;
//            }
//        }
//        if(count == 0){
//            answer = true;
//        }
//
//        return answer;
//    }

}
