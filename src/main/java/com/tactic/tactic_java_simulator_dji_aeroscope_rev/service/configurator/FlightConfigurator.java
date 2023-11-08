package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.Flight;

import java.io.*;
import java.util.UUID;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

public interface FlightConfigurator {
    default void initFlight() {
        Flight flight = new Flight();
        flight.setSn(UUID.randomUUID().toString().substring(0,7).toUpperCase());
        //flight.setSn("");
        flight.setCurrentLatitude(0.6546);
        flight.setCurrentLongitude(0.656546);
        app.getFlights().add(flight);
        String path = "flights/";
        ObjectMapper mapper = new ObjectMapper();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + "Flight_" + flight.getSn() + ".log")));
            String temp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(flight);
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default boolean loadFlights() {
        new File("flights").mkdirs();
        String[] list = new File("flights").list();
        if (list != null && list.length > 0) {
            File file = new File("flights/" + list[0]);

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String res = "";
                String temp = "";
                while (temp != null) {
                    temp = reader.readLine();
                    if(temp != null) {
                        res += temp;
                    }
                }
                ObjectMapper mapper = new ObjectMapper();
                Flight flight = mapper.readValue(res,Flight.class);
                flight.setTimeDetected(System.currentTimeMillis() / 1000 + "");
                app.getFlights().add(flight);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    default void saveFlight() {

    }
}
