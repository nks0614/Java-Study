package test;

public class SecondQuestion {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            System.out.println(Math.random());
//            checkGrade((int)(Math.random()*100));
        }

        checkGrade(75);
        checkGrade(90);
        checkGrade(80);
    }

    public static void checkGrade(int num){
        System.out.print(num+ " ");
        if(num >= 90){
            System.out.println("수");
        }else if(num >= 80){
            System.out.println("우");
        }else if(num >= 70){
            System.out.println("미");
        }else if(num >= 60){
            System.out.println("양");
        }else{
            System.out.println("가");
        }
    }

}