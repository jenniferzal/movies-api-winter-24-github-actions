package edu.greenriver.edu.movieappone;

import edu.greenriver.edu.movieappone.db.MovieRepository;
import edu.greenriver.edu.movieappone.domain.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MovieAppOneApplication {

	public static void main(String[] args) {
		/*ApplicationContext context = SpringApplication.run(MovieAppOneApplication.class, args);
		MovieRepository dbRepo = context.getBean(MovieRepository.class);

		 List<Movie> movies = new ArrayList<>(List.of(
				new Movie(0, "Inception", 2010, "Science Fiction", "PG-13", false),
				new Movie(0, "The Shawshank Redemption", 1994, "Drama", "R", false),
				new Movie(0, "The Dark Knight", 2008, "Action", "PG-13", false),
				new Movie(0, "Pulp Fiction", 1994, "Crime", "R", false),
				new Movie(0, "Titanic", 1997, "Drama", "PG-13", false),
				new Movie(0, "The Godfather", 1972, "Crime", "R", false),
				new Movie(0, "Avatar", 2009, "Action", "PG-13", true),
				new Movie(0, "The Lord of the Rings: The Return of the King", 2003, "Fantasy", "PG-13", false),
				new Movie(0, "Jurassic Park", 1993, "Science Fiction", "PG-13", false),
				new Movie(0, "Forrest Gump", 1994, "Drama", "PG-13", false)
		));

		 //loop over movies and insert each movie into the db
		 dbRepo.saveAll(movies);*/
	}

}
