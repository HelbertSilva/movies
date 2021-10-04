package texo.movielist.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import texo.movielist.data.jpa.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
