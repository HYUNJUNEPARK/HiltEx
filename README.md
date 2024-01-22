# HiltEx
-정리 중-

-`com.aos.hiltex.example1` : @Inject, @Module, @Qualifier 사용을 볼 수 있는 기본 예시
-`com.aos.hiltex.example2` : Room


Dagger 2와 Hilt
-Hilt는 Dagger 설정 코드를 생성하는 코드로 작동한다.
-Dagger의 상용구를 제거하고 실제로 개체를 주입할 위치를 정의하는 측면만 남긴다.


`@HiltAndroidApp`
-Hilt를 사용하는 모든 앱에는 `@HiltAndroidApp` 어노테이션이 달린 Application 클래스가 있어야 한다.
-Hilt Components의 코드 생성을 시작하고 생성된 Components를 사용하는 응용프로그램의 기본 클래스도 생성한다.
```kotlin
@HiltAndroidApp
class HiltApplication: Application()
```


`@AndroidEntryPoint`
-액티비티나 프래그먼트 등에 붙여서 Hilt가 쓰인다는 것을 알려준다.
-주입 가능 클래스 ex) `Activity, Fragment, View, Service, BroadcastReceiver`


`@Inject`
-클래스 이름 뒤에 @Inject 를 적어주고 constructor() 를 적어준다. -> 어딘가에서 클래스가 사용
```kotlin
class Store @Inject constructor() {
    fun open() = Log.i(TAG, "OPEN")
    fun close() = Log.i(TAG, "CLOSE")
}
```

-사용할 객체 앞에 @Inject 를 적어준다 -> Hilt가 객체를 만들어 주입
```kotlin
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   @Inject lateinit var store: Store

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        store.opne()
   }
}
```


Hilt 모듈
`@Module`
-Hilt에 모듈임을 알려준다.

`@InstallIn`
-모듈이 어던 범위에서 쓰이는가를 나타낸다.
-ex) `SingletonComponent, ActivityComponent` ...
```kotlin
@InstallIn(SingletonComponent::class)
@Module
object FactoryModule 
```

`@Qualifier`
`@Bind`
-인터페이스가 어떻게 구현되는지 Hilt가 구분할 수 있게 된다.





ViewModel은 별도의 API @HiltViewModel을 통해 지원
```kotlin
 @HiltViewModel
class FooViewModel @Inject constructor(
  val handle: SavedStateHandle,
  val foo: Foo
) : ViewModel
```


View
기본적으로 `SingletonComponent` 및 `ActivityComponent` 바인딩만 View에 주입할 수 있다.
View에서 Fragment 바인딩을 활성화하려면 클래스에 `@WithFragmentBindings` 어노테이션을 추가
여러 ViewModel에서 한 인스턴스를 공유해야 하는 경우 `@ActivityRetainedScoped` 또는 `@Singletone`을 사용하여 범위를 지정해야 한다.


Scoped vs UnScoped
범위없음(UnScoped)바인딩
이 바인딩에 대한 각 요청은 새 인스턴스를 가져온다
```kotlin
class UnscopedBinding @Inject constructor()
```

범위지정바인딩(Scoped)바인딩
이 바인딩에 대해 동일한 컴포넌트인스턴스의 각 요청은 동일한 인스턴스를 가져온다.
ex. @Singleton, @ActivityRetainedScoped, @ViewModelScoped, @ActivityScoped, @ViewScoped, @ServiceScoped
Hilt는 현재 Android 유형 중 Application(@HiltAndroidApp 사용), Activity, Fragment, View, Service, BroadcastReceiver를 지원합니다.
``` kotlin
@FragmentScoped
class ScopedBinding @Inject constructor() { ... }
```



@Singleton : 애플리케이션 컨테이너에서 항상 같은 인스턴스를 제공
주석을 사용하여 인스턴스의 범위를 컨테이너로 지정할 수 있습니다. Hilt는 수명 주기가 다른 여러 컨테이너를 생성할 수 있으므로 이러한 컨테이너로 범위가 지정된 다양한 주석이 있습니다.
인스턴스 범위를 애플리케이션 컨테이너로 지정하는 주석은 @Singleton입니다.




@Provides로 인스턴스 제공
@Provides 주석을 달아 Hilt에 생성자가 삽입될 수 없는 유형의 제공 방법을 알려 줄 수 있습니다.
@Provides 주석이 있는 함수 본문은 Hilt에서 이 유형의 인스턴스를 제공해야 할 때마다 실행됩니다.
@Provides 주석이 있는 함수의 반환 유형은 Hilt에 결합 유형 또는 유형의 인스턴스 제공 방법을 알려 줍니다.

@Binds
인터페이스에 사용할 구현을 Hilt에 알리려면 Hilt 모듈 내 함수에 @Binds 주석을 사용

---
Dependency injection with Hilt(프로젝트에 Hilt 추가)
https://developer.android.com/training/dependency-injection/hilt-android#kts

Hilt CodeLab
https://developer.android.com/codelabs/android-hilt?hl=ko#0

힐트 Hilt 안드로이드에서 의존성 관리하기 : 외부 라이브러리 모듈로 만들기
https://software-creator.tistory.com/35

Hilt 라이브러리 이해하기
https://junyoung-developer.tistory.com/183
