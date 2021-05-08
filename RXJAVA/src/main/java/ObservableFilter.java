import io.reactivex.rxjava3.core.Observable;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ObservableFilter {

    public static void main(String[] args) throws InterruptedException {

        // debounce, 특정 시간 동안 다른 아이템이 발행되지 않을 때에만 아이템을 발행
        // 반복적으로 빠르게 발행된 아이템들을 필터링할 때에 유용
//        Observable.create(emitter -> {
//            emitter.onNext(1);
//            Thread.sleep(1000);
//            emitter.onNext(2);
//            emitter.onNext(3);
//            emitter.onNext(4);
//            Thread.sleep(1000);
//            emitter.onNext(5);
//        })
//                .debounce(10, TimeUnit.MICROSECONDS)
//                .subscribe(System.out::println);  // 1, 4, 5

        // distinct, 아이템이 중복 발행되지 않도록 필터링
//        Observable.just("A", "B", "C", "B", "A")
//                .distinct()
//                .subscribe(System.out::println); // A, B, C

        // elementAt, 발행되는 아이템 시퀀스에서 특정 인덱스를 가져온다.
//        Observable.just(0,1,2,3,4)
//                .elementAt(2)
//                .subscribe(System.out::println); // 2

        // filter, 조건식이 참인 아이템만 발행
//        Observable.just(1,2,3,4,5)
//                .filter(x -> x > 2)
//                .subscribe(System.out::println); // 3, 4, 5

        // sample, 일정 시간 간격으로 최근에 발행된 아이템을 방출
//        Observable.interval(100, TimeUnit.MILLISECONDS)
//                .sample(200, TimeUnit.MILLISECONDS)
//                .subscribe(System.out::println); // 1, 3, 4, 6, 9
        // 계산 상으로는 1, 3, 5, 7, 9가 맞는 것 같지만,
        // 아마 컴파일러라든가, sample과 interval 간의 실행 시간 차이로 인해 저렇게 나오지 않나 예상
//        Thread.sleep(1000);

        // skip, 말 그대로 스킵한다.
//        Observable.just(1,2,3,4,5)
//                .skip(2)
//                .subscribe(System.out::println); // 3, 4, 5

        // take, skip의 반대 개념, 인자로 넘어온 수 만큼 아이템만 발행
        Observable.just(1,2,3,4,5)
                .take(2)
                .subscribe(System.out::println); // 1, 2


    }

}
