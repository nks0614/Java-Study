package concept;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date today = new Date();

        System.out.println(today);

        System.out.println(1900 + today.getYear());

        System.out.println(twoNumber(today.getMonth() + 1));

        System.out.println(twoNumber(today.getDate()));

        System.out.println(today.getHours());

        Calendar c = Calendar.getInstance();

        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));

        int hour = 18;

        if(hour < 8 || hour > 19){
            System.out.println("아침");
        } else if(hour >= 8 && hour < 13){
            System.out.println("점심");
        } else {
            System.out.println("저녁");
        }
    }

    public static String twoNumber(int num) {
        if(num > 9) return Integer.toString(num);
        return "0" + num;

    }

}
