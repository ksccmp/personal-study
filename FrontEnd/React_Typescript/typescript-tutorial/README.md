# 1강. 구구단
* package.json 생성
    ```
    npm init
    ```
    ```
    package name: (typescript-tutorial)
    version: (1.0.0)
    description:
    entry point: (index.js)
    test command:
    git repository:
    keywords:
    author: KSC
    license: (ISC)
    ```
* typescript 패키지 설치
    ```
    npm i typescript
    ```
* lecture.html 생성
    ```
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8" />
        <title>구구단</title>
    </head>
    <body>
    <script src="lecture.js"></script>
    </body>
    </html>
    ```
* lecture.ts 생성 (html 오픈했을 때 에러 발생, ts를 인식하지 못함)
    ```
    const a: number = 1;
    console.log('hello javascript');
    console.log('hello typescript');
    ```
* terminal을 cmd로 변경 (구글링)
* typescript 전역 설치
    ```
    npm i -g typescript
    ```
* tsc명렁어로 ts파일을 이용하여 js파일 생성
    ```
    tsc lecture.ts
    ```
* watch를 통해 저장 시 자동으로 js파일 생성
    ```
    tsc lecture.ts -w
    ```
* npx란 : 프로젝트에 설치된 버전으로 명령어 실행 (global을 대체)

# 2강. 숫자야구
* lecture.html 내용 변경
    ```
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8" />
        <title>숫자야구</title>
    </head>
    <body>
    <script src="lecture.ts"></script>
    </body>
    </html>
    ```
* tsconfig.json 생성 (typescript 공식 문서에서 설정내용 확인 가능)
    ```
    {
        "compilerOptions": {
            // noImplicit과 strict같은 경우는 규칙을 지키면서 개발을 하기 위해 true로 잡는게 좋음. 그렇지 않을 경우 js와 다를 것이 없음
            "noImplicitAny": true,
            "noImplicitThis": true,
            "noImplicitReturns": true,
            "strict": true,

            // lib는 ES2015(ES6)와 ES2017이 중요한데 매번 등장하는 ES를 모두 등록하는 것이 좋음
            "lib": ["DOM", "ES5", "ES6", "ES2015", "ES2016", "ES2017", "ES2018", "ES2019", "ES2020"],

            // 문서 compile 타겟을 ES5로 잡는다. 보통 ES5나 ES6로 하는데 ES5로 하면 클래스 형태에서 에러가 날 수 있고 ES6로 하면 IE에서 돌아가지 않기 때문에 ES6로 설정하고 babel을 추가하여 사용하기도 한다.
            "target": "ES5" 
        },
        "include": ["lecture.ts"], // 해당 tsconfig를 포함시킬 파일
        "exclude": ["*.js"], // 해당 tsconfig를 제외시킬 파일
        // "extends": "" // 공통 tsconfig가 있고 폴더마다 다른 tsconfig를 적용하고 싶을 때 사용
    }
    ```
# 3강. 가위바위보 게임
* lecture.html 변경
    ```
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8" />
        <title>rsp</title>
        <style>
            #computer {
                width: 142px;
                height: 200px;
                background-position: 0 0;
            }
        </style>
    </head>
    <body>
    <div id="computer">
        <img src="" alt="">

    </div>
    <div>
        <button id="rock" class="btn">바위</button>
        <button id="scissor" class="btn">가위</button>
        <button id="paper" class="btn">보</button>
    </div>
    <script src="lecture.js"></script>
    </body>
    </html>
    ```
* interface와 type의 차이
    * interface는 서로 분리해서 명시하면 합쳐지지만 type은 그러지 않는다 (해당 기능을 이용하여 다른 사람이 미리 정의한 interface에 나만의 속성값을 추가하여 사용할 수 있다)
        ```
        interface RSP {
            readonly ROCK: '0';
        }

        interface RSP {
            readonly SCISSORS: '-142px';
            readonly PAPER: '-284px';
        }

        type RSP1 = {
            readonly ROCK: '0';
            readonly SCISSORS: '-142px';
            readonly PAPER: '-284px';
        }
        ```
    * interface는 주로 객체에, type은 주로 새로운 타입을 정의할 때 사용
* 객체의 인터페이스가 명확하지 않을 때
    ```
    interface Example {
        a: 3;
        b: 7;
        [key: string]: number;  // key는 string에 값을 number인 어떠한 값이 들어와도 상관없다
    }

    const example: Example = {
        a: 3,
        b: 7,
        d: 10,
        e: 5, // ...
    }
    ```
# 4강. 자스스톤
* lecture.html파일 변경
    ```
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8" />
        <title>자스스톤</title>
        <style>
            #my, #rival {
                display: inline-block;
                vertical-align: top;
                margin-right: 50px;
                min-width: 500px;
            }
            .turn {
                border: 1px solid blue;
            }
            #rival {
                vertical-align: bottom;
            }
            #my-deck, #rival-deck {
                display: inline-block;
                vertical-align: top;
                width: 300px;
                background: silver;
            }
            #rival-deck, #rival-hero, #rival-cards, #my-cards, #my-deck, #my-hero {
                text-align: center;
            }
            .card {
                width: 75px;
                height: 120px;
                display: inline-block;
                position: relative;
                border: 1px solid black;
                margin-bottom: 10px;
                background: white;
                user-select: none;
            }
            .card-name {
                text-align: center;
                font-size: 14px;
            }
            .card-att, .card-hp, .card-cost {
                font-size: 16px;
                font-weight: bold;
                text-align: center;
                line-height: 30px;
                width: 30px;
                height: 30px;
                border-radius: 50%;
                display: inline-block;
                position: absolute;
                bottom: 0;
                border: 1px solid black;
            }
            .card-cost {
                bottom: auto;
                top: 0;
                left: 0;
                background-color: blue;
                color: white;
            }
            .card-att {
                left: 0;
                background-color: yellow;
            }
            .card-hp {
                right: 0;
                background-color: red;
                color: white;
            }
            .card-hidden {
                display: none;
            }
            .card-selected {
                border: 2px solid red;
            }
            .card-turnover {
                background: gray;
            }
            #turn-btn {
                float: right;
                position: relative;
                top: -23px;
            }
        </style>
    </head>
    <body>
    <div id="rival">
        <div>코스트: <span id="rival-cost">10</span>/<span>10</span></div>
        <div id="rival-hero"></div>
        <div id="rival-cards" style="height: 150px">

        </div>
    </div>
    <div id="rival-deck">
        <div>덱</div>
    </div>
    <hr />
    <button id="turn-btn">턴넘기기</button>
    <div id="my" class="turn">
        <div id="my-cards" style="height: 150px">

        </div>
        <div id="my-hero">
        </div>
        <div>코스트: <span id="my-cost">10</span>/<span>10</span></div>
    </div>
    <div id="my-deck">
        <div>덱</div>
    </div>
    <div class="card-hidden">
        <div class="card">
            <div class="card-cost"></div>
            <div class="card-att"></div>
            <div class="card-hp"></div>
        </div>
    </div>
    <script src="lecture.js"></script>
    <div>빨강이 체력, 노랑이 공격력, 적 영웅의 체력이 0이되면 승리!
    영웅을 보호하기 위해 쫄병들을 코스트(파란색) 내에서 뽑을 수 있음</div>
    </body>
    </html>
    ```
