package texo.movielist.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import texo.movielist.data.jpa.domain.Movie;
import texo.movielist.data.jpa.service.MovieRepository;

@RestController
@RequestMapping(path="/movies")
public class MovieResources {
	
    private final MovieRepository repository;

    public MovieResources(MovieRepository repository) {
        this.repository = repository;
    }
    
    @PostMapping
    public void save (@RequestBody Movie movie) {
    	
    	repository.save(movie);
    }

    @GetMapping
    public List<Movie> findAll () {
    	
    	return repository.findAll();
    	
    }
    
    @GetMapping(path="/{id}")
    public Optional<Movie> findById (Long id) {
    	
    	return repository.findById(id);
    	
    }
    
    @DeleteMapping(path="/{id}")
    public void deleteById (@RequestBody Long id) {
    	
    	repository.deleteById(id);
    	
    }
    
    @PutMapping(path="/{id}")
    public void update (@RequestBody Long id, Movie newMovie) {
    	/*
    	Movie m = repository.findById(id)
    			.map(movie -> { movie.setYear(newMovie.getYear());
    			movie.setTitle(newMovie.getTitle());
    			movie.setProducer(newMovie.getProducer());
    			movie.setStudios(newMovie.getStudios());
    			movie.setYear(newMovie.getYear());});
    	repository.save(m);
    	*/
    }

}
