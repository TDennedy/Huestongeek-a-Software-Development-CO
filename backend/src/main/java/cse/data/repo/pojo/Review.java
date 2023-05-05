package cse.data.repo.pojo;

import java.time.OffsetDateTime;
import java.util.UUID;

import cse.data.pojo.ReviewTemplate;
import cse.data.pojo.User;
import cse.data.repo.pojo.converter.StarRatingConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(schema = "hiking", name = "feature_review")

@NoArgsConstructor
public class Review {
	// Easier than rewriting a converter method between short & StarRating
	private static final StarRatingConverter converter = new StarRatingConverter();
	
	@Id
	@Column
	private UUID id = UUID.randomUUID();
	
	@Column(name = "user_id")
	private UUID userID;
	
	@Column(name = "trail_id")
	private UUID trailID;
	
	@Column(name = "n_stars")
	@Convert(converter = StarRatingConverter.class)
	private StarRating rating;
	
	@Column
	private String body;
	
	@Column
	private String title;
	
	@Column(name = "last_updated")
	private OffsetDateTime lastUpdated = OffsetDateTime.now();
	
	public Review(User user, ReviewTemplate template) {
		this.userID = user.getUuid();
		this.trailID = template.getTrailID();
		this.rating = converter.convertToEntityAttribute(template.getStars());
		this.body = template.getBody();
		this.title = template.getTitle();
	}
}
