import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumGame {

    public static void main(String[] args) {
        int[] a = {2,2,2,2};
        int[] b = {1,1,1,1};

        System.out.println(solution(a,b));
    }

    //정확성 테스트는 통과 그러나 효율성 테스트는 실패
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Boolean win = false;
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            int temp = A[i];
            for(int j = 0; j < B.length; j++){
                if(B[j] > temp){
                    answer++;
                    win = true;
                    B[j] = -1;
                    break;
                }
            }

            if(!win){
                for(int k = 0; k < B.length; k++){
                    if(B[k] != -1){
                        B[k] = -1;
                        break;
                    }
                }
            }else{
                win = false;
            }

        }

        return answer;
    }

    // 둘다 오름차순 정렬한 것의 결과도 같다는 것을 알게 되었다!

    //요건 다른 사람의 풀이
//    public int solution(int[] A, int[] B) {
//        int answer = 0;
//
//        Arrays.sort(A);
//        Arrays.sort(B);
//        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
//            if(A[i] < B[j]) {
//                answer++;
//                j--;
//            }
//        }
//
//        return answer;
//    }
}
