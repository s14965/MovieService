package pj.pjatk.szymaj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pj.pjatk.szymaj.movie.Movie;
import pj.pjatk.szymaj.movie.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieServiceRestController {

    MovieService movieService;

    @GetMapping("/exception")
    public RuntimeException throwException(){
        return new RuntimeException();
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> getMovieList() { return ResponseEntity.ok(movieService.getList());}

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.getMovie(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        if(movie == null || movie.getId() > 0) {
            return ResponseEntity.badRequest().build();
        }
        else {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movie);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        if (movieService.getMovie(id)==null)
            return ResponseEntity.badRequest().build();
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if (movieService.getMovie(id)==null)
            return ResponseEntity.notFound().build();
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}