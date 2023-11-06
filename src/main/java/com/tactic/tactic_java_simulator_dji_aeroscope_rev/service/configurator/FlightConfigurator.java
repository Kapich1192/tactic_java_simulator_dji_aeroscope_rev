package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

public interface FlightConfigurator {
    default void initFlight() {
        Flight flight = new Flight();
        flight.setSn(UUID.randomUUID().toString().substring(0,7).toUpperCase());
        flight.setCurrentLatitude(37.6546);
        flight.setCurrentLongitude(57.656546);
        app.getFlights().add(flight);
        String path = "flights/";
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + "Flight_" + flight.getSn() + ".txt")));
            String temp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(flight);
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default boolean loadFlights() {
        return false;
    }

    default void saveFlight() {

    }
}
