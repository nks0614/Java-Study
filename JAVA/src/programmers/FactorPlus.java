package programmers;

public class FactorPlus {

    public static void main(String[] args) {

        System.out.println(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            int factor = 0;

            for(int j = 1; j <= i; j++) {

                if(i % j == 0) factor++;
            }

            if(factor % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

}
