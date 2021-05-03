package programmers;

public class AddDigit {

    public static void main(String[] args) {
        System.out.println(solution(987));
    }

    public static int solution(int n) {
        int answer = 0;

        while(n >= 10){
            answer += n % 10;
            n /= 10;
        }

        answer += n;

        return answer;
    }

}
