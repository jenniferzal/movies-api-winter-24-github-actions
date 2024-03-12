package edu.greenriver.edu.movieappone.service;

import edu.greenriver.edu.movieappone.db.MovieRepository;
import edu.greenriver.edu.movieappone.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
    This class has business logic and is marked as a
    stereotypical service layer.
*/
@Service
public class MovieService
{
    private MovieRepository repository;

    public MovieService(MovieRepository repository)
    {
        this.repository = repository;

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
        repository.saveAll(movies);
    }

    public Movie getRandomMovie()
    {
        Random generator = new Random();
        List<Movie> movies = repository.findAll();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

    public List<Movie> all()
    {
        //convert to read-only list
        List<Movie> movies = repository.findAll();
        return Collections.unmodifiableList(movies);
    }

    public Movie byTitle(String title)
    {

        //we can use functional code (with lambdas) -- option 2 of what is done above
        /*Movie found = movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst()
                .orElse(null);*/
        /*List<Movie> movies = repository.findAll();
        int index = movieIndexOf(title);

        return movies.get(index);*/
        List<Movie> results = new ArrayList<>();
        List<Movie> movies = repository.findAll();

        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getTitle().equals(title))
            {
                return next;
            }
        }

        return null;
    }

    public List<Movie> byYear(int year)
    {
        /*List<Movie> results = new ArrayList<>();
        List<Movie> movies = repository.findAll();

        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getReleaseYear() == year)
            {
                results.add(next);
            }
        }*/
        List<Movie> movies = repository.findAll();

        List<Movie> foundMovies = movies.stream()
                .filter(movie -> movie.getReleaseYear() == year)
                .collect(Collectors.toList());
        return foundMovies;
    }

    public Movie addMovie(Movie movie)
    {
        //this will result in an INSERT SQL statement
        return repository.save(movie);
    }

    public Movie updateMovie(Movie updatedMovie, String title)
    {

        //find the movie that matches
        /*Movie savedMovie = movies.get(movieIndexOf(title));

        //update the data in the movie
        savedMovie.setGenre(updatedMovie.getGenre());
        savedMovie.setReleaseYear(updatedMovie.getReleaseYear());
        savedMovie.setInternational(updatedMovie.isInternational());
        savedMovie.setRating(updatedMovie.getRating());
*/
        //return savedMovie;
        return null;
    }

    public Movie updateMovie(Movie updatedMovie, int id)
    {
        Movie currentMovie = repository.findById(id).orElseThrow();

        currentMovie.setRating(updatedMovie.getRating());
        currentMovie.setInternational(updatedMovie.isInternational());
        currentMovie.setGenre(updatedMovie.getGenre());
        currentMovie.setReleaseYear(updatedMovie.getReleaseYear());
        currentMovie.setTitle(updatedMovie.getTitle());

        //this is add or update
        return repository.save(currentMovie);
    }

    public void deleteMovie(int id)
    {
        repository.deleteById(id);
    }

    public void deleteMovie(String title)
    {
/*        int index = movieIndexOf(title);
        movies.remove(index);*/
    }

    //returns the index where the matching movie title is found
    private int movieIndexOf(String title)
    {
        List<Movie> movies = repository.findAll();
        for (int i = 0; i < movies.size(); i++)
        {
            Movie next = movies.get(i);
            if (next.getTitle().equalsIgnoreCase(title))
            {
                return i;
            }

        }
        return -1;
    }

    public Movie byId(int id)
    {
        return repository.findById(id).orElseThrow(null);
    }

    public boolean isValidMovie(Movie movie)
    {
        return movie.getTitle() != null && !movie.getTitle().isEmpty();
    }
}
