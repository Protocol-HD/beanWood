import axios from "axios";
import React, { useCallback, useRef } from "react";
import { Link } from "react-router-dom";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faUserPlus} from '@fortawesome/free-solid-svg-icons';
import { useState } from "react/cjs/react.development";
import {Button} from 'react-bootstrap';



function SignUp() {
    const userUrl = "http://localhost:8080/user/save";
    const userIdCheckUrl = "http://localhost:8080/user/checkUserId/{id}/exists";

    const userId = useRef();
	const userAddress = useRef();
	const userPassword = useRef();

    const [idCheck, setIdCheck] = useState('');
    const [idCheckError, setIdCheckError] = useState('');
    const [password, setPassword] = useState('');
    const [passwordCheck, setPasswordCheck] = useState('');
    const [passwordError, setPasswordError] = useState('');


    // 회원가입
    const addUser = (e) => {
		e.preventDefault();
        if(password !== passwordCheck){
            return setPasswordError(true);
        }
		axios.post(userUrl, {
			userId: userId.current.value,
			userAddress: userAddress.current.value,
			userPassword: userPassword.current.value,
			userAdmin: false
		});
        
	}
    //회원가입end

    //아이디 중복 체크
    const checkUserId = (e) => {
        e.preventDefault();
       
    }
    //아이디 중복 체크 end

    const onChangePassword = (e) => {
        setPassword(e.target.value);
    }

    const onChangePasswordCheck = (e) => {
        setPasswordError(e.target.value !== password);
        setPasswordCheck(e.target.value);
    }

    return ( 
        <section className="login-area pt-100 pb-100">
            <div className="container">
                <div className="row">
                    <div className="col-lg-8 offset-lg-2">
                        <div className="basic-login">
                        <div className="text-center">
                        <FontAwesomeIcon icon={faUserPlus} className="user" size="3x" color="#003333" />
                        </div>
                            <h3 className="text-center mb-60">Signup From Here</h3>
                            <form onSubmit={addUser}>
                                <form onSubmit={checkUserId}>
                                <label for="id">ID <span>**</span></label>
                                <input id="id" type="text" placeholder="사용하실 아이디를 입력해주세요." ref={userId} />
                                <button className="btn theme-btn" onClick={checkUserId}>ID 중복 확인</button>
                                </form>
                                <label for="password">Password <span>**</span></label>
                                <input id="password" type="password" placeholder="사용하실 비밀번호를 입력하세요." ref={userPassword} onChange={onChangePassword}/>

                                <label for="passwordconfirm">Password Confirm <span>**</span></label>
                                <div>
                                <input id="user-password-check" type="password" value={passwordCheck} onChange={onChangePasswordCheck} placeholder="사용하실 비밀번호를 한 번 더 입력하세요."  />
                                {passwordError && <div style={{color : 'red'}}>
                                    비밀번호가 일치하지 않습니다.</div>}
                                </div>
                                
                                <label for="pass">Address <span>**</span></label>
                                <input id="pass" type="text" placeholder="사용하실 주소를 입력하세요." ref={userAddress} />

                                <div className="mt-10"></div>
                                <button className="btn theme-btn-2 w-100" >회원가입하기</button>
                                <div className="or-divide"><span>or</span></div>
                                <button className="btn theme-btn w-100"><Link to="/login">로그인 하기</Link></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
     );
}


export default SignUp;