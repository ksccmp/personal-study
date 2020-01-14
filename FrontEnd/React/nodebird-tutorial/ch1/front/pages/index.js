import React, { useEffect } from 'react';
import PostForm from '../components/PostForm';
import PostCard from '../components/PostCard';
import {useDispatch, useSelector} from 'react-redux';
import {LOG_IN, LOG_OUT, loginAction, logoutAction} from '../reducers/user';

const Home = () => {
    // const dispatch = useDispatch(); // setState가 바뀌었다고 생각
    const {user, isLoggedIn} = useSelector(state => state.user); // useState가 바뀌었다고 생각
    // const isLoggedIn = useSelector(state => state.user.uisLoggedIn); // 잘게 쪼개기 가능
    const {mainPosts} = useSelector(state => state.post);
    
    return (
        <>
            <div>
                {isLoggedIn && <PostForm />}
                {mainPosts.map((c) => {
                    return (
                        <PostCard key={c} post={c}/>
                    );
                })}
            </div>
        </>
    );
};

export default Home;