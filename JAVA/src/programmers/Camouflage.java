package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Camouflage {

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "headgear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    // 테스트 케이스 몇 개는 통과 하지 못했다. 어떤 조건이 틀린걸까

//    public static int solution(String[][] clothes) {
//        int answer = 1;
//        HashMap<String, Integer> hash = new HashMap<>();
//        HashSet<String> kind = new HashSet<>();
//
//        for(int i = 0; i < clothes.length; i++) {
//            String cloth = clothes[i][1];
//            hash.put(cloth, hash.getOrDefault(cloth, 0) + 1);
//            kind.add(cloth);
//        }
//
//        Iterator it = kind.iterator();
//
//        while(it.hasNext()) {
//            answer *= hash.get(it.next());
//
//            if(kind.size() == 1) {
//                return answer;
//            }
//        }
//
//        return answer + clothes.length;
//    }

    // 풀어가려는 방식 자체는 비슷한 거 같음.
    // 내 코드와 비교했을 때, 난 이미 있을 때 1로 시작했다. 그 옷 종류를 안 입는다는 경우의 수를 기억했어야 됐다.
//    public static int solution(String[][] clothes) {
//        int answer = 1;
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//        for(int i=0; i<clothes.length; i++) {
//            if (hashMap.containsKey(clothes[i][1])) // 의상의 종류를 키값으로 두는데, 만약 이미 있다면
//                hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1); // 원래 값에서 1 추가
//            else  // 없다면
//                hashMap.put(clothes[i][1], 2); // 옷 종류마다 안 입는 경우의 수가 있으니 그 경우의 수를 미리 추가
//        }
//
//        for (Iterator<Integer> i = hashMap.values().iterator(); i.hasNext(); ) //hashmap을 iterator로 변환 후 다음 값이 있다면의 조건으로 반복문을 진행
//            answer *= i.next(); // 그리고 그 값을 곱하여 경우의 수 계산
//
//        return answer - 1; // 곱하기 위해서 1에서 시작했으니 1을 빼줌
//    }

    // 내 코드 수정 버전. 없을 때 2를 준다.
    // 그리고 키값 저장을 해야 된다 생각해서 set을 넣었는데
    // 그럴 필요가 없었다.
    // 그냥 Map 자체를 Iterator로 바꾸면 되는 거 였다.
    // 이 부분은 공부가 덜 된 듯 하다.
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String cloth = clothes[i][1];
            hash.put(cloth, hash.getOrDefault(cloth, 1) + 1);
        }

        Iterator<Integer> it = hash.values().iterator();

        while(it.hasNext()) {
            answer *= it.next();
        }

        return answer -1 ;
    }
}
