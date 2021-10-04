package texo.movielist;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import texo.movielist.data.jpa.domain.Movie;
import texo.movielist.data.jpa.service.MovieRepository;

@SpringBootApplication
public class MovielistApplication {

    private static MovieRepository repository;

    public MovielistApplication(MovieRepository repository) {
        this.repository = repository;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(MovielistApplication.class, args);
		
        List<Movie> movieList = readFile();
        
        writeList(movieList);
	}

    private static List<Movie> readFile() {
		
		List<Movie> movieList = new ArrayList<Movie>();

		Path path = Paths.get("src/main/java/texo/movielist/resources/files/movielist.csv");
		
		try(BufferedReader reader = Files.newBufferedReader(path,Charset.forName("UTF-8"))){
			
			String line = null;
			
			while((line = reader.readLine()) != null) {				
								
				String[] lineTemp = line.split(";");
					
				Movie movie = new Movie();
				
				//verifica o campo year (titulo ou subtitulo, etc)
				if(isInteger(lineTemp[0])) {

					//year	title	studios	producers	winner
					movie.setYear(Integer.parseInt(lineTemp[0]));
					movie.setTitle(lineTemp[1]);
					movie.setStudios(lineTemp[2]);
					movie.setProducer(lineTemp[3]);
					if(lineTemp.length > 4) {
						movie.setWinner(lineTemp[4]);
					}
					movieList.add(movie);
				}
								
			}
			
			return movieList;
			
		}catch(IOException e) {
			
			throw new RuntimeException("Erro ao fazer a leitura do arquivo");
			
		}
		
	}
    
    private static void writeList(List<Movie> movieList) {
    	
        for(Movie m : movieList) {
        	
        	repository.save(m);
        }
        
    }
    
    public static boolean isInteger(String str) {
    	
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
