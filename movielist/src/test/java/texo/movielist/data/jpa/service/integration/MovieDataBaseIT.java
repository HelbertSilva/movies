/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package texo.movielist.data.jpa.service.integration;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import texo.movielist.data.jpa.domain.Movie;
import texo.movielist.data.jpa.service.MovieRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class MovieDataBaseIT {

	@Autowired
    private MovieRepository repository;

	@Test
	@DisplayName("Teste de Integração com o Bando de Dados")
	public void integrationDataBaseTest() {

		Movie movie = new Movie();
		
		movie.setYear(2000);
		movie.setTitle("a");
		movie.setStudios("a");
		movie.setProducer("a");
		movie.setWinner("a");
		
		repository.save(movie);
		
		List<Movie> movies = this.repository.findAll();

		Assertions.assertNotNull(movies);
	}
	
}