package programmers;

public class StockPrice {

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 2, 3};
        int[] a = solution(p);

        for(int i : a){
            System.out.println(i);
        }
    }

    // 테스트케이스는 통과했는데 효율성에서 떨어짐
//    public static int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//        int time = 0;
//
//        for(int i = 0; i < prices.length; i++){
//            for(int j = i+1; j < prices.length; j++){
//                if(prices[i] <= prices[j]){
//                    time++;
//                }
//            }
//            answer[i] = time;
//            time = 0;
//        }
//
//        return answer;
//    }

    //위에서 짠 코드와 비슷해보지만 끝까지 비교하지 않고 중간에 자른다. 더 빠름
    public static int[] solution(int[] prices){
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j==answer.length-1) answer[i] = j-i;
            }
        }
        return answer;
    }
}
