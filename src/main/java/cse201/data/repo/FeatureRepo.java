package cse201.data.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cse201.data.repo.pojo.Feature;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, UUID>{
	@Query("FROM Feature JOIN FETCH geometry WHERE collectionID = :collectionID")
	List<Feature> findByCollectionId(@Param("collectionID") UUID collectionID);
}