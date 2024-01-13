# HiltEx
-정리 중-


Dagger 2와 Hilt
Hilt는 Dagger 설정 코드를 생성하는 코드로 작동한다.
Dagger의 상용구를 제거하고 실제로 개체를 주입할 위치를 정의하는 측면만 남긴다.


@HiltAndroidApp
Hilt를 사용하는 모든 앱에는 @HiltAndroidApp 어노테이션이 달린 Application 클래스가 있어야 한다.
Hilt Components의 코드 생성을 시작하고 생성된 Components를 사용하는 응용프로그램의 기본 클래스도 생성한다.


@AndroidEntryPoint
다른 Android 클래스에서 멤버 주입을 활성화
Activity, Fragment, View, Service, BroadcastReceiver


ViewModel은 별도의 API @HiltViewModel을 통해 지원
```kotlin
 @HiltViewModel
class FooViewModel @Inject constructor(
  val handle: SavedStateHandle,
  val foo: Foo
) : ViewModel
```

View
기본적으로 SingletonComponent 및 ActivityComponent 바인딩만 View에 주입할 수 있다.
View에서 Fragment 바인딩을 활성화하려면 클래스에 @WithFragmentBindings 어노테이션을 추가
여러 ViewModel에서 한 인스턴스를 공유해야 하는 경우 @ActivityRetainedScoped 또는 @Singletone을 사용하여 범위를 지정해야 한다.


Scoped vs UnScoped
범위없음(UnScoped)바인딩
이 바인딩에 대한 각 요청은 새 인스턴스를 가져온다
```kotlin
class UnscopedBinding @Inject constructor() { ... }
```

범위지정바인딩(Scoped)바인딩
이 바인딩에 대해 동일한 컴포넌트인스턴스의 각 요청은 동일한 인스턴스를 가져온다.
ex. @Singleton, @ActivityRetainedScoped, @ViewModelScoped, @ActivityScoped, @ViewScoped, @ServiceScoped
Hilt는 현재 Android 유형 중 Application(@HiltAndroidApp 사용), Activity, Fragment, View, Service, BroadcastReceiver를 지원합니다.
``` kotlin
@FragmentScoped
class ScopedBinding @Inject constructor() { ... }
```

Hilt는 FragmentActivity(예: AppCompatActivity)를 확장하는 활동, 그리고 Android 플랫폼의 Fragment(현재 지원 중단됨)가 아닌 Jetpack 라이브러리 Fragment를 확장하는 프래그먼트만 지원합니다.
@AndroidEntryPoint : Hilt 를 사용하기 위해  Activity, Fragment 클래스명 위에 추가.
Hilt는 Activity, Fragment 의 수명 주기에 연결된 종속 항목 컨테이너를 생성하고 Activity, Fragment 에 인스턴스를 삽입할 수 있습니다.


@Singleton : 애플리케이션 컨테이너에서 항상 같은 인스턴스를 제공
주석을 사용하여 인스턴스의 범위를 컨테이너로 지정할 수 있습니다. Hilt는 수명 주기가 다른 여러 컨테이너를 생성할 수 있으므로 이러한 컨테이너로 범위가 지정된 다양한 주석이 있습니다.
인스턴스 범위를 애플리케이션 컨테이너로 지정하는 주석은 @Singleton입니다.


Hilt 모듈
@Module과 @InstallIn 주석이 달린 클래스
@Module : Hilt에 모듈임을 알려 주고
@InstallIn : 컨테이너에서 Hilt 구성요소를 지정하여 결합을 사용할 수 있는지 Hilt에 알려 줍니다.
Hilt 모듈을 사용하여 Hilt에 다양한 유형의 인스턴스 제공 방법을 알려 줍니다.
인터페이스나 프로젝트에 포함되지 않은 클래스와 같이 생성자가 삽입될 수 없는 유형의 결합을 Hilt 모듈에 포함
ex) 빌더를 사용하여 인스턴스를 생성해야 하는 OkHttpClient


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


