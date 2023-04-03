import React, { useState, useEffect } from 'react';

const GoogleMap = () => {
  const [mapSrc, setMapSrc] = useState('');

  useEffect(() => {
    // Set the Google Maps API URL with your own API key
    const url = `https://maps.googleapis.com/maps/api/js?key=AIzaSyDPsCGUWWRv5LekIntD2pFAeeEyjMOOLps`;

    // Set the map URL with the latitude and longitude of your location
    const mapUrl = `https://www.google.com/maps/embed/v1/place?q=39.58207920430959,-84.76143785762235&key=AIzaSyDPsCGUWWRv5LekIntD2pFAeeEyjMOOLps`;

    // Load the Google Maps API script
    const script = document.createElement('script');
    script.src = url;
    script.async = true;
    script.onload = () => setMapSrc(mapUrl);
    document.head.appendChild(script);

    // Cleanup function to remove the script from the page
    return () => {
      document.head.removeChild(script);
    };
  }, []);

  return (
    <div>
      <iframe
        className='w-full flex h-screen'
        title="Google Map"
        loading="lazy"
        allowFullScreen
        src={mapSrc}
      ></iframe>
    </div>
  );
}

export default GoogleMap;
