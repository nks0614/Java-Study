package programmers;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class BridgeTrucks {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ConcurrentLinkedQueue<>(); // 다리를 하나의 큐로 생각
        int sum = 0;
        for(int t : truck_weights) {
            while(true) {
                if(q.isEmpty()) { // 다리가 비어있다면
                    q.add(t); // 다리에 트럭을 추가
                    sum += t; // 무게 합을 추가
                    answer++; // 트럭이 다리에 완전히 올라가기 위해선 1초가 필요하니 추가
                    break;
                } else if(q.size() == bridge_length) { // 큐의 크기가 다리의 길이와 같다면 -다리의 길이만큼 차가 올라와있다는 소리
                    sum -= q.poll(); // 무게 합에서 맨 앞의 차 무게를 빼 준다.
                } else {
                    if(sum + t > weight) { // 현재 다리 위에 올라와 있는 차와 올라올 차의 무게가 무게 제한보다 무겁다면
                        answer++; // 1초를 추가해주고
                        q.add(0); // 큐에 0을 넣어서 다른 트럭이 빠져나갈 때까지 기다린다.
                    } else {
                        q.add(t); // 그게 아니라면 다리에 차를 올리고
                        sum += t; // 무게 추가
                        answer++; // 1초 추가
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}