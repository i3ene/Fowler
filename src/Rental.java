class Rental {
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
        double total = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                total += 2;
                if (this.getDaysRented() > 2)
                    total += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                total += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                total += 1.5;
                if (this.getDaysRented() > 3)
                    total += (this.getDaysRented() - 3) * 1.5;
                break;
            default:
                System.out.println("Error in Switchcase");
                break;
        }
        return total;
    }

    public int getFrequentRenterPoints() {
        return this.movie.getFrequentRenterPoints(this.daysRented);
    }
}