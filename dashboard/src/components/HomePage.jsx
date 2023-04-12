import './homepage.css'
// import map from '../data/HWMap.png'
import { SiRedwoodjs } from 'react-icons/si';

export default function HomePage({ keycloak }) {
    return (
        <div>
            <header className="items-center gap-3 ml-3 mt-4 flex text-xl font-extrabold tracking-tight dark:text-white text-slate-900">
              <SiRedwoodjs /> <span>Hueston Geek</span>
            </header>
            <nav>
                <a href="">Placeholder Text</a>
                <a href="">Placeholder Text</a>
                <a href="">Placeholder Text</a>
                <button onClick={() => keycloak.login({ redirectUri: origin})}>
                    Login
                </button>
            </nav><div class="map">
                <img src="https://www.discoverdaytonohio.com/wp-content/uploads/place_lakes_and_parks_hueston_woods_20-1.jpg" alt="Map Image" />
            </div><footer>
                <p>Copyright HuestonGeeks 2023</p>
            </footer>
        </div>
    );
}