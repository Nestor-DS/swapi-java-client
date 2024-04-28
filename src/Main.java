import com.nds.starwarsapi.FileGenerator;
import com.nds.starwarsapi.Movie;
import com.nds.starwarsapi.MovieQuery;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieQuery query = new MovieQuery();

        System.out.println("Enter the movie number: ");

        try {
            var movieNum = scanner.nextLine();
            Movie movie = query.searchMovie(Integer.valueOf(movieNum));
            System.out.println("Movie details: " + movie);
            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.saveJson(movie);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Exiting the application");
        }
    }
}
