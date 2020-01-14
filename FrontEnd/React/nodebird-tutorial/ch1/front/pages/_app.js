import React from 'react';
import AppLayout from '../components/AppLayout';
import PropTypes from 'prop-types';
import {Provider} from 'react-redux'; // Provider가 redux state를 제공
import {createStore, compose, applyMiddleware} from 'redux';
import withRedux from 'next-redux-wrapper';
import reducer from '../reducers';

// layout은 _app.js에서 코딩한다.
const NodeBird = ({Component, store}) => {
    return (
        <Provider store={store}>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/antd/3.25.3/antd.css" />

            <AppLayout>
                <Component />
            </AppLayout>
        </Provider>
    );
};

NodeBird.propTypes = {
    Component: PropTypes.elementType, // node는 렌더링 되는 모든 것, 배열 숫자 등등 선택해서도 가능
    store: PropTypes.object,
};

export default withRedux((initialState, options) => {
    // 여기에 store 커스터마이징
    const middlewares = []; // 미들웨어는 액션과 스토어 사이에서 동작
    const enhancer = compose(applyMiddleware(...middlewares), 
    !options.isServer && window.__REDUX_DEVTOOLS_EXTENSION__ !== 'undefined' ? window.__REDUX_DEVTOOLS_EXTENSION__() : (f) => f,);

    const store = createStore(reducer, initialState, enhancer);
    return store;
})(NodeBird);

//export default NodeBird;