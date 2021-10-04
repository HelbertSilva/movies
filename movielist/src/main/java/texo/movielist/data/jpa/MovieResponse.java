package texo.movielist.data.jpa;

import java.util.List;

public class MovieResponse {
	
	public List<MovieWinner> min;
	public List<MovieWinner> max;

	
	public List<MovieWinner> getMin() {
		return min;
	}
	
	public void setMin(List<MovieWinner> min) {
		this.min = min;
	}
	
	public List<MovieWinner> getMax() {
		return max;
	}
	
	public void setMax(List<MovieWinner> max) {
		this.max = max;
	}
}
