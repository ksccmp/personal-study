# CRA(Create React App)을 사용하지 않고 환경 설정
## 기본 설치
* Node.js 설치
  * https://nodejs.org/ko/ 로 접속 or 검색창에 Node.js 검색
* yarn 설치
  * VS Code 상단바에 있는 Terminal을 눌러 New Terminal or 키보드로 ctrl + shift + ` 입력
  * terminal에서 npm install -g yarn 입력
## Extension 설정
* ES7 React/Redux/GraphQL/React-Native snippets : 자주 사용하는 snippet들을 단축키로 간단히 생성
* Bracket Pair Colorizer : 여는 대괄호와 닫는 대괄호를 같은 색으로 표시
* Auto Rename Tag : 마크업 앞 혹은 뒤를 수정하면 그에 대응하는 마크업으로 자동 수정
* Prettier - Code formatter : 선호하는 포맷에 따라 커스터마이징하여 사용
* Live Server : 로컬 개발 서버를 생성
## 기본 설정
* root 폴더 생성 후 terminal에 해당 폴더까지 들어가기
* package.json 생성 : 노드 프로젝트에 대한 정보를 담음
  ```
  npm init
  ```
* 내용 입력
  ```
  package name: {패키지 명} ex) video_chat
  version: {버전} ex) (1.0.0)
  description: {세부 설명} ex) video chat visual
  entry point: {시작 지점} ex) (index.tsx)
  test command: 
  git repository:
  keywords:
  author: {제작자} ex) KSC
  license: {라이센스} ex) (ISC)
  ```
* react/typescript 사용을 위한 모듈 설치
  ```
  yarn add react react-dom @types/react @types/react-dom typescript ts-node
  ```
* root폴더에 public 폴더 생성 후 index.html 생성
* index.html에 내용 입력
  ```
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta http-equiv="X-UA-Compatible" content="ie=edge" />
      <title>Document</title>
    </head>
    <body>
      <div id="root"></div>
    </body>
  </html>
  ```
* root폴더에 src 폴더 생성 후 App.ts 생성
* App.tsx에 내용 입력
  ```
  import React from 'react';

  const App: React.FC = () => {
      return <div>hello world!</div>
  }

  export default App;
  ```
* src폴더에 index.tsx 생성
* index.tsx에 내용 입력
  ```
  import React from 'react';
  import ReactDOM from 'react-dom';
  import App from './App';

  ReactDOM.render(<App />, document.querySelector("#root"));
  ```
* tsconfig.json 생성 : tsc를 실행하면 자동으로 찾아서 변환해주는 환경 설정
  ```
  npx typescript --init
  ```
* 주석 해제 및 변경 내역
  ```
  {
    "compilerOptions": {
      /* Visit https://aka.ms/tsconfig.json to read more about this file */

      /* Basic Options */
      "target": "es6",                          /* Specify ECMAScript target version: 'ES3' (default), 'ES5', 'ES2015', 'ES2016', 'ES2017', 'ES2018', 'ES2019', 'ES2020', or 'ESNEXT'. */
      "module": "commonjs",                     /* Specify module code generation: 'none', 'commonjs', 'amd', 'system', 'umd', 'es2015', 'es2020', or 'ESNext'. */
      "lib": ["ES2015", "ES2016", "ES2017", "ES2018", "ES2019", "ES2020", "DOM"],                             /* Specify library files to be included in the compilation. */
      "allowJs": true,                       /* Allow javascript files to be compiled. */
      "jsx": "react",                     /* Specify JSX code generation: 'preserve', 'react-native', or 'react'. */
      "outDir": "./dist",                        /* Redirect output structure to the directory. */

      /* Strict Type-Checking Options */
      "strict": true,                           /* Enable all strict type-checking options. */
      "noImplicitAny": true,                 /* Raise error on expressions and declarations with an implied 'any' type. */

      /* Module Resolution Options */
      "moduleResolution": "node",            /* Specify module resolution strategy: 'node' (Node.js) or 'classic' (TypeScript pre-1.6). */
      "esModuleInterop": true,                  /* Enables emit interoperability between CommonJS and ES Modules via creation of namespace objects for all imports. Implies 'allowSyntheticDefaultImports'. */
      "skipLibCheck": true,                     /* Skip type checking of declaration files. */
      "forceConsistentCasingInFileNames": true  /* Disallow inconsistently-cased references to the same file. */
    },
    "exclude": ["node_modules"],
    "include": ["./src/**/*"]
  }
  ```
* 바벨에 필요한 모듈 설치 : 브라우저가 이해할 수 있는 자바스크립트의 최신 문법으로 변환 (ES5 -> ES6)
  ```
  yarn add babel-loader @babel/core @babel/preset-env @babel/preset-react @babel/preset-typescript
  ```
  * @babel/core : 바벨을 사용하기 위한 필수 모듈
  * @babel/preset-env : 바벨에서 스크립트 코드를 트랜스 파일링 하기 위한 플러그인들을 모아둔 모듈
  * @babel/preset-react : 바벨에서 리액트 코드를 트랜스 파일링 하기 위한 플러그인들을 모아둔 모듈
  * babel-loader : 웹팩을 돌릴 시에 바벨을 적용하기 위한 모듈
  * @babel/preset-typescript : 
* root폴더에 babel.config.js 파일 생성
* babel.config.js에 내용 입력
  ```
  module.exports = function (api) {
      api.cache(true);

      const presets = [
          [
              '@babel/preset-env',
              {
                  targets: {
                      node: true,
                  },
              },
          ],
          '@babel/preset-react',
          '@babel/preset-typescript',
      ];

      const plugins = [];

      return {
          presets,
          plugins,
      };
  };
  ```
* 웹팩에 필요한 모듈 설치 : 모든 리액트 관련 파일들을 브라우저에서 이용할 수 있는 하나의 번들로 묶어 패킹하는 모듈 번들러
  ```
  yarn add webpack webpack-cli webpack-dev-server html-webpack-plugin ts-loader
  ```
  * webpack : 웹팩 모듈 (모든 리액트 파일을 하나의 컴파일된 자바스크립트 파일로 생성)
  * webpack-cli : 웹팩 명령어를 커맨드 라인에서 실행할 때 필요한 모듈
  * html-webpack-plugin : 웹팩 실행이 완료된 번들 파일을 붙인 html 파일을 만들어 주는 모듈
  * ts-loader
* root폴더에 webpack.config.js 파일 생성
* webpack.config.js에 내용 입력
  ```
  const path = require('path');
  const HtmlWebpackPlugin = require('html-webpack-plugin');

  module.exports = {
      mode: 'development',

      entry: './src/index',

      resolve: {
          extensions: ['.js', '.jsx', '.ts', '.tsx'],
      },

      module: {
          rules: [
              {
                  test: /\.tsx?$/,
                  loader: ['babel-loader', 'ts-loader'], // 오른쪽에서 왼쪽 방향으로 적용되기 때문에 ts-loader가 오른쪽에 위치
                  exclude: ['/node_modules/'],
              },
          ],
      },

      output: {
          path: path.resolve(__dirname, 'dist'),
          filename: 'bundle.js',
          publicPath: '/', // 새로고침을 할 시 페이지 유지
      },

      devServer: {
          historyApiFallback: true, // 새로고침을 할 시 페이지 유지
          contentBase: path.join(__dirname, 'dist'), // 이 경로에 있는 파일이 변경될 때 번들을 다시 컴파일
          compress: true,
          port: 8888,
      },

      plugins: [
          new HtmlWebpackPlugin({
              // index.html에 output에서 만들어진 bundle.js를 적용하여, dist에 새로운 html 파일 생성
              template: `./public/index.html`,
          }),
      ],
  };
  ```
  * path : core nodejs 모듈 중 하나로 파일 경로 설정할 때 사용
  * html-webpack-plugin : index.html 파일을 dist폴더에 bundle 파일과 함께 자동으로 생성
  * mode : production or development
  * entry : 파일들을 묶기 위해 웹팩이 바라보는 파일 시작점
  * resolve : 웹팩이 자동으로 경로나 확장자를 처리할 수 있게 도와주는 옵션
  * output: bundle된 파일의 결과물을 위한 설정
  * webpack-dev-server : 변경사항이 있을 때 마다 자동으로 webpack을 수정해주는 역할, npm start할 시 자동으로 페이지 로드 수행
* package.json에 설정 추가
  ```
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "webpack-dev-server --open" // 추가
  },
  ```
# ESLint, Prettier 적용하기
## ESLint 설정
* TSLint를 사용하지 않고 ESLint를 사용하는 이유
  ```
  2019년에 TSLint 팀은 더이상 TSLint를 지원하지 않기로 결정했습니다.
  그 이유는 ESLint가 존재하기 때문에 동일한 의도의 목적으로 프로젝트간에 많은 중복코드가 있었기 때문입니다. TSLint 팀은 ESLint의 마이그레이션을 지원하고 ESLint의 Typescript 지원을 개선 하는데 집중한다고 밝혔습니다. 다만, TSLint를 새로운 컴파일러 버전 및 기능과 호환성을 보장하도록 지원은 할 예정이라고 합니다.
  ```
* ESLint를 위한 필수 패키지 설치
  ```
  yarn add --dev eslint eslint-config-airbnb eslint-plugin-import @typescript-eslint/eslint-plugin @typescript-eslint/parser
  ```
* root폴더에 .eslintrc 파일 생성
* .eslintrc에 내용 입력
  ```
  {
    "env": {
      "browser": true,
      "es6": true
    },
    "extends": ["airbnb", "'plugin:react/recommended", "plugin:prettier/recommended"],
    "globals": {
      "Atomics": "readonly",
      "SharedArrayBuffer": "readonly"
    },
    "parser": "@typescript-eslint/parser",
    "parserOptions": {
        "ecmaFeatures": {
            "jsx": true
        },
        "ecmaVersion": 2018,
        "sourceType": "module"
    },
    "settings": {
        "import/resolver": {
			"node": {
				"paths": ["src"],
				"extensions": [".d.ts", ".ts", ".tsx"]
			}
		}
    },
    "plugins": ["react", "@typescript-eslint"],
    "rules": {
      "react/jsx-filename-extension": [1, {"extensions": [".tsx"]}],
      "import/extensions": [
          "error",
          "ignorePackages", {"js": "never", "jsx": "never", "ts": "never", "tsx": "never", "json": "never"}
      ],
      "react/jsx-indent": [2, "tab"],
      "react/jsx-indent-props": [2, "tab"]
    }
  }
  ```
* 설정 창 오픈 (ctrl + ,)
* 오른쪽 상단에 3개 아이콘 중 맨 왼쪽 클릭 (파일모양)
* setting.json에 내용 입력
  ```
  "editor.codeActionsOnSave": {
      "source.fixAll.eslint": true,
  },
  ```
  * editor.codeActionsOnSave : 저장할 때 속성값 수행
  * source.fixAll.eslint : ESLint에 정해진 대로 코드 자동 수정
## Prettier 설정
* Prettier를 위한 필수 패키지 설치
  ```
  yarn add --dev prettier eslint-config-prettier eslint-plugin-prettier
  ```
* 설정 창 오픈 (ctrl + ,)
* 오른쪽 상단에 3개 아이콘 중 맨 왼쪽 클릭 (파일모양)
* setting.json에 내용 입력
  ```
  {
    "[typescript]": {
        "editor.formatOnSave": true
    },
    "[typescriptreact]": {
        "editor.formatOnSave": true
    },
    "editor.codeActionsOnSave": {
        "source.fixAll.eslint": true,
    },
    "prettier.singleQuote": true,
    "prettier.semi": true,
    "prettier.tabWidth": 4,
    "prettier.trailingComma": "all",
    "prettier.printWidth": 120,
    "prettier.arrowParens": "always"
  }
  ```
  * singleQuote : 문자열에 싱글쿼트(') 사용
  * semi : 코드 끝에 세미클론(;) 사용
  * tabWidth : 들여쓰기 4칸
  * trailingComma : 객체나 배열 작성할 때 값 맨 뒤에거에도 쉼표(,) 사용
  * printWidth : 한 줄에 120칸 까지 작성
  * arrowParens : 화살표 함수 매개변수 하나인건 괄호 사용 안함 (const test = variable => {})
# Axios 적용하기
## 기본 설정
* axios 설치하기
  ```
  yarn add axios
  ```
## baseURL 등록하기
* src/api에 axios.js 파일 생성
* axios.js에 내용 입력
  ```
  import axios from 'axios';

  const axiosAPI = axios.create({
      baseURL: 'http://localhost:8080/videochat', // axios 사용할 때 path앞에 baseURL이 항상 추가
  });

  export default axiosAPI;
  ```
## 사용방법
* 회원가입 예제
  ```
  import axios from '../api/axios';

  axios
      .post('/user/insert', user)
      .then((res) => {
          if (res.data.data == 1) {
              console.log('회원가입 성공!');
          }
      })
      .catch((e) => {
          console.log(e);
      });
  ```
# router 적용하기
## 기본설정
* router를 위한 필수 패키지 설치
  ```
  yarn add react-router react-router-dom @types/react-router @types/react-router-dom
  ```
## 사용방법
* App.tsx 파일 수정
  ```
  import React from 'react';
  import { BrowserRouter, Route, Redirect, Switch } from 'react-router-dom';
  import SignIn from './pages/signIn';
  import SignUp from './pages/signUp';

  const App: React.FC = () => {
      return (
          <BrowserRouter>
              <Switch>
                <Route path="/user/signIn" component={SignIn} />
                <Route path="/user/signUp" component={SignUp} />
                <Redirect to="/user/signIn" />
            </Switch>
          </BrowserRouter>
      );
  };

  export default App;
  ```  
* Link 사용하기 (a태그와 유사)
  ```
  <Link to="/user/signUp">signUp</Link>
  ```
* history / location / match 사용하기
  * RouteComponentProps를 제네릭으로 등록하여 사용하고 싶은 것을 prop에 가져오기
  * withRouter로 export default값 덮어주기 (외부에 BrowseRouter가 덮여 있어야 됨)
  * App.tsx에 적용할 거기 때문에 위의 조건 때문에 BrowseRouter를 index.tsx로 이동
  * index.tsx
    ```
    import React from 'react';
    import ReactDOM from 'react-dom';
    import App from './App';
    import { BrowserRouter } from 'react-router-dom';

    ReactDOM.render(
        <BrowserRouter>
            <App />
        </BrowserRouter>,
        document.querySelector('#root'),
    );
    ```
  * App.tsx
    ```
    import React from 'react';
    import { Route, Redirect, Switch, RouteComponentProps, withRouter } from 'react-router-dom';
    import SignIn from './pages/signIn';
    import SignUp from './pages/signUp';

    const App: React.FC<RouteComponentProps> = ({ history }) => {
        const testClick = () => {
            history.push('/user/signUp');
        };
        return (
            <>
                <Switch>
                    <Route path="/user/signIn" component={SignIn} />
                    <Route path="/user/signUp" component={SignUp} />
                    <Redirect to="/user/signIn" />
                </Switch>
                <input type="button" value="test" onClick={testClick}></input>
            </>
        );
    };

    export default withRouter(App);
    ```
# redux 사용 방법
## 기본 설정
* redux devtools 크롬 확장자 설치
  * https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd?hl=ko
* redux에 필요한 모듈 설치
  ```
  yarn add redux react-redux redux-devtools-extension @types/react-redux
  ```
* src/modules/reducer에 index.tsx 파일 생성
* index.tsx에 내용 입력
  ```
  import { combineReducers } from 'redux';

  export interface reducerState {
    
  }

  const rootReducer = combineReducers({
      
  });

  export default rootReducer;
  ```
* src/api에 interface.tsx 파일 생성
* interface.tsx에 내용 입력
  ```
  export interface IuserAuth {
      userId: string;
      userPw: string;
  }

  export interface Iuser extends IuserAuth {
      userNm: string;
      userGd: string;
      userAge: number;
      userPh: string;
      userMa: string;
      rgstTm: string;
      updtTm: string;
  }
  ```
* src/modules에 actions.tsx 파일 생성
* actions.tsx에 내용 입력
  ```
  import { Iuser } from '../api/interface';

  export const userSetUser: string = 'userSetUser';

  interface IuserSetUserAction {
      type: typeof userSetUser;
      payload: Iuser;
  }

  export const userSetUserAction = (res: Iuser): IuserSetUserAction => {
      return {
          type: userSetUser,
          payload: res,
      };
  };

  export type reducerAction = IuserSetUserAction;
  ```
* src/modules/reducer에 user.tsx 파일 생성
* user.tsx에 내용 입력
  ```
  import * as actions from '../actions';
  import { Iuser } from '../../api/interface';

  export interface IinitUserState {
      user: Iuser;
  }

  const initUserState: IinitUserState = {
      user: {
          userId: '',
          userPw: '',
          userNm: '',
          userGd: '',
          userAge: 0,
          userPh: '',
          userMa: '',
          rgstTm: '',
          updtTm: '',
      },
  };

  const reducer = (state: IinitUserState = initUserState, action: actions.reducerAction) => {
      switch (action.type) {
          case actions.userSetUser:
              return {
                  ...state,
                  user: action.payload,
              };

          default:
              return {
                  ...state,
              };
      }
  };

  export default reducer;
  ```
* src/modules/reducer/index.tsx에 내용 추가
  ```
  import { combineReducers } from 'redux';
  import user from './user'; // 추가
  import { IinitUserState } from './user'; // 추기

  export interface reducerState {
      user: IinitUserState; // 추가
  }

  const rootReducer = combineReducers({
      user, // 추가
  });

  export default rootReducer;
  ```
* src/modules에 store.tsx 파일 생성
* store.tsx에 내용 입력
  ```
  import { createStore } from 'redux';
  import { composeWithDevTools } from 'redux-devtools-extension';
  import rootReducer from './reducer';

  const store = createStore(rootReducer, composeWithDevTools());

  export default store; 
  ```
* src의 index.tsx파일 설정 추가
  ```
  import React from 'react';
  import ReactDOM from 'react-dom';
  import App from './App';
  import { BrowserRouter } from 'react-router-dom';
  import store from './modules/store'; // 추가
  import { Provider } from 'react-redux'; // 추기

  ReactDOM.render(
      <Provider store={store}> // 추가
          <BrowserRouter>
              <App />
          </BrowserRouter>
      </Provider>, // 추가
      document.querySelector('#root'),
  );
  ```
* src/pages폴더에 signIn.tsx파일 생성
* signIn.tsx에 내용 입력 (button을 클릭하면 redux에 데이터 저장 후 user에 데이터 연동되어 이름 표시)
  ```
  import React from 'react';
  import { useDispatch, useSelector } from 'react-redux';
  import { Iuser } from '../api/interface';
  import { userSetUserAction } from '../modules/actions';
  import { reducerState } from '../modules/reducer';

  const signIn = () => {
      const dispatch = useDispatch();
      const user: Iuser = useSelector((state: reducerState) => state.user.user);

      const testClick = () => {
          const setUser: Iuser = {
              userId: 'userId',
              userPw: 'userPw',
              userNm: 'userNm',
              userGd: 'userGd',
              userAge: 0,
              userPh: 'userPh',
              userMa: 'userMa',
              rgstTm: 'rgstTm',
              updtTm: 'updtTm',
          };

          dispatch(userSetUserAction(setUser));
      };

      return (
          <div>
              <p>SignIn 페이지입니다.</p>
              <input type="button" value="로그인" onClick={testClick}></input>
              {user.userNm}
          </div>
      );
  };

  export default signIn;
  ```
# react hook 사용 방법
* useState 사용 방법 (text에 값을 입력하면 입력된 값이 표출되는 코드)
  ```
  import React, { useState } from 'react';

  const signUp = () => {
      const [userId, setUserId] = useState<string>('');

      const onUserId = (e: React.ChangeEvent<HTMLInputElement>) => {
          setUserId(e.target.value);
      };

      return (
          <div>
              <p>SignUp 페이지입니다.</p>
              <input type="text" onChange={onUserId}></input>
              {userId}
          </div>
      );
  };

  export default signUp;
  ```
* useReducer 사용 방법 (useState와 동일한 경우)
  ```
  import React, { useState, useReducer } from 'react';

  const signUp = () => {
      interface IinitState {
          userId: string;
          userPw: string;
          userNm: string;
          userGd: string;
          userAge: number;
          userPh: string;
          userMa: string;
          rgstTm: string;
          updtTm: string;
      }

      type Iaction = { type: typeof setUserId; payload: string };

      const setUserId: string = 'setUserId';

      const initState: IinitState = {
          userId: '',
          userPw: '',
          userNm: '',
          userGd: '',
          userAge: 0,
          userPh: '',
          userMa: '',
          rgstTm: '',
          updtTm: '',
      };

      const setUserIdAction = (e: React.ChangeEvent<HTMLInputElement>) => {
          dispatchSignUp({
              type: setUserId,
              payload: e.target.value,
          });
      };

      const signUpReducer = (state: IinitState, action: Iaction) => {
          switch (action.type) {
              case setUserId: {
                  return {
                      ...state,
                      userId: action.payload,
                  };
              }

              default: {
                  return {
                      ...state,
                  };
              }
          }
      };

      const [localReducer, dispatchSignUp] = useReducer(signUpReducer, initState);

      return (
          <div>
              <p>SignUp 페이지입니다.</p>
              <input type="text" onChange={setUserIdAction}></input>
              {localReducer.userId}
          </div>
      );
  };

  export default signUp;
  ```
# redux-saga 사용하기
## 기본 설정
* 필수 패키지 설치
  ```
  yarn add redux-saga
  ```
* babel.config.js 내용 추가 // async, await 사용 위함
  ```
  module.exports = function (api) {
      api.cache(true);

      // preset-env에 targets 추가
      const presets = [
          [
              '@babel/preset-env',
              {
                  targets: {
                      node: true,
                  },
              },
          ],
          '@babel/preset-react',
      ];

      const plugins = [];

      return {
          presets,
          plugins,
      };
  };
  ```
* src/modules/saga index.tsx 파일 생성
* index.tsx에 내용 입력
  ```
  import { all } from 'redux-saga/effects';

  function* rootSaga() {
      yield all([]);
  }

  export default rootSaga;
  ```
* src/modules/saga user.tsx 파일 생성
* user.tsx에 내용 입력
  ```
  import * as actions from '../actions';
  import axios from '../../api/axios';

  const saga = [];

  export default saga;
  ```
* src/modules/store.tsx 내용 변경
  ```
  import { createStore, applyMiddleware } from 'redux'; // applyMiddleware 추가
  import { composeWithDevTools } from 'redux-devtools-extension';
  import createSagaMiddleware from 'redux-saga'; // 추가
  import rootReducer from './reducer';
  import rootSaga from './saga'; // 추가

  const sagaMiddleware = createSagaMiddleware(); // 추가
  const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(sagaMiddleware))); // DevTools 괄혼안에 applyMiddleware(sagaMiddleware) 추가

  sagaMiddleware.run(rootSaga); // 추가

  export default store;
  ```
## 예시 (로그인을 할 때 saga를 이용하여 비동기 처리하기)
* 처리되는 로직
  * saga가 반응하길 기다리고 있는(takeEvery) type을 dispatch(userSelectByUserIdAction)
  * reducer에서 해당 type에 반응(actions.userSelectByUserId)
  * saga가 해당 type을 가로채어 데이터 처리 후(userSelectByUserIdSaga) saga가 기다리지 않는 type에 put(actions.userSetUserAction(res.data.data))
  * reducer가 해당 type에 반응하여 데이터를 저장(actions.userSetUser)
* src/modules/action.tsx에 내용 추가
  ```
  import { Iuser, IuserAuth } from '../api/interface';

  // Saga
  export const userSelectByUserId: string = 'userSelectByUserId';

  // Not Saga
  export const userSetUser: string = 'userSetUser';

  // Saga
  interface IuserSelectByUserIdAction {
      type: typeof userSelectByUserId;
      payload: IuserAuth;
  }

  // Not Saga
  interface IuserSetUserAction {
      type: typeof userSetUser;
      payload: Iuser;
  }

  // Saga
  export const userSelectByUserIdAction = (res: IuserAuth): IuserSelectByUserIdAction => {
      return {
          type: userSelectByUserId,
          payload: res,
      };
  };

  // Not Saga
  export const userSetUserAction = (res: Iuser): IuserSetUserAction => {
      return {
          type: userSetUser,
          payload: res,
      };
  };

  export type reducerAction = IuserSelectByUserIdAction | IuserSetUserAction;
  ```
* src/modules/reducer/user.tsx에 내용 추가
  ```
  import * as actions from '../actions';
  import { Iuser } from '../../api/interface';

  export interface IinitUserState {
      user: Iuser;
  }

  const initUserState: IinitUserState = {
      user: {
          userId: '',
          userPw: '',
          userNm: '',
          userGd: '',
          userAge: 0,
          userPh: '',
          userMa: '',
          rgstTm: '',
          updtTm: '',
      },
  };

  const reducer = (state: IinitUserState = initUserState, action: actions.reducerAction) => {
      switch (action.type) {
          // Saga
          case actions.userSelectByUserId: {
              return {
                  ...state,
                  payload: action.payload,
              };
          }

          // Not Saga
          case actions.userSetUser:
              return {
                  ...state,
                  user: action.payload,
              };

          default:
              return {
                  ...state,
              };
      }
  };

  export default reducer;
  ```
* src/modules/saga/user.tsx에 내용 추가
  ```
  import { put, call, takeEvery } from 'redux-saga/effects';
  import * as actions from '../actions';
  import axios from '../../api/axios';

  function* userSelectByUserIdSaga(action: actions.reducerAction) {
      try {
          const res = yield call([axios, 'get'], '/user/selectByUserId', {
              params: {
                  userId: action.payload.userId,
                  userPw: action.payload.userPw,
              },
          });

          if (res.data.data === 0) {
              alert('로그인 실패');
          } else {
              yield put(actions.userSetUserAction(res.data.data));
              alert('로그인 성공');
          }
      } catch (e) {
          alert(e);
      }
  }

  const saga = [takeEvery(actions.userSelectByUserId, userSelectByUserIdSaga)];

  export default saga;
  ```
* src/pages폴더에 signIn.tsx파일 내용 추가 (사가테스트 클릭 시 axios를 통해 가져온 데이터를 화면에 표시)
  ```
  import React from 'react';
  import { useDispatch, useSelector } from 'react-redux';
  import { Iuser, IuserAuth } from '../api/interface';
  import { userSetUserAction, userSelectByUserIdAction } from '../modules/actions';
  import { reducerState } from '../modules/reducer';

  const signIn = () => {
      const dispatch = useDispatch();
      const user: Iuser = useSelector((state: reducerState) => state.user.user);

      const testClick = () => {
          const setUser: Iuser = {
              userId: 'userId',
              userPw: 'userPw',
              userNm: 'userNm',
              userGd: 'userGd',
              userAge: 0,
              userPh: 'userPh',
              userMa: 'userMa',
              rgstTm: 'rgstTm',
              updtTm: 'updtTm',
          };

          dispatch(userSetUserAction(setUser));
      };

      const sagaTest = () => {
          const testUser: IuserAuth = {
              userId: 'asd',
              userPw: 'asd',
          };
          dispatch(userSelectByUserIdAction(testUser));
      };

      return (
          <div>
              <p>SignIn 페이지입니다.</p>
              <input type="button" value="로그인" onClick={testClick}></input>
              <input type="button" value="사가테스트" onClick={sagaTest}></input>
              {user.userNm}
          </div>
      );
  };

  export default signIn;
  ```









# react 전용 UI-Framework 사용하기
## Material-UI 사용하기 (진행하던 시즌 중 1위...)
* https://material-ui.com/ 에 접속하면 관련 정보를 얻을 수 있음
* material 패키지 설치하기
  ```
  yarn add @material-ui/core
  ```