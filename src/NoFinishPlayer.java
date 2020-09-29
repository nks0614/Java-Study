import java.util.Arrays;
import java.util.HashMap;

public class NoFinishPlayer {

    public static void main(String[] args) {
        String[] a = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(a, b));
    }

// 맨첨에 짠 코드. 이유는 모르겠지만 정답으로 뜨는게 프로그래머스에서는 틀렸다 한다.
//    public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//
//        for(int i = 0; i < participant.length; i++){
//            for(int j = 0; j < completion.length; j++){
//                if(participant[i] == completion[j]){
//                    participant[i] = "";
//                    completion[j] = "";
//                    break;
//                }
//            }
//        }
//
//        for(String i : participant){
//            if(i != ""){
//                answer = i;
//                break;
//            }
//        }
//
//        return answer;
//    }

// 그리고 찾아본 코드. 오류는 안 나지만 너무 비효율적이다.
//    public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//        String temp = "";
//
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        int i = 0;
//
//        while(i < completion.length){
//            if(!completion[i].equals(participant[i])){
//                temp = participant[i];
//                break;
//            }else{
//                i++;
//            }
//        }
//
//        if(!temp.equals("")){
//            answer = temp;
//        }else{
//            answer = participant[participant.length-1];
//        }
//
//        return answer;
//    }

// 그리고 프로그래머스 다른 사람 정답에서 본 코드. 정말 깔끔하다.
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

}
