package com.example.termopshis.web.ui;


import com.example.termopshis.model.Formule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController = Controller + ResponseBody
@Slf4j
@RequiredArgsConstructor
public class TermostaticController {

    private final Formule formule;

//    @Autowired
//    public TermostaticController(Formule formule) {
//        this.formule = formule;
//    }
    @Bean


    @GetMapping("/termostatic")
    public String showTermo() {
        log.info("Get works");
        return "termostatic";
    }

    @PostMapping("/termostatic")
    @ResponseBody
    public Map<String, Object> calculatePressure(
            @RequestParam double Temperature,
            @RequestParam double Period,
            @RequestParam double MaxVolume,
            @RequestParam double Amount_substans
    ) {
//        Formule formule = new Formule();
        log.info("Post works");

        formule.setTempeture(Temperature);
        formule.setAmount_substans(Amount_substans);

        // Список для хранения значений давления
        List<Double> pressures = new ArrayList<>();

        for (double volume = Period; volume <= MaxVolume; volume += Period) {
            formule.setValume(volume);
            double pressure = formule.mend_Clap_press(volume);
            pressures.add(pressure);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("Pressures", pressures);
        return response;
    }
}