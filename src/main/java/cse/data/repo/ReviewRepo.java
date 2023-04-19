package cse.data.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cse.data.repo.pojo.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, UUID> {
	@Query("FROM Review WHERE userID = :userID")
	List<Review> findByUserId(@Param("userID") UUID userID);
	
	@Query("FROM Review WHERE trailID = :trailID")
	List<Review> findByTrailId(@Param("trailID") UUID trailID);
}
