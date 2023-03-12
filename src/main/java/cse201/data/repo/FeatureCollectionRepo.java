package cse201.data.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cse201.data.repo.pojo.FeatureCollection;

@Repository
public interface FeatureCollectionRepo extends JpaRepository<FeatureCollection, UUID>{
}