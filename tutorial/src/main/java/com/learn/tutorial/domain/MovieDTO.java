package com.learn.tutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieDTO {
    private int movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieMainActor;
    private String directorName;
    private Director director;
}
