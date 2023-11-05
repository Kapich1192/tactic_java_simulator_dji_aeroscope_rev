package com.tactic.tactic_java_simulator_dji_aeroscope_rev.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String getDashboard() {
        return "dashboard";
    }
}
