1. npm init (package.json 생성) --> 노드 프로젝트에 대한 정보를 담고 있음
--> package name: video_chat --> 입력
    version: (1.0.0)
    description: video chat visual  --> 입력
    entry point: (index.js)
    test command:
    git repository:
    keywords:
    author: KSC --> 입력
    license: (ISC)

2. npm install react react-dom --> react 사용을 위한 모듈 설치

3. root폴더에 public 폴더 생성 후 index.html 생성 후 입력
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

4. root폴더에 src/components 폴더 생성 후 App.jsx 생성 후 입력
    ```
    import React from 'react';

const App = () => {
    return <div>hello world!</div>
}

export default App;
    ```

5. src폴더에 index.jsx 생성 후 입력
    ```
    import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';

ReactDOM.render(<App />, document.querySelector("#root"));
    ```


6. npm i -D @babel/core @babel/preset-env @babel/preset-react babel-loader --> 바벨에 필요한 모듈 설치
    @babel/core : 바벨을 사용하기 위한 필수 모듈
    @babel/preset-env : 바벨에서 스크립트 코드를 트랜스 파일링 하기 위한 플러그인들을 모아둔 모듈
    @babel/preset-react : 바벨에서 리액트 코드를 트랜스 파일링 하기 위한 플러그인들을 모아둔 모듈
    babel-loader : 웹팩을 돌릴 시에 바벨을 적용하기 위한 모듈

7. root폴더에 babel.config.js 파일 생성 후 입력
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

8. npm i -D webpack webpack-cli html-webpack-plugin --> webpack에 필요한 모듈 설치
    webpack : 웹팩 모듈
    webpack-cli : 웹팩 명령어를 커맨드 라인에서 실행할 때 필요한 모듈
    html-webpack-plugin : 웹팩 실행이 완료된 번들 파일을 붙인 html 파일을 만들어 주는 모듈

9. root폴더에 webpack.config.js 파일 생성 후 입력
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
        exclude: /node_modules/
      }
    ]
  },

  output: {
    path: path.resolve(__dirname, "dist"),
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

entry: 파일들을 묶기 위해 Webpack이 바라보는 파일 시작점
output: bundle된 파일의 결과물을 위한 설정
mode: production or development
resolve: import 될 수 있는 파일 확장자 명


10. package.json에 설정 추가 --> npm start할 시 서버 오픈
    ```
      "scripts": {
    "start": "webpack"
  },
    ```

11. npm i -D webpack-dev-server --> 변경사항이 있을 때 마다 자동으로 webpack을 수정해주는 역할, npm start할 시 자동으로 페이지 로드 수행

12. package.json에 설정 추가
    ```
     "scripts": {
    "start": "webpack-dev-server --open"
  },
    ```

13. webpack.config.js 설정 추가
    ```
    devServer: {
    contentBase: path.join(__dirname, "dist"), // 이 경로에 있는 파일이 변경될 때 번들을 다시 컴파일
    compress: true,
    port: 8888
  },
    ```