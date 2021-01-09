package programmers;

public class WorkoutClothes {

    public static void main(String[] args) {
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(solution(3, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }



        return answer;
    }

}
