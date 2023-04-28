import "./styles.css";

import { onSubmit } from "./form.js"
import { useState, useEffect } from "react";
import { getOxfordTrails } from "./Requests"

export default function App() {
  return (
    <div className="App">
      <h1>Review and Rate!</h1>
      <h2>Complete the form to rate a trail</h2>
      <body>
        <form id="rateReview" onSubmit={onSubmit}>
        <label for="trailName">Select Trail Name:</label>
          <select id="trailName" name="trailName" size="2" multiple>
            <TrailOptions/>
          </select>
          <p>Rate the trail 0-5 stars:</p>
          <input type="radio" id="star0" name="rate" value="0"></input>
          <label htmlFor="star0">0 Stars</label> {/** doesn't cause an error, but technically should use htmlFor since JavaScript has for keyword. */}
          <input type="radio" id="star1" name="rate" value="1"></input>
          <label htmlFor="star1">1 Star</label>
          <input type="radio" id="star2" name="rate" value="2"></input>
          <label htmlFor="star2">2 Star</label>
          <input type="radio" id="star3" name="rate" value="3"></input>
          <label htmlFor="star3">3 Stars</label>
          <input type="radio" id="star4" name="rate" value="4"></input>
          <label htmlFor="star4">4 Stars</label>
          <input type="radio" id="star5" name="rate" value="5"></input>
          <label htmlFor="star5">5 Stars</label>
          <p>
          
          </p>
          <label htmlFor="review">Your Review's Title:</label>
          <p>
          
          </p>
          <input type="text" id="review" name="title"></input>
          <p>
          
          </p>
          <input type="submit" value="Submit"></input>
        </form>
      </body>
    </div>
  );
}

function TrailOptions() {
  const [ trails, setTrails ] = useState();

  useEffect(() => {
    const trails = getOxfordTrails()
                    .then(trails => trails.json())
                    .then(json => setTrails(json));
  }, [])

  if (trails != null)
      return trails.features.map(trail => {
      const props = trail.properties;

      return <option value={props.id}> {props.name} </option>
    })

  // Code here is executed while trails are loading from backend
  // Could throw a loading bar or something here if you want, but probably not necessary, it'll just render nothing otherwise
}