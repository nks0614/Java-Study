package concept.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SampleReflection {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 조작하려는 클래스에 대한 객체를 얻는다.
        Class c = Class.forName("java.lang.String"); // 클래스의 Canonical 이름을 통해 내부적으로 리플렉션을 거쳐 객체를 얻는다.
        Class c2 = int.class; // 직접 클래스 오브젝트를 얻는 것.
        Class c3 = Integer.TYPE; // 원시 타입을 표현하는 wrapper 클래스인 경우, 클래스이름.TYPE을 통해 얻을 수 있다.

        // 2. 클래스 멤버에 접근하는 메서드를 호출한다.
        Constructor[] constructors = c.getDeclaredConstructors(); // 클래스에 선언된 생성자들을 배열로 반환한다.
        Method[] methods = c.getMethods(); // 클래스에 선언된 메소드들을 배열로 반환한다.

        // 3. 이렇게 준비한 정보들로 리플렉션 API를 사용하여 정보를 다룬다.

        for(Method m : methods) { // 메서드 목록 출력

            System.out.println("이름 : " + m.getName());
            System.out.println("접근자 : " + Modifier.toString(m.getModifiers()));

            System.out.print("매개변수 : ");
            Class[] params = m.getParameterTypes();
            for(Class i : params) {
                System.out.print(i + ", ");
            }
            System.out.println("");

            System.out.print("예외사항 : ");
            Class[] expt = m.getExceptionTypes();
            for(Class i : expt) {
                System.out.println(i + ", ");
            }
            System.out.println("");

            System.out.println("반환형 : "+m.getReturnType());
            System.out.println("--------------------------------------------");
        }


    }

}
