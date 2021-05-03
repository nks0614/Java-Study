package programmers;

import java.util.ArrayList;

public class Development {

    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};

        for(int i : solution(p, s)){
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            int remain = 100 - progresses[i];
            progresses[i] = (remain % speeds[i] == 0) ? remain / speeds[i] : remain / speeds[i] + 1;
        }

        int cnt = 0;
        int stand = progresses[cnt];
        for(int i = 0; i < progresses.length; i++){
            if(stand < progresses[i]){
                answer.add(i-cnt);
                stand = progresses[i];
                cnt = i;
            }
            if(i == progresses.length - 1){
                answer.add(progresses.length - cnt);
            }
        }

        int[] arr = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            arr[i] = answer.get(i);
        }

        return arr;
    }

}
