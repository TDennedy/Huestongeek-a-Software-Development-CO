import HomePage from "./Homepage"

function App() {
  return (
    <div className="App">
      <MenuBar/>
      <HomePage/>
    </div>
  );
}

// I think Loc already made a menu bar, so you don't
// have to worry about this anymore. I'll just keep it as a placeholder.
function MenuBar() {
    return (
        <header>
            <h1>Hike-athon</h1>
            <div class="btn-right">
                <button>Sign in</button>
            </div>
        </header>
    );
}

export default App;
