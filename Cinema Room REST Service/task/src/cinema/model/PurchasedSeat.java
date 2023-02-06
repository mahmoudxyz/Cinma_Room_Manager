package cinema.model;
import java.util.UUID;

public class PurchasedSeat {
    private UUID token;
    private SeatUnit seatUnit;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public SeatUnit getSeatUnit() {
        return seatUnit;
    }

    public void setSeatUnit(SeatUnit seatUnit) {
        this.seatUnit = seatUnit;
    }

    @Override
    public String toString() {
        return "{" +
                '"'+ "token"+ '"'+  ":" + '"'+token +'"' + "," +
                seatUnit.toString("ticket") +
                '}';
    }
}
