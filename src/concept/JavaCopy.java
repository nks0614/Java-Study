package concept;

public class JavaCopy {

    public static void main(String[] args) {

        //int와 double은 깊은 복사
//        int a = 1;
//        int b = a;
//
//        a = 3;
//
//        double c = 3.2;
//        double d = c;
//
//        c = 2.5;

        //String과 char 또한 깊은 복사
//        String a = "hello";
//        String b = a;
//
//        a = "world";
//
//        char c = 's';
//        char d = c;
//
//        c = 'a';

        //배열은 얕은 복사
//        int[] a = {1,2,3};
//        int[] b = a;
//
//        a[0] = 3;
//
//        System.out.print("a : ");
//        for(int i = 0; i < a.length; i++){
//            System.out.print(a[i] + " ");
//        }
//        System.out.println("");
//
//        System.out.print("b : ");
//        for(int i = 0; i < b.length; i++){
//            System.out.print(b[i] + " ");
//        }



        // 객체 또한 얕은 복사이다.
//        concept.Student s1 = new concept.Student(10, "김김김");
//        concept.Student s2 = s1;
//
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
//
//        s1.name = "박박박";
//
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
    }


}

class Student{
    int age;
    String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "이름 : "+name+" 나이 : "+age;
    }
}