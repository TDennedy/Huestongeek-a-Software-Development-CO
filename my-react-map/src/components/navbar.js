import React, { useEffect, useState } from 'react'; 

import './navbar.css';
import { kcinit } from "../Keycloak";

const loggedIn = (keycloak) => keycloak != null && keycloak.authenticated; 

export default function Navbar(){
	const [ keycloak, setKeycloak ] = useState();

	useEffect(() => {
		kcinit.then(kc => setKeycloak(kc));
	}, []);

	console.log(keycloak);
	if (keycloak != null)
		console.log(keycloak.idTokenParsed);

	return (
		<div className="heading">
			<h1>map app</h1>
			<div>
				<UserBox keycloak={keycloak}/>
				<LoginBox keycloak={keycloak}/>
			</div>
		</div>
	);
}

function LoginBox({ keycloak }) {
	if (loggedIn(keycloak))
		return (
			<button onClick={() => keycloak.logout()}> Logout </button>
		);

	else
		return (
			<button onClick={() => keycloak.login()}> Login </button>
		);
}

function UserBox({ keycloak }) {
	if (loggedIn(keycloak))
		return (
			<p> {keycloak.idTokenParsed.preferred_username} </p>
		);
}