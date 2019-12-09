package com.improving.client;


import com.improving.domain.Flight;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightClient{


    RestTemplate restTemplate;


    FlightClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public List<Flight> getFlights(String date){
        Flight[] flights = restTemplate.getForObject("https://aa-flight-engine-hack.herokuapp.com/flights?date="+date, Flight[].class);
       // System.out.println(flights.length);
        return Arrays.asList(flights);
    }
}

