import java.util.Arrays;

public class StringDescSort {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        char[] arr = s.toCharArray(); //문자열을 char 배열로 변환
        StringBuilder answer = new StringBuilder(); //반환될 answer

        Arrays.sort(arr); //자체 sort 기능 사용 (오름차순)

        for (char c : arr) {
            answer.append(c); //정렬된 char들을 합치고
        }


        return answer.reverse().toString(); //reverse 시키면 내림차순이 된다
    }

}
