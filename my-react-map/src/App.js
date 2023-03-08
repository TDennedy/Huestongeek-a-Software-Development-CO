import * as React from 'react';
import Map, {NavigationControl, Source, Layer} from 'react-map-gl';
import Navbar from './components/navbar.js';
import maplibregl from 'maplibre-gl';
import 'maplibre-gl/dist/maplibre-gl.css';
import { initKeycloak } from "./Keycloak";

import DrawControl from "./Draw.tsx";
import './App.css';
import trails from "./features.json";

import { useEffect, useState } from "react";

const pointLayerStyle = {
	id: 'points',
	type: 'circle',
	paint: {
		'circle-color': 'blue',
		'circle-radius': 5,
		'circle-stroke-width': 1,
		'circle-stroke-color': 'white',
	},
	filter: ['==', '$type', 'Point']
};

const lineLayerStyle = {
	id: 'lines',
	type: 'line',
	paint: {
		'line-color': 'blue',
		'line-width': 2,
	},
	filter: ['==', '$type', 'LineString']
};

const initialViewState = { 
	longitude: -84.749747,
	latitude: 39.563526,
	zoom: 14
}

const DEFAULT_VIEWPORT = {
	width: 800,
	height: 600,
	longitude: -122.45,
	latitude: 37.78,
	zoom: 14,
};

initKeycloak();

function App() {
	useEffect(() => {
		const fetchData = async () => {
			//const response = await fetch("https://api.maptiler.com/data/d5ed667f-6740-41d7-90ae-8db62726665a/features.json?key=Adfu325jajdZpZFxiEJu");

		//	setData(trails);
		};

		//fetchData();
	}, []);
	
	return (
		<div className="App">
			<Navbar/>
			<MapComponent/>
		</div>
	);
}

// Displaying the drawn trails
function MapComponent() {
	const [ data, setData ] = useState();

	return (
		<Map mapLib={maplibregl}
			initialViewState={initialViewState}
			mapStyle="https://api.maptiler.com/maps/c5c52cca-2522-4e56-bbb7-f9e0a0832fed/style.json?key=Adfu325jajdZpZFxiEJu"
			style={{width: "100%", height: " calc(100vh - 77px)"}}
		>
			<NavigationControl position="top-left" />
			<Source type="geojson" data={trails}>
				<Layer {...pointLayerStyle} />
				<Layer {...lineLayerStyle} />
			</Source>
		</Map>
	)
}

// Drawing the trails
function DrawMapComponent() {
//	const [ viewport, setViewport ] = useState({ viewport: DEFAULT_VIEWPORT, modeHandler: null });

	return (
      	<Map
//  		{...viewport}
	        mapLib={maplibregl}
			initialViewState={initialViewState}
			mapStyle="https://api.maptiler.com/maps/c5c52cca-2522-4e56-bbb7-f9e0a0832fed/style.json?key=Adfu325jajdZpZFxiEJu"
			style={{width: "100%", height: " calc(100vh - 77px)"}}
//	        onViewportChange={setViewport}
	    >
	        <DrawControl
	          position="top-left"
	          displayControlsDefault={false}
	          cursor='crosshair'
	          controls={{
	            line_string: true
	          }}
	          defaultMode="draw_line_string"
	          onCreate={() => {}}
	          onUpdate={() => {}}
	          onDelete={() => {}}
	        />
    	</Map>
    );
}

export default App;
