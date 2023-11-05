package com.tactic.tactic_java_simulator_dji_aeroscope_rev.service.schedulers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class PrintLogScheduler {
    @Scheduled(fixedRate = 1000l)
    public void printLog() {

    }
}
