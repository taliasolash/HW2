public class RentalSystem {
    private int numOfMovies;
    private int numOfDirectors;
    private Movie[] movies;
    private Director[] directors;
    private static final int maxMovies = 30;

    public RentalSystem() {
        this.numOfMovies = 0;
        this.movies = new Movie[maxMovies];
        this.directors = new Director[maxMovies];
    }

    public void addMovie(String title, int releaseYear, Director director, Genre genre) {
        Movie movie = new Movie(title,releaseYear, director, genre);
        boolean isDirectorExist = false;
        for (int i = 0; i < this.numOfMovies; i++) {
            if (movie.equals(this.movies[i])) {
                System.out.println("Movie is already in the system.");
                break;
            }
            if (director.isExist(this.movies[i].getDirector().getName(), this.movies[i].getDirector().getBiography()) == true) {
                isDirectorExist = true;
            }
        }
        if (!isDirectorExist) {
            directors[numOfDirectors] = director;
            numOfDirectors ++;
        }
        if (this.numOfMovies >= maxMovies) {
            System.out.println("Cannot add more movies.");
        } else {
            this.movies[this.numOfMovies] = movie;
            this.numOfMovies ++;
        }
    }
    private int findMovieIndex (String title, int releaseYear, Director director){
        M
        for (int i=0; i<numOfMovies; i++){
            if (movies[i].equals()){
                return i;
            }
        } return -1;

    }
    public void removeMovie(String title, int releaseYear, Director director){
        int movieIndex=findMovieIndex();
        if (movieIndex==-1){
            System.out.println("No such movie exist.");
        }
        Movie movieToRemove=movies(movieIndex);
        if (movieToRemove.getIsRented()){
            System.out.println("Cannot remove a rented movie");
        }
        movies[movieIndex]=movies[numOfMovies-1];
        movies[numOfMovies-1]=null;
        numOfMovies--;




    }

    private Movie movies(int movieIndex) {
    }
}
