package cinema.controller;


import cinema.model.BookedSeat;
import cinema.model.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/return")
public class ReturnController {
    BookedSeat bookedSeat = BookedSeat.getInstance();

    Logger logger = Logger.getAnonymousLogger();


    @PostMapping
    ResponseEntity<String> refund(@RequestBody Token token)  {

        if (bookedSeat.getBookedSeats().containsKey(token.getToken())) {

            String response = "{"+bookedSeat.getBookedSeats().get(token.getToken()).toString("returned_ticket") + "}";
            bookedSeat.getBookedSeats().remove(token.getToken());
            return ResponseEntity.ok(response);

        }


        return new ResponseEntity<>("""
                {
                    "error": "Wrong token!"
                }""", HttpStatus.BAD_REQUEST);
    }


}
