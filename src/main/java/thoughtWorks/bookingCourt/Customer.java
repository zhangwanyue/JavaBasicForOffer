package thoughtWorks.bookingCourt;

public class Customer {
    String userID;
    int year;
    int month;
    int day;
    int startClock;
    int endClock;
    String place;

    public Customer(String id, int year, int month, int day, int startClock, int endClock, String placa) {
        this.userID = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.startClock = startClock;
        this.endClock = endClock;
        this.place = placa;
    }

    public boolean isIDEuqal(Customer c) {
        if (this.userID.equals(c.userID))
            return true;
        return false;
    }

    public boolean isDateEqual(Customer c) {
        if (this.year == c.year && this.month == c.month && this.day == c.day)
            return true;
        return false;
    }

    public boolean isPlaceEqual(Customer c) {
        if (this.place.equals(c.place))
            return true;
        return false;
    }

    public boolean isEqual(Customer c) {
        if (this.userID.equals(c.userID) && this.year == c.year && this.month == c.month && this.day == c.day && this.startClock == c.startClock && this.endClock == c.endClock)
            return true;
        return false;
    }

    public boolean isTimeConflict(Customer c) {
        if (isDateEqual(c) &&
                ((this.startClock < c.startClock && this.endClock < c.endClock && this.endClock > c.startClock)
                        || (this.startClock > c.startClock && this.startClock < c.endClock && this.endClock > c.startClock && this.endClock < c.endClock)
                        || (this.startClock > c.startClock && this.startClock < c.endClock && this.endClock > c.endClock)
                        || (c.startClock < this.startClock && c.endClock < this.endClock && c.endClock > this.startClock)
                        || (c.startClock > this.startClock && c.startClock < this.endClock && c.endClock > this.startClock && c.endClock < this.endClock)
                        || (c.startClock > this.startClock && c.startClock < this.endClock && c.endClock > this.endClock))
                && isPlaceEqual(c))
            return true;
        return false;
    }
}
