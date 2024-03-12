package edu.greenriver.edu.movieappone.db;

import edu.greenriver.edu.movieappone.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>
{
    //we have all the CRUD methods we need


}
