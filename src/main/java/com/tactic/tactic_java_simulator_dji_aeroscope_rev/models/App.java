package com.tactic.tactic_java_simulator_dji_aeroscope_rev.models;

import com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator.Configurator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class App implements Configurator {
    private HashMap<String,String> setting;
    private ArrayList<Flight> flights;

    public App() {

    }

    public HashMap<String, String> getSetting() {
        return setting;
    }

    public void setSetting(HashMap<String, String> setting) {
        this.setting = setting;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
