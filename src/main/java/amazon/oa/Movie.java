package amazon.oa;

import java.util.*;

public class Movie {
    int movieId;
    float rating;
    List<Movie> similarMovies;

    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        this.similarMovies = new ArrayList<>();
    }

    static List<Movie> findSimilarMovies(Movie movie, int num, Movie[] movies) {
        Queue<Movie> similars = new PriorityQueue<>(num, (m1, m2) -> {
            if (m1.rating == m2.rating)
                return 0;
            else if (m1.rating > m2.rating)
                return 1;
            else
                return -1;
        });

        Set<Integer> visited = new HashSet<>();
        visited.add(movie.movieId);
        Queue<Movie> q = new LinkedList<>();
        q.offer(movie);

        while (!q.isEmpty()) {
            Movie v = q.poll();

            for (Movie m : v.similarMovies) {
                if (visited.add(m.movieId)) {
                    similars.offer(m);
                    if (similars.size() > num)
                        similars.poll();
                    q.offer(m);
                }
            }
        }

        List<Movie> ans = new ArrayList<>(similars);

        System.out.println(ans);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            list.add(ans.get(i).movieId);
        }
        System.out.println(list);

        return ans;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append(movieId).append(", ").append(rating);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Movie[] movies = new Movie[8];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = new Movie(i + 1, 1.2F);
        }
        movies[0].rating = 6.2F;
        movies[1].rating = 3.6F;
        movies[2].rating = 2.4F;
        movies[3].rating = 9.8F;
        movies[4].rating = 5.1F;
        movies[5].rating = 8.4F;
        movies[6].rating = 8.4F;
        movies[7].rating = 8.0F;

        movies[0].similarMovies.add(movies[1]);
        movies[0].similarMovies.add(movies[2]);
        movies[0].similarMovies.add(movies[3]);

        movies[1].similarMovies.add(movies[4]);
        movies[1].similarMovies.add(movies[0]);
        movies[2].similarMovies.add(movies[4]);

        movies[3].similarMovies.add(movies[5]);
        movies[3].similarMovies.add(movies[6]);

        movies[6].similarMovies.add(movies[7]);

        findSimilarMovies(movies[0], 14, movies);
    }
}
