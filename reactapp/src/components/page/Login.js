import axios from "axios";
import React, { useRef } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDoorOpen } from "@fortawesome/free-solid-svg-icons";

function Login() {

    const userUrl = "http://localhost:8080/user/findByUserId/";
    const userId = useRef();
    const userPassword = useRef();
    

    const addSignup = (e) => {
		e.preventDefault();
		axios.get(userUrl + userId.current.value).then(Response => {
			console.log(Response.data);
			if(Response.data.userId === userId.current.value) {
				alert("로그인 성공");
			} else {
				alert("아이디를 확인해 주세요.")
			}
		})
	}

    return ( 
        <section className="login-area pt-100 pb-100">
            <div className="container">
                <div className="row">
                    <div className="col-lg-8 offset-lg-2">
                        <div className="basic-login">
                        <div className="text-center">
                        <FontAwesomeIcon icon={faDoorOpen} size="3x" color="#003333" />
                        </div>
                            <h3 className="text-center mb-60">Login From Here</h3>
                            <form onSubmit={addSignup}>
                                <label for="name">ID<span>**</span></label>
                                <input id="name" type="text" placeholder="아이디를 입력하세요." ref={userId}/>
                                <label for="pass">PASSWORD <span>**</span></label>
                                <input id="pass" type="password" placeholder="비밀번호를 입력하세요." ref={userPassword}/>
                                <div className="login-action mb-20 fix">
                                    <span className="log-rem f-left">
                                        <input id="remember" type="checkbox" />
                                        <label for="remember">Remember me!</label>
                                    </span>
                                    <span className="forgot-login f-right">
                                        <a href="javascript:void(0)">Lost your password?</a>
                                    </span>
                                </div>
                                <button className="btn theme-btn-2 w-100">로그인 하기</button>
                                <div className="or-divide"><span>or</span></div>
                                <button className="btn theme-btn w-100"><Link to="/signup">회원가입 하기</Link></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
     );
}

export default Login;