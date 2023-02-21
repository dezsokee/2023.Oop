package oop.labor02;

public class Movie {
    private static String title;
    private static String director;
    private static int releaseYear;
    private double rating;
    private Genre genre;

    public Movie(String title, String director, int releaseYear, double rating, Genre genre)
    {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
    }

    public static String getTitle() {
        return title;
    }

    public static String getDirector() {
        return director;
    }

    public static int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return this.rating;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString()
    {
        String returned_String = title+"("+String.valueOf(releaseYear)+") directed by "+director+", rating: "+rating+", genre: "+genre;
        return returned_String;
    }
}
