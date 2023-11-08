package com.tactic.tactic_java_simulator_dji_aeroscope_rev;

import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

@SpringBootApplication
public class TacticJavaSimulatorDjiAeroscopeRevApplication {

	public static void main(String[] args) {
		app = new App();
		if(!app.loadConfigure()) {
			app.initConfigure();
		}
		if (!app.loadFlights())
			app.initFlight();
		SpringApplication.run(TacticJavaSimulatorDjiAeroscopeRevApplication.class, args);
	}

}
