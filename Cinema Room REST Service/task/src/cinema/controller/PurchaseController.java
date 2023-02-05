package cinema.controller;

import cinema.model.Seat;
import cinema.model.SeatUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    List<String> purchasedSeats = new ArrayList<String>();

    @PostMapping()
    ResponseEntity<String> successResponse(@RequestBody SeatUnit seatUnit){
        String returnResponse = "";
        Seat seat = Seat.getInstance();
        Seat.addAvailableSeats();
        if (purchasedSeats.contains("Seat No" + seatUnit.getRow() + seatUnit.getColumn())) {
            return new ResponseEntity<>("{\"error\": \"The ticket has been already purchased!\"}",HttpStatus.BAD_REQUEST);
        }

        if (seatUnit.getColumn() <= 9 && seatUnit.getColumn() > 0 && seatUnit.getRow() <= 9 && seatUnit.getRow() > 0) {
            List<String> list = seat.getAvailableSeats();
            returnResponse = list.get(((seatUnit.getRow() -1 ) * 9 )  + (seatUnit.getColumn() - 1));
            purchasedSeats.add("Seat No" + seatUnit.getRow() + seatUnit.getColumn() );
            return ResponseEntity.ok(returnResponse);
        }

        return new ResponseEntity<>("{\"error\": \"The number of a row or a column is out of bounds!\"}",HttpStatus.BAD_REQUEST);
    }
}
