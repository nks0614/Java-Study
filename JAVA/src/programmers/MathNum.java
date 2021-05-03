package programmers;

public class MathNum {

    public static void main(String[] args) {
        int[] a = solution(2, 5);
        for(int i : a){
            System.out.println(i);
        }
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int min = java.lang.Math.min(n, m);
        System.out.println("min : "+ min);

        for(int i = 1; i <= min; i++){
            if(n % i == 0 && m % i == 0){
                answer[0] = i;
            }
        }

        answer[1] = n * m / answer[0];
        System.out.println("max : "+answer[1]);

        return answer;
    }

}

