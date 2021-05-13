import io.reactivex.rxjava3.core.Observable;

public class ObservableCombination {

    public static void main(String[] args) {

        /*
         * combineLatest, 두 Observable에서 가장 최근에 발행된 아이템들을 취합하여 하나로 발행
         */
        Observable<Integer> source1 = Observable.create((emitter -> {
            new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    emitter.onNext(i);
                    try { Thread.sleep(1000); }
                    catch (Exception ignored) { }
                }
            }).start();
        }));

        Observable<String> source2 = Observable.create((emitter -> {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    emitter.onNext("A");
                    Thread.sleep(700);
                    emitter.onNext("B");
                    Thread.sleep(100);
                    emitter.onNext("C");
                    Thread.sleep(700);
                    emitter.onNext("D");
                } catch (Exception e) { }
            }).start();
        }));

        // 1     2     3     4     5
        //    A    BC  D

        Observable.combineLatest(source1, source2, (num, str) -> num + str)
                .subscribe(System.out::println);

        // zip, zip은 combineLatest와 다르게 최근에 발행한 순서가 아닌, 1:1 관계로 묶어준다.
//        Observable.zip(source1, source2, (num, str) -> num + str)
//                .subscribe(System.out::println);
    }

}
