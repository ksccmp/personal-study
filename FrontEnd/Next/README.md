# npx create-next-app 사용하지 않고 환경설정 하기
## 기본파일 구조 생성
* package.json 생성
    ```
    npm init
    ```
* package.json scripts 수정
    ```
    "scripts": {
        "dev": "next dev -p 8888", // webpack dev-server 로 8888포트 오픈
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
* /pages/__error.js 파일 생성 및 작성
    ```
    import * as React from 'react';

    const Error = ({ statusCode }) => {
        return (
            <div>
                에러 발생 시 나오는 페이지 <br /> {statusCode}
            </div>
        );
    };

    export const getServerSideProps = async ({ res, req }) => {
        const statusCode = res.statusCode;

        return {
            props: {
                statusCode,
            },
        };
    };

    export default Error;
    ```
* /pages/404.js 파일 생성 및 작성 (에러에 맞는 페이지를 작성 가능)
    ```
    import * as React from 'react';

    const Error404 = () => {
        return (
            <>
                <div>
                    <p>404 에러 페이지</p>
                </div>
            </>
        );
    };

    export default Error404;
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
* /pages/_error.js -> /pages/_error.tsx 변경 및 내용 수정
    ```
    import * as React from 'react';
    import { GetServerSideProps } from 'next';

    interface IError {
        statusCode: number;
    }

    const Error: React.FC<IError> = ({ statusCode }): JSX.Element => {
        return (
            <div>
                에러 발생 시 나오는 페이지 <br /> {statusCode}
            </div>
        );
    };

    export const getServerSideProps: GetServerSideProps = async ({ res, req }) => {
        const statusCode = res.statusCode;

        return {
            props: {
                statusCode,
            },
        };
    };

    export default Error;
    ```
* 다른 js파일 -> tsx파일로 변경
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
* /pages/hello.tsx 생성 및 작성
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

## Redux 적용
* 필수 패키지 설치
    ```
    npm install  redux react-redux redux-devtools-extension @types/react-redux
    ```
* /modules/actions.tsx 파일 생성 및 작성
    ```
    export const increase = 'increase';
    export const decrease = 'decrease';

    export interface IincreaseAction {
        type: typeof increase;
    }

    export interface IdecreaseAction {
        type: typeof decrease;
    }

    export const increaseAction = (): IincreaseAction => {
        return {
            type: increase,
        };
    };

    export const decreaseAction = (): IdecreaseAction => {
        return {
            type: decrease,
        };
    };

    export type Iactions = IincreaseAction | IdecreaseAction;
    ```
* /modules/reducer/reducerCounter.tsx 파일 생성 및 작성
    ```
    import * as actions from '../actions';

    export interface IinitCounterState {
        number: number;
    }

    const initCounterState: IinitCounterState = {
        number: 1,
    };

    // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types
    const reducerCounter = (state = initCounterState, action: actions.Iactions) => {
        switch (action.type) {
            case actions.increase: {
                return {
                    ...state,
                    number: state.number + 1,
                };
            }

            case actions.decrease: {
                return {
                    ...state,
                    number: state.number - 1,
                };
            }

            default: {
                return {
                    ...state,
                };
            }
        }
    };

    export default reducerCounter;
    ```
* /modules/reducer/reducerIndex.tsx 파일 생성 및 작성
    ```
    import { combineReducers } from 'redux';
    import reducerCounter from './reducerCounter';
    import { IinitCounterState } from './reducerCounter';

    export interface IreducerIndex {
        reducerCounter: IinitCounterState;
    }

    const reducerIndex = combineReducers({ reducerCounter });

    export default reducerIndex;
    ```
* /modules/store.tsx 파일 생성 및 작성
    ```
    import { createStore } from 'redux';
    import { composeWithDevTools } from 'redux-devtools-extension';
    import reducerIndex from './reducer/reducerIndex';

    const store = createStore(reducerIndex, composeWithDevTools());

    export default store;
    ```
* /pages/_app.tsx 파일 수정
    ```
    import { AppProps } from 'next/app';
    import AppLayout from '../component/layouts/appLayout';
    import store from '../modules/store';
    import { Provider } from 'react-redux';

    const App = ({ Component, pageProps }: AppProps): JSX.Element => {
        return (
            <>
                <Provider store={store}>
                    <AppLayout>
                        <Component {...pageProps} />
                    </AppLayout>
                </Provider>
            </>
        );
    };

    export default App;
    ```
* /pages/hello.tsx 파일 수정
    ```
    import * as React from 'react';
    import { useObserver } from 'mobx-react';
    import useStore from '../modules/mobx/useStore';
    import { useDispatch, useSelector } from 'react-redux';
    import { IreducerIndex } from '../modules/reducer/reducerIndex';
    import { increaseAction, decreaseAction } from '../modules/actions';

    const Hello = (): JSX.Element => {
        const { CounterStore } = useStore();

        const reduxNumber: number = useSelector((state: IreducerIndex) => state.reducerCounter.number);
        const dispatch = useDispatch();

        const onMobxIncrease = () => {
            CounterStore.increase();
        };

        const onMobxDecrease = () => {
            CounterStore.decrease();
        };

        const onReduxIncrease = () => {
            dispatch(increaseAction());
        };

        const onReduxDecrease = () => {
            dispatch(decreaseAction());
        };

        return useObserver(() => (
            <>
                <div>
                    <span>Mobx의 number값: {CounterStore.number}</span>
                </div>
                <button style={{ width: '4rem', height: '2rem' }} onClick={onMobxIncrease}>
                    Mobx증가
                </button>
                <button style={{ width: '4rem', height: '2rem' }} onClick={onMobxDecrease}>
                    Mobx감소
                </button>

                <div>
                    <span>Redux의 number값: {reduxNumber}</span>
                </div>
                <button style={{ width: '4rem', height: '2rem' }} onClick={onReduxIncrease}>
                    Redux증가
                </button>
                <button style={{ width: '4rem', height: '2rem' }} onClick={onReduxDecrease}>
                    Redux감소
                </button>
            </>
        ));
    };

    export default Hello;
    ```

## ENV 적용하기
* next에서는 next.config.js파일에서 자체적으로 지원
* next dev에서는 process.env.NODE_ENV가 자동으로 development로 인식 / build파일에서는 자동으로 production으로 인식
* root폴더에 next.config.js파일 생성 및 작성
    ```
    module.exports = {
        webpack: (config, { isServer }) => {
            if (!isServer) {
                config.node = {
                    fs: 'empty',
                };
            }

            return config;
        },

        env: {
            STATE_1: process.env.NODE_ENV === 'production' ? 'PROD_MOBX' : 'DEV_MOBX',
            STATE_2: process.env.NODE_ENV === 'production' ? 'PROD_REDUX' : 'DEV_REDUX',
        },
    };
    ```
* /pages/hello.tsx 파일 수정
    ```
    ...

    return useObserver(() => (
        <>
            <div>
                {process.env.STATE_1}의 number값: {CounterStore.number}
            </div>
            <button style={{ width: '4rem', height: '2rem' }} onClick={onMobxIncrease}>
                Mobx증가
            </button>
            <button style={{ width: '4rem', height: '2rem' }} onClick={onMobxDecrease}>
                Mobx감소
            </button>

            <div>
                {process.env.STATE_2}의 number값: {reduxNumber}
            </div>
            <button style={{ width: '4rem', height: '2rem' }} onClick={onReduxIncrease}>
                Redux증가
            </button>
            <button style={{ width: '4rem', height: '2rem' }} onClick={onReduxDecrease}>
                Redux감소
            </button>
        </>
    ));

    ...
    ```

## PWA 적용하기
* 필수 패키지 설치
npm install next-pwa
* /next.config.js 수정
    ```
    // eslint-disable-next-line @typescript-eslint/no-var-requires
    const withPWA = require('next-pwa');

    module.exports = withPWA({
        ...

        pwa: {
            dest: 'public',
        },

        ...
    });
    ```
* /static/manifest.json 생성 및 내용 입력
    ```
    {
        "name": "PWA App",
        "short_name": "App",
        "icons": [
        {
            "src": "/static/icons/android-chrome-192x192.png",
            "sizes": "192x192",
            "type": "image/png"
        },
        {
            "src": "/static/icons/android-chrome-384x384.png",
            "sizes": "384x384",
            "type": "image/png"
        },
        {
            "src": "/static/icons/icon-512x512.png",
            "sizes": "512x512",
            "type": "image/png"
        }
        ],
        "theme_color": "#FFFFFF",
        "background_color": "#FFFFFF",
        "start_url": "/",
        "display": "standalone",
        "orientation": "portrait"
    }
    ```
* /static/icons에 manifest.json의 icons에 등록된 파일 사이즈대로 집어넣기
* /pages/_document.tsx 파일 생성 및 내용 입력
    ```
    import * as React from 'react';
    import Document, { Html, Head, Main, NextScript } from 'next/document';

    class MyDocument extends Document {
        render(): JSX.Element {
            return (
                <Html>
                    <Head>
                        <meta name="application-name" content="PWA App" />
                        <meta name="apple-mobile-web-app-capable" content="yes" />
                        <meta name="apple-mobile-web-app-status-bar-style" content="default" />
                        <meta name="apple-mobile-web-app-title" content="PWA App" />
                        <meta name="description" content="Best PWA App in the world" />
                        <meta name="format-detection" content="telephone=no" />
                        <meta name="mobile-web-app-capable" content="yes" />
                        <meta name="msapplication-config" content="/static/icons/browserconfig.xml" />
                        <meta name="msapplication-TileColor" content="#2B5797" />
                        <meta name="msapplication-tap-highlight" content="no" />
                        <meta name="theme-color" content="#000000" />

                        <link rel="apple-touch-icon" sizes="180x180" href="/static/icons/apple-touch-icon.png" />
                        <link rel="icon" type="image/png" sizes="32x32" href="/static/icons/favicon-32x32.png" />
                        <link rel="icon" type="image/png" sizes="16x16" href="/static/icons/favicon-16x16.png" />
                        <link rel="manifest" href="/static/manifest.json" />
                        <link rel="mask-icon" href="/static/icons/safari-pinned-tab.svg" color="#5bbad5" />
                        <link rel="shortcut icon" href="/static/icons/favicon.ico" />
                        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" />

                        <meta name="twitter:card" content="summary" />
                        <meta name="twitter:url" content="https://yourdomain.com" />
                        <meta name="twitter:title" content="PWA App" />
                        <meta name="twitter:description" content="Best PWA App in the world" />
                        <meta
                            name="twitter:image"
                            content="https://yourdomain.com/static/icons/android-chrome-192x192.png"
                        />
                        <meta name="twitter:creator" content="@DavidWShadow" />
                        <meta property="og:type" content="website" />
                        <meta property="og:title" content="PWA App" />
                        <meta property="og:description" content="Best PWA App in the world" />
                        <meta property="og:site_name" content="PWA App" />
                        <meta property="og:url" content="https://yourdomain.com" />
                        <meta property="og:image" content="https://yourdomain.com/static/icons/apple-touch-icon.png" />
                    </Head>
                    <body>
                        <Main />
                        <NextScript />
                    </body>
                </Html>
            );
        }
    }

    export default MyDocument;
    ```
* next run build / next run start 실행 후 웹페이지에서 +버튼을 이용하여 다운로드