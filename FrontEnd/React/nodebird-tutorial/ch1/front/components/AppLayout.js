import React, { useState } from 'react';
import Link from 'next/link';
import PropTypes from 'prop-types';
import LoginForm from './LoginForm';
import {Menu, Input, Button, Row, Col, Card, Avatar, Form} from 'antd';

const dummy = {
    nickname: '제로초',
    Post: [],
    Followings: [],
    Followers: [],
    isLoggedIn: true,
}

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
            <Row gutter={8}>
                <Col xs={24} md={6}>
                    {dummy.isLoggedIn ?
                        <Card 
                            actions={[
                                <div key="twit">짹짹<br />{dummy.Post.length}</div>,
                                <div key="following">팔로잉<br />{dummy.Followings.length}</div>,
                                <div key="follower">팔로워<br />{dummy.Followers.length}</div>,
                            ]}
                        >
                            <Card.Meta avatar={<Avatar>{dummy.nickname[0]}</Avatar>} title={dummy.nickname}></Card.Meta>
                        </Card>
                        :
                        <LoginForm />
                    }
                </Col>
                <Col xs={24} md={12}>
                    {children}
                </Col>
                <Col xs={24} md={6}>세번째
                </Col>
            </Row>
        </div>
    );
};
// xs: 모바일, sm: 작은화면, md: 중간화면, lg: 큰화면, 가로 전체는 24

AppLayout.propTypes = {
    children: PropTypes.node,
};

export default AppLayout;