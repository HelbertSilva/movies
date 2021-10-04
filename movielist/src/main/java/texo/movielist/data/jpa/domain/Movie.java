package texo.movielist.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "YEAR", nullable = true)
	public int year;
	
	@Column(name = "TITTLE", length = 1000, nullable = true)
	public String title;
	
	@Column(name = "STUDIOS", length = 1000, nullable = true)
	public String studios;
	
	@Column(name = "PRODUCER", length = 1000, nullable = true)
	public String producer;
	
	@Column(name = "WINNER", length = 50, nullable = true)
	public String winner;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStudios() {
		return studios;
	}
	
	public void setStudios(String studios) {
		this.studios = studios;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}

}
