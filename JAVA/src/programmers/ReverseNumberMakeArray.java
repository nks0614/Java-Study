package programmers;

public class ReverseNumberMakeArray {

    public static void main(String[] args) {
        int[] a = solution(12345);
        for(int i : a) {
            System.out.println(i);
        }
    }

    public static int[] solution(long n) {
        String strN = n + "";
        int[] answer = new int[strN.length()];
        int i = 0;

        while(n > 0) {
            answer[i++] = (int) (n % 10);
            n /= 10;
        }



        return answer;
    }

}
