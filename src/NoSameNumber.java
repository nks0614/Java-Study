import java.util.ArrayList;

public class NoSameNumber {


    public static void main(String[] args) {
        int[] test = {1, 1, 3, 3, 0, 1, 1};

        for (int i : Solution(test)) {
            System.out.print(i + " ");
        }


    }
    
    public static int[] Solution(int[] arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        int preNum = 10; //조건에서 숫자는 0~9라 했으니 절대 나올 수 없는 숫자인 10

        for (int num : arr) { //arr의 저장되있는 값들을 검사
            if (preNum != num) // num이 다르다면
                tempList.add(num); //tempList에 저장
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }

}
