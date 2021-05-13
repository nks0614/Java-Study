package programmers;

public class SignPlus {

    public static void main(String[] args) {
        int[] absolutes = {1,1,1};
        boolean[] signs = {true, false, true};
        solution(absolutes, signs);
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

}
