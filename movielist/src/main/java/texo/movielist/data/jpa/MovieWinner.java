package texo.movielist.data.jpa;

public class MovieWinner implements Comparable <MovieWinner>{
	
	public String producer;
	public Integer interval;
	public int previousWin;
	public int followingWin;

	public MovieWinner (String producer, Integer interval, int previousWin, int followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}

	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public Integer getInterval() {
		return interval;
	}
	
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	
	public int getPreviousWin() {
		return previousWin;
	}
	
	public void setPreviousWin(int previousWin) {
		this.previousWin = previousWin;
	}
	
	public int getFollowingWin() {
		return followingWin;
	}
	
	public void setFollowingWin(int followingWin) {
		this.followingWin = followingWin;
	}
	
    public String toString() {
        return this.producer+this.interval+this.previousWin+this.followingWin;
    }
    
	@Override
	public int compareTo(MovieWinner o) {
		if(this.getInterval() > o.getInterval()) {
			return 1;
		}else if(this.getInterval() < o.getInterval()) {
			return -1;
		}
		return 0;
	}

}