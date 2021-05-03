package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteMinNum {

    public static void main(String[] args) {
        int[] c = {4,3,1,2};
        int[] a = solution(c);
        for(int i : a){
            System.out.println(i);
        }
    }

    //내가 짠 코드. 그러나 길다
//    public static int[] solution(int[] arr){
//        int[] answer = {-1};
//        ArrayList<Integer> ansList = new ArrayList<>();
//
//        if(arr.length != 1){
//            int min = arr[0];
//            int idx = 0;
//            for(int i = 0; i < arr.length; i++){
//                if(min > arr[i]){
//                    min = arr[i];
//                    idx = i;
//                }
//
//            }
//
//            for(int i = 0; i < arr.length; i++){
//                if(i == idx){
//                    continue;
//                }
//                ansList.add(arr[i]);
//            }
//
//            answer = new int[ansList.size()];
//            int size = 0;
//            for(int i : ansList){
//                answer[size++] = i;
//            }
//        }
//
//        return answer;
//
//    }

    //다른 사람 풀이. 짧고 간단하다
    public static int[] solution(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

}
