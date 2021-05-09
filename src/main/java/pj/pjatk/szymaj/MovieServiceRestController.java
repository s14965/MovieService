package pj.pjatk.szymaj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieServiceRestController {

    MovieList movieList = MovieList.getInstance();

    @GetMapping("")
    public ResponseEntity<List<Movie>> getMovieList() {
        return ResponseEntity.ok(movieList.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id) {
        Movie movie = movieList.getMovie(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    //Nie dziala
    @PostMapping("")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        if(movie == null || movie.getId() > 0) {
            return ResponseEntity.badRequest().build();
        }
        else {
            movieList.addMovie(movie);
            return ResponseEntity.ok(movie);
        }
    }
/*
    @PutMapping("/put/{pathVariable}")
    public ResponseEntity<Object> putPV(@PathVariable Object pathVariable) {
        return ResponseEntity.ok(pathVariable);
    }

    @DeleteMapping("/delete/{pathVariable}")
    public ResponseEntity<Object> deletePV(@PathVariable Object pathVariable) {
        return ResponseEntity.ok(null);
    }
*/
}