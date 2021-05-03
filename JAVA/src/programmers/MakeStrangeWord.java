package programmers;

public class MakeStrangeWord {

    public static void main(String[] args) {
        System.out.println(solution("TT eRSese"));
    }

    public static String solution(String s) {
        String answer = "";
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i+1);

            if (temp.equals(" ")) {
                answer += " ";
                cnt = 0;
            } else {
                answer += cnt % 2 == 0 ? temp.toUpperCase() : temp.toLowerCase();
                cnt++;
            }
        }

        return answer;
    }

}
