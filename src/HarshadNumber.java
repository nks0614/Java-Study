public class HarshadNumber {

    public static void main(String[] args){
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        int n = 0;

        String num = Integer.toString(x);

        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            n += c - '0';
        }


        return x % n == 0;
    }

}
