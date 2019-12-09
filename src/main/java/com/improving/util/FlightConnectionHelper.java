package com.improving.util;

import com.improving.domain.Flight;
import com.improving.domain.Intinery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlightConnectionHelper {



    List<Intinery> intineries = new LinkedList<Intinery>();


    public List<Intinery> getLongestFlight(String origin, String destination, String date, List<Flight> flights){

            for(Flight e: flights) {
            if(e.getOrigin().getCode().equals(origin) && e.getDestination().getCode().equals(destination)) {
                List<Flight> newFlights = new ArrayList<>();
                newFlights.add(e);
                Intinery itin = new Intinery();
                itin.setListOfFlights(newFlights);
                intineries.add(itin);
            }
            else if(e.getOrigin().getCode().equals(origin)) {
                List<Flight> newFlights = new LinkedList<Flight>();
                newFlights.add(e);
                getLongestFlightHelper(newFlights, e.getDestination().getCode(), destination, flights);
            }


        }

        return intineries;
}


    public void getLongestFlightHelper(List<Flight> newFlights, String newOrigin, String destination, List<Flight> flights){
        String arrivalTimeToConnection = newFlights.get(newFlights.size()-1).getArrivalTime();
        for(Flight e: flights) {
            boolean paxHasEnoughTime = TimeUtil.timeIsBefore(arrivalTimeToConnection, e.getDepartureTime());

            if(e.getOrigin().getCode().equals(newOrigin) && e.getDestination().getCode().equals(destination) && paxHasEnoughTime) {
                List<Flight> itinFlights = new LinkedList<Flight>();
                itinFlights.addAll(newFlights);
                itinFlights.add(e);
                Intinery itin = new Intinery();
                itin.setListOfFlights(itinFlights);
                intineries.add(itin);
            }
            else if(e.getOrigin().getCode().equals(newOrigin) && paxHasEnoughTime) {
                List<Flight> itinFlights = new LinkedList<Flight>();
                itinFlights.addAll(newFlights);
                itinFlights.add(e);
                getLongestFlightHelper(itinFlights, e.getDestination().getCode(), destination, flights);
            }
        }
    }


    /**
     *  Direct Flight - Add
     *  If its an Origin, keep it in mind
     *
     *
     */
}
