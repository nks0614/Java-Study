public class GuessFight {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    //먼저 풀었던 문제, 그러나 4개의 실패가 뜸
//    public static int solution(int n, int a, int b) {
//        int answer = 1;
//
//
//        while (!(a - b == -1 || a - b == 1)) {
//            b = b%2 == 0 ? (b/=2) : (b = b/2+1);
//            a = a%2 == 0 ? (a/=2) : (a = a/2+1);
//            answer++;
//        }
//
//        return answer;
//    }

    //근데 이건 성공함. 단순히 위의 코드랑 비교하면
    //while을 한번 더 도나 안 도나 차이 같은데...
    //어떤 테스트케이스를 거친 건지 모르니
    //어디서 오류가 나는지 잘 모르겠다.
    //추측해보자면 아마 a,b 둘 다 똑같은 숫자가 들어올 때가 아닐까 싶다
    public static int solution(int n, int a, int b){
        int answer = 0;

        while(a != b){
            b = b%2 == 0 ? (b/=2) : (b = b/2+1);
            a = a%2 == 0 ? (a/=2) : (a = a/2+1);
            System.out.println(a + " " + b);
            answer++;
        }
        return answer;
    }

}
