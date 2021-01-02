package programmers;

public class XtermN {

    public static void main(String[] args) {

        long[] answer = solution(-4,2);

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }

    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

}
