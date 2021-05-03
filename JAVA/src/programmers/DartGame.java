package programmers;

public class DartGame {

    public static void main(String[] args) {
        System.out.println(solution("1T2D3D#"));
    }

    public static int solution(String dartResult) {
        char[] darts = dartResult.toCharArray(); //보기 쉽게 array에 저장
        int[] score = new int[3]; //각 항목마다의 점수
        int cnt = -1;

        for(int i = 0; i < darts.length; i++) {
            if(darts[i] >= '0' && darts[i] <= '9') {
                cnt++;
                if(darts[i] == '1' && darts[i+1] == '0') {
                    score[cnt] = 10;
                    i++;
                } else {
                    score[cnt] = darts[i] - '0';
                }
            } else if(darts[i] == 'D') {
                score[cnt] *= score[cnt];
            } else if(darts[i] == 'T') {
                score[cnt] *= score[cnt] * score[cnt];
            } else if(darts[i] == '*') {
                if(cnt > 0) {
                    score[cnt-1] *= 2;
                }
                score[cnt] *= 2;
            } else if(darts[i] == '#') {
                score[cnt] *= -1;
            }
        }
        return score[0] + score[1] + score[2];
    }

}
