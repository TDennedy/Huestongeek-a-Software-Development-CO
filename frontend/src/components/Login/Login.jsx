import React from "react";
import './Login.css';


const Login = () => {
    return (
        <div class="vid-container">
            <video class="bgvid" autoplay="autoplay" muted="muted" preload="auto" loop>
                <source
                    src="https://vod-progressive.akamaized.net/exp=1677576938~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F3329%2F11%2F291648067%2F1106060006.mp4~hmac=c96dc27b1e4455df8dbae4125fc8c738f655564d756ca75f49a6ae763478ac4a/vimeo-prod-skyfire-std-us/01/3329/11/291648067/1106060006.mp4" type="video/webm">
                </source>
            </video>
            <div class="inner-container">
                <video class="bgvid inner" autoplay="autoplay" muted="muted" preload="auto" loop>
                    <source
                        src="https://vod-progressive.akamaized.net/exp=1677576938~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F3329%2F11%2F291648067%2F1106060006.mp4~hmac=c96dc27b1e4455df8dbae4125fc8c738f655564d756ca75f49a6ae763478ac4a/vimeo-prod-skyfire-std-us/01/3329/11/291648067/1106060006.mp4"
                        type="video/webm">
                    </source>
                </video>
                <div class="box">
                    <h1>Login</h1>
                    <input type="text" placeholder="Username" />
                    <input type="text" placeholder="Password" />
                    <button>Login</button>
                    <p>Not a member? <span>Sign Up</span></p>
                </div>
            </div>
        </div>
    )
}

export default Login;