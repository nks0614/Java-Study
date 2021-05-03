package programmers;

import java.util.HashMap;

public class Hashmap {

    public static void main(String[] args) {
        HashMap<String,String> map1 = new HashMap<String,String>(); //HashMap생성
        HashMap<String,String> map2 = new HashMap<>(); //new에서 타입 파라미터 생략가능
        HashMap<String,String> map3 = new HashMap<>(map1); //map1의 모든 값을 가진 HashMap생성
        HashMap<String,String> map4 = new HashMap<>(10); //초기 용량(capacity)지정
        HashMap<String,String> map5 = new HashMap<>(10, 0.7f); //초기 capacity,load factor지정
        HashMap<String,String> map6 = new HashMap<String,String>(){{ //초기값 지정
            put("a","b");
        }};

        HashMap<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "사과");
        testMap.put(2, "바나나");
        testMap.put(3, "포도");

        testMap.remove(1);

        System.out.println(testMap.get(2));
    }

}
