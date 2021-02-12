package macro;

import java.awt.*;
import java.awt.event.InputEvent;


public class TempCheckMacro {

    public static int[] pw = {48, 54, 49, 52};

    public static void main(String[] args) {
//        Timer t = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                PointerInfo pt = MouseInfo.getPointerInfo();
//
//                System.out.println(pt.getLocation()); // x,y
//            }
//        };
//
//        t.schedule(timerTask, 0, 3000);
        try{
            Robot r = new Robot();
            //웨일 클릭
            mouseClick(206, 858, r);
            r.delay(1000);
            //바로가기
            mouseClick(893, 88, r);
            r.delay(1000);
            //비밀번호
            password(r);
            //go
            mouseClick(946, 550, r);
            r.delay(1000);
            mouseClick(806, 770 ,r);
            r.delay(1000);
            //선택지
            selectSafe(r);


        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void password(Robot r){
        for(int i : pw){
            r.keyPress(i);
        }
    }

    public static void selectSafe(Robot r){
        r.mouseWheel(5);
        r.delay(1000);
        mouseClick(103, 348, r);
        r.delay(1000);
        mouseClick(98, 618, r);
        r.delay(1000);
        r.mouseWheel(2);
        r.delay(1000);
        mouseClick(99,672,r);
        r.delay(1000);
        mouseClick(365, 800, r);
    }

    public static void mouseClick(int x, int y, Robot r){
        r.mouseMove(x, y);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }


}
