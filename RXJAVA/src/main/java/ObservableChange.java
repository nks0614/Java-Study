import io.reactivex.rxjava3.core.Observable;

public class ObservableChange {

    public static void main(String[] args) {

        // map, 아이템을 변환하는 가장 기본적인 방법
//        Observable<Integer> intSrc = Observable.just(1,2,3);
//        Observable<String> strSrc = intSrc.map(i -> String.valueOf(i));
//        strSrc.subscribe( item ->
//                System.out.println("item : " + item + ", Class : " + item.getClass().getSimpleName())
//        );

        // flatMap, Observable을 다른 Observable로 변환시킨 후, 발행되는 아이템을 병합하여
        // 다시 아이템을 방출시킨다. 한 개의 아이템을 n번씩 방출
//        Observable<String> src = Observable.just("1", "2", "3");
//        src.flatMap(str -> Observable.just(str + "1", str + "2")).subscribe(System.out::println);

        // buffer는 Observable이 발행하는 아이템을 묶어서 List로 변환
//        Observable.range(0, 8)
//                .buffer(3)
//                .subscribe(item -> {
//                    System.out.println("발행");
//                    for(int i : item) {
//                        System.out.println(i);
//                    }
//                });
        // scan은 발행된 아이템을 다음 발행되는 아이템의 첫번째 인자로 전달한다
        Observable.just("a", "b", "c", "d", "e")
                .scan((x, y) -> x + y)
                .subscribe(System.out::println);

    }

}
