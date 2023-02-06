package cinema.repo;

public class StatsRepo {
    private int currentIncome = 0;
    private int numberOfAvailableSeats =81;
    private int numberOfPurchasedTickets =0;

    private StatsRepo(){

    }
    private static StatsRepo INSTANCE;

    public static StatsRepo getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new StatsRepo();
        }
        return INSTANCE;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @Override
    public String toString() {
        return "{" +
                "current_income" + ':'+ currentIncome +
                ", number_of_available_seats" + ':'+ numberOfAvailableSeats +
                ", number_of_purchased_tickets" + ':'+ numberOfPurchasedTickets +
                '}';
    }
}
