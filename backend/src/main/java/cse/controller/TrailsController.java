package cse.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cse.data.pojo.GeoJSON;
import cse.service.GeoService;

@RestController
@RequestMapping("/trails")
public class TrailsController {
	@Autowired
	private GeoService geoService;
	
//	@PostMapping
//	public Feature tst(@RequestBody Feature feature) {
//		return geoService.save(feature);
//	}
	
	@GetMapping
	public GeoJSON getGeoJSON(@RequestParam("id") UUID id) {
		return geoService.getByCollection(id);
	}

}
