package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Year2016 {

    public static void main(String[] args) {
        System.out.println(solution(1, 1));
    }

    //두 날짜간의 차이를 이용해 요일을 구함
    public static String solution(int a, int b) {
        String answer = "";

        String date1 = "2016-01-01";
        String date2 = "2016-"+zeroNum(a)+"-"+zeroNum(b);

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date FirstDate = format.parse(date1);
            Date SecondDate = format.parse(date2);

            long calDate = FirstDate.getTime() - SecondDate.getTime();

            long calDateDays = calDate / (24 * 60 * 60 * 1000);

            calDateDays = Math.abs(calDateDays);

            int day = (int) (calDateDays % 7);

            switch(day){
                case 0:
                    answer = "FRI";
                    break;
                case 1:
                    answer = "SAT";
                    break;
                case 2:
                    answer = "SUN";
                    break;
                case 3:
                    answer = "MON";
                    break;
                case 4:
                    answer = "TUE";
                    break;
                case 5:
                    answer = "WED";
                    break;
                case 6:
                    answer = "THU";
                    break;
            }

        } catch (Exception e) {

        }

        return answer;
    }

    public static String zeroNum(int n){
        String sN = Integer.toString(n);
        return n < 10 ? "0"+sN : sN;
    }

    //프로그래머스 풀이에서 본 코드인데 그냥 달력이다! ㅋㅋㅋㅋ
    //코드가 길긴 한데 뺘르긴 할 것 같다
    public String getDayName(int a, int b)
    {
        String answer = "";
        switch(a) {
            case 1:
            case 7:
                if(b % 7 == 1)
                    answer = "FRI";
                else if(b % 7 == 2)
                    answer = "SAT";
                else if(b % 7 == 3)
                    answer = "SUN";
                else if(b % 7 == 4)
                    answer = "MON";
                else if(b % 7 == 5)
                    answer = "TUE";
                else if(b % 7 == 6)
                    answer = "WED";
                else
                    answer = "THU";
                break;
            case 2:
            case 8:
                if(b % 7 == 1)
                    answer = "MON";
                else if(b % 7 == 2)
                    answer = "TUE";
                else if(b % 7 == 3)
                    answer = "WED";
                else if(b % 7 == 4)
                    answer = "THU";
                else if(b % 7 == 5)
                    answer = "FRI";
                else if(b % 7 == 6)
                    answer = "SAT";
                else
                    answer = "SUN";
                break;
            case 3:
            case 11:
                if(b % 7 == 1)
                    answer = "TUE";
                else if(b % 7 == 2)
                    answer = "WED";
                else if(b % 7 == 3)
                    answer = "THU";
                else if(b % 7 == 4)
                    answer = "FRI";
                else if(b % 7 == 5)
                    answer = "SAT";
                else if(b % 7 == 6)
                    answer = "SUN";
                else
                    answer = "MON";
                break;
            case 4:
            case 9:
            case 12:
                if(b % 7 == 1)
                    answer = "THU";
                else if(b % 7 == 2)
                    answer = "FRI";
                else if(b % 7 == 3)
                    answer = "SAT";
                else if(b % 7 == 4)
                    answer = "SUN";
                else if(b % 7 == 5)
                    answer = "MON";
                else if(b % 7 == 6)
                    answer = "TUE";
                else
                    answer = "WED";
                break;
            case 5:
                if(b % 7 == 1)
                    answer = "SUN";
                else if(b % 7 == 2)
                    answer = "MON";
                else if(b % 7 == 3)
                    answer = "TUE";
                else if(b % 7 == 4)
                    answer = "WED";
                else if(b % 7 == 5)
                    answer = "THU";
                else if(b % 7 == 6)
                    answer = "FRI";
                else
                    answer = "SAT";
                break;
            case 6:
                if(b % 7 == 1)
                    answer = "WED";
                else if(b % 7 == 2)
                    answer = "THU";
                else if(b % 7 == 3)
                    answer = "FRI";
                else if(b % 7 == 4)
                    answer = "SAT";
                else if(b % 7 == 5)
                    answer = "SUN";
                else if(b % 7 == 6)
                    answer = "MON";
                else
                    answer = "TUE";
                break;
            case 10:
                if(b % 7 == 1)
                    answer = "SAT";
                else if(b % 7 == 2)
                    answer = "SUN";
                else if(b % 7 == 3)
                    answer = "MON";
                else if(b % 7 == 4)
                    answer = "TUE";
                else if(b % 7 == 5)
                    answer = "WED";
                else if(b % 7 == 6)
                    answer = "THU";
                else
                    answer = "FRI";
                break;
        }
        return answer;
    }

}
