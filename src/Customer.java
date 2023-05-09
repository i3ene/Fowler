import java.util.*;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String newname) {
        this.name = newname;
    };

    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    };

    public String getName() {
        return this.name;
    };

    public String getStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = this.rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            // determine amounts for each line
            thisAmount = each.getCharge();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
