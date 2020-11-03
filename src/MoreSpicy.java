import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreSpicy {

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(s, 7));
    }

// 또 효율성이 떨어진다... 당연히 배열 정렬에 배열 비교문까지 있으니 느릴 수 밖에. 근데 이거 외엔 방법을 아직은 모르겠다.
//    public static int solution(int[] scoville, int K) {
//        int answer = 0;
//
//        Arrays.sort(scoville);
//
//        for (int i = 0; i < scoville.length - 1; i++) {
//            if (scoville[i] < K && scoville[i] != -1) {
//                int temp = scoville[i] + (scoville[i + 1] * scoville[i + 1]);
//                scoville[i] = -1;
//                scoville[i+1] = temp;
//                Arrays.sort(scoville);
//                answer++;
//            }
//        }
//
//        for(int k : scoville){
//            if(k <= K && k != -1){
//                answer = -1;
//                break;
//            }
//        }
//
//        return answer;
//    }

    // 찾아보니 우선순위 큐라는 것이 있었다.
    // 위의 내가 짠 코드처럼 배열을 정렬하고 배열을 돌면서 비교할 필요가 없었다.
    // 코드도 간결해지고 효율성도 좋아졌다.
    // 여전히 배워갈 게 많다.
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue(); //우선순위 큐, 큐이긴 한데 우선순위에 따라 아웃 순서가 결정된다.

        for (int aScoville : scoville) {
            heap.offer(aScoville); //값 추가
        }

        while (heap.peek() <= K) { //heap.peak 는 heap의 첫번째 값을 불러오는 것.
            if (heap.size() == 1) { //heap의 사이즈가 1이면 비교하지 않아도 된디 -1을 반환
                return -1;
            }
            int a = heap.poll(); //heap.poll은 heap의 첫번째 값을 반환하고 제거
            int b = heap.poll();


            int result = a + (b * 2);

            heap.offer(result);
            answer++;
        }
        return answer;
    }
}
