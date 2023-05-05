package cse.data.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cse.data.repo.pojo.FeatureCollection;

@Repository
public interface FeatureCollectionRepo extends JpaRepository<FeatureCollection, UUID>{
}