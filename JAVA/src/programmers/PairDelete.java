package programmers;

import java.util.Stack;

public class PairDelete {

    public static void main(String[] args) {
        System.out.println(solution("jj"));
    }

    // 효율성에서 걸림. 어떻게 해야 될까?
//    public static int solution(String s) {
//        int answer = -1;
//        StringBuilder word = new StringBuilder(s);
//
//        for(int i = 0; i < word.length() - 1; i++) {
//            if(word.charAt(i) == word.charAt(i + 1)) {
//                word.deleteCharAt(i);
//                word.deleteCharAt(i);
//                i = -1;
//            }
//        }
//
//        if(word.toString().equals("")) answer = 1;
//        else answer = 0;
//
//        return answer;
//    }

    // 생각해보니깐 예전에 비슷한 걸 푼 적이 있다.
    // 후위계산기였는데, 그때도 스택으로 연산자를 저장하고 최근에 값을 찾아서 계산했다.
    // 이것도 어차피 최근 값 (즉, 근처 값)만 비교하면 되니, 스택에 저장하면 될 듯 하다.
    // 된다. 약간 허무한 거 같기두 하고...
    public static int solution(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String last = stack.peek();
                String now = String.valueOf(s.charAt(i));

                if(last.equals(now)) {
                    stack.pop();
                } else {
                    stack.push(now);
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

}
