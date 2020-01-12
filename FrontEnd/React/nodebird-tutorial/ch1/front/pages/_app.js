import React from 'react';
import AppLayout from '../components/AppLayout';
import PropTypes from 'prop-types';
import {Provider} from 'react-redux'; // Provider가 redux state를 제공
import {createStore} from 'redux';
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
    const store = createStore(reducer, initialState);
    // 여기에 store 커스터마이징
    return store;
})(NodeBird);

//export default NodeBird;