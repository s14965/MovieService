package pj.pjatk.szymaj.movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getList() {
        return movieRepository.findAll();
    }
    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }
    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }
    public Movie getMovie(Long id){
        Movie m = null;
        try {
            return movieRepository.findById(id).get();
        }
        catch(Exception e) {
            return m;
        }

    }
    public void updateMovie(Long id, Movie movie) {
        Movie m = movieRepository.findById(id).orElseThrow();
        if (movie.getTitle() != null)
            m.setTitle(movie.getTitle());
        if (movie.getCategory() != null)
            m.setCategory(movie.getCategory());
        movieRepository.save(m);
    }

    public void makeAvailable(Long id) {
        Movie m = getMovie(id);
        if (m != null)
            m.setAvailable(true);
        movieRepository.save(m);
    }
}
