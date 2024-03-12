package edu.greenriver.edu.movieappone.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//getters/setters, toString(), equals/hashcode..\
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie
{
    //auto-increment field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int releaseYear;
    private String genre;
    private String rating;
    private boolean international;

}
