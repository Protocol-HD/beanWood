import axios from "axios";
import React, { useRef } from "react";

function Join() {
	const userUrl = "http://localhost:8080/user/save";
	const userId = useRef();
	const userAddress = useRef();
	const userPassword = useRef();

	const addUser = (e) => {
		e.preventDefault();
		axios.post(userUrl, {
			userId: userId.current.value,
			userAddress: userAddress.current.value,
			userPassword: userPassword.current.value,
			userAdmin: false
		});
	}
	return (
		<div className="row g-3">
			<form onSubmit={addUser}>
				<div className="col-6 m-auto">
					<label htmlFor="inputId" className="form-label">ID</label>
					<input type="text" className="form-control" id="userId" placeholder="사용하실 아이디를 입력해주세요." ref={userId} />
				</div>


				<div className="col-6 m-auto">
					<label htmlFor="inputPassword4" className="form-label">Password</label>
					<input type="password" className="form-control" id="password" placeholder="사용하실 비밀번호를 입력하세요." ref={userPassword} />
				</div>


				<div className="col-6 m-auto">
					<label htmlFor="inputPassword4" className="form-label">Password Confirm</label>
					<input type="password" className="form-control" id="password2" placeholder="비밀번호를 한 번 더 입력해주세요." />
				</div>

				<div className="col-6 m-auto">
					<label htmlFor="inputAddress" className="form-label">Address</label>
					<input type="text" className="form-control" id="address" placeholder="주소를 입력해주세요." ref={userAddress} />
				</div>

				<div className="text-center mt-3">
					<button type="submit" className="btn btn-primary">Sign in</button>
				</div>
			</form>
		</div>
	);
}

export default Join;