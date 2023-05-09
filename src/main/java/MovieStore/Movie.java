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

    public double getCharge(int days) {
        double result = 0;
        switch (this.getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;
                if (days > 2)
                    result += (days - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> result += days * 3;
            case Movie.CHILDRENS -> {
                result += 1.5;
                if (days > 3)
                    result += (days - 3) * 1.5;
            }
        }
        return result;
    }
}