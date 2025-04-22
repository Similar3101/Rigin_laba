package com.example.termopshis.web.ui;


import com.example.termopshis.model.formule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TermostaticController {


    @GetMapping("/termostatic")
    public String showTermo() {
        return "termostatic";
    }

    @PostMapping("/termostatic")
    @ResponseBody
    public Map<String, Object> calculatePressure(
            @RequestParam double Volume,
            @RequestParam double Temperature,
            @RequestParam double Amount_substans
    ) {
        formule formule = new formule();

        formule.setValume(Volume);
        formule.setAmount_substans(Amount_substans);
        formule.setTempeture(Temperature);

        double Pressure = formule.mend_Clap_press(Volume);

        Map<String, Object> response = new HashMap<>();
        response.put("Pressure", Pressure);
        return response;
    }
}