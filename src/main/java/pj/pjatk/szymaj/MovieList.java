package pj.pjatk.szymaj;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    private static MovieList instance;
    private List<Movie> movieList = new ArrayList<Movie>();

    private MovieList(){
        movieList.add(new Movie(1, "Batman", Category.Action));
        movieList.add(new Movie(2, "Nic Smiesznego", Category.Comedy));
        movieList.add(new Movie(3, "Shrek", Category.etc));
    }
    public static MovieList getInstance(){
        if (instance == null) {
            instance = new MovieList();
        }
        return instance;
    }

    public List<Movie> getList() {
        return movieList;
    }
    public void addMovie(Movie m){
        m.setId(movieList.size()+1);
        movieList.add(m);
    }
    public void deleteMovie(long id){
        movieList.remove(getMovie(id));
    }
    public Movie getMovie(long id){
        Movie movie = null;
        for(Movie m: movieList){
            if(id == m.getId()){
                movie = m;
                break;
            }
        }
        return movie;
    }

    public void updateMovie(long id, Movie movie) {
        getMovie(id).setName(movie.getName());
        getMovie(id).setCategory(movie.getCategory());
    }
}
