import React, {useCallback} from 'react';
import {useSelector, useDispatch} from 'react-redux';
import TodoList from '../components/TodoList';

let id = 0;

const TodoListContainer = () => {
    const {input, todos} = useSelector(state => state.todos, []);
    const dispatch = useDispatch();

    const onChange = e => onChangeInput(e.target.value);

    const onChangeInput = useCallback(
        value => dispatch({type: "todos/CHANGE_INPUT", payload: value}),
        [dispatch]
    )

    const onSubmit = useCallback(
        e => {
            e.preventDefault();
            console.log("onSubmit : ", input);
            dispatch({type: "todos/INSERT", payload: {id: ++id, text: input}});
            onChangeInput('');
        },
        [dispatch, input, onChangeInput]
    );

    const onToggle = useCallback(
        id => dispatch({type: "todos/TOGGLE_CHECK", payload: id}),
        [dispatch]
    );

    const onRemove = useCallback(
        id => dispatch({type: "todos/REMOVE", payload: id}),
        [dispatch]
    );

    return(
        <TodoList input={input} todos={todos} onChange={onChange} onSubmit={onSubmit} onToggle={onToggle} onRemove={onRemove}></TodoList>
    );
}

export default TodoListContainer;