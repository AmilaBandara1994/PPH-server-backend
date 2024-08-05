package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.entity.*;
import lk.earth.earthuniversity.util.RegexProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;



@CrossOrigin
@RestController
@RequestMapping(value = "/regexes")
public class RegexController {

    @GetMapping(path ="/employee", produces = "application/json")
    public HashMap<String, HashMap<String, String>> employee() {
        return RegexProvider.get(new Employee());
    }

    @GetMapping(path ="/clinic", produces = "application/json")
    public HashMap<String, HashMap<String, String>> clinic() {
        return RegexProvider.get(new Clinic());
    }

    @GetMapping(path ="/users", produces = "application/json")
    public HashMap<String, HashMap<String, String>> user() {
        return RegexProvider.get(new User());
    }
    @GetMapping(path ="/doctors", produces = "application/json")
    public HashMap<String, HashMap<String, String>> doctor() {
        return RegexProvider.get(new Doctor());
    }

    @GetMapping(path ="/patients", produces = "application/json")
    public HashMap<String, HashMap<String, String>> patient() {
        return RegexProvider.get(new Patient());
    }

    @GetMapping(path ="/appointments", produces = "application/json")
    public HashMap<String, HashMap<String, String>> appointment() {
        return RegexProvider.get(new Appointment());
    }

    @GetMapping(path ="/patientpayments", produces = "application/json")
    public HashMap<String, HashMap<String, String>> patientpayment() {
        return RegexProvider.get(new Patientpayment());
    }

    @GetMapping(path ="/drugs", produces = "application/json")
    public HashMap<String, HashMap<String, String>> drug() {
        return RegexProvider.get(new Drug());
    }
    @GetMapping(path ="/diagnoses", produces = "application/json")
    public HashMap<String, HashMap<String, String>> diagnosis() {
        return RegexProvider.get(new Diagnosis());
    }


    @GetMapping(path ="/families", produces = "application/json")
    public HashMap<String, HashMap<String, String>> faimilise() {
        return RegexProvider.get(new Family());
    }

}


