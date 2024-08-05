package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DiseasediagnosisDao;
import lk.earth.earthuniversity.entity.Diseasediagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/diseasediagnoses")
public class DiseasediagnosisController {

    @Autowired
    private DiseasediagnosisDao diseasediagnosisDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Diseasediagnosis> get() {

        List<Diseasediagnosis> diseasediagnoses = this.diseasediagnosisDao.findAll();

        diseasediagnoses = diseasediagnoses.stream().map(
                diseasediagnosis -> { Diseasediagnosis b = new Diseasediagnosis();
                    b.setId(diseasediagnosis.getId());
                    b.setDisease(diseasediagnosis.getDisease());
                    return b; }
        ).collect(Collectors.toList());

        return diseasediagnoses;

    }

}


