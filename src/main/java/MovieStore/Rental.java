package MovieStore;
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        this.movie = newmovie;
        this.daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public double getCharge() {
        return this.movie.getCharge(this.daysRented);
    }

    public int getFrequentRenterPoints() {
        return this.movie.getFrequentRenterPoints(this.daysRented);
    }
}