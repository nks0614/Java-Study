import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ObservableStudy {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World");
//            emitter.onError(new Throwable("Error"));
            emitter.onComplete();
        });

        source.subscribe(System.out::println, throwable -> {
            System.out.println("Throw Error : " + throwable.getMessage());
        });

        // just를 활용한 Observable
        Observable<String> source2 = Observable.just("Hello", "World");
        source2.subscribe(System.out::println);

        // 배열의 아이템을 Observable로 바꿀 때
        String[] strArr = new String[]{"FIRST", "SECOND", "THIRD"};
        Observable<String> source3 = Observable.fromArray(strArr);
        source3.subscribe(System.out::println);

        // ArrayList나 Hash 같은 Iterable 클래스는 fromIterable을 활용
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("1");
        strList.add("2");
        Observable source4 = Observable.fromIterable(strList);
        source4.subscribe(System.out::println);

        // Observable 외에도 하나의 아이템만 발행하는 Single
        Single.create(emitter -> emitter.onSuccess("Single Success"))
                .subscribe(System.out::println);

        // 아이템을 발행하지 않고, 정상적으로 실행이 종료되었는지에 대해 확인할 때 쓰는 Completable
        Completable.create(emitter -> {
            System.out.println("OK");
            emitter.onComplete();
        }).subscribe(() -> System.out.println("COMPLETED"));


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

    // 공식 Docs에서 Observable 연산자 결정에 대한 팁을 알려줘서 정리
//    나는 새로운 Observable을 생성하고 싶은데 그 Observable이
//    ...특정 항목을 생성해야 한다면:Just
//       ...구독 시점에 호출된 함수를 통해 생성된 항목을 리턴해야 한다면:Start
//       ...구독 시점에 호출된 Action, Callable, Runnable 또는 그와 유사한 함수 등을 통해 생성된 항목을 리턴해야 한다면:From
//       ...지정된 시간 이후에 항목을 배출해야 한다면:Timer
//    ...특정 Array, Iterable 또는 유사한 형태의 소스로부터 항목들을 배출해야 한다면:From
//    ...퓨처(Future)에서 항목을 조회해서 배출해야 한다면:Start
//    ...퓨처에서 연속된 항목을 가져와야 한다면:From
//    ...반복적으로 연속된 항목을 배출해야 한다면:Repeat
//    ...사용자가 정의한 로직을 통해 생성되어야 한다면:Create
//    ...각각의 옵저버가 Observable을 구독한 후에 생성되어야 한다면:Defer
//    ...연속된 정수를 배출해야 한다면:Range
//       ...특정 시간 간격별로 항목을 배출해야 한다면:Interval
//          ...특정 시간 후에 항목을 배출해야 한다면:Timer
//    ...항목 배출 없이 실행을 완료해야 한다면:Empty
//    ...아무일도 하지 않아야 한다면:Never

//    다른 Observable을 결합시켜 새로운 Observable을 생성해야 한다
//    ...그리고 순서와 상관없이 전달 된 모든 Observable이 가진 항목 전체를 배출해야 한다면:Merge
//    ...그리고 전달 된 Observable의 순서대로 Observable이 가진 모든 항목들을 배출해야 한다면:Concat
//    ...생성하고 싶은 Observable은, 두 개 이상의 Observable이 가진 항목들을 순서대로 결합시켜 새로운 항목을 배출해야 하는데:
//       ...각각의 Observable이 항목을 배출 할 때마다 그 항목들을 결합시켜 배출해야 한다면:Zip
//       ...Observable 중 하나라도 항목을 배출할 경우에 마지막으로 배출된 항목들을 결합시켜 배출해야 한다면:CombineLatest
//       ...하나의 Observable이 배출한 항목의 타임 윈도우가 열려있는 시간 동안 다른 Observable이 항목을 배출할 때마다 새로운 항목을 배출해야 한다면:Join
//       ...Pattern과 Plan 중계자를 이용해서 항목을 배출해야 한다면:And/Then/When
//    ...그리고 가장 최근에 항목을 배출한 Observable을 통해서만 항목을 배출해야 한다면:Switch

//    Observable이 배출한 항목들을 변환한 후에 다시 배출해야 하는데
//    ...함수와 함께 항목을 한번에 하나씩 변환 후 배출해야 한다면:Map
//    ...해당 Observable이 배출한 모든 항목들을 하나의 Observable이 배출하는 형태로 배출해야 한다면:FlatMap
//       ...순서대로 Observable이 배출한 항목들을 연결지어 배출해야 한다면:ConcatMap
//    ...앞에서 실행 된 결과를 기반으로 항목을 변환한 후 배출해야 한다면:Scan
//    ...타임 스탬프를 추가하여 변환한 후 배출해야 한다면:Timestamp
//    ...항목 배출 전까지 경과한 시간을 가리키는 객체로 변환한 후에 배출해야 한다면:TimeInterval

//    Observable이 항목을 배출하기 전에 항목의 배출 시간을 지연시켜야 한다면:Delay

//    Observable이 배출하는 항목들과 알림들을 다시 항목들로 변환 후 배출해야 하는데
//    ...이때 배출하는 항목들을 알림 객체로 감싸서(wrapping) 배출해야 한다면:Materialize
//       ...이 알림 객체가 다시 풀릴 수(unwrapping) 있다면:Dematerialize

//    Observable이 배출하는 모든 객체를 무시하고 completed/error 알림만 전달해야 한다면:IgnoreElements

//    Observable이 가진 항목을 그대로를 배출하지만 배출 전에 다른 항목들을 먼저 배출될 수 있도록 추가해야 한다면:StartWith
//    ...만약 소스 Observable이 비어있을 경우 기본 항목을 추가해야 한다면:DefaultIfEmpty

//    Observable이 배출하는 항목들을 모아둔 후 버퍼로 다시 배출해야 한다면:Buffer
//    ...그 중 마지막에 배출된 항목이 추가된 버퍼만 배출해야 한다면:TakeLastBuffer

//    하나의 Observable을 여러 Observable로 나눠야 한다:Window
//    ...그 중 유사한 항목들을 같은 Observable에 모아 두어야 한다면:GroupBy

//    Observable이 배출한 특정 항목을 조회해야 하는데
//    ...Observable이 완료되기 전에 마지막으로 배출한 항목을 조회해야 한다면:Last
//    ...배출된 항목이 단지 하나이고 이것을 조회해야 한다면:Single
//    ...배출한 첫 번째 항목을 조회해야 한다면:First

//    Observable의 특정 항목만 재배출 해야 하는데
//    ...어떤 조건을 만족시키지 않는 항목들을 필터링해서 재배출 해야 한다면:Filter
//    ...첫 번째 항목만 재배출 해야 한다면:First
//    ...처음 몇 개의 항목들만 재배출 해야 한다면:Take
//    ...마지막 항목만 재배출 해야 한다면:Last
//    ...몇 번째 위치한 항목만 재배출 해야 한다면:ElementAt
//    ...재배출할 항목들이 처음 몇개 이후의 것들일 경우
//       ...처음 몇 개의 항목들 이후의 것들 이라면:Skip
//       ...특정 조건을 만족시킨 이후의 것들 이라면:SkipWhile
//       ...초기 특정 시간 이후에 배출된 항목들 이라면:Skip
//       ...두 번째 Observable이 항목을 배출한 이후의 것들 이라면:SkipUntil
//    ...마지막 항목 몇개를 제외한 경우
//       ...마지막 몇 개 항목을 제외한 것들 이라면:SkipLast
//       ...특정 조건을 만족할때 까지의 것들 이라면:TakeWhile
//       ...소스 Observable이 완료되기 이전 특정 시간 동안 배출한 것들을 제외한 것이라면:SkipLast
//       ...두 번째 Observable이 항목을 배출한 이후에 배출된 것들을 제외한 것이라면:TakeUntil
//    ...주기적으로 Observable을 샘플링해서 재배출해야 한다면:Sample
//    ...특정 시간이 지나고 나서 배출된 항목들만 재배출 해야 한다면:Debounce
//    ...이미 배출된 항목과 동일한 것들을 제외시켜 재배출 해야 한다면:Distinct
//       ...만약 중복된 항목이 바로 연이어 배출된다면:DistinctUntilChanged
//    ...항목 배출이 시작된 이후에 얼마 동안 구독을 지연시켜야 한다면:DelaySubscription

//    항목들을 배출하는 Observable 컬랙션 중에 첫 번째로 항목을 배출하는 Observable의 항목만 배출해야 한다면:Amb

//    Observable이 배출한 연속된 항목 전체를 평가해야 한다
//    ...그리고 항목 전체가 테스트를 통과했는지를 가리키는 boolean 타입 항목 하나를 배출해야 한다면:All
//    ...그리고 항목 전체 중 하나라도 테스트를 통과했는지를 가리키는 boolean 타입 항목 하나를 배출해야 한다면:Contains
//    ...그리고 Observable이 항목을 배출하지 못했는지를 가리키는 boolean 타입 항목 하나를 배출해야 한다면:IsEmpty
//    ...그리고 두 Observable이 같은 순서대로 항목들을 배출했는지를 가리키는 boolean 타입 하나를 배출해야 한다면:SequenceEqual
//    ...그리고 전체 배출된 항목의 평균 값을 항목을 배출해야 한다면:Average
//    ...그리고 전체 배출된 항목의 합계를 배출해야 한다면:Sum
//    ...그리고 얼마나 많은 항목들이 배출됐는지를 배출해야 한다면:Count
//    ...그리고 가장 큰 값을 가진 항목을 배출해야 한다면:Max
//    ...그리고 가장 작은 값을 가진 항목을 배출해야 한다면:Min
//    ...배출되는 항목 순서대로 각각에 집계 함수를 적용해서 결과를 배출해야 한다면:Scan

//    Observable이 배출한 전체 항목들을 특정 자료구조로 배출하고 싶다면To
//
//    연산자가 특정 스케줄러 상에서 동작해야 한다면:SubscribeOn
//    ...연산자가 옵저버한테 알림을 줄 때 동작할 스케줄러를 지정해야 한다면:ObserveOn

//    특정 이벤트가 발생 할 때 Observable 상에서 어떤 동작을 실행시켜야 한다면:Do

//    오류가 발생했을 때 Observable이 옵저버에게 오류를 알려야 하다면:Throw
//    ...만약 항목이 배출되지 않은 상태에서 특정 시간이 경과했다면Timeout

//    자연스럽게 Observable을 복구해야 하는데
//    ...타임 아웃이 발생한 경우 백업 Observable로 전환시켜 복구해야 한다면:Timeout
//    ...앞에서 발생한 오류 알림으로부터 복구해야 한다면:Catch
//       ...이전 Observable에 재구독을 시도해야 한다면:Retry

//    동일한 생명주기를 가진 리소스를 Observable로 생성해야 한다면:Using
//
//    Observable을 구독하고 Observable이 완료될 때까지 블로킹 상태에 있는 퓨처(Future)를 전달 받고 싶다면:Start
//
//    구독자의 요청 전까지 Observable이 항목을 구독자에게 배포하지 말아야 한다면:Publish
//    ...그리고 맨 마지막 항목만을 배출해야 한다면:PublishLast
//    ...그리고 배출 이후에 구독자가 구독을 시작했다 하더라고 동일하게 배출 순서를 전달해야 한다면:Replay
//    ...하지만 모든 구독자가 한번에 구독을 해지할 수 있어야 한다면:RefCount
//    ...그리고 배출을 시작하도록 Observable에게 요청해야 한다면:Connect

}
