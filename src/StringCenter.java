public class StringCenter {

    public static void main(String[] args) {
        System.out.println(solution2("01234"));
    }

    public static String solution(String s) {
        String answer = "";
        int size = s.length();

        String center = Character.toString(s.charAt(size / 2));

        if (size % 2 == 0) {
            answer = Character.toString(s.charAt(size / 2 - 1)) + center;
        } else {
            answer = center;
        }

        return answer;
    }

    public static String solution2(String s) {
        String answer = "";
        int size = s.length();

        if (size % 2 == 0) {
            answer = s.substring(size / 2 - 1, size / 2 + 1);
        } else {
            answer = s.substring(size / 2, size / 2 + 1);
        }

        return answer;
    }


}
