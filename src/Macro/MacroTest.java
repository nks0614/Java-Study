package Macro;

import java.awt.*;
import java.awt.event.InputEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Timer;
import java.util.TimerTask;

public class MacroTest {

    public static void main(String[] args) {
        try{
//            Timer t = new Timer();
//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    PointerInfo pt = MouseInfo.getPointerInfo();
//
//                    System.out.println(pt.getLocation()); // x,y
//                }
//            };
//            t.schedule(timerTask, 0, 3000);
            //java.awt.Point[x=1034,y=536]
            //java.awt.Point[x=1031,y=652]
            Robot r = new Robot();

            r.delay(3000);
            while(true){
                r.mouseMove(1034, 536);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                r.delay(1000);
                r.mouseMove(1031,652);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                r.delay(1500);
            }

//            Robot robot = new Robot();
//            robot.mouseMove(200, 150);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); //좌클릭 다운
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); //좌클릭 업,
//                                                              // 업 안 해주면 드래그가 된다.
//
//            robot.keyPress(48);
//            robot.keyPress(49);
//            robot.keyPress(50);
//            robot.keyPress(51);
//            robot.keyPress(52);
//            robot.keyPress(65);
//            robot.keyPress(66);
//            robot.keyPress(67);
//            robot.keyPress(68);
//
//            robot.delay(1000);
//            robot.keyPress(17);
//            robot.keyPress(65);
//            robot.keyRelease(17);
//            robot.keyPress(8);


//            robot.mouseWheel(10); 휠

            //https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list/31637206
            // keycode list
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
