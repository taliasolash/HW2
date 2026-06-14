public class Customer {
    private String name;
    private String id;
    private Movie[] rentedMovies;
    private int numOfRentedMovies;
    private static final int MAX_RENTED_MOVIES = 5;
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.rentedMovies = new Movie[MAX_RENTED_MOVIES];
        this.numOfRentedMovies = 0;
    }
    public boolean isSameCustomer(String id) {
        return this.id.equals(id);
    }
    public boolean canRentMoreMovies() {
        return numOfRentedMovies < MAX_RENTED_MOVIES;
    }
    public void addMovie(Movie movie) {
        rentedMovies[numOfRentedMovies] = movie;
        numOfRentedMovies++;
    }
    public boolean hasMovie(Movie movie) {
        for (int i = 0; i < numOfRentedMovies; i++) {
            if (rentedMovies[i].equals(movie)) {
                return true;
            }
        }
        return false;
    }
    public boolean removeMovie(Movie movie) {
        for (int i = 0; i < numOfRentedMovies; i++) {
            if (rentedMovies[i].equals(movie)) {
                rentedMovies[i] = rentedMovies[numOfRentedMovies - 1];
                rentedMovies[numOfRentedMovies - 1] = null;
                numOfRentedMovies--;
                return true;
            }
        }
        return false;
    }
    public boolean hasNoMovies() {
        return numOfRentedMovies == 0;
    }
}
