import io.reactivex.rxjava3.subjects.PublishSubject;

public class StartRx {

    public static void main(String[] args) {
        // 1. 데이터 스트림을 만든다.
        PublishSubject<Integer> items = PublishSubject.create();
        // 2. 아이템을 추가한다.
        items.onNext(1);
        items.onNext(2);
        items.onNext(3);
        items.onNext(4);

        // 3. 짝수만 출력하는 데이터 스트림으로 변형한 뒤 구독한다.
        items.filter(item -> item % 2 == 0)
                .subscribe(System.out::println);

        // 4. 아이템을 더 추가한다.
        items.onNext(5);
        items.onNext(6);
        items.onNext(5);
        items.onNext(8);

        // 출력 결과 : 6, 8
        // 이유 : PublishSubject는 구독 시점 이후의 데이터만 옵저버에 전달하기 때문에
        //       구독을 시작한 이후에 추가된 아이템들이 출력된 것. 구독 시점을 위로 올리면 2, 4, 6, 8이 출력된다.

    }

}
