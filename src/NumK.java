import java.util.Arrays;

public class NumK {

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] c = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] d = solution(a, c);

        for(int i : d){
            System.out.println(i);
        }
    }

    // 직접 푼 문제. 통과도 되고 속도도 괜찮다 bb
//    public static int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//
//        for (int i = 0; i < commands.length; i++) {
//            int[] a = new int[commands[i][1] - commands[i][0] + 1];
//            int cnt = 0;
//
//            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
//                a[cnt++] = array[j -1];
//            }
//            Arrays.sort(a);
//
//            answer[i] = a[commands[i][2] - 1];
//        }
//
//        return answer;
//    }

    //다른 사람 풀이. 처음 보는 게 있어 가져와 보았다.
    //copyOfRang는 전달받은 배열의 특정범위를 새로운 배열로 복사해서 반환한다고 한다.
    //위의 내 코드하고 비교해보면 for문 하나를 뺄 수 있으니 매우 이득이다.
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
