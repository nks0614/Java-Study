import java.util.Arrays;

public class FindKimInSeoul {

    public static void main(String[] args) {
        String[] s = {"f","f","f","Kim"};
        System.out.println(Solution(s));
    }

    public static String Solution(String[] seoul){
        int count = 0;
        String answer = "";

        for(String s : seoul){
            if(s.equals("Kim")){
                answer = "김서방은 "+count+"에 있다";
                break;
            }
            count++;
        }
        return answer;
    }


// 다른 사람 풀이, 이렇게 간단하게 하는 방법이 있었다.
//    public String findKim(String[] seoul){
//        //x에 김서방의 위치를 저장하세요.
//        int x = Arrays.asList(seoul).indexOf("Kim");
//
//        return "김서방은 "+ x + "에 있다";
//    }

}
