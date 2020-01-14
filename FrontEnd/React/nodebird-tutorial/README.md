1. npm init => author: ZeroCho, license: MIT
2. npm install react react-dom next
3. npm install -D nodemon webpack
4. npm install -D eslint
5. 폴더에 .eslintrc 생성
6. .eslintrc 작성 다하면 npm i eslint-plugin-import eslint-plugin-react eslint-plugin-react-hooks
7. npm install -g next
8. npm install antd

# proptypes설치
 * npm install prop-types

# 기본구성
 ### _document.js => html, head, body
 ### _app.js => root
 ### pages => 실제 컴포넌트
 ### _error.js => 에러가 발생할 때 (배포하기 전에는 굳이 커스터마이징 할 필요가 없음)

# redux 설치
 * npm install redux react-redux
 * npm install react-redux@next

# next에서 redux 사용할 때
 * npm install next-redux-wrapper