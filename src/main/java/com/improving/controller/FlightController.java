package com.improving.controller;

import com.improving.domain.Airport;
import com.improving.domain.Duration;
import com.improving.domain.Flight;
import com.improving.client.FlightClient;
import com.improving.domain.Intinery;
import com.improving.service.FlightBusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class FlightController {

    FlightClient flightClient;
    //FlightService

    FlightBusinessService service;

    public FlightController(FlightBusinessService service) {
        this.service = service;
    }

    @GetMapping("flights")
    public @ResponseBody
    List<Intinery> flights(@RequestParam String origin, @RequestParam String destination, @RequestParam String date) {
        return service.getLongestFlight(origin, destination, date);
    }


    @GetMapping("stubItins")
    public @ResponseBody
    List<Intinery> stubItins(@RequestParam String origin, @RequestParam String destination, @RequestParam String date){


        return stub();
    }

    private List<Intinery> stub() {
        List<Intinery> list = new LinkedList<Intinery>();

        list.add(getNewItin());
        list.add(getNewItin());
        list.add(getNewItin());
        list.add(getNewItin());
        return list;
    }

    private Intinery getNewItin() {
        Intinery itin = new Intinery();
        itin.setListOfFlights(new LinkedList<Flight>());
        itin.getListOfFlights().add(getNewFlight());
        itin.getListOfFlights().add(getNewFlight());


        return itin;

    }

    private Flight getNewFlight() {
        Flight flight = new Flight();
        flight.setOrigin(new Airport());
        flight.setDestination(new Airport());
        flight.setDuration(new Duration());
        flight.setArrivalTime("TIME");
        flight.setDepartureTime("TIME");
        flight.getOrigin().setCode("ORD");
        flight.getOrigin().setCity("Chicago");
        flight.getDestination().setCode("DFW");
        flight.getDestination().setCity("Dallas");
        return flight;
    }

}