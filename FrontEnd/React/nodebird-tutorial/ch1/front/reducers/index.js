import {combineReducers} from 'redux';
import user from './user';
import post from './post';

const rootReducer = combineReducers({ // initialstate, reducer 합쳐줌
    user,
    post,
});

export default rootReducer;