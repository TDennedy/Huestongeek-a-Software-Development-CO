package cse.data.pojo;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewTemplate {
	private UUID trailID;
	
	private short stars;
	
	private String body;
	
	private String title;
}
