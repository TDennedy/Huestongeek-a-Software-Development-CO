package cse.data.repo.pojo.converter;

import static cse.data.repo.pojo.StarRating.FIVE;
import static cse.data.repo.pojo.StarRating.FOUR;
import static cse.data.repo.pojo.StarRating.ONE;
import static cse.data.repo.pojo.StarRating.THREE;
import static cse.data.repo.pojo.StarRating.TWO;

import cse.data.repo.pojo.StarRating;
import jakarta.persistence.AttributeConverter;


public class StarRatingConverter implements AttributeConverter<StarRating, Short> {

	@Override
	public Short convertToDatabaseColumn(StarRating rate) {
		if (rate == null)
			return null;

		switch (rate) {
		
		case ONE: return 1;
		case TWO: return 2;
		case THREE: return 3;
		case FOUR: return 4;
		case FIVE: return 5;
			
		}
		
		throw new IllegalArgumentException(rate + " not found.");
	}

	@Override
	public StarRating convertToEntityAttribute(Short stars) {
		if (stars == null)
			return null;

		switch (stars) {
		
		case 1: return ONE;
		case 2: return TWO;
		case 3: return THREE;
		case 4: return FOUR;
		case 5: return FIVE;
			
		}
		
		throw new IllegalArgumentException(stars + " not supported.");
	}
}
