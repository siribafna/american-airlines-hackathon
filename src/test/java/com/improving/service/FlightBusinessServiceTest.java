package com.improving.service;

import com.improving.client.FlightClient;
import com.improving.domain.Airport;
import com.improving.domain.Duration;
import com.improving.domain.Flight;
import com.improving.domain.Intinery;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightBusinessServiceTest {


    //Mockito.mock(Object)
    /**
     * Mockito.when(Object.doesSomething).return(customresponse)
     */
    FlightClient flightClient = Mockito.mock(FlightClient.class);
    FlightBusinessService fbservice = new FlightBusinessService(flightClient);


    @Test
    public void test_noflights() {

        Mockito.when(flightClient.getFlights(Mockito.anyString())).thenReturn(new LinkedList<Flight>());
        List<Intinery> result = fbservice.getLongestFlight("DFW", "ORD", "2019-12-09");
        assertTrue(result.isEmpty());

    }
    @Test
    public void test_only_origin_flights() {

        //What Client Returns
        Mockito.when(flightClient.getFlights("2019-12-09")).thenReturn(get3Flights());
        //Actual Service Call
        List<Intinery> result = fbservice.getLongestFlight("DFW", "ORD", "2019-12-09");
        assertTrue(result.size() == 2);

    }


    private List<Flight> get3Flights(){

        /**
         * DFW -> ORD - 5 hours
         * DFW -> SFO - 3 hour
         * SFO -> ORD - 6 hours
         *
         */
        LinkedList flights = new LinkedList<Flight>();
       flights.add(getNewFlight("DFW","ORD", 5, 0));
       flights.add(getNewFlight("DFW","SFO", 3, 0));
        flights.add(getNewFlight("SFO","ORD", 6, 0));


        return flights;
    }

    private Flight getNewFlight(String origin, String destination, int hours, int minutes){
        Flight newFlight = new Flight();


        newFlight.setOrigin(new Airport());
        newFlight.setDestination(new Airport());
        newFlight.getOrigin().setCode(origin);
        newFlight.getDestination().setCode(destination);
        newFlight.setDuration(new Duration());
        newFlight.getDuration().setMinutes(minutes);
        newFlight.getDuration().setLocale(null);
        newFlight.getDuration().setHours(hours);

        return newFlight;
    }

}
