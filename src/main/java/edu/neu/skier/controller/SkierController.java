package edu.neu.skier.controller;


import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.client.model.LiftRide;
import io.swagger.client.model.ResponseMsg;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/skiers")
public class SkierController {

    private Gson gson = new Gson();
    ResponseMsg responseMsg = new ResponseMsg();
    @PostMapping("/{resortID}/seasons/{seasonID}/days/{day}/skiers/{skierId}")
    public ResponseEntity<String> createLiftRide(
            @PathVariable("resortID") Integer resortID,
            @PathVariable("seasonID") String seasonID,
            @PathVariable("day") String dayID,
            @PathVariable("skierId") Integer skierID,
            @RequestBody LiftRide liftRide) {


        if (!isValidDayID(dayID)) {
            responseMsg.setMessage("Lift ride recorded successfully");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(responseMsg));
        }
        // TODO

        // Dummy data for response body
        responseMsg.setMessage("Lift ride recorded successfully");

        // Return a 200/201 response with dummy data as response body
        return ResponseEntity.status(HttpStatus.CREATED).body(gson.toJson(responseMsg));
    }


//    @GetMapping
//    public ResponseEntity<String> getLiftDetails(HttpServletRequest request) {
//        String urlPath = request.getPathInfo();
//        if (urlPath == null || urlPath.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        String[] urlParts = urlPath.split("/");
////        if (!isUrlValid(urlParts)) {
////            return ResponseEntity.badRequest().body(gson.toJson(new ResponseMsg("invalid url")));
////        }
//
////        // Your business logic here
////
////        ResponseMsg responseMsg = new ResponseMsg("Lift ride vertical value get successfully");
//        return ResponseEntity.ok(gson.toJson(responseMsg));
//    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDayID(String dayID) {
        try {
            int day = Integer.parseInt(dayID);
            return day >= 1 && day <= 366;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
