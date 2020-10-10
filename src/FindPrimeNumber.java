public class FindPrimeNumber {

    public static void main(String[] args) {
        System.out.println(solution(5));

    }


// 맨 처음 짠 코드. 그러나 효율성에서 실패
//    ublic static int solution(int n) {
//        int answer = 0;
//        boolean isPrime = false;
//
//        if(n == 1){
//            return -1;
//        }
//        else if(n == 2){
//            return 1;
//        }
//
//        for(int i = 2; i <= n; i++){
//            isPrime = true;
//            for(int j = 2; j < i; j++){
//                if(i % j == 0){
//                    isPrime = false;
//                    break;
//                }
//            }
//
//            if(isPrime){
//                answer++;
//            }
//
//        }
//
//        return answer;
//    }

    // 에라토스테네스의 체를 활용한 소수찾기
    // 근데 작은 수를 계산할 때는 위의 코드보다 훨씬 느릴 것 같다 - 루트도 구해야 되고 배열을 참조해야되기에...
    public static int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];

        for (int i = 2; i <= n; i++)
            prime[i] = true;

        // 제곱근 구하기
        // 소수를 찾을 때는 구하려는 수의 루트n 값까지만 비교하면 된다는 공식이 있다.
        int root = (int) Math.sqrt(n);

        for (int i = 2; i <= root; i++) { //2는 소수인 걸 알고 있으니 true로 놔두면 지우면서 시작할 수 있다.
            if (prime[i] == true) {
                for (int j = i; i * j <= n; j++) //그 배수들을 다 false
                    prime[i * j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                answer++;
        }

        return answer;
    }


}
