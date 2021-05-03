package test;

import java.util.Arrays;

public class FirstQuestion {

    public static void main(String[] args) {
        int[] num = {92, 108, 30, 45, 60, 295, 35};
        Arrays.sort(num);
        int median = 0;
        int sum = 0;
        double variance = 0;

        for(int i = 0; i < num.length; i++){
            if(i == num.length / 2){
                median = num[i];
            }
            sum += num[i];
        }

        int punSum = 0;
        for(int i : num){
            int p = i - sum/7;
            punSum += p*p;
        }
        variance = (double)punSum / num.length;

        System.out.println("평균 : "+sum/7);
        System.out.println("중앙값 : "+median);
        System.out.println("분산 : "+variance);

    }

}
