package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PonketMon {

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        System.out.println(solution(a));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int number = nums.length / 2;
        HashSet<Integer> hash = new HashSet<>();

        for(int i : nums) {
            hash.add(i);
        }

        if(hash.size() >= number) {
            answer = number;
        } else  {
            answer = hash.size();
        }


        return answer;
    }

}
