package com.dalvarez.videoclub_persistence_mongodb.entities;

import com.dalvarez.videoclub.domain.models.Movie;
import com.googlecode.jmapper.JMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MovieEntity {

    @Id
    private String id;

    private String name;

    private LocalDate publicationDate;

    private String description;

    private LocalDate registrationDate;

    private CompanyEntity company;

    private List<CategoryEntity> categories = new ArrayList<>();

    public static MovieEntity fromMovie(Movie movie) throws ClassCastException {
        return new JMapper<>(MovieEntity.class, Movie.class)
                .getDestination(movie);
    }

    public Movie toMovie() throws ClassCastException {
        return new JMapper<>(Movie.class, MovieEntity.class)
                .getDestination(this);
    }

}