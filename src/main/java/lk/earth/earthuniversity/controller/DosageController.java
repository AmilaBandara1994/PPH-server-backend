package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DosageDao;
import lk.earth.earthuniversity.entity.Dosage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/dosages")
public class DosageController {

    @Autowired
    private DosageDao dosageDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Dosage> get() {

        List<Dosage> dosages = this.dosageDao.findAll();

        dosages = dosages.stream().map(
                dosage -> { Dosage b = new Dosage();
                    b.setId(dosage.getId());
                    b.setName(dosage.getName());
                    return b; }
        ).collect(Collectors.toList());

        return dosages;

    }

}


