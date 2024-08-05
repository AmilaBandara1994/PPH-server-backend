package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.SymptomsdiagnosisDao;
import lk.earth.earthuniversity.entity.Symptomsdiagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/symptomsdiagnoses")
public class SymptomsdiagnosisController {

    @Autowired
    private SymptomsdiagnosisDao symptomsdiagnosisDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Symptomsdiagnosis> get() {

        List<Symptomsdiagnosis> symptomsdiagnoses = this.symptomsdiagnosisDao.findAll();

        symptomsdiagnoses = symptomsdiagnoses.stream().map(
                symptomsdiagnosis -> { Symptomsdiagnosis b = new Symptomsdiagnosis();
                    b.setId(symptomsdiagnosis.getId());
                    b.setSymptoms(symptomsdiagnosis.getSymptoms());
                    return b; }
        ).collect(Collectors.toList());

        return symptomsdiagnoses;

    }

}


