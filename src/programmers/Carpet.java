package programmers;

public class Carpet {

    public static void main(String[] args){
        int[] a = solution(8,1);
        for(int i : a){
            System.out.println(i);
        }

    }

    //통과 했으나 11ms가 나오는 걸 보니 너무 비효율적이라는 생각이 들었다.
//    public static int[] solution(int brown, int yellow) {
//        int[] answer = new int[2];
//        int a = 0, b =0, cnt = 0;
//
//        for(int i = 1; i <= yellow; i++){
//            if(yellow % i == 0){
//                int j = yellow / i;
//                if((brown - ((i+2)*2)) / 2 == j){
//                    answer[0] = Math.max(i+2, j+2);
//                    answer[1] = Math.min(i+2, j+2);
//                }
//            }
//        }
//
//        return answer;
//    }

    //프로그래머스 다른 사람의 풀이
    public static int[] solution(int brown, int yellow) {
        int a = (brown+4)/2; //완성된 카펫의 가로 + 세로 길이
        int b = yellow + brown; // 전체 타일 개수
        int[] answer = {(int)(a + Math.sqrt(a*a-4*b))/2, (int)(a-Math.sqrt(a*a-4*b))/2};
        /*
        우선 카펫의 가로 + 세로, 즉 a를 한변으로 하는 정사각형을 만든 후,
        카펫모양으로 정사각형의 네 귀퉁이를 잘라내면, 즉 - 4 * b를 하면 가운데에 정사각형 형태의 타일이 남습니다.
        루트를 이용하여 그 정사각형의 한 변의 길이를 구해주는데 그 한 변의 길이가 완성된 카펫의 가로와 세로의 길이 차이가 됩니다.
        그러므로 더 긴쪽, 즉 가로를 구하기 위해선 가로와 새로를 더한 값에 차이를 더해주고 2로 나누고, 짧은 쪽을 구하기 위해선 빼고 2로 나눠주면 됩니다.
        */
        //라고 이렇게 푸신 분이 설명을 해주셨음음
       return answer;
    }

}
