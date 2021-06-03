package pj.pjatk.szymaj.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.id = ?1")
    Movie findBy(Long id);
    @Query("select m from Movie m where m.title = ?1")
    List<Movie> findByTitle(String name);
    @Query("select m from Movie m where m.category = ?1")
    List<Movie> findByCategory(Category category);
    @Query("select m from Movie m where m.isavailable = ?1")
    List<Movie> findByAvailable(boolean isavailable);
}
