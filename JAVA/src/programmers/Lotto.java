package programmers;

public class Lotto {

    public static void main(String[] args) {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win = {31, 10, 45, 1, 6, 19};
        int[] a = solution(lottos, win);
        for(int i : a) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6,6};

        int same = 0;
        int zero = 0;

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0){
                zero++;
            } else {
                for(int j = 0; j < win_nums.length; j++) {
                    if(lottos[i] == win_nums[j]) same++;
                }
            }


        }

        answer[0] = Math.min(7 - (same + zero), 6);
        answer[1] = Math.min(7 - same, 6);

        return answer;
    }

}
