import "./styles.css";

export default function App() {
  return (
    <div className="App">
      <h1>Review and Rate!</h1>
      <h2>Complete the form to rate a trail</h2>
      <body>
        <form id="rateReview" action="form.js">
        <label for="trailName">Select Trail Name:</label>
          <select id="trailName" name="trailName" size="2" multiple>
          <option value="Cedar Falls Trail">Cedar Falls Trail</option>
          <option value="Sycamore Trail">Sycamore Trail</option>
          <option value="Pine Loop/Cabin Trail">Pine Loop/Cabin Trail</option>
          <option value="Mud Lick Trail">Mud Lick Trail</option>
          <option value="West Shore Trail">West Shore Trail</option>
          <option value="Sugar Bush Trail">Sugar Bush Trail</option>
          <option value="Blue Heron Trail">Blue Heron Trail</option>
          <option value="Big Woods Trail">Big Woods Trail</option>
          <option value="Hedge Apple Trail">Hedge Apple Trail</option>
          <option value="Indian Mound Trail">Indian Mound Trail</option>
          <option value="Galleon Run Trail">Galleon Run Trail</option>
          <option value="Equisetum Loop Trail">Equisetum Loop Trail</option>
          </select>
          <p>Rate the trail 0-5 stars:</p>
          <input type="radio" id="star0" name="rate" value="star0"></input>
          <label for="star0">0 Stars</label>
          <input type="radio" id="star1" name="rate" value="star1"></input>
          <label for="star1">1 Star</label>
          <input type="radio" id="star2" name="rate" value="star2"></input>
          <label for="star2">2 Star</label>
          <input type="radio" id="star3" name="rate" value="star3"></input>
          <label for="star3">3 Stars</label>
          <input type="radio" id="star4" name="rate" value="star4"></input>
          <label for="star4">4 Stars</label>
          <input type="radio" id="star5" name="rate" value="star5"></input>
          <label for="star5">5 Stars</label>
          <p>
          
          </p>
          <label for="review">Leave your review below:</label>
          <p>
          
          </p>
          <input type="text" id="review" name="review"></input>
          <p>
          
          </p>
          <input type="submit" value="Submit"></input>
        </form>
      </body>
    </div>
  );
}

