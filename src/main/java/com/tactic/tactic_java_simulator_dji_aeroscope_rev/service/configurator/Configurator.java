package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tactic.tactic_java_simulator_dji_aeroscope_rev.models.App;

import java.io.*;

import static com.tactic.tactic_java_simulator_dji_aeroscope_rev.config.Singleton.app;

public interface Configurator {
    String pathConfigure = "configure/";
    String fileName = "simulator_config.json";
    default void initConfigure() {
        ObjectMapper mapper = new ObjectMapper();
        app.initialize();
        try {
            new File(pathConfigure).mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathConfigure + fileName)));
            String buf = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(app);
            writer.write(buf);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default boolean loadConfigure() {
        boolean result = false;
        String res = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            new File(pathConfigure).mkdirs();
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathConfigure + fileName)));
            String temp = "";
            while (temp != null) {
                temp = reader.readLine();
                if(temp != null)
                    res += temp;
            }

            app = mapper.readValue(res, App.class);
            result = true;
        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    default void saveConfigure() {
        ObjectMapper mapper = new ObjectMapper();
        new File(pathConfigure).mkdirs();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathConfigure + fileName)));
            String buf = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(app);
            writer.write(buf);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
