package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.SymptomsDao;
import lk.earth.earthuniversity.entity.Symptoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/symptoms")
public class SymptomsController {

    @Autowired
    private SymptomsDao symptomsDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Symptoms> get() {

        List<Symptoms> symptoms = this.symptomsDao.findAll();

        symptoms = symptoms.stream().map(
                symptom -> { Symptoms b = new Symptoms();
                    b.setId(symptom.getId());
                    b.setName(symptom.getName());
                    return b; }
        ).collect(Collectors.toList());

        return symptoms;

    }

}


