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
## 기본 설정
* root 폴더 생성 후 terminal에 해당 폴더까지 들어가기
* package.json 생성 : 노드 프로젝트에 대한 정보를 담음
  ```npm init```
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
  ```npm install react react-dom```
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
  ```npm i -D @babel/core @babel/preset-env @babel/preset-react babel-loader```
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
  ```npm i -D webpack webpack-cli html-webpack-plugin```
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
      filename: "bundle.js"
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
  * mode : production or development
  * entry : 파일들을 묶기 위해 웹팩이 바라보는 파일 시작점
  * resolve : 웹팩이 자동으로 경로나 확장자를 처리할 수 있게 도와주는 옵션
  * html-webpack-plugin : index.html 파일을 dist폴더에 bundle 파일과 함께 자동으로 생성
  * output: bundle된 파일의 결과물을 위한 설정
* 웹팩에 필요한 모듈 추가 설치
  ```npm i -D webpack-dev-server```
  * webpack-dev-server : 변경사항이 있을 때 마다 자동으로 webpack을 수정해주는 역할, npm start할 시 자동으로 페이지 로드 수행
* package.json에 설정 추가
  ```
  "scripts": {
  "start": "webpack-dev-server --open"
  }
  ```
* webpack.config.js 설정 추가
  ```
  devServer: {
  contentBase: path.join(__dirname, "dist"), // 이 경로에 있는 파일이 변경될 때 번들을 다시 컴파일
  compress: true,
  port: {port명} ex) 8888
  },
  ```
# redux 사용 방법
## 기본 설정
* redux devtools 크롬 확장자 설치
  * https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd?hl=ko
* redux에 필요한 모듈 설치
  ```yarn add redux react-redux@next redux-devtools-extension```
* src에 modules폴더 생성
* src/modules에 index.js 파일 생성
* index.js에 내용 입력
  ```
  import { combineReducers } from 'redux';

  const rootReducer = combineReducers({
  });

  export default rootReducer;
  ```
* src/modules에 user.js 파일 생성
* user.js에 내용 입력
  ```
  export const initState = {
    user: {},
  }

  const user_setUser = 'user_setUser';

  export const setUserAction = res => {
      return {
          type: user_setUser,
          payload: res,
      }
  }

  const reducer = (state = initState, action) => {
      switch(action.type) {
          case user_setUser: {
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
* src/modules에 내용 추가
  ```
  import user from './user';

  const rootReducer = combineReducers({
      user,
  });
  ```
* src의 index.js파일 설정 추가
  ```
  import {createStore} from 'redux';
  import {composeWithDevTools} from 'redux-devtools-extension';
  import rootReducer from './modules';
  import {Provider} from 'react-redux';

  const store = createStore(rootReducer, composeWithDevTools());

  ReactDOM.render(
      <Provider store={store}>
          <App />
      </Provider>, 
      document.querySelector("#root")
  );
  ```
* src/pages폴더 생성
* src/pages폴더에 login.js파일 생성
* login.js에 내용 입력 (button을 클릭하면 redux에 데이터 저장 후 saveuser에 데이터 연동되어 이름 표시)
  ```
  import React from 'react';
  import { useDispatch, useSelector } from 'react-redux';
  import { setUserAction } from '../modules/user';

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