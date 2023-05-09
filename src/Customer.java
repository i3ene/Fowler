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
        Enumeration<Rental> enumRentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for ");
        result.append(this.getName()).append("\n");
        result.append("\t").append("Title").append("\t\t").append("Days").append("\t").append("Amount").append("\n");

        while (enumRentals.hasMoreElements()) {
            Rental each = enumRentals.nextElement();
            // show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t\t").append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
        }
        
        // add footer lines
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
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

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
