# npx create-next-app 사용하지 않고 환경설정 하기
## 기본파일 구조 생성
* package.json 생성
    ```
    npm init
    ```
* package.json scripts 수정
    ```
    "scripts": {
        "dev": "next dev", // webpack dev-server 로 실행
        "build": "next build", // build
        "start": "next start" // build파일로 실행
    },
    ```
* 필수 패키지 설치
    ```
    npm install next react react-dom
    ```
* root폴더 위치에 pages폴더 생성
* /pages/index.js 파일 생성 및 작성
    ```
    import * as React from 'react';

    const Index = () => {
        return (
            <>
                <div>
                    index page!!
                </div>
            </>
        );
    };

    export default Index;
    ```
* /pages/_app.js 파일 생성 및 작성
    ```
    const App = ({ Component, pageProps }) => {
        return <Component {...pageProps} />;
    };

    export default App;
    ```
* 실행
    ```
    npm run dev
    ```

## TypeScript 적용
* 필수 패키지 설치
    ```
    npm install typescript @types/react @types/node
    ```
* root폴더에 next-env.d.ts파일 생성
* /pages/_app.js -> /pages/_app.tsx 변경 및 내용 수정
    ```
    import { AppProps } from 'next/app';

    const App = ({ Component, pageProps }: AppProps) => {
        return <Component {...pageProps} />;
    };

    export default App;
    ```
* npm run dev 실행 시 추천되는 tsconfig.json 자동 생성

## ESLint / Prettier 적용
### ESLint 적용
* .eslintrc.json 파일 생성
    ```
    npx eslint --init
    ```
    ```
    ? How would you like to use ESLint? (Use arrow keys)
      To check syntax only 
    ❯ To check syntax and find problems // 선택
      To check syntax, find problems, and enforce code style 
        
    ? What type of modules does your project use? (Use arrow keys)
    ❯ JavaScript modules (import/export) // 선택
      CommonJS (require/exports) 
      None of these 
        
    ? Which framework does your project use? 
    ❯ React // 선택
      Vue.js 
      None of these 
    
    ? Does your project use TypeScript? (y/N) y // y 입력
    
    ? Where does your code run? (Press <space> to select, <a> to toggle all, <i> to invert selection)
    ❯ ◉ Browser // 선택
      ◯ Node 
    
    ? What format do you want your config file to be in? (Use arrow keys)
      JavaScript
      YAML 
    ❯ JSON // 선택
        
    The config that you've selected requires the following dependencies:

    @typescript-eslint/eslint-plugin@latest @typescript-eslint/parser@latest
    ? Would you like to install them now with npm? (Y/n) Y // Y 입력
    ```
* .eslintrc.json 파일 수정
    ```
    {
        "env": {
            "browser": true,
            "es6": true,
            "node": true
        },
        "extends": [
            "eslint:recommended",
            "plugin:@typescript-eslint/recommended",
            "plugin:prettier/recommended", // Prettier 적용
            "prettier/@typescript-eslint" // Prettier 적용
        ],
        "parser": "@typescript-eslint/parser",
        "parserOptions": {
            "ecmaFeatures": {
                "jsx": true
            },
            "ecmaVersion": 2018,
            "sourceType": "module"
        },
        "plugins": [
            "react",
            "@typescript-eslint"
        ],
        "rules": { // endOfLine Error 제거
            "prettier/prettier": [
                "error", {
                    "endOfLine": "auto"
                }
            ]
        }
    }
    ```
* setting.json 수정
    ```
    "editor.codeActionsOnSave": {
        "source.fixAll.eslint": true,
    },
    ```
### Prettier 적용
* 필수 패키지 설치
    ```
    npm install prettier eslint-config-prettier eslint-plugin-prettier
    ```
* root폴더에 .prettierrc 파일 생성 및 작성
    ```
    {
        "singleQuote": true,
        "semi": true,
        "tabWidth": 4,
        "trailingComma": "all",
        "printWidth": 120,
        "arrowParens": "always"
    }
    ```
* setting.json 수정
    ```
    "[typescript]": {
        "editor.formatOnSave": true
    },
    "[typescriptreact]": {
        "editor.formatOnSave": true
    },
    ```

## MobX 적용
* 필수 패키지 설치
    ```
    npm install --save mobx mobx-react
    ```
### Decorator 없이 적용
* /modules/mobx/counterStore.tsx 생성 및 작성
    ```
    import { observable } from 'mobx';

    export interface ICounterStore {
        number: number;
        increase(): void;
        decrease(): void;
    }

    const CounterStore: ICounterStore = observable({
        number: 1,
        increase() {
            console.log('increase');
            this.number++;
        },

        decrease() {
            console.log('decrease');
            this.number--;
        },
    });

    export default CounterStore;
    ```
* /modules/mobx/useStore.tsx 생성 및 작성
    ```
    import CounterStore from './counterStore';
    import { ICounterStore } from './counterStore';

    interface IuseStore {
        CounterStore: ICounterStore;
    }

    const useStore = (): IuseStore => ({ CounterStore });

    export default useStore;
    ```
*  /pages/hello.tsx 생성 및 작성
    ```
    import * as React from 'react';
    import { useObserver } from 'mobx-react';
    import useStore from '../modules/mobx/useStore';

    const Hello = (): JSX.Element => {
        const { CounterStore } = useStore();

        const onIncrease = () => {
            CounterStore.increase();
        };

        const onDecrease = () => {
            CounterStore.decrease();
        };

        return useObserver(() => (
            <>
                <div>
                    <span>CounterStore의 number값: {CounterStore.number}</span>
                </div>
                <button style={{ width: '4rem', height: '2rem' }} onClick={onIncrease}>
                    증가
                </button>
                <button style={{ width: '4rem', height: '2rem' }} onClick={onDecrease}>
                    감소
                </button>
            </>
        ));
    };

    export default Hello;
    ```