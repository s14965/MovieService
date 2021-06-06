package pj.pjatk.szymaj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pj.pjatk.szymaj.movie.Movie;
import pj.pjatk.szymaj.movie.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieServiceRestController {

    private final MovieService movieService;

    public MovieServiceRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/exception")
    public RuntimeException throwException() {
        return new RuntimeException();
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovieList() {
        return ResponseEntity.ok(movieService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovie(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        if (movieService.getMovie(id) == null)
            return ResponseEntity.badRequest().build();
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @PutMapping("makeAvailable/{id}")
    public ResponseEntity<Movie> makeAvailable(@PathVariable Long id) {
        if (movieService.getMovie(id) == null)
            return ResponseEntity.badRequest().build();
        movieService.makeAvailable(id);
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @PutMapping("rentMovie/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        if (movieService.getMovie(id) == null)
            return ResponseEntity.badRequest().build();
        movieService.rentMovie(id);
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if (movieService.getMovie(id) == null)
            return ResponseEntity.notFound().build();
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }



}