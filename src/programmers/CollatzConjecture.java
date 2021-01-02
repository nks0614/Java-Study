package programmers;

public class CollatzConjecture {

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int answer = 0;

        while(num != 1){
            if(answer >= 500){
                answer = -1;
                break;
            }

            if(num % 2 == 0){
                num /= 2;
            }
            else{
                num = num * 3 + 1;
            }
            ++answer;
        }

        return answer;
    }

}
