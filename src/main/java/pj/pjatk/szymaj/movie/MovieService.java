package pj.pjatk.szymaj.movie;
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
    public void addMovie(Movie m){
        movieRepository.save(m);
    }
    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }
    public Movie getMovie(Long id){
        return movieRepository.findById(id).orElseThrow();
    }
    public void updateMovie(Long id, Movie movie) {
        Movie m = movieRepository.findById(id).orElseThrow();
        m.setTitle(movie.getTitle());
        m.setCategory(movie.getCategory());
    }
}
