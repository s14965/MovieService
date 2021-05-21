package pj.pjatk.szymaj;

import pj.pjatk.szymaj.Category;

public class Movie {

    long id = 0;
    String name;
    Category category;
    public Movie(){}
    public Movie(String n, Category c){
        name = n;
        category = c;
    }
    public Movie(long i, String n, Category c){
        id = i;
        name = n;
        category = c;
    }

    public long getId() {
        return id;
    }
    public void setId(long i){
        id = i;
    }
    public String getName() {
        return name;
    }
    public void setName(String s) {
        name = s;
    }
    public Category getCategory() {
        return category;
    }
    public  void setCategory(Category c){
        category = c;
    }
}