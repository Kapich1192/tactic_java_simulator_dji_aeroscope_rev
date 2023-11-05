package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.configurator;

public interface Configurator {
    default void initConfigure() {

    }

    default boolean loadConfigure() {
        return true;
    }

    default void saveConfigure() {

    }

}
