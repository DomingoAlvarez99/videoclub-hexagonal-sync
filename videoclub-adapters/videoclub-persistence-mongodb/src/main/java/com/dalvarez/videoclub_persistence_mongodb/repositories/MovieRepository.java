package com.dalvarez.videoclub_persistence_mongodb.repositories;

import com.dalvarez.videoclub_persistence_mongodb.entities.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface MovieRepository extends MongoRepository<MovieEntity, String> {

    Optional<MovieEntity> findByName(String movie);

}
