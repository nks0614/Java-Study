public class GoodSquare {


    public static void main(String[] args) {
        System.out.println(solution(12, 8));
    }

    public static long solution(long w, long h) {
        long answer = 1;

        answer = (w * h) - (w + h - gcd(w, h));
        /*
            w*h는 전체 넓이,
            정리하면 [ ( W/최대공약수 ) + ( H/최대공약수 ) - 1 ] * 최대공약수
            그리고 이공식은  [ W+H-최대공약수 ]로 해도 결과가 같다
            그렇다고 한다.

            참고 사이트 https://taesan94.tistory.com/55
        */

        return answer;
    }

    private static long gcd( long w , long h ) {

        long small,big ;

        big = w >= h ? w : h ;
        small = w < h ? w : h ;

        while ( small != 0 ) {
            long nmg = big % small ;
            big = small;
            small = nmg;
        }
        return big;
    }


}
