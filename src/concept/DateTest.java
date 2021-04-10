package concept;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date today = new Date();

        System.out.println(today);

        System.out.println(1900 + today.getYear());

        System.out.println(twoNumber(today.getMonth() + 1));

        System.out.println(twoNumber(today.getDate()));

        System.out.println(today.getHours());
    }

    public static String twoNumber(int num) {
        if(num > 9) return Integer.toString(num);
        return "0" + num;

    }

}
