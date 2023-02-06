package cinema.controller;

import cinema.repo.StatsRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/stats")
public class StatsController {
    Logger logger = Logger.getAnonymousLogger();

    @PostMapping
    ResponseEntity<String> getStats(@RequestParam (value = "password",required = false) String password){
        logger.warning("Reached");
        if (Objects.equals(password, "super_secret")) {
            return ResponseEntity.ok(StatsRepo.getInstance().toString());
        }

        return new ResponseEntity<>("{\n" +
                "    \"error\": \"The password is wrong!\"\n" +
                "}", HttpStatus.UNAUTHORIZED);
    }
}
