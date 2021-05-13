package programmers;

import java.util.Arrays;

public class Immigration {

    public static void main(String[] args) {
        int[] times = {7, 10};
        System.out.println(solution(6, times));

    }

    // 풀리긴 하나 시간복잡도가 정말 안 좋다. 이중 반복문에
    // 전체 탐색을 하기 때문에 너무 느리다.
//    public static long solution(int n, int[] times) {
//        long time = 1;
//
//        while(n != 0) {
//            for(int i : times) {
//                if(time % i == 0) {
//                    n -= 1;
//                }
//            }
//            time++;
//        }
//        return time-1;
//    }

    // 그래서 써야 하는 것이 이중탐색.
    public static long solution(int n, int[] times) {
        // 모든 사람이 심사를 받는데 걸리는 시간의 최댓값
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long start, mid, end;
        start = 0;
        end = Long.MAX_VALUE;
        long sum;
        // 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
        // mid : 심사를 받는데 주어진 시간
        // sum : 주어진 시간(mid)동안 심사를 받을 수 있는 사람 수
        while (start <= end) {
            mid = (start + end) / 2;
            System.out.println("Start : " + start + " End :" + end + " Mid : " +mid);
            sum = 0;
            // 주어진 시간동안 몇명 검사 할 수 있는지 누적합
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];

                if (sum >= n)
                    break;
            }
            System.out.println("Sum : "+sum);
            // 비교 대상(사람 수)
            // 검사 다 못할 때(시간 부족)
            if (n > sum) {
                start = mid + 1;
            }
            // 검사 다 했을 때 (시간이 남음)
            // 최소 시간 찾아야함
            else {
                end = mid - 1;
                answer = Math.min(answer, mid);
                System.out.println("answer : " + answer);
            }
            System.out.println("-----------------------------");
        }

        return answer;
    }

}
