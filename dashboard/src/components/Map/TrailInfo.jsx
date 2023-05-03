import React from 'react'

import './TrailInfo.css'

const TrailInfo = ({ data }) => {
  return (
    <div className='trailinfo'>
      {data && data.features.map((item) => (
        <div
          className='trail'
          style={{ border: '2px solid', borderColor: `${item.properties.color}`}}
        >
          <h1>{item.properties.name}</h1>
          <p>🥾 Difficulty: {item.properties.difficulty}</p>
          <p>🛣️ Distance: {item.properties.distance} miles</p>
          <p>🚴🏻‍♂️ With Bike: {item.properties.isBiked ? "Yes" : "No"}</p>
        </div>
			))}
    </div>
  )
}

export default TrailInfo