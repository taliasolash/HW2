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

    public Director getDirector() {
        return this.director;
    }
    public String printMovie(){
        return ("Title: "+this.title+", Genre: "+this.genre+", Year: "+this.releaseYear+", director: "+ director.getName());
    }
    public Boolean getIsRented(){
        return isRented;
    }
    public boolean isSameMovie(String title,int releaseYear, String directorName){
        return this.title.equals(title) && this.releaseYear == releaseYear&& this.director.getName().equals(directorName);
    }
    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }
}




