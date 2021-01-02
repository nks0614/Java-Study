package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class AddTwoNum {

    public static void main(String[] args){
        int[] a = {5,0,2,7};

        int[] b = solution(a);
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
    }

    public static int[] solution(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                list.add(numbers[i] + numbers[j]);
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(!list2.contains(list.get(i))){
                list2.add(list.get(i));
            }
        }

        Collections.sort(list2);
        int[] answer = new int[list2.size()];

        int size = 0;
        for(int i : list2){
            answer[size++] = i;
        }

        return answer;
    }


}
