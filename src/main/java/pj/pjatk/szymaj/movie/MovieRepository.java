package pj.pjatk.szymaj.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findBy(Long id);
    List<Movie> findByName(String name);
    List<Movie> findByCategory(Category category);
    List<Movie> findByAvailability(boolean isavailable);
}
