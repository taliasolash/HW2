public class RentalSystem {
    private int numOfMovies;
    private int numOfDirectors;
    private Movie[] movies;
    private Director[] directors;
    private static final int maxMovies = 30;
    private static final int maxCustomers = 30;
    private Customers[] customers;
    private int numOfCustomers;

    public RentalSystem() {
        this.numOfMovies = 0;
        this.movies = new Movie[maxMovies];
        this.directors = new Director[maxMovies];
        this.customers = new Customers[maxCustomers];
        this.numOfCustomers = 0;
    }

    private Director findDirector(String directorName) {
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].getDirector().getName().equals(directorName)) {
                return movies[i].getDirector();
            }
        }
        return null;
    }

    public void addMovie(String title, Genre genre, int releaseYear, String directorName, String biography) {
        if (numOfMovies >= maxMovies) {
            System.out.println("Cannot add more movies.");
            return;
        }
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].isSameMovie(title, releaseYear, directorName)) {
                System.out.println("Movie is already in the system.");
                return;
            }
        }
        Director director = findDirector(directorName);
        if (director == null) {
            director = new Director(directorName, biography);
        }
        Movie movie = new Movie(title, releaseYear, director, genre);
        movies[numOfMovies] = movie;
        numOfMovies++;
    }

    private int findMovieIndex(String title, int releaseYear, String directorName) {
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].isSameMovie(title, releaseYear, directorName)) {
                return i;
            }
        }
        return -1;

    }

    public void removeMovie(String title, int releaseYear, String directorName) {
        int movieIndex = findMovieIndex(title, releaseYear, directorName);
        if (movieIndex == -1) {
            System.out.println("No such movie exists.");
            return;
        }
        Movie movieToRemove = movies[movieIndex];
        if (movieToRemove.getIsRented()) {
            System.out.println("Cannot remove a rented movie");
            return;
        }
        movies[movieIndex] = movies[numOfMovies - 1];
        movies[numOfMovies - 1] = null;
        numOfMovies--;
    }

    private Customers findCustomer(String customerId) {
        for (int i = 0; i < numOfCustomers; i++) {
            if (customers[i].isSameCustomer(customerId)) {
                return customers[i];
            }
        }
        return null;
    }
    public void rentMovie(String customerName,
                          String customerId,
                          String title,
                          int releaseYear,
                          String directorName) {
        int movieIndex = findMovieIndex(title, releaseYear, directorName);
        if (movieIndex == -1) {
            System.out.println("No Such movie exists");
            return;
        }
        Movie movie = movies[movieIndex];
        Customers customer = findCustomer(customerId);
        if (customer == null) {
            if (numOfCustomers >= maxCustomers) {
                System.out.println("No room for new customers");
                return;
            }
            customer = new Customers(customerName, customerId);
            customers[numOfCustomers] = customer;
            numOfCustomers++;
        }
        if (customer.hasMovie(movie)) {
            System.out.println("Customer already has this movie.");
            return;
        }
        if (!customer.canRentMoreMovies()) {
            System.out.println("The customer has reached the limit");
            return;
        }
        customer.addMovie(movie);
    }
}

