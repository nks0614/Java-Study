package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class EnglishShiritori {

    public static void main(String[] args) {
        String[] words = {"abb", "baa", "ccc", "cda", "abb"};
        int[] a = solution(3, words);
        System.out.println(Arrays.toString(a));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        char startChar;
        char endChar = words[0].charAt(words[0].length() - 1);
        HashSet<String> wordSet = new HashSet<>(){{
            add(words[0]);
        }};

        for(int i = 1; i < words.length; i++) {

            if(!wordSet.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            startChar = words[i].charAt(0);

            if(startChar != endChar) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            endChar = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }

}
