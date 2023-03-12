package cse201.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cse201.data.pojo.GeoJSON;
import cse201.data.repo.pojo.Feature;
import cse201.service.GeoService;

@RestController
@RequestMapping("/trails")
public class TrailsController {
	@Autowired
	private GeoService geoService;
	
	@PostMapping
	public Feature tst(@RequestBody Feature feature) {
		return geoService.save(feature);
	}
	
	@GetMapping
	public GeoJSON geoJSON(@RequestParam("id") UUID id) {
		return geoService.getByCollection(id);
	}
}
