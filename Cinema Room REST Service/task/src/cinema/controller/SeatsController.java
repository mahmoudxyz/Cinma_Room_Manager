package cinema.controller;

import cinema.model.Seat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatsController {
    Seat seatInfo = Seat.getInstance();

    @GetMapping
    public String getSeatInfo(){

        return seatInfo.toString();
    }
}
