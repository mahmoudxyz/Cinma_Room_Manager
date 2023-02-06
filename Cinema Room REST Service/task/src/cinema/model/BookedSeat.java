package cinema.model;

import java.util.HashMap;
import java.util.UUID;

public class BookedSeat {
    HashMap<String,SeatUnit> bookedSeats = new HashMap<>();
    private static BookedSeat bookedSeatInstance;
    private BookedSeat(){

    }
    public static BookedSeat getInstance(){
        if (bookedSeatInstance == null) {
            bookedSeatInstance = new BookedSeat();
        }
        return bookedSeatInstance;
    }

    public static BookedSeat getBookedSeatInstance() {
        return bookedSeatInstance;
    }



    public HashMap<String, SeatUnit> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(HashMap<String, SeatUnit> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
