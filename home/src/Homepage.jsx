import style from "./Homepage.module.css";

export default function HomePage() {
    return (
        <div className={style.homePage}>
            <nav>
                <a href="">Placeholder Text</a>
                <a href="">Placeholder Text</a>
                <a href="">Placeholder Text</a>
            </nav><div class="map">
                <img src="https://www.discoverdaytonohio.com/wp-content/uploads/place_lakes_and_parks_hueston_woods_20-1.jpg" alt="Map Image" />
            </div><footer>
                <p>Copyright HuestonGeeks 2023</p>
            </footer>
        </div>
    );
}