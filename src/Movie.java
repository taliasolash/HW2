public class Movie {
    private String title;
    private int releaseYear;
    private Director director;
    private Genre genre;
    private Boolean isRented;

    public Movie(String title, int releaseYear, Director director, Genre genre){
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
        this.isRented = false;
    }
    public String printMovie(){
        return ("Title: "+this.title+" Year: "+this.releaseYear+" director: "+ director);
    }
    @Override
    public boolean equals(Movie movie) {
        if ()
    }

    public Director getDirector() {
        return this.director;
    }
    public Boolean getIsRented(){
        return isRented;
    }
    public boolean isSameMovie(String title,int releaseYear, String directorName){
        return this.title.equals(title) && this.releaseYear == releaseYear&& this.director.getName().equals(directorName);
    }
}




