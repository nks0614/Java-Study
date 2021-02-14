import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static Timer t = new Timer();
    public static TimerTask timerTask;
    static int i = 0;

    public static void main(String[] args) {
        timer();
        timer(); //둘이 다른 객체를 만듬, 실행되고 있거나 말거나 그냥 새로 만듬

    }

    public static void timer(){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(i++);
            }
        };
        t.schedule(timerTask, 0, 3000);
    }

}
