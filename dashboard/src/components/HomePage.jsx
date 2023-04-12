import './homepage.css'

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
            </nav>
            <div className="map">
                <img src="https://www.discoverdaytonohio.com/wp-content/uploads/place_lakes_and_parks_hueston_woods_20-1.jpg" alt="Map Image" />
            </div><footer>
                <p>Copyright HuestonGeeks 2023</p>
            </footer>
        </div>
    );
}