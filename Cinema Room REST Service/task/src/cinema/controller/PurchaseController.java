package cinema.controller;

import cinema.model.BookedSeat;
import cinema.model.PurchasedSeat;
import cinema.model.Seat;
import cinema.model.SeatUnit;
import cinema.repo.StatsRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    StatsRepo repo = StatsRepo.getInstance();

    List<String> purchasedSeats = new ArrayList<String>();
    PurchasedSeat purchasedSeat = new PurchasedSeat();
    BookedSeat bookedSeat = BookedSeat.getInstance();
    HashMap<String, SeatUnit> hashTempo = new HashMap<>();


    @PostMapping()
    ResponseEntity<String> successResponse(@RequestBody SeatUnit seatUnit) {
        Seat.addAvailableSeats();
        if (purchasedSeats.contains("Seat No" + seatUnit.getRow() + seatUnit.getColumn())) {
            return new ResponseEntity<>("{\"error\": \"The ticket has been already purchased!\"}", HttpStatus.BAD_REQUEST);
        }

        if (seatUnit.getColumn() <= 9 && seatUnit.getColumn() > 0 && seatUnit.getRow() <= 9 && seatUnit.getRow() > 0) {

            purchasedSeats.add("Seat No" + seatUnit.getRow() + seatUnit.getColumn());
            SeatUnit returnSeat = new SeatUnit();
            returnSeat.setRow(seatUnit.getRow());
            returnSeat.setColumn(seatUnit.getColumn());
            returnSeat.setPrice();
            UUID randomTokenTempo = UUID.randomUUID();

            purchasedSeat.setToken(randomTokenTempo);
            purchasedSeat.setSeatUnit(returnSeat);
            hashTempo.put(randomTokenTempo.toString(), returnSeat);
            bookedSeat.setBookedSeats(hashTempo);

            repo.setNumberOfPurchasedTickets(repo.getNumberOfPurchasedTickets()+ 1);
            repo.setNumberOfAvailableSeats(repo.getNumberOfAvailableSeats() -1);
            repo.setCurrentIncome(repo.getCurrentIncome() + returnSeat.getPrice());


            return ResponseEntity.ok(purchasedSeat.toString());
        }

        return new ResponseEntity<>("{\"error\": \"The number of a row or a column is out of bounds!\"}", HttpStatus.BAD_REQUEST);
    }
}
