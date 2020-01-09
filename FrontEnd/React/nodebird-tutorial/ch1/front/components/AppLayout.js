import React from 'react';
import Link from 'next/link';
import PropTypes from 'prop-types';
import {Menu, Input, Button, Row, Col} from 'antd';

const AppLayout = ({children}) => {
    return (
        <div>
            <Menu mode="horizontal">
                <Menu.Item key="home"><Link href="/"><a>노드버드</a></Link></Menu.Item>
                <Menu.Item key="profile"><Link href="/profile"><a>프로필</a></Link></Menu.Item>
                <Menu.Item key="mail">
                    <Input.Search enterButton style={{verticalAlign: 'middle'}} />
                </Menu.Item>
            </Menu>
            <Link href="/signup"><a><Button>회원가입</Button></a></Link>
            <Row>
                <Col xs={24} md={6}>첫번째</Col>
                <Col xs={24} md={12}>두번째</Col>
                <Col xs={24} md={6}>세번째</Col>
            </Row>
            {children}
        </div>
    );
};
// xs: 모바일, sm: 작은화면, md: 중간화면, lg: 큰화면, 가로 전체는 24

AppLayout.propTypes = {
    children: PropTypes.node,
};

export default AppLayout;