package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisionNumArray {

    public static void main(String args[]){
        int[] arr = {2, 36, 1, 3};
        int[] a = solution(arr, 1);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();


        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }

        if(answer.isEmpty()){
            answer.add(-1);
        }
        else{
            answer.sort(null);
        }

        int[] a = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            a[i] = answer.get(i);
        }

        return a;
    }

    //다른 사람 풀이. 한 줄이면 된다...
    //근데 -1 파트가 없는걸 보니 문제 개편 전에는 -1 내용이 없었나 보다.
    public int[] divisible(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }

}
