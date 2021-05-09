package pj.pjatk.szymaj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import pj.pjatk.szymaj.Category;

@RestController
@RequestMapping("/movies")
public class MovieServiceRestController<> {


    Movie batman = new Movie(1,"Batman", Category.Action);
    Movie nicsmiesznego = new Movie(2,"Nic Smiesznego", Category.Comedy);
    Movie Shrek = new Movie(2,"Shrek", Category.etc);
    private Movie[] movieList = {batman, nicsmiesznego, Shrek};


    @GetMapping("")
    public ResponseEntity getMovieList() {
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovie(@PathVariable Object id) {
        return ResponseEntity.ok(id);
    }
/*
    @PostMapping("/token")
    public ResponseEntity<Object> postRB(@RequestBody Object t) {
        if(t == null) {
            return ResponseEntity.ok("null");
        }
        else{
            return ResponseEntity.ok(t);
        }
    }

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