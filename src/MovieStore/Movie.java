package MovieStore;
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private final int priceCode;

    public Movie(String newtitle, int newpriceCode) {
        this.title = newtitle;
        this.priceCode = newpriceCode;
    }

    public int getPriceCode() {
        return this.priceCode;
    }

    public String getTitle() {
        return this.title;
    }

    public int getFrequentRenterPoints(int days) {
        if (this.priceCode == Movie.NEW_RELEASE && days > 1)
            return 2;
        else
            return 1;
    }
}