package cse.data.pojo;

import java.util.Map;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Represents a trail, as it appears in our raw CSV format.
 * @author Sam
 *
 */
public class Trail {
	@CsvBindByName(column = "Name")
    private String name;
	
    @CsvBindByName(column = "PolylineEncoded")
    private String encodedPolyline;
    
    @CsvBindByName
    private String color;
    
    @CsvBindByName(column = "Distance")
    private double distance;

    @CsvBindByName(column = "Difficulty")
    private int difficulty;
    
    @CsvBindByName(column = "isLoop")
    private boolean loop;
    
    @CsvBindByName(column = "isPaved")
    private boolean paved;
    
    @CsvBindByName(column = "isBiked")
    private boolean biked;
    
    @CsvBindByName(column = "hasLakeView")
    private boolean lakeView;
    
    public boolean hasLakeView() {
    	return lakeView;
    }

	public Map<String, ?> toGeneric() {
		return Map.of(
				"name", name,
				"distance", distance,
				"difficulty", difficulty,
				"isLoop", loop,
				"isPaved", paved,
				"isBiked", biked,
				"hasLakeView", lakeView,
				"color", color
			);
	}
}
