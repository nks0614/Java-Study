public class IntegerRoot {

    public static void main(String[] args) {
        System.out.println(solution(121));
    }

    public static long solution(long n) {
        long answer = 0;
        double a = (double)Math.sqrt(n) * 10;

        boolean check = a % 10 == 0;

        if(check){
            long i = (long)Math.sqrt(n) +1;
            answer = i * i;
        }else{
            return -1;
        }

        return answer;
    }

}
