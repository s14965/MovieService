package pj.pjatk.szymaj;

import pj.pjatk.szymaj.Category;

public class Movie {

    long id;
    String name;
    Category category;

    public Movie(long i, String n, Category c){
        id = i;
        name = n;
        category = c;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}