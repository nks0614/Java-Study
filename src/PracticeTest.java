import java.util.ArrayList;

public class PracticeTest {

    public static void main(String[] args) {
        int[] q = {1,3,2,4,2};
        int[] a = solution(q);
        for(int i : a){
            System.out.println(i);
        }
    }

    // 풀긴 풀었으나 런타임 에러가 뜨고 너무 복잡함
//    public static int[] solution(int[] answers) {
//        int[] check = new int[3];
//        int[] oneCheck = {1, 2, 3, 4, 5};
//        int[] twoCheck = {2, 1, 2, 3, 2, 4, 2, 5};
//        int[] threeCheck = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//
//        check[0] = check(answers,oneCheck);
//        check[1] = check(answers, twoCheck);
//        check[2] = check(answers, threeCheck);
//
//        int max = check[0];
//        for(int i = 0; i < check.length;i++){
//            if(max <= check[i]){
//                max = check[i];
//            }else{
//                check[i] = -1;
//            }
//        }
//        ArrayList<Integer> a = new ArrayList<>();
//        for(int i = 0; i < check.length; i++){
//            if(check[i] != -1){
//                a.add(i+1);
//            }
//        }
//
//        int[] answer = new int[a.size()];
//        for(int i = 0; i < a.size(); i++){
//            answer[i] = a.get(i);
//        }
//
//        return answer;
//    }
//
//    public static int check(int[] answers, int[] numCheck ){
//        int num = 0;
//        for(int i = 0; i < answers.length; i++){
//            if(i >= numCheck.length){
//                int z = i % numCheck.length -1;
//                if(answers[i] == numCheck[z]){
//                    num++;
//                }
//            }
//            else{
//                if(answers[i] == numCheck[i]){
//                    num++;
//                }
//            }
//        }
//
//        return num;
//    }

    //다른 사람 코드
    public static int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5}; //수포자1
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; //수포자2
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //수포자3
        int[] score = new int[3]; //점수
        for(int i=0; i<answer.length; i++) { //정답 개수 측정
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2])); //최대값구하기
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray(); //리스트 변환
    }



}
