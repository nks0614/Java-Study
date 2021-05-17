package programmers;

public class MakePrimeNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // 소수인지 확인
                    int num = nums[i] + nums[j] + nums[k];

                    if(isPrime(num)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isPrime(int sum) {

        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) return false;
        }
        return true;
    }



}
