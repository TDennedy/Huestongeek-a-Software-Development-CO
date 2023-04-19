package cse.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cse.data.pojo.trailforks.TFGeoJSON;

//https://www.trailforks.com/rms/?rmsP=j2&mod=trailforks&op=map&format=geojson&z=12.4&layers=markers,polygons,tracks&markertypes=region,poi,directory,eventpremium,labels,trails,nst,waypoint&region=ridingarea_6151&region_filter=undefined&bboxa=-84.85001654825486,39.55451810434161,-84.72252345174502,39.60465282940419&display=difficulty&activitytype=1&condition_time=0&trailids=&trailids_exclude=&rid=6151&season=0&ebike=0&group=0&filters=&hideunsanctioned=0&mapcollection=0&center_lng=-84.78627&center_lat=39.57959&pitch=0
@Service
public class ScrapeService {
	private final ObjectMapper mapper;
	
	private RestTemplate template = new RestTemplate();
	
	private final HttpHeaders headers = new HttpHeaders();
	
	@Autowired
	public ScrapeService(ObjectMapper mapper) {
		this.mapper = mapper;
		headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0");
		headers.add("Accept-Language", "en-US,en;q=0.5");
	}
	
	/**
	 * Scrape GeoJson data from trailforks.
	 * @param fullURL The full URL to the GeoJson from trailforks.
	 */
	public TFGeoJSON scrapeTrailForksGeoJson(String fullURL) {
		fullURL = fullURL.replaceAll("www.trailforks.com/", "www.pinkbike.com/");
		
		final RequestEntity<String> req = new RequestEntity<>(
				headers,
				HttpMethod.GET, 
				URI.create(fullURL)
			);
				
		final ResponseEntity<String> resp = template.exchange(req, String.class);

		try {
			System.out.println(resp.getBody());
			return mapper.readValue(resp.getBody(), TFGeoJSON.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
