package texo.movielist.resources;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import texo.movielist.data.jpa.MovieResponse;
import texo.movielist.data.jpa.MovieWinner;
import texo.movielist.data.jpa.domain.Movie;
import texo.movielist.data.jpa.service.MovieRepository;

@RestController
public class MovieAwardsIntervalResource {

    private MovieRepository repository;

    public MovieAwardsIntervalResource(MovieRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping(path="/awardsinterval")
    MovieResponse awardsInterval () {
    	MovieResponse awardsInterval = new MovieResponse();
    	awardsInterval.setMin(min());
    	awardsInterval.setMax(max());
    	return awardsInterval;
    }

	@GetMapping(path="/max")
    List<MovieWinner> max () {

		List<MovieWinner> listOr = new ArrayList<MovieWinner>();
		listOr = orderByInterval ();

		List<MovieWinner> list = new ArrayList<MovieWinner>();
    	int max = listOr.get(listOr.size() -1).getInterval();
    	
		for(MovieWinner m : listOr) {
			if(m.getInterval() == max) {
				list.add(m);
			}
		}

    	return list;
    }
    
    @GetMapping(path="/min")
    List<MovieWinner> min () {

		List<MovieWinner> listOr = new ArrayList<MovieWinner>();
		listOr = orderByInterval ();

		List<MovieWinner> list = new ArrayList<MovieWinner>();
    	int min = listOr.get(0).getInterval();
    	
		for(MovieWinner m : listOr) {
			if(m.getInterval() == min) {
				list.add(m);
			}
		}

    	return list;
    }
    
    public List<MovieWinner> orderByInterval (){
    	
    	List<Movie> movies = repository.findAll();

    	List<Movie> movieWinners = onlyWinners(movies);

    	List<MovieWinner> list = new ArrayList<MovieWinner>();
    	
    	for(Movie mx : movieWinners) {
    		for(Movie my : movieWinners) {
    			
    			if(mx.getProducer().equals(my.getProducer()) && mx.getYear() < my.getYear()) {
    				MovieWinner mw = null;

    				mw = new MovieWinner(mx.getProducer(), 
    						my.getYear() - mx.getYear(),
    						my.getYear(),
    						mx.getYear());

    				list.add(mw);
    				break;
    			}
    			
    		}
    	}

    	Collections.sort(list);

    	return list;
    }
    
    public List<Movie> onlyWinners (List<Movie> movieList){
    	List<Movie> movieWinners = new ArrayList<Movie>();
    	for(Movie m : movieList) {
    		if(m.getWinner() != null) {
    			movieWinners.add(m);
    		}
    	}
    	return movieWinners;
    }

}