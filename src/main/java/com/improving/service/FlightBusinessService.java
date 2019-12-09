package com.improving.service;

import com.improving.client.FlightClient;
import com.improving.domain.Flight;
import com.improving.domain.Intinery;
import com.improving.util.FlightConnectionHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class FlightBusinessService {
    FlightClient flightClient;


    FlightBusinessService(FlightClient flightClient) {
        this.flightClient = flightClient;
    }

    public List<Flight> getFlightsBasedOnOriginAndDestination(String origin, String destination) {

        return null;
    }

    public List<Intinery> getLongestFlight(String origin, String destination, String date) {

        List<Flight> flights = flightClient.getFlights(date);
        List<Intinery> intineries = new FlightConnectionHelper().getLongestFlight(origin, destination, date, flights);


        return intineries;
    }
}
