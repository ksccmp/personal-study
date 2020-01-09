import React from 'react';
import AppLayout from '../components/AppLayout';
import PropTypes from 'prop-types';

// layout은 _app.js에서 코딩한다.
const NodeBird = ({Component}) => {
    return (
        <>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/antd/3.25.3/antd.css" />

            <AppLayout>
                <Component />
            </AppLayout>
        </>
    );
};

NodeBird.propTypes = {
    Component: PropTypes.elementType, // node는 렌더링 되는 모든 것, 배열 숫자 등등 선택해서도 가능
};

export default NodeBird;