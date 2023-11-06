package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.schedulers;

import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.Flight;
import com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.aero_log_manager.AeroLogManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

@Service
@EnableScheduling
public class FlightManagerScheduler {
    AeroLogManager manager = new AeroLogManager();
    public static boolean action = true;
    @Scheduled(fixedRate = 1000L)
    public void changeStateFlights() {
        if(action) {
            for (Flight flight : app.getFlights()) {
                manager.printSimpleLog(flight);
            }
        }
    }
}
