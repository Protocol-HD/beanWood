import axios from "axios";
import React, { useRef } from "react";

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
		<form onSubmit={addSignup}>
			<div className="col-6 m-auto" >
				<label htmlFor="InputId" className="form-label">ID</label>
				<input type="text" className="form-control" id="Id" placeholder="아이디를 입력하세요." ref={userId} />
			</div>

			<div className="col-6 m-auto" >
				<label htmlFor="InputPassword" className="form-label">PASSWORD</label>
				<input type="password" className="form-control" id="Password" placeholder="비밀번호를 입력하세요." ref={userPassword} />
			</div>

			<div className="text-center mt-3">
				<button className="btn btn-primary" type="submit" >Login</button>
			</div>
		</form>
	);
}

export default Login;