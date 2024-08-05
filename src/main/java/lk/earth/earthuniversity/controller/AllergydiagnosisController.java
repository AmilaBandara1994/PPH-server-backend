package lk.earth.earthuniversity.controller;


import lk.earth.earthuniversity.dao.AllergydiagnosisDao;
import lk.earth.earthuniversity.entity.Allergydiagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/allergydiagnoses")
public class AllergydiagnosisController {

    @Autowired
    private AllergydiagnosisDao allergydiagnosisDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Allergydiagnosis> get() {

        List<Allergydiagnosis> allergydiagnoses = this.allergydiagnosisDao.findAll();

        allergydiagnoses = allergydiagnoses.stream().map(
                allergydiagnosis -> { Allergydiagnosis b = new Allergydiagnosis();
                    b.setId(allergydiagnosis.getId());
                    b.setAllergy(allergydiagnosis.getAllergy());
                    return b; }
        ).collect(Collectors.toList());

        return allergydiagnoses;

    }

}


