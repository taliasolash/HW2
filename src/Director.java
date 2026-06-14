public class Director {
    private String name;
    private String biography;

    public Director(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public String getName() {
        return this.name;
    }
    public String getBiography() {
        return this.biography;
    }
    public boolean isExist(String name, String biography) {
        return this.name.equals(name) && this.biography.equals(biography);
    }

}
