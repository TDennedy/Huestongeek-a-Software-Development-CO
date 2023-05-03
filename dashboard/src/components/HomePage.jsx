import './style_index.css'

export default function HomePage({ keycloak }) {
    return (
        <div>
<<<<<<< Updated upstream
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
            </nav><div className="map">
                <img src={map} alt="Map Image" />
            </div><footer>
                <p>Copyright HuestonGeeks 2023</p>
            </footer>
=======
            <nav className="container-fluid nav">
            <div className="container cf">
            <div className="brand">
                <a href="#splash">Hueston Geek</a>
            </div>
            <i className="fa fa-bars nav-toggle"></i>
            <ul>
                <li><a href="#about">About</a></li>
                <li><a href="#skills">Services</a></li>
                <li><a onClick={() => keycloak.login({ redirectUri: origin})}>Login</a></li>
                <li><a onClick={() => keycloak.register({ redirectUri: origin})}>Sign-up</a></li>
            </ul>
            </div>
        </nav>
        
        <div className="container-fluid splash" id="splash">
            <div className="container">
            <h1>Hueston Geeks</h1>
            <span className="lead">Hike-athon</span>
            <span className="continue"></span>
            </div>
        </div>
        
        <div className="container-fluid intro" id="about">
            <div className="container">
            <h2>About Hike-athon</h2>
            <p>This website allows its users to look at trails from Hueston Woods. By logging in, you can look at
                a myriad of trails available at Hueston Woods. Users can even log their personal experiences from the trails and
                leave a review for the public to see.</p>
            </div>
        </div>
        
        <div className="container-fluid features" id="skills">
            <div className="container cf">
            <h2>Our Services</h2>
            <div className="col-3">
                <h3>Interactive Trail Map</h3>
                <p>Browse an Interactive Map that details all available trails at Hueston Woods. A handy legend can be
                    found on the left of the map with extra details for each trail.</p>
            </div>
            <div className="col-3">
                <h3>Review Trails</h3>
                <p>Rate the trails of Hueston Woods and share your experience with other hikers!</p>
            </div>
            <div className="col-3">
                <h3>Trail Gallery</h3>
                <p>View pictures taken by other hikers in the Trail Gallery. Below is a sample of what the Trail Gallery has to offer.</p>
            </div>
            </div>
        </div>
        
        <div className="container-fluid portfolio" id="portfolio">
            <div className="container cf">
            <h2>Trail Gallery</h2>
            <div className="gallery">
                <div className="gallery-image"><img src="https://visithw.com/assets/caches/images/assets/users/general/IMG_5399_cc_sm-691x299.jpg" alt="" /></div>
                <div className="gallery-image"><img src="https://www.hikingamerica.com/content/images/2022/05/huestonWoods.jpg" alt="" /></div>
                <div className="gallery-image"><img src="https://i0.wp.com/footpathsblog.com/wp-content/uploads/2023/03/DSC_0004-2.jpg?resize=723%2C482&ssl=1" alt="" /></div>
                <div className="gallery-image"><img src="https://visithw.com/assets/caches/images/assets/users/general/bike_trail_serpentine-691x299.jpg" alt="" /></div>
                <div className="gallery-image"><img src="https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvMzYxNjM2OTgvNzkwMDUyYTdlZGFmZTIwOTFmYzJiYzZkYzk1NWM2YzguanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjo1MDAsImhlaWdodCI6NTAwLCJmaXQiOiJpbnNpZGUifSwicm90YXRlIjpudWxsLCJqcGVnIjp7InRyZWxsaXNRdWFudGlzYXRpb24iOnRydWUsIm92ZXJzaG9vdERlcmluZ2luZyI6dHJ1ZSwib3B0aW1pc2VTY2FucyI6dHJ1ZSwicXVhbnRpc2F0aW9uVGFibGUiOjN9fX0=" alt="" /></div>
                <div className="gallery-image"><img src="https://media-cdn.tripadvisor.com/media/photo-s/08/aa/ce/5c/hueston-woods-state-park.jpg" alt="" /></div>
            </div>
            </div>
        </div>
        
        <footer className="container-fluid footer">
            <div className="container">
                <p>© 2022 All rights reserved by Huestongeek.com</p>
            </div>
        </footer>
>>>>>>> Stashed changes
        </div>
    );
}
