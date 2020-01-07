import React, { useCallback } from 'react';
import {useSelector, useDispatch} from 'react-redux';
import Counter from '../components/Counter';

const CounterContainer = () => {
    const counter = useSelector(state => state.counter, []);
    const dispatch = useDispatch();

    const onIncrease = useCallback(
        () => dispatch({type: "counter/INCREMENT"}),
        [dispatch]
    );

    const onDecrease = useCallback(
        () => dispatch({type: "counter/DECREMENT"}),
        [dispatch]
    );

    return (
        <Counter number={counter} onIncrease={onIncrease} onDecrease={onDecrease}></Counter>
    );
}

export default CounterContainer;