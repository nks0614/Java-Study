import java.util.Arrays;

public class Budget {

    public static void main(String[] args) {

        int[] a = {2,2,3,3};

        System.out.println(solution(a, 10));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i = 0; i < d.length; i++){
            if(budget - d[i] >= 0){
                budget -= d[i];
                answer++;
            }
            else{
                break;
            }
        }

        return answer;
    }

}
