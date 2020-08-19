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
  entry point: {시작 지점} ex) (index.js)
  test command: 
  git repository:
  keywords:
  author: {제작자} ex) KSC
  license: {라이센스} ex) (ISC)
  ```
* react 사용을 위한 모듈 설치
  ```
  npm install react react-dom
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
* root폴더에 src 폴더 생성 후 App.js 생성
* App.js에 내용 입력
  ```
  import React from 'react';

  const App = () => {
      return <div>hello world!</div>
  }

  export default App;
  ```
* src폴더에 index.js 생성
* index.js에 내용 입력
  ```
  import React from 'react';
  import ReactDOM from 'react-dom';
  import App from './App';

  ReactDOM.render(<App />, document.querySelector("#root"));
  ```
* 바벨에 필요한 모듈 설치 : 브라우저가 이해할 수 있는 자바스크립트의 최신 문법으로 변환 (ES5 -> ES6)
  ```
  npm i -D @babel/core @babel/preset-env @babel/preset-react babel-loader
  ```
  * @babel/core : 바벨을 사용하기 위한 필수 모듈
  * @babel/preset-env : 바벨에서 스크립트 코드를 트랜스 파일링 하기 위한 플러그인들을 모아둔 모듈
  * @babel/preset-react : 바벨에서 리액트 코드를 트랜스 파일링 하기 위한 플러그인들을 모아둔 모듈
  * babel-loader : 웹팩을 돌릴 시에 바벨을 적용하기 위한 모듈
* root폴더에 babel.config.js 파일 생성
* babel.config.js에 내용 입력
  ```
  module.exports = function(api) {
    api.cache(true);
    
    const presets = ["@babel/preset-env", "@babel/preset-react"];
    
    const plugins = [];
    
    return {
      presets,
      plugins
    };
  };
  ```
* 웹팩에 필요한 모듈 설치 : 모든 리액트 관련 파일들을 브라우저에서 이용할 수 있는 하나의 번들로 묶어 패킹하는 모듈 번들러
  ```
  npm i -D webpack webpack-cli html-webpack-plugin
  ```
  * webpack : 웹팩 모듈 (모든 리액트 파일을 하나의 컴파일된 자바스크립트 파일로 생성)
  * webpack-cli : 웹팩 명령어를 커맨드 라인에서 실행할 때 필요한 모듈
  * html-webpack-plugin : 웹팩 실행이 완료된 번들 파일을 붙인 html 파일을 만들어 주는 모듈
* root폴더에 webpack.config.js 파일 생성
* webpack.config.js에 내용 입력
  ```
  const path = require("path");
  const HtmlWebpackPlugin = require("html-webpack-plugin");

  module.exports = {
    mode: "development",

    entry: "./src/index",

    resolve: {
      extensions: [".js", ".jsx"]
    },

    module: {
      rules: [
        {
          test: /\.jsx?$/,
          loader: "babel-loader",
          exclude: ['/node_modules/']
        }
      ]
    },

    output: {
      path: path.resolve(__dirname, "dist"), // __dirname : 현재 디렉토리
      filename: "bundle.js",
      publicPath: '/', // 새로고침을 할 시 페이지 유지
    },

    plugins: [
      new HtmlWebpackPlugin({
        // index.html에 output에서 만들어진 bundle.js를 적용하여, dist에 새로운 html 파일 생성
        template: `./public/index.html`
      })
    ]
  };
  ```
  * path : core nodejs 모듈 중 하나로 파일 경로 설정할 때 사용
  * html-webpack-plugin : index.html 파일을 dist폴더에 bundle 파일과 함께 자동으로 생성
  * mode : production or development
  * entry : 파일들을 묶기 위해 웹팩이 바라보는 파일 시작점
  * resolve : 웹팩이 자동으로 경로나 확장자를 처리할 수 있게 도와주는 옵션
  * output: bundle된 파일의 결과물을 위한 설정
* 웹팩에 필요한 모듈 추가 설치
  ```
  npm i -D webpack-dev-server
  ```
  * webpack-dev-server : 변경사항이 있을 때 마다 자동으로 webpack을 수정해주는 역할, npm start할 시 자동으로 페이지 로드 수행
* package.json에 설정 추가
  ```
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "webpack-dev-server --open" // 추가
  },
  ```
* webpack.config.js 설정 추가
  ```
  devServer: {
    historyApiFallback: true, // 새로고침을 할 시 페이지 유지
    contentBase: path.join(__dirname, "dist"), // 이 경로에 있는 파일이 변경될 때 번들을 다시 컴파일
    compress: true,
    port: {port명} ex) 8888
  },
  ```
# ESLint, Prettier 적용하기
## ESLint 설정
* ESLint를 위한 필수 패키지 설치
  ```
  yarn add --dev eslint eslint-config-airbnb eslint-plugin-import eslint-plugin-jsx-a11y eslint-plugin-react
  ```
* root폴더에 .eslintrc 파일 생성
* .eslintrc에 내용 입력
  ```
  {
    "env": {
      "browser": true,
      "es6": true
    },
    "extends": ["airbnb", "prettier", "prettier/react"],
    "globals": {
      "Atomics": "readonly",
      "SharedArrayBuffer": "readonly"
    },
    "plugins": ["react", "prettier"],
    "rules": {
      "react/prop-types": 0,
      "no-underscore-dangle": 0,
      "import/imports-first": ["error", "absolute-first"],
      "import/no-extraneous-dependencies": [
        "error",
        {
          "devDependencies": true
        }
      ],
      "import/newline-after-import": "error",
      "import/prefer-default-export": 0,
      "react/prefer-stateless-function": 0,
      "react/jsx-filename-extension": 0,
      "react/jsx-one-expression-per-line": 0,
      "linebreak-style": 0,
      "no-unused-vars": 0,
      "camelcase": 0

      // error off : 0 , warning 1,
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
  yarn add --dev prettier eslint-config-prettier eslint-plugin-prettier babel-eslint
  ```
* 설정 창 오픈 (ctrl + ,)
* 오른쪽 상단에 3개 아이콘 중 맨 왼쪽 클릭 (파일모양)
* setting.json에 내용 입력
  ```
  {
    "[javascript]": {
        "editor.formatOnSave": true
    },
    "[javascriptreact]": {
        "editor.formatOnSave": true
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
  import React from 'react';
  import axios from '../api/axios';

  const signUp = () => {
      const userSignUp = () => {
          let user = {
              user_id: '123',
              user_pw: '456',
              user_nm: '789',
              user_gd: 'M',
              user_age: 30,
              user_ph: '010-1234-5678',
              user_ma: 'abc@d.com',
          };

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
      };

      return (
          <>
              <p>HELLO</p>
              <input type="button" value="signUp" onClick={userSignUp} />
          </>
      );
  };

  export default signUp;
  ```
# router 적용하기
## 기본설정
* router를 위한 필수 패키지 설치
  ```
  yarn add react-router react-router-dom
  ```
## 사용방법
* App.js 파일 수정
  ```
  import React from 'react';
  import { Redirect, Route } from 'react-router'; // Redirect: 페이지 Redirect, Route: path에 알맞은 component 등록
  import { BrowserRouter } from 'react-router-dom'; // Route 외부에 덮어져서 Browser 이동을 도움
  import SignIn from './pages/signIn';
  import SignUp from './pages/signUp';

  const App = () => {
      return (
          <>
              <BrowserRouter>
                  <Route exact path="/">
                      <Redirect to="/user/signIn" />
                  </Route>
                  <Route path="/user/signIn" component={SignIn} />
                  <Route path="/user/signUp" component={SignUp} />
              </BrowserRouter>
          </>
      );
  };

  export default App;
  ```
* Link 사용하기 (a태그와 유사)
  ```
  <Link to="/user/signUp">signUp</Link>
  ```
* useHistory 사용하기 (window.history와 유사)
  ```
  import React from 'react';
  import { useHistory } from 'react-router';

  const signIn = () => {
    const history = useHistory();

    const onSignUp = () => {
        history.push('/user/signUp');
    };

    return (
      <>
        <div>
            <input type="button" value="SignUp" onClick={onSignUp} />
        </div>
      </>
    )
  }

  export default signIn;
  ```
  
# redux 사용 방법
## 기본 설정
* redux devtools 크롬 확장자 설치
  * https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd?hl=ko
* redux에 필요한 모듈 설치
  ```
  yarn add redux react-redux@next redux-devtools-extension
  ```
* src에 modules폴더 생성
* src/modules/reducer에 index.js 파일 생성
* index.js에 내용 입력
  ```
  import { combineReducers } from 'redux';

  const rootReducer = combineReducers({
  });

  export default rootReducer;
  ```
* src/modules에 actions.js 파일 생성
* actions.js에 내용 입력
  ```
  const user_setUser = 'user_setUser';

  export const setUserAction = res => {
      return {
          type: user_setUser,
          payload: res,
      }
  }
  ```
* src/modules/reducer에 user.js 파일 생성
* user.js에 내용 입력
  ```
  import * as actions from '../actions';

  export const initState = {
    user: {},
  }

  const reducer = (state = initState, action) => {
      switch(action.type) {
          case actions.user_setUser: {
              return {
                  ...state,
                  user: action.payload,
              };
          }

          default: {
              return {
                  ...state,
              };
          }
      }
  }

  export default reducer;
  ```
* src/modules/reducer/index.js에 내용 추가
  ```
  import user from './user';

  const rootReducer = combineReducers({
      user,
  });
  ```
* src/modules에 store.js 파일 생성
* store.js에 내용 추가
  ```
  import { createStore } from 'redux';
  import { composeWithDevTools } from 'redux-devtools-extension';
  import rootReducer from './reducer';

  const store = createStore(rootReducer, composeWithDevTools());

  export default store; 
  ```
* src의 index.js파일 설정 추가
  ```
  import React from 'react';
  import ReactDOM from 'react-dom';
  import { Provider } from 'react-redux';
  import App from './App';
  import store from './modules/store';

  ReactDOM.render(
      <Provider store={store}>
          <App />
      </Provider>,
      document.querySelector('#root'),
  );
  ```
* src/pages폴더 생성
* src/pages폴더에 login.js파일 생성
* login.js에 내용 입력 (button을 클릭하면 redux에 데이터 저장 후 saveuser에 데이터 연동되어 이름 표시)
  ```
  import React from 'react';
  import { useDispatch, useSelector } from 'react-redux';
  import { setUserAction } from '../modules/actions';

  const login = () => {
      const dispatch = useDispatch(); // redux에 데이터를 전송하여 저장하는 역할 수행
      const saveuser = useSelector(state => state.user.user); // state.{rootReducer에 등록된 user파일}.{user파일의 initState의 user객체}의 값을 saveuser에 저장
      
      const setUser = () => {
          const user = {
              id: 'abc',
              name: 'person',
              phone: '010-1234-5678',
          }
          dispatch(setUserAction(user));
      }
      
      return (
          <div>
              <h1>Login 페이지 입니다.</h1>
              <input type="button" value="button" onClick={setUser}></input>
              <p>나의 이름은 {saveuser.name}</p>
          </div>
      )
  }

  export default login;
  ```
# react hook 사용 방법
* useState 사용 방법
  ```
  const [userId, setUserId] = useState('');

  const onUserId = (e) => {
    setUserId(e.target.value);
  };

  return (
    <div>
        <h1>SCVC Login</h1>
        <input type="text" onChange={onUserId} />
    </div>
  );
  ```
# react 전용 UI-Framework 사용하기
## Material-UI 사용하기 (진행하던 시즌 중 1위...)
* https://material-ui.com/ 에 접속하면 관련 정보를 얻을 수 있음
* material 패키지 설치하기
  ```
  yarn add @material-ui/core
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
* src/modules/saga index.js 파일 생성
* index.js에 내용 입력
  ```
  import { all } from 'redux-saga/effects';

  function* rootSaga() {
      yield all();
  }

  export default rootSaga;

  ```
* src/modules/saga user.js 파일 생성
* user.js에 내용 입력
  ```
  import * as actions from '../actions';
  import axios from '../../api/axios';

  const saga = [];

  export default saga;
  ```
* src/modules/store.js 내용 변경
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
  * saga가 해당 type을 가로채어 데이터 처리 후(userSelectByUserIdSaga) saga가 기다리지 않는 type에 put(actions.setUserAction(res.data.data))
  * reducer가 해당 type에 반응하여 데이터를 저장(actions.userSetUser)
* src/modules/action.js에 내용 추가
  ```
  // Saga
  export const userSelectByUserId = 'userSelectByUserId';

  export const userSelectByUserIdAction = (res) => {
      return {
          type: userSelectByUserId,
          payload: res,
      };
  };
  ```
* src/modules/reducer/user.js에 내용 추가
  ```
  import * as actions from '../actions';

  const initState = {
      user: '',
  };

  const reducer = (state = initState, action) => {
      switch (action.type) {
          // Saga
          case actions.userSelectByUserId: {
              return {
                  ...state,
                  payload: action.payload,
              };
          }

          // Not Saga
          case actions.userSetUser: {
              return {
                  ...state,
                  user: action.payload,
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
* src/modules/saga/user.js에 내용 추가
  ```
  import { takeEvery, put, call } from 'redux-saga/effects';
  import * as actions from '../actions';
  import axios from '../../api/axios';

  function* userSelectByUserIdSaga(action) {
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
              yield put(actions.setUserAction(res.data.data));
              localStorage.userToken = res.headers['jwt-user-token']; // jwt-user-token으로 response온 값을 localStorage에 저장
              alert('로그인 성공');
          }
      } catch (e) {
          alert(e);
      }
  }
  const saga = [
      takeEvery(actions.userSelectByUserId, userSelectByUserIdSaga),
  ];

  export default saga;
  ```
* 로그인 페이지에서 로그인 버튼을 누를 때 함수
  ```
  const onSignIn = () => {
      dispatch(userSelectByUserIdAction({ userId, userPw }));
  };
  ```