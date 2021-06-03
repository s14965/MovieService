package pj.pjatk.szymaj.movie;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    private static MovieList instance;
    private List<Movie> movieList = new ArrayList<>();

    private MovieList(){

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
        getMovie(id).setTitle(movie.getTitle());
        getMovie(id).setCategory(movie.getCategory());
    }
}
