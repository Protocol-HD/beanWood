import axios from "axios";
import React, { useRef } from "react";

function Login() {

    const userUrl = "http://localhost:8080/user/find/{id}";
    const userId = useRef();
    const userPassword = useRef();

    const addSignup = (e) => {
        e.preventDefault();
        axios.post(userUrl, {
            userId: userId.current.value,
            userPassword: userPassword.current.value
        })
    }

    return ( 

    <form onSubmit={addSignup}>
        <div className="col-md-4">
        <label for="InputId" className="form-label">ID</label>
        <input type="text" className="form-control" id="Id" placeholder="아이디를 입력하세요." ref={userId} />
        </div>
        <div className="col-md-4">
        <label for="InputPassword" className="form-label">PASSWORD</label>
        <input type="text" className="form-control" id="Password" placeholder="비밀번호를 입력하세요." ref={userPassword} />
        </div>
        <button class="btn btn-primary" type="button" >Login</button>
    </form>
     );
}

export default Login;