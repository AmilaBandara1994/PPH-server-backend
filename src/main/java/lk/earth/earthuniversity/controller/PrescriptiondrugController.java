package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.PrescriptiondrugDao;
import lk.earth.earthuniversity.entity.Prescriptiondrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/prescriptiondrugs")
public class PrescriptiondrugController {

    @Autowired
    private PrescriptiondrugDao prescriptiondrugDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Prescriptiondrug> get() {

        List<Prescriptiondrug> prescriptiondrugs = this.prescriptiondrugDao.findAll();

        prescriptiondrugs = prescriptiondrugs.stream().map(
                prescriptiondrug -> { Prescriptiondrug b = new Prescriptiondrug();
                    b.setId(prescriptiondrug.getId());
                    b.setDescription(prescriptiondrug.getDescription());
                    b.setDays(prescriptiondrug.getDays());
                    b.setDose(prescriptiondrug.getDose());
                    b.setDosage(prescriptiondrug.getDosage());
                    b.setDrug(prescriptiondrug.getDrug());
                    b.setMeal(prescriptiondrug.getMeal());
                    b.setDescription(prescriptiondrug.getDescription());
                    b.setDrugschedule(prescriptiondrug.getDrugschedule());
                    return b; }
        ).collect(Collectors.toList());

        return prescriptiondrugs;

    }

}


