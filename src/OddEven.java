public class OddEven {

    public static void main(String[] args) {
        System.out.println(solution(0));
    }

    public static String solution(int num) {

        return num % 2 == 0 ? "Even" : "Odd";
    }

}
