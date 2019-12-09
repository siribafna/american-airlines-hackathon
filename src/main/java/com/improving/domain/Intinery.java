package com.improving.domain;

import java.util.List;

public class Intinery {

    private List<Flight> listOfFlights;

    public List<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public void setListOfFlights(List<Flight> listOfFlights) {
        this.listOfFlights = listOfFlights;
    }

    public int getTotalTime(){
        int totalTime = 0;
        for(Flight f: listOfFlights){
            totalTime += f.getDuration().getTotalTime();
        }
        return totalTime;
    }
}
