import React, {useState, useCallback, memo} from 'react';
import {Form, Input, Checkbox, Button} from 'antd';
import PropTypes from 'prop-types';
import { signUpAction } from '../reducers/user';
import {useDispatch} from 'react-redux';

// 타이핑 칠 때마다 최적화 해주는 방법 (페이스북도 사용 잘 안함)
// const TextInput = memo(({value, onChange}) => {
//     return (
//         <Input name="user-id" value={value} required onChange={onChange}></Input>
//     );
// });

// 커스텀 훅 (반복을 제거 가능)
export const useInput = (initValue = null) => {
    const [value, setter] = useState(initValue);
    const handler = (e) => {
        setter(e.target.value);

    };
    return [value, handler];
};
// const [id, onChangeId] = useInput('');

const TextInput = ({value}) => {
    return (
        <div>{value}</div>
    );
};

TextInput.propTypes = {
    value: PropTypes.string,
};

const Signup = () => {
    const [id, setId] = useState('');
    const [nick, setNick] = useState('');
    const [password, setPassword] = useState('');
    const [passwordCheck, setPasswordCheck] = useState('');
    const [term, setTerm] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [termError, setTermError] = useState(false);
    const dispatch = useDispatch();

    const onSubmit = useCallback((e) => {
        e.preventDefault();
        if(password !== passwordCheck) {
            return setPasswordError(true);
        }
        if(!term) {
            return setTermError(true);
        }
        dispatch(signUpAction({
            id,
            password,
            nick,
        }));
    }, [password, passwordCheck, term]);
    const onChangeId = (e) => {
        setId(e.target.value);
    };
    const onChangeNick = (e) => {
        setNick(e.target.value);
    };
    const onChangePassword = (e) => {
        setPassword(e.target.value);
    };
    const onChangePasswordChk = useCallback((e) => {
        setPasswordError(e.target.value !== password);
        setPasswordCheck(e.target.value);
    }, [password]);
    const onChangeTerm = useCallback((e) => {
        setTermError(false);
        setTerm(e.target.checked)
    }, []);

    return (
        <>
            <Form onSubmit={onSubmit} style={{padding: 10}}>
                <TextInput value="135135"></TextInput>
                <div>
                    <label htmlFor="user-id">아이디</label>
                    <br />
                    <Input name="user-id" value={id} required onChange={onChangeId}></Input>
                    {/* <TextInput value={id} onChange={onChangeId}></TextInput> */}
                </div>
                <div>
                    <label htmlFor="user-nick">닉네임</label>
                    <br />
                    <Input name="user-nick" value={nick} required onChange={onChangeNick}></Input>
                </div>
                <div>
                    <label htmlFor="user-password">비밀번호</label>
                    <br />
                    <Input name="user-password" type="password" value={password} required onChange={onChangePassword}></Input>
                </div>
                <div>
                    <label htmlFor="user-password-check">비밀번호체크</label>
                    <br />
                    <Input name="user-password-check" type="password" value={passwordCheck} required onChange={onChangePasswordChk}></Input>
                    {passwordError && <div style={{color: 'red'}}> 비밀번호가 일치하지 않습니다.</div>}
                </div>
                <div>
                    <Checkbox name="user-term" value={term} onChange={onChangeTerm}>제로초 말을 잘 들을 것을 동의합니다.</Checkbox>
                    {termError && <div style={{color: 'red'}}> 약관에 동의하셔야 합니다.</div>}
                </div>
                <div style={{marginTop: 10}}>
                    <Button type="primary" htmlType="submit">가입하기</Button>
                </div>
            </Form>
        </>
    );
};

export default Signup;