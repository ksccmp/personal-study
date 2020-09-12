# ECMAScript
## ECMAScript란 ?
* Ecma International이 ECMA-262 기술 규격에 따라 정의하고 있는 표준화된 스크립트 프로그래밍 언어
* 자바스크립트를 표준화하기 위해 만들어짐
## ES버전
* ES1 : 1997년 6월에 등장
* ES2 : 1998년 6월에 등장
* ES3 : 1999년 12월에 등장
* ES4 : 정치적 차이로 버려짐
* ES5 : 2009년 12월에 등장
    * 배열에 forEach, map, filter, reduce, some 등의 메소드 지원
    * object에 getter / setter 지원
    * JSON 지원
* ES6(ES2015) : 2015년 6월에 등장 / JavaScript의 대 변화가 이루어진 시점
    * let, const 키워드 추가
    * arrow 문법 지원 (간결해진 코드 + this 바인딩 안함)
    * iterator / generator 추가
    * module들의 import / export 추가
    * Promise 도입
* ES7(ES2016) : 2016년 6월에 등장
* ES8(ES2017) : 2017년 6월에 등장
    * async - await 도입
* ES.Next : 곧 등장 할 다음 버전의 ECMAScript를 의미
* ES 버전이 지속적으로 높아짐에 따라 브라우저에서 인식하지 못하여 처리하지 못하는 상황이 발생 --> 트랜스 파일러의 등장
## 트랜스 파일러
* 프로그램의 소스코드를 이전 버전 또는 최신 버전 등의 비슷한 수준의 언어로 변환하는 역할
* 대표적으로 Babel이 존재
* JavaScript에서는 ES6버전 이후는 브라우저에서 못 읽는 기능들이 있기 때문에 브라우저에서 읽을 수 있는 버전으로 Babel이 트랜스 파일을 해줌

# 모듈
## 모듈이란 ?
* 구현 세부사항을 캡슐화하고 공개 API를 노출하여 다른 코드에서 쉽게 로드하여 재 사용할 수 있도록 만든 코드조각
## 모듈이 생기게 된 배경
* ```<script src="jquery.js"></script>```와 같이 코드를 작성할 때 스크립트들을 윗 단에서 모두 불러오다보니 사용하지 않는 것들도 모두 불러와 접근할 수 있기 때문에 충돌의 위험성이 커지게 됨
* 쓸 코드만 미리 지정하고 안 쓸 코드들은 배제하기 위해 모듈이 등장하게 됨
## 모듈포맷(모듈문법)
* AMD (Asynchronous Module Definition) : 비동기 모듈 정의
    * 비동기적으로 필요한 파일을 다운로드 하는 방식으로 client(브라우저 환경)에서 외부 모듈을 가져올 때 유리한 방식
    * define으로 모듈화하고 require을 이용하여 사용
        * myModule.js
        ```
        define(['jquery', 'zerocho'], function($, Z) {
            console.log($);
            console.log(Z);
            return {
                a: $,
                b: Z,
            }
        });
        ```
        * 사용파일
        ```
        require(['myModule', 'TweenMax'], function (my, T) {
            console.log(my.a); // jquery
            console.log(my.b); // zerocho
            console.log(T); // TweenMax
            console.log(jquery); // undefined 또는 에러
        });
        ```
* CommonJS
    * 모든 모듈이 로컬에 다운로드가 된 이후에 실행하는 방식 (다운되기 전까지 페이지를 동작할 수 없음)
    * Node.js에서 채택하여 사용하고 있으며 server환경에서 외부 모듈을 가져올 때 유리한 방식
    * module.exports로 모듈화하고 require을 이용하여 사용
        * myModule.js
        ```
        const $ = require('jquery');
        const Z = require('zerocho');
        module.exports = {
            a: $,
            b: Z,
        };
        ```
        * 사용파일
        ```
        const my = require('myModule');
        const T = require('TweenMax');
        console.log(my.a, my.b);
        console.log(T);
        ```
* UMD
    * AMD와 CommonJS를 쓰는 두 그룹으로 나뉘어 호환이 안되고 있기 때문에 어떤 모듈방식으로 든 모듈을 선언할 수 있도록 하기 위해 등장
    * AMD, CommonJs, 기존의 window에 추가하는 방식(```<script></script>```로 등록)까지 커버가 가능
    * myModule.js
        ```
        (function (root, factory) {
            if (typeof define === 'function' && define.amd) { // AMD
                define(['jquery', 'zerocho'], factory);
            } else if (typeof module === 'object' && module.exports) { // CommonJS
                module.exports = factory(require('jquery'), require('zerocho'));
            } else { // window
                root.myModule = factory(root.$, root.Z); 
            }
        }(this, function($, Z) {
            return {
                a: $,
                b: Z,
            };
        });
        ```
* ES6 모듈 포맷 (export / import)
## require vs import
### 공통점
* require과 import 모두 모듈을 가져올 때 사용하는 방식
* require은 기존의 CommonJS와 AMD 등의 모듈들을 불러올 때 사용하고 있었는데 ES6버전 이후로 import라는 것을 이용하여 언어 내부적으로 모듈 의존성을 지원
### 차이점
* require같은 경우는 모듈에 들어있는 모든 값을 한 번에 가져와서 선택하여 사용하는 방식
* import도 require와 같이 동작할 수 있지만 특정 기능들만 가져와서 사용할 수 있음

## 모듈로더
* 모듈포맷으로 작성된 모듈들을 해석하고 로드하는 역할
* 런타임할 때 실행 (클라이언트 사이드에서 불러옴)
* 모듈을 30개의 js파일로 나누어 작성하여 불러온다면 각각의 모듈들을 불러오기 때문에 30번을 불러와야댐 --> 부하 발생
* 부하를 줄이기 위해 빌드시간에 모듈들을 하나로 합치자는 생각이 고안되어 모듈 번들러가 등장
## 모듈 번들러
* 모듈로더를 대체하기 위해 등장
* 빌드타임에 실행되어 번들 파일(bundle.js)을 생성한 후 client에서는 번들 파일을 로드
* 대표적으로 Browserify / Webpack이 존재
## 순환참조
### 순환참조란 ?
* JavaScript 모듈은 런타임시 최초 import를 만날 때 단 한 번만 확인하고 반환을 하는데 반환된 모듈은 Global로 관리되고 있는 모듈 객체에 추가가 됨
* 이후 다른 곳에서 동일한 모듈을 import할 경우 재 평가를 하지 않고 모듈 객체에서 가져와 사용하게 됨
* 이런 상황에서 A모듈에서 B모듈을 import하고 B모듈에서도 A모듈을 import하게 되면 반환되지 않은 함수를 사용하여 에러가 발생되는 것을 순환참조라고 함
### 해결방법
* 모듈의 Dependency 순서를 명확히 지정
* 별도의 모듈을 import하는 파일을 만들어서 해당 파일 내부에서 모듈 import를 관리

# 객체지향 vs 함수형
## 객체지향 프로그래밍
### 객체지향 프로그래밍이란 ?
* 절차지향 프로그램과 같이 명시된 순서대로 처리하는 것이 아니라 "객체"라는 기본 단위로 나누어 객체들간의 상호작용을 하는 프로그래밍
### 객체지향 프로그래밍 특징
* 추상화(Abstract) : 목적과 관련이 없는 것을 제거하고 필요한 부분만 표현하기 위한 개념
* 다형성(Polymorphism) : 형태가 같은데 서로 다른 기능을 수행
* 상속성(Inherit) : 부모가 사용하는 특징들을 상속받아서 자식이 수행
* 캡슐화(Encapsulate) : 사용되는 여러 기능들을 하나의 캡슐에 담는다는 개념
## 함수형 프로그래밍
### 함수형 프로그래밍이란 ?
* 프로그래밍의 상태와 상태를 변경시키는 명령형 프로그래밍(절차지향, 객체지향)과는 달리 순수 함수를 조합하여 프로그래밍 하는 선언형 프로그래밍 방식
### 함수형 프로그래밍 특징
* 1급 객체 : 변수나 데이터를 구조안에 담음 / 파라미터 전달 가능 / return 값 사용 / 할당에 사용된 이름과 관계없이 고유한 구별이 가능 / 동적으로 프로펄티 할당
* 고차함수 : 함수에 함수를 파라미터로 전달 가능 / 함수의 return 값으로 함수를 사용 가능
* 불변성 : 한 번 정의된 데이터는 변경되지 않음, 변경이 필요한 경우 복사본을 만들어 작업 (array.map, array.reduce, array.filter 등이 생김)
* 순수함수 : 동일한 입력에는 항상 같은 값을 반환 / 함수의 실행이 프로그래밍의 실행에 영향을 미치지 않아야 함

# 렌더링
## 렌더링이란 ?
* 서버로부터 HTML 파일들을 받아 브라우저에 뿌려주는 과정
## 브라우저 렌더링 과정
* 사용자가 URI를 입력하여 브라우저 엔진에 전달
* 브라우저 엔진에서 URI에 대한 저장된 쿠키 등의 자료들을 가져와 렌더링 엔진으로 전달
* 렌더링 엔진 과정
    * HTML을 파싱하여 DOM(Document Object Model) 트리를 생성
    * CSS를 파싱하여 CSSOM(CSS Object Model) 트리를 생성
    * DOM 트리와 CSSOM 트리를 통해 렌더링 트리 생성
    * 레이아웃 단계에서 브라우저의 어느 위치에 어느 크기로 렌더링 트리를 그려주는지 계산
    * 페인트 단계에서 요소들을 실제 화면에 그려줌
* 리플로우 / 리페인트
    * 리플로우(Reflow) : 노드의 크기위 위치를 다시 계산하는 작업
    * 리페인트(RePaint) : 렌더링 트리를 레이아웃에 다시 그려주는 작업
    * 발생경우
        * 페이지 초기 렌더링
        * 윈도우 리사이징
        * 노드 추가 또는 제거
        * 요소의 위치, 크기 변경
        * 폰트 변경, 이미지 크기 변경

# 비동기
## 비동기 방식이란 ?
* 웹페이지를 리로드 하지 않고 데이터를 불러오는 방식이며 서버에 요청을 한 후 서버가 멈추어 있지 않고 데이터 처리를 함
## 장점
* 웹페이지 속도 향상
* 서버가 처리되는 것을 기다리지 않고 처리 가능
* 동기 방식에서 불가능했던 다양한 UI가 가능 (제목이나 태그들을 페이지의 리로드 없이 수정 가능)
## 단점
* 히스토리 관리가 되지 않음
* 페이지 이동없는 통신으로 보안상의 문제가 있음
* 연속하는 데이터를 요청 시 서버 부하가 증가
* 동일출처 정책으로 다른 도메인과 통신이 불가능 (CORS 문제 발생)
## 비동기 기법
* AJAX(Asynchronous Javascript And XML) : JavaScript 라이브러리 중 하나로 브라우저가 가지고 있는 XMLHttpRequest 객체를 이용하여 페이지의 일부만을 위한 데이터를 로드하는 기법
* CallBack : ES6 버전 이전에 자바스크립트에서 사용하던 비동기 방식 (계속해서 콜백 내에 작업해야되며 깊이가 점점 깊어지는 콜백지옥 현상이 발생)
* Promise : ES6 버전에 출시되어 CallBack의 단점을 보완하며 간결하게 코드를 작성할 수 있도록 함
* Async / Await : ES8 버전에 출시되어 Promise를 보완
    * 동기적 코드 흐름으로 개발 가능
    * 코드가 간결해지고 가독성이 높아짐
    * error가 어디서 발생했는지 알기 쉬움
    * try/catch로 error 핸들링이 가능

# 호이스팅
## 호이스팅이란 ?
* 선언된 모든 변수(var, let, const 등) 및 함수(함수선억식)들을 코드 상단으로 끌어올리는 것 (할당내용은 끌어올리지 않음)
## 예시 (var)
* 작성한 코드
    ```
    console.log(hoisting); //undefined
    var hoisting = "success";
    console.log(hoisting); // 'success'
    ```
* 실제 동작되는 코드
    ```
    var hoisting;
    console.log(hoisting); //undefined
    hoisting = "success";
    console.log(hoisting); // 'success'
    ```
## 예시 (함수표현식)
* 예시
    ```
    a();
    var a = function() {
    console.log("a is not a function");
    };
    ```
* 실제 동작되는 코드
    ```
    var a;
    a(); // error, "a is not a function"
    a = function() {
    console.log("a is not a function");
    };
    ```
## let, const에서의 호이스팅
* 예시
    ```
    console.log(x); // throws a ReferenceError
    const x = 'hey';
    ```
    ```
    console.log(x); // throws a ReferenceError
    let x = 'hey';
    ```
* 에러발생 이유 : const와 let은 호이스팅이 되기는 하지만 실제 변수가 선언되어 있는 위치에 오기전까지 변수 호출할 수 없음 (Temporal Dead Zone의 영향)

# 클로저
## 실행 문맥(Execution Context) 이란?
* 실행 가능한 코드가 실행되기 위한 환경이라는 추상적인 용어로 전역 코드 단위와 함수(블럭) 코드 단위로 나타냄
* 예시
    ```
    // global context
    let a = "Hello";
    
    function func1() { // local execution context
        let a = 1;
        let b = 2;

        function func2() { // local execution context
            return;
        }
    }
    ```
### 동작방법
* 전역 실행 컨텍스트에서 프로그램이 시작되고 함수를 호출할 때마다 새로운 지역 실행 컨텍스트가 실행되며 자신들의 고유한 변수를 가지고 콜 스택으로 들어감
* 콜 스택에 들어간 지역 실행 컨텍스트는 return 또는 } 로 함수 호출이 끝마치면 콜스택에서 빠져나오고 반환된 값들은 해당 함수를 호출했던 실행 컨텍스트에게 반환되고 소멸됨
## lexical scope 란?
* 자바스크립트에서 변수를 찾는 범위로 지역 실행 컨텍스트에서 먼저 변수를 찾고 이후로 호출 컨텍스트에서 변수를 찾음
* 호출 컨텍스트에서도 찾지 못하면 전역 실행 컨텍스트까지 올라가고 전역에도 없다면 undefined를 반환 ()
## 클로저란 ?
* 내부함수가 정의될 때 외부 함수의 환경을 기억하는 원리를 지칭하는 용어
## 예시
* 클로저 예시
    ```
    let out = 'out value';

    function outFunc() {
        const inner = 'in value';

        function inFunc(isParam) {
            console.log(`out: ${out}`);
            console.log(`inner: ${inner}`);
            console.log(`inParam: ${inParam}`);
        }

        return inFunc;
    }

    const param = 'this is param';
    const outResult = outfunc();
    outResult(param); // out: out value \n inner: in value \n inParam: this is param;
    out = 'out change';
    outResult(param); // out: out change \n inner: in value \n inParam: this is param;
    ```
* 클로저-호이스팅 문제 예시
    ```
    for (var i=0; i<100; i++){
        setTimeout(function(){
            console.log(i);
        }, i*100);
    }
    // 결과 : 100 100 100 100 100 100 ...
    // 이유 : setTimeout이라는 비동기 함수가 100개가 실행이 순서되로 되지만 실제로 Timeout이 되어 console을 찍을 때는 i값이 이미 100까지 도달하여 100을 출력
    ```
* 클로저-호이스팅 예방 예시 (var을 let으로 변경해도 가능)
    ```
    for (var i=0; i<100; i++){
        function call(j) {
            setTimeout(function(){
                console.log(j);
            }, j*100);
        }
        call(i);
    }
    // 결과 : 0 1 2 3 4 5 6 ...
    // 이유 : Timeout이 될 때 바라보는 값이 변수로 들어온 j값이기 때문에 0부터 순서대로 출력
    ```

# 프로토타입
## 프로토타입이란 ?
* 일반적인 객체지향언어에서의 클래스를 대신하여 상속 등을 흉내내어 자바스크립트가 객체지향언어로 사용될 수 있도록 도와주는 역할
## 개념
* prototype 예시
    ```
    function Person() {}
    Person.prototype.eyes = 2;
    Person.prototype.nose = 1;
    var kim  = new Person();
    var park = new Person():
    console.log(kim.eyes); // => 2
    ```
* 위의 예시와 같이 Person.prototype이라는 Object가 어딘가에 존재하고 Person함수로부터 생성된 객체(kim, park)들은 어딘가에 존재하는 Object에 들어있는 값을 사용할 수 있음
* Prototype Object : 함수를 정의할 때 생성 / 일반적인 객체와 같으며 기본적은 속성으로 constructor와 __proto__를 가지고 있음
* 아래 그림과 같이 생성된 함수는 prototype이라는 속성을 통해 Prototype Object에 접근 가능
    <image src="image/prototype1.PNG" alt="prototype1" width="600px" height="400px">
* Prototype Link : __proto__속성을 통해 조상이었던 함수의 Prototype Object를 가리킴 / 만들어진 Prototype Object도 __proto__속성을 가지고 있고 해당 속성을 통해 Object의 Prototype Object에 접근 가능
* 위의 예처럼 kim.eyes라는 어떤 속성값을 찾으려고 할 때 Object의 Prototype Object까지 도달해도 값을 찾지 못하면 undefined를 표출함
    <image src="image/prototype2.PNG" alt="prototype2" width="600px" height="400px">

# 이벤트루프 / 동시성모델
## 동시성
* JavaScript는 한 번에 하나의 작업만 처리하는 싱글스레드 언어인데 수많은 작업들이 동시에 처리되는 것처럼 보여짐
* 이러한 동시성모델은 이벤트루프를 기반으로 만들어짐
## 이벤트루프
* 호출스택(Call Stack) : JavaScript에서 실행되는 함수의 현재 위치 및 상태를 기록하는 자료 구조 / 현재 어떤 함수가 동작되고 다음에 어떤 함수가 호출되는지를 제어
* 이벤트큐(Event Queue) : 런타임 시점에 처리해야 할 Task를 담아놓은 큐로 비동기 이벤트(DOM Event, Ajax, SetTimeout 등)들의 작업이 완료된 뒤 실행 될 Task들이 이벤트 큐에 쌓임
* 이벤트루프 : Call Stack 내에서 실행중인 Task들이 있는지를 확인하고 Call Stack이 비워지게 될 경우 Event Queue 내의 Task가 Call Stack으로 이동되어 실행 되는것을 반복시켜줌
    <image src="image/eventloop.PNG" alt="eventloop" width="600px" height="400px">

# Package Manager
## Package Manager 란?
* 패키지를 다루는 작업(패키지 설치, 수정, 업데이트 ,삭제)을 편리하고 안전하게 수행하기 위해 사용되는 툴
* 패키지는 라이브러리와 유사한 개념으로 라이브러리가 코드의 작성을 위해 사용되는 코드의 묶음이면 패키지는 코드의 배포를 위해 사용되는 코드의 묶음이라고 볼 수 있음
* 따라서 패키지는 경우에 따라 라이브러리를 포함할 수도 있고 실행파일 등을 포함
* 패키지가 소유하고 있는 정보 : 컴파일한 소프트웨어의 바이너리, 환경설정 관련 정보, Dependency 관련 정보
## Denpendency 란?
* 많은 패키지들은 다른 관련 패키지가 설치되어 있어야만 정상적으로 동작을 함.
* 해당 경우에 기존 패키지를 실행시키기 위해 필요한 다른 패키지들을 Dependency라고 부름
* 패키지를 설치할 때 각각의 패키지가 자신의 Dependency 정보를 가지고 있어 사용자가 특정 패키지를 사용할 때 쉽게 사용할 수 있게 해줌
    * 자신의 Dependency 정보를 가지고 있지 않을 때 Dependency Hell이 발생할 수 있음
        * 예시 : A라는 패키지를 설치하는데 B라는 Dependency가 필요함. B라는 Denpendency를 설치하는 도중 B의 Dependency로 A라는 Dependency가 필요.
## Package Manager의 역할
* 패키지의 Dependency 관리
* 패키지의 보안관리 : 신뢰 + 손상방지
* 여러 패키지를 기능에 따라 그룹으로 관리
* 패키지 압축 해제
* 소프트웨어를 저장하고 관리하는 저장소인 Software Repository로부터 패키지를 찾고, 다운로드 / 설치 / 업데이트까지 수행
## npm vs yarn
* npm은 Node.js에서 주로 사용하는 패키지매니저
* yarn은 페이스북에서 개발한 새로운 자바스크립트 패키지매니저로 더 빠르게 패키지를 설치하고 의존성 관리르 다양한 디바이스에서 할 수 있게 하기 위해 개발
* yarn 공식홈페이지에서 설명하는 다른 패키지매니저와의 차이점 (고속 / 보안 / 신뢰성 / 오프라인 모드 / 결정적 / 네트워크 성능 / 동일 패키지 / 네트워크 복구 / 플랫 모드)
* 속도면에서는 yarn이 더욱 빨랐으나 최근에는 npm의 punching back을 통해 거의 차이가 나지 않음 (그래도 yarn이 근소하게 빠름)
* 신뢰성(안정성)면에서는 npm과 yarn 모두 문제없이 잘 사용되고 있기 때문에 비교하기 힘듬
* 보안면에서는 npm은 패키지를 설치할 때 자동으로 코드와 의존성을 실행할수 있도록 허용하였는데 이부분에서 위험도가 증가 (특허 정책 없이 등록한 패키지 등) 
* 하지만 yarn은 yarn.lock이나 package.json으로 부터 설치만 함, 그리고 yarn.lock은 모든 디바이스에서 같은 패키지를 설치하는 것을 보장하여 다른 버전 설치로부터 오는 버그 양을 줄임
* 현재 사용빈도는 npm이 yarn보다 더 높은 상태
## package.json
### package.json 이란?
* Package Manager로부터 설치한 패키지들에 관한 정보와 의존중인 정보를 담고 있는 파일
### dependencies vs devdependencies
* 둘다 패키지에 관련된 dependency들을 담아두고 있음
* 가장 큰 차이점은 dependencies는 운영(프로덕션)환경에서 응용 프로그램에 필요한 패키지이고 devdependencies는 로컬 개발 및 테스트에서만 필요한 패키지

# 이벤트 전달 방식
## 이벤트 버블링
### 이벤트 버블링 이란?
* 특정 화면 요소에서 이벤트가 발생했을 때 해당 이벤트가 더 상위의 화면 요소들로 전달되어 가는 특성 (트리 구조상에서 상위 단계로 올라가는 것, div -> div -> div -> body)
## 이벤트 캡쳐
### 이벤트 캡쳐 란?
* 이벤트 버블링과 반대방향으로 이벤트를 전파하는 방식, 하위 단계로 해당 이벤트를 전달 (하위 단계를 클릭했을 때 상위 단계에서 부터 실행되어 옴)
### 구현 방법
* capture 속성값에 true를 지정
    ```
    var divs = document.querySelectorAll('div');
    divs.forEach(function(div) {
        div.addEventListener('click', logEvent, {
            capture: true // default 값은 false입니다.
        });
    });
    ```
## 이벤트 전달 방식 중지
* 이벤트 버블링이나 이벤트 캡쳐와 같이 복잡한 이벤트 전달 방식을 수행하고 싶지 않고 해당 화면 요소의 이벤트만 신경쓰고 싶을 때 이벤트 전달을 중지함
* event.stopPropagation을 사용하여 이벤트 전달 중지
    ```
    divs.forEach(function(div) {
        div.addEventListener('click', logEvent);
    });

    function logEvent(event) {
        event.stopPropagation();
        console.log(event.currentTarget.className); // three
    }
    ```
## event.stopPropagation vs event.preventDefault
* stopPropagation은 이벤트 버블링이나 이벤트 캡쳐와 같이 이벤트를 상위 또는 하위단계에 전달하는 것을 방지
* preventDefault는 a태그 클릭했을 때 클릭이벤트만 실행되고 브라우저의 행동을 막을 때 사용
## 이벤트 위임
### 이벤트 위임 이란?
* 이벤트를 등록할 때 사용해야 되는 각각의 요소들에 이벤트를 추가하는 것이 아니라 상위 요소에서 하위 요소들의 이벤트를 제어하는 방식
### 장점
* 동적인 요소들에 대한 이벤트 처리가 수월함
* 상위 요소에서 이벤트를 관리하기 때문에 하위 요소들을 자유롭게 추가 및 삭제 가능
* 이벤트핸들러 관리가 용이
* 등록 핸들러 자체가 줄어들기 때문에 메모리 누수 가능성을 줄임

# This
## 기본개념
* this는 기본적으로 window를 지칭
    ```
    this; // Window {}
    ```
* 함수안에서 this를 호출할 때에도 window를 지칭
    ```
    function a() { console.log(this); };
    a(); // Window {}
    ```
* 변수를 지정하며 함수를 생성할 때에는 변수값을 지칭
    ```
    var obj = {
        a: function() { console.log(this); },
    };
    obj.a(); // obj
    ```
* 위의 예에서 변수에 다시 집어넣을 때에는 다시 window를 지칭
    ```
    var a2 = obj.a;
    a2(); // window
    ```
* 클래스를 생성할 때 new를 통해 불러오지 않을 시에는 window를 지칭 / new를 선언할 시에는 클래스를 지칭
    ```
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    Person.prototype.sayHi = function() {
        console.log(this.name, this.age);
    }

    Person('ZeroCho', 25);
    console.log(window.name, window.age); // ZeroCho 25

    var hero = new Person('Hero', 33); // Person {name: "Hero", age: 33}
    hero.sayHi(); // Hero 33
    ```
## Call vs Apply vs Bind
### 기본개념
* Call, Apply, Bind 모두 함수 내의 this를 변경해주는 역할을 수행
### Call vs Apply
* Call과 Apply모두 첫 번재 인자에 this로 세팅하고 싶은 객체를 넘겨 this를 해당 객체로 변경시킴
* Call같은 경우는 this 세팅 객체를 제외하고 이후 변수들을 ,로 구분
* Apply같은 경우는 this 세팅 객체를 제외하고 이후 배열로 구분
    ```
    const obj = { name : 'Tom' }
    const say = function(city) {
        console.log(`Hello, My name is ${this.name}, I live in ${city}`);
    }
    say('Seoul'); // Hello, My name is  , I live in Seoul
    say.call(obj, 'Seoul'); // Hello, My name is Tom, I live in Seoul
    say.apply(obj, ['Seoul']); // Hello, My name is Tom, I live in Seoul
    ```
### Call vs Bind
* Call과 Apply는 바로 함수를 실행시키지만 Bind는 실행하지 않고 Bound함수를 리턴시킴
* 변수 구분은 Call과 같이 ,로 구분
    ```
    const obj = { name : 'Tom' }
    const say = function(city) {
        console.log(`Hello, My name is ${this.name}, I live in ${city}`);
    }
    const boundSay = say.bind(obj);
    boundSay('Seoul'); // Hello, My name is Tom, I live in Seoul
    ```

# JavaScript 원시타입
## 종류
* 기본 데이터 타입 : number(숫자), string(문자), boolean, undefined, null
* 참조 데이터 타입 : object
## null vs undefined
### 공통점
* 두 값 모두 변수에 값이 없다는 것을 의미
### 차이점
* null같은 경우는 의도를 가지고 변수에 null값을 할당하여 변수에 값이 없다는 것을 나타냄 (null의 type은 object)
* undefined같은 경우는 변수를 선언하고 값을 할당하기 전의 형태 (undefined의 type은 undefined)

# map vs reduce vs for

# === vs ==

# inline vs inline-block vs block
## inline vs block
* inline은 대표적으로 ```<span>```태그의 성질로 text 크기만큼 점유하고 동일 라인에 붙는 성질을 소유
* inline의 가장 큰 특징은 width/height와 margin/padding의 top/bottom 속성을 사용할 수 없음
* block은 ```<p>``` ```<div>```태그 등의 성질이며 무조건 한줄을 점유하고 다음 태그는 다음 줄로 보내버림
## inline vs inline-block
* inline-block은 기본적으로 inline의 성질을 가지고 있지만 inline의 단점을 보완하기 위해 등장
* inline-block은 inline에서 사용할 수 없었던 width/height와 margin/padding의 top/bottom 속성을 사용할 수 있음

# margin vs padding
## 공통점
* 두 속성 모두 여백을 만들때 사용하는 속성
## 차이점
* margin은 바깥쪽 여백을 만들 때 사용
* padding은 안쪽 여백을 만들때 사용

# position
## position 속성 종류
* static : position 속성의 default 값으로 요소를 나열한 순서대로 배치 (top, right, bottom, left 등의 속성 사용 불가)
* relative : static이었을 때 배치되는 위치를 기준으로 상대적 위치를 지정하여 배치
* absolute : 이전에 작성된 문서의 흐름과 상관없이 여러 속성값(top, right, bottom, left)들을 이용하여 배치 (기준이 되는 위치는 가장 가까운 부모 및 조상의 position속성이 relative인 요소)
* fixed : absolute와 마찬가지로 문서의 흐름에 상관없이 위치를 결정하고 브라우저 창이 기준이 되어 스크롤을 하더라도 계속 고정되어 배치
* sticky : 기준점(ex) top:50px)을 넘지 않을 때는 relative처럼 동작하다가 넘게될 시 fixed와 같이 동작 (스크롤을 내릴 때 상단에 고정배치 시킬 때 사용)

# SASS vs SCSS vs CSS
## SASS와 SCSS 등장 배경
* CSS가 복잡한 언어는 아니지만 작업이 크고 고도화 될수록 복잡해지는 CSS 작업을 쉽게 해주며 가독성과 재사용성을 높여 유지보수를 쉽게 하기 위해 등장
* CSS보다 심플한 표기법으로 구조화하여 표현할 수 있음
* 변수 및 조건문과 반복문 그리고 믹스인(MixIn) 등을 사용할 수 있음
## SASS vs SCSS
* 문법적인 차이가 존재
* SCSS코드 (기존의 CSS구조와 유사)
    ```
    .list {
        width: 100px;
        float: left;
        li {
            color: red;
            background: url("./image.jpg");
            &:last-child {
            margin-right: -10px;
            }
        }
    }
    ```
* SASS코드 (괄호대신 들여쓰기를 사용하여 코드 작성)
    ```
    .list
        width: 100px
        float: left
        li
            color: red
            background: url("./image.jpg")
            &:last-child
                margin-right: -10px
    ```
* SASS보다 SCSS가 더 이후에 등장하였고 SCSS가 더 넓은 범용성과 CSS의 호환성 등의 장점으로 SCSS 사용을 권장 / 공식문법도 SCSS 기준으로 나와있음
## SCSS vs StyledComponent
* StyledComponent는 기본적인 CSS파일을 작성하지 않고 스타일을 적용시켜 컴포넌트화 시켜서 사용
* SCSS와 뭐가 더 좋다고 판단할 수는 없지만 개인적으로 StyledComponent가 컴포넌트 형태로 적용하기 때문에 더 직관적이고 CSS파일을 파일별로 관리하지 않아도 되어서 편리함

# GET vs POST
## GET
* 주로 데이터를 읽거나 검색할 때 자주 사용되는 메소드
* GET 요청이 성공적으로 이루어지면 XML이나 JSON과 함께 200 (OK) HTTP 응답 코드를 리턴 / 에러 발생시에는 404(Not Found)나 400(Bad Request)가 주로 발생
* HTTP명세에 의하면 GET 요청은 idempotent하고 같은 요청을 여러번 하더라도 변함없이 항상 같은 응답을 받아 안전하기 때문에 데이터 변경 등의 안전하지 않은 연산에 사용하면 안됨
* GET은 서버에 데이터를 전송할 때 URL뒤 파라미터에 값을 붙여서 전송 (보안에 취약)
## POST
* 주로 새로운 리소스를 생성할 때 사용되는 메소드
* POST 요청이 성공적으로 이루어지면 201 (Created) HTTP응답 코드를 리턴
* HTTP명세에 의하면 POST 요청은 idempotent하지 않고 안전하지도 않기 때문에 같은 요청을 보낼 시 같은 정보를 담은 다른 resource를 반활항 가능성이 큼
* POST는 서버에 데이터를 전송할 때 request body에 데이터를 담아 전송 (보안에 안전)

# 브라우저 저장소
## 브라우저 저장소란 ?
* LocalStorage, SessionStorage, Cookie가 존재하며 클라이언트에 데이터를 저장하기 위한 데이터 저장소 역할을 수행
* 모두 key-value 형태로 값을 저장하여 데이터를 관리
## LocalStorage
* LocalStorage는 window.localStorage에 위치하며 데이터를 직접 지우기 전까지 계속 저장되어 있기 때문에 자동로그인 등에 사용
* localStorage.setItem('key', 'value') / localStroage.getItem('key') / localStroage.'key' = 'value' / localStorage.removeItem('key') 등과 같은 방법으로 사용
## SessionSotrage
* SessionStorage도 LocalStorage와 마찬가지로 window.SessionStorage에 위치하며 LocalStorage와 달리 윈도우나 브라우저를 닫을 경우 제거가 됨
* 사용법은 LocalStorage와 동일
## Cookie
* Cookie는 Storage들과 달리 만료기한이 있는 저장소
* 서버와 통신할 때 자동으로 Cookie값들을 서버에 같이 보냄

# SPA (Single Page Application)
## SPA 란?
* 단일 페이지로 구성된 웹 어플리케이션을 의미하며 화면 이동시에 서버로부터 HTML을 전달받지 않고 필요한 데이터만 JSON으로 전달 받아 동적으로 렌더링하는 기술
## 장점
* 화면이 이동할 때 화면마다 화면 전체를 렌더링 할 필요가 없기 때문에 이동속도가 빠름
* 화면에 필요한 데이터만 받아 오기 때문에 서버 요청이 적어 처리과정이 효율적임
* 빠른 반응성, 화면 전환 애니메이션 등에 의해 사용자 친화적이서 UX를 높여줌
* 컴포넌트 단위로 나누어 개발하기 때문에 관리가 용이
## 단점
* 처음 화면을 로딩할 때 모든 화면을 로드하기 때문에 속도가 느림
    * Lazy Loading으로 문제 해결
* 검색엔진 최적화(SEO)가 어려움
    * Server Side Rendering(SSR)로 문제 해결
## Lazy Loading
### Lazy Loading 이란?
* 화면을 로드할 때 중요한 데이터만 로드하고 이미지, 동영상 또는 일부 데이터와 같은 중요하지 않은 데이터는 로드를 연기하는 기법
* 주로 이미지를 로드할 때 많이 사용
### 사용방법
* 스크롤할 때 적용시키고자 하는 데이터의 위치가 화면에 들어왔을 때를 script로 계산하여 표현되도록 작성
* 최근 더 좋은 방법으로는 IntersectionOberserver이라는 API를 사용하여 Lazy Loading을 구현
## SEO (Search Engine Optimization)
### SEO 란?
* 검색엔진최적화 라는 의미로 웹 사이트가 구글과 같은 검색엔진의 검색결과에서 우리의 서비스를 상위로 나올수 있도록 도와주는 기술
* 검색엔진마다 검색봇이 데이터를 수집해가는 방식이 다르기 때문에 어떤 검색엔진에 더 중요하게 노출할 것인지를 생각하여 SEO를 최적화 하는 것이 중요
### SEO로 상위 랭크되는 방법
* 문법에 맞는 HTML 작성 : title태그로 제목을 기재하고 div태그로 줄을 바꾸고, strong과 em태그로 강조하는 등 적절한 HTML 소스 적용
* 구체적인 페이지 제목 만들기 : 페이지 제목은 구체적이고 간결하게 구성하여 검색 결과 화면에서 잘리지 않도록 하기 / 반복 키워드 삼가
* 메타 태그 활용 : meta name="keywords"나 meta name="description"과 같은 태그를 적절히 사용
* 이미지에 alt 속성 기재 : 이미지 속에 그려지 문자는 검색엔진에 의해 인식되지 않기 때문에 alt 속성에 텍스트를 기재
### SPA에서 SEO 문제
* SAP는 기본적으로 CSR 동작 방식이고, CSR 에서는 View를 그릴 때 서버에서 js를 가져와 View 그려냄
* 하지만 SEO는 기본적으로 HTML에서 데이터를 수집하도록 동작되기 때문에 js를 가져오는 CSR에서는 데이터를 수집하지 못해 빈 페이지를 크롤링 하는것으로 인식

# DOM vs Virtual DOM
## DOM (Document Object Model) 이란?
* 웹 페이지에 대한 프로그래밍 인터페이스로 HTML 요소들이 구조화된 것
* DOM의 개체 구조는 트리 형태로 표현
* DevTools에 보여지는 코드들이 DOM임
* HTML과 DOM은 항상 동일하다고 볼 수 없음
    * 브라우저가 HTML을 수정했을 때 HTML과 DOM은 다름 ex) tbody와 같은 태그를 뺴먹고 table에 작성을 했을 때 브라우저가 tbody를 작성하여 DOM에 들어있음
    * script나 비동기로 DOM을 조작한 경우 ex) script나 비동기로 html내용을 변경하거나 컨테르르 가져올 경우
## Virtual DOM 이란?
* 실제 DOM을 추상화 한 것으로 매번 컴포넌트를 변경할 때 마다 DOM에 접근하여 조작하지 않고 변경 부분만 파악하여 일괄 업데이트 하기 위해 사용
* 실제 DOM은 브라우저에서 관리하지만 Virtual DOM은 실제 DOM을 카피하여 메모리상에서 관리함
* 메모리상에서 관리되고 있기 때문에 훨씬 빠르고 변경 부분을 파악후 리플로우를 한 번 일어나게 만들어 줌


가비지컬렉터
웹프로토콜이란?
    HTTP통신
    HTTPS통신
    HTTP1.1 2.0차이
자바스크립트의 배열이 실제 자료구조 배열이 아닌 이유
HTML이 렌더링중에 Javascript가 실행되면 렌더링이 멈추는 이유
Javascript 성능 최적화 방법
SEO
=== vs ==


리액트의 상태관리 (Redux, MobX, Context API 등)
    뭐인지
    왜 사용하는지
    만드는 순서 및 동작원리
리덕스 사가의 옵저버블
클래스형과 함수형의 차이
클래스형의 라이프사이클 메소드
스켈레톤 UI란

뷰 vs 리액트

뷰 상태관리
뷰 라이프사이클
뷰에서 양방향 데이터가 일어난 ㅡ원리

타입스크리트
    등장배경
    장점
    리액트의 경우 tsx파일을 js로 변환하는 트랜스파일링을 거치는데 이런 과정때문에 바벨이 필요없음

라이브러리 프레임워크 차이
깃 관리 방식
메소드체이닝
    개념
    장단점
메모리제이션이란
RestFul API란
CORS란
ESLINt, Prettier, Webpack이란

배포경험

적응협웹 vs 반응형웹

CSR vs SSR

프로세스 vs 스레드

call by value vs call by reference