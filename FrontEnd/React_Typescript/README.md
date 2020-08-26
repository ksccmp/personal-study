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
      "target": "es5",                          /* Specify ECMAScript target version: 'ES3' (default), 'ES5', 'ES2015', 'ES2016', 'ES2017', 'ES2018', 'ES2019', 'ES2020', or 'ESNEXT'. */
      "module": "commonjs",                     /* Specify module code generation: 'none', 'commonjs', 'amd', 'system', 'umd', 'es2015', 'es2020', or 'ESNext'. */
      "lib": ["ES2015", "ES2016", "ES2017", "ES2018", "ES2019", "ES2020", "DOM"],                             /* Specify library files to be included in the compilation. */
      "allowJs": true,                       /* Allow javascript files to be compiled. */
      "jsx": "react",                     /* Specify JSX code generation: 'preserve', 'react-native', or 'react'. */
      "outDir": "./dist",                        /* Redirect output structure to the directory. */

      /* Strict Type-Checking Options */
      "strict": true,                           /* Enable all strict type-checking options. */
      "noImplicitAny": true,                 /* Raise error on expressions and declarations with an implied 'any' type. */
      "noImplicitThis": true,                /* Raise error on 'this' expressions with an implied 'any' type. */

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
* history 사용하기
  * RouteComponentProps를 제네릭으로 등록하여 사용하고 싶은 것을 prop에 history 가져오기
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
* match 사용하기
  * RouteComponentProps를 제네릭으로 등록하고 params로 가져와야 되는 interface를 생성하여 제네릭을 추가 등록한 뒤 prop에 match 가져오기
  * Route를 다음과 같이 등록
    ```
    <Route path="/socket/chat/:roomId" component={Chat} />
    ```
  * 예시
    ```
    import * as React from 'react';

    interface ImatchParams {
        roomId: string;
    }

    const chat: React.FC<RouteComponentProps<ImatchParams>> = ({ match }) => {
        React.useEffect(() => {
            console.log(match.params.roomId);
        }, []);

        return (
          <>
            <div>
              match Test
            </div>
          </>
        )
    }
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

  export interface IuserSetUserAction {
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
                  user: (action as actions.IuserSetUserAction).payload,
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
                  payload: (action as actions.IuserSelectByUserIdAction).payload,
              };
          }

          // Not Saga
          case actions.userSetUser:
              return {
                  ...state,
                  user: (action as actions.IuserSetUserAction).payload,
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

  function* userSelectByUserIdSaga(action: actions.IuserSelectByUserIdAction) {
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
* TextField 사용법
  ```
  const setUserNmAction = (e: React.ChangeEvent<HTMLInputElement>) => {
        dispatchSignUp({
            type: setUserNm,
            payload: e.target.value,
        });
    };

  <TextField id="standard-basic" label="이름" onChange={setUserNmAction} />
  ```
* Select / MenuItem 사용법 (localReducer는 위의 useReducer 참고)
  ```
  const setUserGdAction = (
      e: React.ChangeEvent<{
          name?: string | undefined;
          value: unknown;
      }>,
  ) => {
      dispatchSignUp({
          type: setUserGd,
          payload: e.target.value as string,
      });
  };

  <Select
      labelId="demo-simple-select-label"
      id="demo-simple-select"
      value={localReducer.userGd}
      onChange={setUserGdAction}
  >
      <MenuItem value="M">남자</MenuItem>
      <MenuItem value="W">여자</MenuItem>
  </Select>
  ```
# socket-io 사용하기
## 채팅서버 생성 (새로운 폴더 생성하여 툴 새로 접속)
* package.json 생성
  ```
  npm init
  ```
* 내용 입력
  ```
  package name: {패키지 명} ex) socket
  version: {버전} ex) (1.0.0)
  description: {세부 설명} ex) socket for video chat
  entry point: {시작 지점} ex) (index.tsx)
  test command: 
  git repository:
  keywords:
  author: {제작자} ex) KSC
  license: {라이센스} ex) MIT
  ```
* 필수 모듈 설치
  ```
  yarn add express socket
  ```
* root에 index.js 생성 및 입력
  ```
  const app = require('express')();
  const server = require('http').createServer(app);
  const port = 4000;
  const socketIO = require('socket.io')(server);

  server.listen(port, () => {
      console.log('채팅 서버 실행!');
  });

  socketIO.on('connection', (socket) => {
      console.log('user connected');

      socket.on('send message', (msg) => {
          console.log(msg);
          socketIO.to(msg.roomId).emit('receive message', msg);
      });

      socket.on('join room', (msg) => {
          console.log(msg);
          socket.join(msg);
      });

      socket.on('disconnect', (msg) => {
          console.log('user disconnect');
          console.log(msg);
          console.log(socket.id);
      });
  });
  ```
* 서버 실행
  ```
  node index.js
  ```
## 클라이언트와 서버 연결하기
* 필수 모듈 설치
  ```
  yarn add socket.io-client @types/socket.io-client
  ```
* 채팅리스트를 위한 reducer 설정
  * src/api/interface.tsx에 추가
    ```
    export interface Ichat {
      roomId: string;
      userId: string;
      type: string;
      contents: string;
      rgstTm: string;
    }
    ```
  * src/modules/actions.tsx에 추가
    ```
    export const socketSetChatList: string = 'socketSetChatList';
    export const socketResetChatList: string = 'socketResetChatList';

    export interface IsocketSetChatList {
        type: typeof socketSetChatList;
        payload: Ichat;
    }

    export interface IsocketResetChatList {
        type: typeof socketResetChatList;
    }

    export const socketSetChatListAction = (res: Ichat): IsocketSetChatList => {
        return {
            type: socketSetChatList,
            payload: res,
        };
    };

    export const socketResetChatListAction = (): IsocketResetChatList => {
        return {
            type: socketResetChatList,
        };
    };

    export type reducerAction =
    ...
    | IsocketSetChatList
    | IsocketResetChatList;
    ```
  * src/modules/reducer/socket.tsx 생성 및 입력
    ```
    import * as actions from '../actions';
    import { Ichat } from '../../api/interface';

    export interface IinitSocketState {
        chatList: Ichat[];
    }

    const initSocketState: IinitSocketState = {
        chatList: [],
    };

    const reducer = (state = initSocketState, action: actions.reducerAction) => {
        switch (action.type) {
            case actions.socketSetChatList: {
                let newChatList: Ichat[] = state.chatList.slice();
                newChatList.push((action as actions.IsocketSetChatList).payload);
                return {
                    ...state,
                    chatList: newChatList,
                };
            }

            case actions.socketResetChatList: {
                return {
                    ...state,
                    chatList: initSocketState.chatList,
                };
            }

            default: {
                return {
                    ...state,
                };
            }
        }
    };

    export default reducer;
    ```
  * src/modules/reducer/index.tsx 내용 수정
    ```
    import { combineReducers } from 'redux';
    import user from './user';
    import { IinitUserState } from './user';
    import { IinitSocketState } from './socket'; -- 추가
    import socket from './socket'; -- 추가

    export interface reducerState {
        user: IinitUserState;
        socket: IinitSocketState; -- 추가
    }

    const rootReducer = combineReducers({
        user,
        socket, -- 추가
    });

    export default rootReducer;
    ```
* socket을 사용할 파일 생성 및 입력
  ```
  import * as React from 'react';
  import { useDispatch, useSelector } from 'react-redux';
  import { reducerState } from '../modules/reducer/index';
  import { Iuser, Ichat } from '../api/interface';
  import { userLogoutAction, socketSetChatListAction, socketResetChatListAction } from '../modules/actions';
  import { Typography, Button, TextField } from '@material-ui/core';
  import SocketIO from 'socket.io-client';

  const main = () => {
      const dispatch = useDispatch();

      const [text, setText] = React.useState<string>('');
      const [socket, setSocket] = React.useState<SocketIOClient.Socket>();
      const [roomId, setRoomId] = React.useState<string>('');

      const reduxUser: Iuser = useSelector((state: reducerState) => state.user.user);
      const reduxChatList: Ichat[] = useSelector((state: reducerState) => state.socket.chatList);

      React.useEffect(() => {
          dispatch(socketResetChatListAction());
      }, []);

      const First = () => {
          Close();
          setRoomId('1');
          Open('1');
      };

      const Second = () => {
          Close();
          setRoomId('2');
          Open('2');
      };

      const Open = (openroom: string) => {
          if (reduxUser.userId != '' && reduxUser.userId.length > 0) {
              const connect: SocketIOClient.Socket = SocketIO.connect('http://localhost:4000');
              setSocket(connect);
              dispatch(socketResetChatListAction());

              connect.emit('join room', openroom);

              connect.emit('send message', {
                  roomId: openroom,
                  userId: reduxUser.userId,
                  type: 'alert',
                  contents: reduxUser.userId + '님이 입장하셨습니다',
                  rgstTm: '2020/08/07',
              });

              connect.on('receive message', (msg: Ichat) => {
                  console.log(msg);
                  dispatch(socketSetChatListAction(msg));
              });
          }
      };

      const Close = () => {
          const sc: SocketIOClient.Socket = socket as SocketIOClient.Socket;
          if (sc) {
              sc.disconnect();
          }
      };

      const Send = () => {
          if (text.length > 0) {
              const sc: SocketIOClient.Socket = socket as SocketIOClient.Socket;
              sc.emit('send message', {
                  roomId: roomId,
                  userId: reduxUser.userId,
                  type: 'chat',
                  contents: text,
                  rgstTm: '2020/08/07',
              });
              setText('');
          }
      };

      const EnterSend = (e: React.KeyboardEvent) => {
          if (e.key === 'Enter') {
              Send();
          }
      };

      const onText = (e: React.ChangeEvent<HTMLInputElement>) => {
          setText(e.target.value);
      };

      return (
          <>
              <div>
                  <Typography variant="h5">{reduxUser.userNm}님 안녕하세요. Main Page 입니다~</Typography> <br />
                  <Button variant="contained" color="secondary" onClick={First}>
                      1번방 참여
                  </Button>
                  <Button variant="contained" color="secondary" onClick={Second}>
                      2번방 참여
                  </Button>
                  <Button variant="contained" color="secondary" onClick={Send}>
                      Send
                  </Button>
                  <Button variant="contained" color="secondary" onClick={Close}>
                      Close
                  </Button>
                  <TextField
                      id="standard-basic"
                      label="대화"
                      value={text}
                      onChange={onText}
                      onKeyPress={EnterSend}
                      required
                  />
                  {reduxChatList.map((chat, index) => (
                      <Typography variant="h5" key={index}>
                          {chat.type === 'alert' ? chat.contents : chat.userId + ' : ' + chat.contents}
                      </Typography>
                  ))}
              </div>
          </>
      );
  };

  export default main;
  ```
# RTCPeerConnection 사용하기
## 기본개념
* ICECandidate
    ```
    ICE는 Interactive Connectivity Establishment의 약어로 두 단말이 서로 통신할 수 있는 최적의 경로를 찾도록 도와줌
    Candidate는 두 단말이 통신 가능한 모든 주소들로 Candidate를 서로 연결하여 통신을 수행함
    ```
* STUN Server
    ```
    클라이언트 자신이 사용하는 공인 IP주소를 제공해주는 역할로써 클라이언트는 자신의 공인 IP가 무엇인지 모르기 때문에
    STUN Server에 요청하여 NAT뒤에 잇는 공인IP주소를 가져와 외부와 통신할 수 있도록 도와줌
    (사설 주소와 공인주소를 바인딩)
    ```
* TURN Server
    ```
    NAT환경에 단말이 릴레이 서버를 이용하여 통신하게 해주는 것으로 STUN Server에 문제가 생겼을 때
    통화를 하는 피어들과 직접 통신하지 않고 릴레이 서버 역할을 하는 TURN 서버를 경유하여 통신하게 도와줌
    (릴레이 주소를 할당)
    ```
* 구현 동작방식 (이해한 선에서...)
    ```
    1. pc1 (local PC) / pc2 (Remote PC)를 stun / turn서버를 등록하여 생성
    2. pc1에서 getUserMedia를 통해 stream을 생성한 뒤 각각의 track들(video, audio ...)을 pc1에 추가
    3. track들을 받은 pc1은 통신할 준비가 되었다고 판단하여 onnegotiationneeded 동작
    4. pc1이 offer를 생성하여 LocalDescription에 저장한 뒤 소켓서버에 LocalDescription 전달
    5. offer를 저장한 pc1은 onicecandidate가 동작하여 모든 candidate를 생성하여 pc1에 등록
    6. pc1의 description을 받은 pc2는 RemoteDescription에 pc2의 description을 저장
    7. pc1의 description을 저장하여 track들을 확인한 pc2는 ontrack이 동작하여 videoList에 저장
    8. RemoteDescription에 pc1의 description을 저장 후 answer를 생성한 뒤 LocalDescription에 저장, 이후 소켓서버에 LocalDescription에 전달
    9. answer를 저장한 pc2은 onicecandidate가 동작하여 모든 candidate를 생성하여 pc2에 등록
    10. pc2의 description을 받은 pc1은 RemoteDescription에 pc1의 description을 저장
    11. 통신 완료
    ```
## 구현
### socket서버
* 위에 생성한 socket 서버의 index.js에 내용 추가
    ```
    ...

    socketIO.on('connection', (socket) => {
        
        ...

        socket.on('videoTest', (msg) => {
            socketIO.to(msg.roomId).emit('receiveTest', msg);
        });
    }
    ```
### reducer 등록
* src/modules/actions.tsx에 내용 추가
    ```
    export const socketSetVideoList: string = 'socketSetVideoList';
    export const socketResetVideoList: string = 'socketResetVideoList';

    export interface IsocketSetVideoListAction {
        type: typeof socketSetVideoList;
        payload: MediaStream;
    }

    export interface IsocketResetVideoListAction {
        type: typeof socketResetVideoList;
    }

    export const socketSetVideoListAction = (res: MediaStream): IsocketSetVideoListAction => {
        return {
            type: socketSetVideoList,
            payload: res,
        };
    };

    export const socketResetVideoListAction = (): IsocketResetVideoListAction => {
        return {
            type: socketResetVideoList,
        };
    };

    export type reducerAction =
        ...
        | IsocketSetVideoListAction
        | IsocketResetVideoListAction;
    ```
* src/modules/reducer/socket.tsx에 내용 추가
    ```
    import * as actions from '../actions';
    import { Ichat } from '../../api/interface';

    export interface IinitSocketState {
        ...
        videoList: MediaStream[];
    }

    const initSocketState: IinitSocketState = {
        ...
        videoList: [],
    };

    const reducer = (state = initSocketState, action: actions.reducerAction) => {
        switch (action.type) {
            ...

            case actions.socketSetVideoList: {
                let newVideoList: MediaStream[] = state.videoList.slice();
                newVideoList.push((action as actions.IsocketSetVideoListAction).payload);
                return {
                    ...state,
                    videoList: newVideoList,
                };
            }

            case actions.socketResetVideoList: {
                return {
                    ...state,
                    videoList: initSocketState.videoList,
                };
            }

            ...
        }
    };

    export default reducer;
    ```
### interface 작성
* src/api/interface.tsx에 내용 추가
    ```
    ...

    export interface Ivideochat {
        type: string;
        sdp?: RTCSessionDescription;
        candidate?: RTCIceCandidate;
        roomId: string;
    }
    ```
### component 작성
* src/components/socket/video.tsx 파일 생성 및 작성
    ```
    import * as React from 'react';

    interface Ivideo {
        stream: MediaStream;
    }

    const video = ({ stream }: Ivideo) => {
        const [videoData, setVideoData] = React.useState<HTMLMediaElement | undefined>(undefined);

        React.useEffect(() => {
            if (videoData) {
                (videoData as HTMLMediaElement).srcObject = stream;
            }
        }, [videoData]);

        return (
            <>
                <div>
                    <video ref={(node: HTMLVideoElement) => setVideoData(node)} width="480px" autoPlay={true}></video>
                </div>
            </>
        );
    };

    export default video;
    ```
### Page 작성
* src/pages/socket/socketMain.tsx 파일 생성 및 작성
    ```
    import * as React from 'react';
    import { useDispatch, useSelector } from 'react-redux';
    import SocketIO from 'socket.io-client';
    import { RouteComponentProps } from 'react-router';
    import Video from '../../components/socket/video';
    import { Ivideochat } from '../../api/interface';
    import { reducerState } from '../../modules/reducer';
    import { socketResetVideoListAction, socketSetVideoListAction } from '../../modules/actions';

    interface ImatchParams {
        roomId: string;
        userId: string;
    }

    const socketMain: React.FC<RouteComponentProps<ImatchParams>> = ({ match }) => {
        const dispatch = useDispatch();

        const [socket, setSocket] = React.useState<SocketIOClient.Socket | undefined>(undefined);

        const videoList: MediaStream[] = useSelector((state: reducerState) => state.socket.videoList);

        const pcConfig = {
            iceServers: [
                {
                    urls: 'stun:stun.l.google.com:19302',
                },
                { urls: 'turn:numb.viagenie.ca', credential: 'muazkh', username: 'webrtc@live.com' },
            ],
        };

        React.useEffect(() => {
            Close();
            dispatch(socketResetVideoListAction());
            const connect: SocketIOClient.Socket = SocketIO.connect('http://localhost:4000');
            connect.id = match.params.userId;
            setSocket(connect);

            const handleVideoOfferMsg = (msg: Ivideochat) => {
                const desc = new RTCSessionDescription(msg.sdp);
                pc2.setRemoteDescription(desc)
                    .then(() => {
                        return pc2.createAnswer();
                    })
                    .then((answer) => {
                        return pc2.setLocalDescription(answer);
                    })
                    .then(() => {
                        connect.emit('videoTest', {
                            type: 'video-answer',
                            sdp: pc2.localDescription,
                            roomId: match.params.roomId,
                        });
                    });
            };

            const handleVideoAnswerMsg = (msg: Ivideochat) => {
                const desc = new RTCSessionDescription(msg.sdp);
                pc1.setRemoteDescription(desc);
            };

            connect.on('receiveTest', (msg: Ivideochat) => {
                if (msg.type === 'video-offer') {
                    handleVideoOfferMsg(msg);
                } else if (msg.type === 'video-answer') {
                    handleVideoAnswerMsg(msg);
                }
            });

            const pc1negotiationneeded = () => {
                console.log('pc1negotiationneeded');
                pc1.createOffer()
                    .then((offer) => {
                        return pc1.setLocalDescription(offer);
                    })
                    .then(() => {
                        connect.emit('videoTest', {
                            type: 'video-offer',
                            sdp: pc1.localDescription,
                            roomId: match.params.roomId,
                        });
                    })
                    .catch((e) => {
                        console.log(e);
                    });
            };

            const pc1icecandidate = (event: RTCPeerConnectionIceEvent) => {
                if (event.candidate) {
                    const candidate = new RTCIceCandidate(event.candidate);
                    pc1.addIceCandidate(candidate).catch((e) => {
                        console.log(e);
                    });
                }
            };

            const pc2icecandidate = (event: RTCPeerConnectionIceEvent) => {
                if (event.candidate) {
                    const candidate = new RTCIceCandidate(event.candidate);
                    pc2.addIceCandidate(candidate).catch((e) => {
                        console.log(e);
                    });
                }
            };

            const pc2track = (event: RTCTrackEvent) => {
                if (event.track.kind == 'video') {
                    dispatch(socketSetVideoListAction(event.streams[0]));
                }
            };

            const pc1: RTCPeerConnection = new RTCPeerConnection(pcConfig);
            const pc2: RTCPeerConnection = new RTCPeerConnection(pcConfig);

            pc1.onicecandidate = pc1icecandidate;
            pc1.onnegotiationneeded = pc1negotiationneeded;
            pc2.onicecandidate = pc2icecandidate;
            pc2.ontrack = pc2track;

            navigator.mediaDevices.getUserMedia({ video: true, audio: true }).then((pc1stream) => {
                dispatch(socketSetVideoListAction(pc1stream));
                pc1stream.getTracks().forEach((track) => {
                    pc1.addTrack(track, pc1stream);
                });
            });
        }, []);

        const Close = () => {
            const sc: SocketIOClient.Socket = socket as SocketIOClient.Socket;
            if (sc) {
                sc.disconnect();
            }
        };

        return (
            <>
                <div>{videoList ? videoList.map((video, index) => <Video stream={video} key={index} />) : ''}</div>
            </>
        );
    };

    export default socketMain;
    ```
# 같은 네트워크 상에서 다른 PC로 접근하기
* package.json 수정
    ```
    "scripts": {
        "test": "echo \"Error: no test specified\" && exit 1",
        "start": "webpack-dev-server --open --host 0.0.0.0" // 추가
    },
    ```