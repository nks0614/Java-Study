import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DisposableStudy {

    public static void main(String[] args) {

        // 아이템을 무한히 발행하거나 오랫동안 실행되는 Observable은 제대로 종료 해주지 않는다면
        // 메모리 누수가 발생할 수 있다. 그렇기 때문에 더 이상 구독이 필요하지 않을 때는 이를 Dispose 시켜주어야 한다.
        Observable source = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = source.subscribe(System.out::println);

        new Thread(() -> {
            try {
                System.out.println(disposable.isDisposed());  // false
                Thread.sleep(3500);
            } catch(Exception e) {
                e.printStackTrace();
            }
            disposable.dispose();
            System.out.println(disposable.isDisposed()); // true
        }).start();

        // 근데 구독자가 여러 곳에 있으면 폐기할 때마다 각 객체를 dispose 시켜야 한다.
        // 이런 귀찮음을 해결할 수 있는 것이 CompositeDisposable 이다.

        Observable source2 = Observable.interval(1, TimeUnit.SECONDS);
        Disposable dis1 = source2.subscribe(System.out::println);
        Disposable dis2 = source2.subscribe(System.out::println);
        Disposable dis3 = source2.subscribe(System.out::println);

        CompositeDisposable cd = new CompositeDisposable();
        cd.add(dis1); // add를 활용해 하나를 추가할 수도 있고
        cd. addAll(dis2, dis3); // addAll로 여러 개를 추가할 수도 있다.

        cd.dispose();

    }

}
