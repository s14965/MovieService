package pj.pjatk.szymaj.movie;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    private boolean isavailable = false;

    public Movie(){}

    public Movie(String n, Category c){
        id = Long.valueOf(0);
        title = n;
        category = c;
    }
    public Movie(Long i, String n, Category c){
        id = i;
        title = n;
        category = c;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long i){
        id = i;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String s) {
        title = s;
    }
    public Category getCategory() {
        return category;
    }
    public  void setCategory(Category c){
        category = c;
    }

    public boolean isAvailable() {
        return isavailable;
    }

    public void setAvailable(boolean available) {
        isavailable = available;
    }
}