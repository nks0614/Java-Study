import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ObservableStudy {

    public static void main(String[] args) throws InterruptedException {
//        Observable<String> source = Observable.create(emitter -> {
//            emitter.onNext("Hello");
//            emitter.onNext("World");
////            emitter.onError(new Throwable("Error"));
//            emitter.onComplete();
//        });
//
//        source.subscribe(System.out::println, throwable -> {
//            System.out.println("Throw Error : " + throwable.getMessage());
//        });
//
//        // just를 활용한 Observable
//        Observable<String> source2 = Observable.just("Hello", "World");
//        source2.subscribe(System.out::println);
//
//        // 배열의 아이템을 Observable로 바꿀 때
//        String[] strArr = new String[]{"FIRST", "SECOND", "THIRD"};
//        Observable<String> source3 = Observable.fromArray(strArr);
//        source3.subscribe(System.out::println);
//
//        // ArrayList나 Hash 같은 Iterable 클래스는 fromIterable을 활용
//        ArrayList<String> strList = new ArrayList<String>();
//        strList.add("1");
//        strList.add("2");
//        Observable source4 = Observable.fromIterable(strList);
//        source4.subscribe(System.out::println);
//
//        // Observable 외에도 하나의 아이템만 발행하는 Single
//        Single.create(emitter -> emitter.onSuccess("Single Success"))
//                .subscribe(System.out::println);
//
//        // 아이템을 발행하지 않고, 정상적으로 실행이 종료되었는지에 대해 확인할 때 쓰는 Completable
//        Completable.create(emitter -> {
//            System.out.println("OK");
//            emitter.onComplete();
//        }).subscribe(() -> System.out.println("COMPLETED"));


        // Cold Observable, 같은 인스턴스여도 구독자가 새로우면 새로 발행
        Observable cold = Observable.interval(1, TimeUnit.SECONDS);
        cold.subscribe(value -> System.out.println("First : " + value));
        Thread.sleep(3000);
        cold.subscribe(value -> System.out.println("Second: " + value));
        Thread.sleep(3000);

        // Hot Observable, 아이템 발행이 시작된 이루노느 모든 구독자에게 같은 아이템을 발행
        // 그렇기에 나중에 들어온 구독자는 이전의 정보를 놓칠 수 있다. 
        ConnectableObservable hot =
                Observable.interval(1, TimeUnit.SECONDS).publish();
        hot.connect();
        hot.subscribe(value -> System.out.println("First : " + value));
        Thread.sleep(3000);
        hot.subscribe(value -> System.out.println("Second: " + value));
        Thread.sleep(3000);
    }

}
