package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class DescSort {

    public static void main(String[] args) {
        System.out.println(solution(118372));

    }

    public static long solution(long n) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();

        while(n > 0){
            list.add(n % 10);
            n /= 10;
        }

        Collections.sort(list);

        int ten = 1;
        for(long a : list){
            answer += a * ten;
            ten *= 10;
        }

        return answer;
    }

}
