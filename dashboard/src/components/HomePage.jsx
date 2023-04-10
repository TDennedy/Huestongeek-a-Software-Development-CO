import './homepage.css'
import map from '../data/HWMap.png'

export default function HomePage({ keycloak }) {
    return (
        <div>
            <nav>
                <a href="">Placeholder Text</a>
                <a href="">Placeholder Text</a>
                <a href="">Placeholder Text</a>
                <button onClick={() => keycloak.login({ redirectUri: origin})}>
                    Login
                </button>
            </nav><div class="map">
                <img src={map} alt="Map Image" />
            </div><footer>
                <p>Copyright HuestonGeeks 2023</p>
            </footer>
        </div>
    );
}